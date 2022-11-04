package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import DTO.Balanceagee;
import DTO.Chiffre_aff;
import DTO.DSO;
import DTO.Evolution_retard;
import DTO.Facture_client;
import DTO.Prevision;
import DTO.Retards;
import DTO.Risque;
import DTO.Statuts;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Relance;
import tn.esprit.spring.helper.FactureExcel;
import tn.esprit.spring.helper.Helper;
import tn.esprit.spring.service.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/facture")
public class FactureController {
	@Autowired
	FactureService factureService;
	
	 //http://localhost:8080/SpringMVC/servlet/all-factures
		@GetMapping("/all-facture")
     	@ResponseBody
		public List<Facture> getFactures() {
	     List<Facture> list = factureService.retrieveAllFactures();
		 return list;
		 } 
		@GetMapping("/facture")
	    public List<Facture> getAllFacture() {
	        return this.factureService.getAllFactures();
	    }
		@PostMapping("/facture/upload")
	    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
			if (Helper.checkExcelFormat(file)) {
	            //true

	            this.factureService.save(file);

	            return ResponseEntity.status(HttpStatus.OK).body("File is uploaded and data is saved to db");


	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	    }
		 //http://localhost:8080/SpringMVC/servlet/balanceagee
			@GetMapping("/balanceagee")
	     	@ResponseBody
			public List<Balanceagee> getMontantByRetards() {
				return  factureService.getMontantByRetards();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/Statusfacture
			@GetMapping("/Statusfacture")
	     	@ResponseBody
			public List<Statuts> getStatus() {
				return  factureService.getStatus();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/evolutionretard
			@GetMapping("/evolutionretard")
	     	@ResponseBody
			public List<Evolution_retard> getEvolution_retard() {
				return  factureService.getEvolution_retard();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/facture_client
			@GetMapping("/facture_client")
	     	@ResponseBody
			public List<Facture_client> getFacture_client() {
				return  factureService.getFacture_client();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/retardsT
			@GetMapping("/retardsT")
	     	@ResponseBody
			public List<Retards> getRetards() {
				return  factureService.getRetards();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/prevision
			@GetMapping("/prevision")
	     	@ResponseBody
			public List<Prevision> getPrevision() {
				return  factureService.getPrevision();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/DSO
			@GetMapping("/DSO")
	     	@ResponseBody
			public List<DSO> getDSO() {
				return  factureService.getDSO();
			  
			 } 
			//http://localhost:8080/SpringMVC/servlet/risque
				@GetMapping("/risque")
		     	@ResponseBody
				public List<Risque> getRisque() {
					return  factureService.getRisque();
				  
				 } 
			//http://localhost:8080/SpringMVC/servlet/Chiffre_aff
			@GetMapping("/Chiffre_aff")
	     	@ResponseBody
			public List<Chiffre_aff> getChiffre_aff() {
				return  factureService.getChiffre_aff();
			  
			 } 
		// http://localhost:8081/SpringMVC/servlet/add-facture
			 @PostMapping("/add-facture")
			 @ResponseBody
			 public Facture addFacture(@RequestBody Facture facture) {
			 return  factureService.addFacture(facture);
			 
			 }
		 // http://localhost:8080/SpringMVC/servlet/modify-facture
		 @PutMapping("/update-facture")
		 @ResponseBody
		 public Facture updateFacture(@RequestBody Facture facture) {
		 return factureService.updateFacture(facture);
		 }
		// http://localhost:8080/SpringMVC/servlet/remove-facture/{facture-num}
		 @DeleteMapping("/delete-facture/{num_facture}")
		 @ResponseBody
		 public void deleteFacture(@PathVariable("num_facture") Integer num_facture) {
			 factureService.deleteFacture(num_facture);
		 }
				
				// http://localhost:8080/SpringMVC/servlet/retrieve-relance/{idR}
							@GetMapping("/retrieve-facture/{num_facture}")
							@ResponseBody
							public Facture  findFactureById(@PathVariable("num_facture") Integer num_facture) {
								return factureService.findFactureById(num_facture);
							}
							@GetMapping("/export/excel")
						    public void exportToExcel(HttpServletResponse response) throws IOException {
						    	System.out.println("Export to Excel ...");
						        response.setContentType("application/octet-stream");
						        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
						        String currentDateTime = dateFormatter.format(new Date());
						        String headerKey = "Content-Disposition";
						        String headerValue = "attachment; filename=factures_" + currentDateTime + ".xlsx";
						        response.setHeader(headerKey, headerValue);
						        List<Facture> factures = factureService.getAllFactures();
						        FactureExcel excel = new FactureExcel(factures);
						        excel.export(response);    
						    }  
}
