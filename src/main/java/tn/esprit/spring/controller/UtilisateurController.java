package tn.esprit.spring.controller;

import java.util.List;

import java.util.Optional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.service.UtilisateurService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurService;
	@Autowired  ServletContext context;
	 //http://localhost:8080/SpringMVC/servlet/all-utilisateurs
		
		@GetMapping("/all-utilisateurs")
     	@ResponseBody
		public List<Utilisateur> getUtilisateurs() {
	     List<Utilisateur> list = utilisateurService.findAllBySupprimer(false);
		 return list;
		 } 
		// http://localhost:8081/SpringMVC/servlet/add-utilisateur
			// @PostMapping("/add-utilisateur")
			// @ResponseBody
			// public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
			// return   utilisateurService.addUtilisateur(utilisateur);
			 
			// }
			// http://localhost:8081/SpringMVC/servlet/create-Utilisateur
			 @PostMapping("/add-Utilisateur")
			 public long addUtilisateur (@RequestParam("file") MultipartFile file,
					 @RequestParam("utilisateur") String utilisateur) throws JsonParseException , JsonMappingException , Exception
			 {
				
				 Utilisateur utilisateurr = new ObjectMapper().readValue(utilisateur, Utilisateur.class);
				addUserImage(file);
			    String image = file.getOriginalFilename();
			    String newImage = FilenameUtils.getBaseName(image)+"."+FilenameUtils.getExtension(image);
			    utilisateurr.setImage(newImage);
			    return utilisateurService.save(utilisateurr);
			 }
			 
		//  http://localhost:8080/SpringMVC/servlet/modify-utilisateur
		 @PutMapping("/modify-utilisateur")
		 @ResponseBody
		 public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		 return utilisateurService.updateUtilisateur(utilisateur);
	 }
		 @PutMapping("/update-utilisateur")
		 @ResponseBody
		    public void update(@RequestParam("file") MultipartFile file,
					 @RequestParam("utilisateur") String utilisateur) throws JsonParseException , JsonMappingException , Exception {
			 Utilisateur utilisateurr = new ObjectMapper().readValue(utilisateur, Utilisateur.class);
		        	deleteUserImage(utilisateurr);
		        	 String image = file.getOriginalFilename();
		     	    String newImage = FilenameUtils.getBaseName(image)+"."+FilenameUtils.getExtension(image);
		     	   utilisateurr.setImage(newImage);
		     	  utilisateurService.updateUtilisateur(utilisateurr);
                  addUserImage(file);
		       
		    }
		// http://localhost:8080/SpringMVC/servlet/remove-utilisateur/{utilisateur-id}
		 @DeleteMapping("/delete-utilisateur/{id_utilisateur}")
		 @ResponseBody
		 public void deleteUtilisateur(@PathVariable("id_utilisateur") Long id_utilisateur) {
	      utilisateurService.deleteUtilisateur(id_utilisateur);
		 }
			// http://localhost:8080/SpringMVC/servlet/retrieve-user/{user-id}
			@GetMapping("/retrieve-utilisateur/{id_utilisateur}")
			@ResponseBody
			public Utilisateur findUtilisateurById(@PathVariable("id_utilisateur") Long id_utilisateur) {
				return utilisateurService.findUtilisateurById(id_utilisateur);
			}
			
		//	 @GetMapping("/verif/{email}")
		//	    public List<Utilisateur> listUser(@PathVariable String email) {
		//	             return utilisateurService.getAllByEmail(email);
		//	   }
			 
			 @GetMapping("/auth/{email}")
			 public ResponseEntity<Utilisateur> login(@PathVariable String email) {
			        Optional<Utilisateur> utilisateur = utilisateurService.login(email);
			        return utilisateur.map(ResponseEntity::ok)
			                   .orElseGet(() -> ResponseEntity.notFound()
		                                               .build());
			    }
			 @GetMapping(path="/ImgUsers/{id}")
			 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
				 Utilisateur utilisateur   =utilisateurService.findById(id).get();
				 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgUsers/")+utilisateur.getImage()));
			 }
	
			 private void addUserImage(MultipartFile file)
			    {
			    	boolean isExit = new File(context.getRealPath("/ImgUsers/")).exists();
				    if (!isExit)
				    {
				    	new File (context.getRealPath("/ImgUsers/")).mkdir();
				    	System.out.println("mk dir Imagess.............");
				    }
				    String image = file.getOriginalFilename();
				    String newImage = FilenameUtils.getBaseName(image)+"."+FilenameUtils.getExtension(image);
				    File serverFile = new File (context.getRealPath("/ImgUsers/"+File.separator+newImage));
				    try
				    {
				    
				    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
				    	 
				    }catch(Exception e) {
				    	 System.out.println("Failed to Add Image User !!");
				    }
				    
			    	
			    }
			    
			    private void deleteUserImage(Utilisateur utilisateur)
			    {
			    	System.out.println( " Delete User Image");
			         try { 
			        	 File file = new File (context.getRealPath("/ImgUsers/"+utilisateur.getImage()));
			             System.out.println(utilisateur.getImage());
			              if(file.delete()) { 
			                System.out.println(file.getName() + " is deleted!");
			             } else {
			                System.out.println("Delete operation is failed.");
			                }
			          }
			            catch(Exception e)
			            {
			                System.out.println("Failed to Delete image !!");
			            }
			    }
}
