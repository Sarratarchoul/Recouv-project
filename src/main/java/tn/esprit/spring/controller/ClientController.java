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

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Relance;
import tn.esprit.spring.helper.ClientExcel;
import tn.esprit.spring.helper.Helper;
import tn.esprit.spring.helper.RelanceExcel;
import tn.esprit.spring.service.ClientService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	 //http://localhost:8080/SpringMVC/servlet/all-clients
		@GetMapping("/all-client")
     	@ResponseBody
		public List<Client> getClients() {
	     List<Client> list = clientService.retrieveAllClients();
		 return list;
		 } 
		// http://localhost:8081/SpringMVC/servlet/add-client
			 @PostMapping("/add-client")
			 @ResponseBody
			 public Client addClient(@RequestBody Client client) {
			 return  clientService.addClient(client);
			 
			 }
		 // http://localhost:8080/SpringMVC/servlet/modify-client
		 @PutMapping("/update-client")
		 @ResponseBody
		 public Client updateClient(@RequestBody Client client) {
		 return clientService.updateClient(client);
		 }
		// http://localhost:8080/SpringMVC/servlet/remove-client/{client-code}
		 @DeleteMapping("/delete-client/{code_client}")
		 @ResponseBody
		 public void deleteClient(@PathVariable("code_client") Long code_client) {
			 clientService.deleteClient(code_client);
		 }
					// http://localhost:8080/SpringMVC/servlet/retrieve-user/{user-id}
					@GetMapping("/retrieve-client/{code_client}")
					@ResponseBody
					public Client  findClientById(@PathVariable("code_client") Long code_client) {
						return clientService.findClientById(code_client);
					}
					@GetMapping("/{code_client}/relances")
				    public List<Relance> getRelancesClient(@PathVariable Long code_client){
				        return clientService.relancesClient(code_client);
				    }
					@GetMapping("/{code_client}/factures")
				    public List<Facture> getFacturesClient(@PathVariable Long code_client){
				        return clientService.facturesClient(code_client);
				    }
					@GetMapping("/client")
				    public List<Client> getAllClients() {
				        return this.clientService.getAllClients();
				    }
					@PostMapping("/client/upload")
				    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
						if (Helper.checkExcelFormat(file)) {
				            //true

				            this.clientService.save(file);

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
				        String headerValue = "attachment; filename=clients_" + currentDateTime + ".xlsx";
				        response.setHeader(headerKey, headerValue);
				        List<Client> clients = clientService.getAllClients();
				        ClientExcel excel = new ClientExcel(clients);
				        excel.export(response);    
				    }  
}
