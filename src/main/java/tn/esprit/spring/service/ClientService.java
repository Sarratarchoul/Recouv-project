package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Relance;



public interface ClientService {

	List<Client> retrieveAllClients();
	 Client addClient (Client c);
	 void deleteClient(Long id);
	 Client updateClient(Client c);
	 Client findClientById(Long id);
	 List<Client> save(List<Client> clients);
	 List<Relance> relancesClient(Long code_client);
	 List<Facture> facturesClient(Long code_client);
	 void save(MultipartFile file);
		List<Client> getAllClients();
}
