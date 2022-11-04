package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import DTO.Nbr_relance;
import tn.esprit.spring.entity.Relance;
import tn.esprit.spring.helper.Helper;
import tn.esprit.spring.helper.RelanceExcel;
import tn.esprit.spring.service.ClientService;
import tn.esprit.spring.service.RelanceService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/relance")
public class RelanceController {
@Autowired
	RelanceService relanceService;
@Autowired
ClientService clientService;
	
	 //http://localhost:8080/SpringMVC/servlet/all-relances
		@GetMapping("/all-relance")
    	@ResponseBody
		public List<Relance> getRelances() {
	     List<Relance> list = relanceService.retrieveAllRelances();
		 return list;
		 } 
		// http://localhost:8080/SpringMVC/servlet/retrieve-relance/{idR}
		@GetMapping("/retrieve-relancesclient/{code_client}/client")
		@ResponseBody
		public List<Relance> getRelancesClient(@PathVariable("code_client") Long code_client) {

			return relanceService.retrieveRelancesClient(code_client);
		}
		// http://localhost:8081/SpringMVC/servlet/add-relance
			 @PostMapping("/add-relance")
			 @ResponseBody
			 public Relance addRelance(@RequestBody Relance relance) {
			 return  relanceService.addRelance(relance);
			 
			 }
			//http://localhost:8080/SpringMVC/servlet/relance_nbr
				@GetMapping("/relance_nbr")
		     	@ResponseBody
				public List<Nbr_relance> getNbr_relance() {
					return  relanceService.getNbr_relance();
				  
				 } 
		 // http://localhost:8080/SpringMVC/servlet/modify-relance
		 @PutMapping("/update-relance")
		 @ResponseBody
		 public Relance updateRelance(@RequestBody Relance relance) {
         return relanceService.updateRelance(relance);
		 }
		
		// http://localhost:8080/SpringMVC/servlet/remove-relance/{relance-id}
		 @DeleteMapping("/delete-relance/{idR}")
		 @ResponseBody
		 public void deleteRelance(@PathVariable("idR") Long IdR) {
			 relanceService.deleteRelance(IdR);
		 }
		// http://localhost:8080/SpringMVC/servlet/retrieve-relance/{idR}
					@GetMapping("/retrieve-relance/{idR}")
					@ResponseBody
					public Relance  findRelanceById(@PathVariable("idR") Long idR) {
						return relanceService.findRelanceById(idR);
					}
					@GetMapping("/relance")
				    public List<Relance> getAllRelances() {
				        return this.relanceService.getAllRelances();
				    }
					@PostMapping("/relance/upload")
				    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
						if (Helper.checkExcelFormat(file)) {
				            //true

				            this.relanceService.save(file);

				            return ResponseEntity.status(HttpStatus.OK).body("File is uploaded and data is saved to db");


				        }
				        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
				    }
					@GetMapping("/export/excel")
				    public void exportToExcel(HttpServletResponse response) throws IOException {
				    	System.out.println("Export to Excel ...");
				        response.setContentType("application/octet-stream");
				        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				        String currentDateTime = dateFormatter.format(new Date());
				        String headerKey = "Content-Disposition";
				        String headerValue = "attachment; filename=relances_" + currentDateTime + ".xlsx";
				        response.setHeader(headerKey, headerValue);
				        List<Relance> relances = relanceService.getAllRelances();
				        RelanceExcel excel = new RelanceExcel(relances);
				        excel.export(response);    
				    }  
}
