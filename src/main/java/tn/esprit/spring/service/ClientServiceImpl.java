package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Relance;
import tn.esprit.spring.exception.UserNotFoundException;
import tn.esprit.spring.helper.Helperc;
import tn.esprit.spring.helper.Helperr;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.RelanceRepository;
@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
    ClientRepository clientRepository;
	@Autowired
    RelanceRepository relanceRepository;
	@Autowired
    FactureRepository factureRepository;
	private static final Logger L = LogManager.getLogger(ClientServiceImpl.class);
	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clients=(List<Client>) clientRepository.findAll();
		for (Client client : clients){
			L.info("client +++ :" + client);
		}
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
		 }
	@Override
	 public List<Client> save(List<Client> clients) {
	        return clientRepository.saveAll(clients);
	    }
	@Override
	public void deleteClient(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		if (client.isPresent()){
			clientRepository.deleteById(id);
		}else{
			L.info("No Client exist");
		}
	}

	@Override
	public Client updateClient(Client c) {
		 Client existingCli = clientRepository.findById(c.getCode_client()).orElse(null);
	        System.out.println(c);
	        if(existingCli == null) {
	            System.out.println("Client non trouvable");
	            return  clientRepository.save(c);
	        }else  {
	        	existingCli.setSenario_relance(c.getSenario_relance());
	        	existingCli.setAdresse_client(c.getAdresse_client());
	        	existingCli.setEmail(c.getEmail());
	        	existingCli.setProfil_payeur(c.getProfil_payeur());
	        	existingCli.setNumTel(c.getNumTel());
	        	existingCli.setPersonne_contact(c.getPersonne_contact());
	        	existingCli.setNom_groupe(c.getNom_groupe());
	        	existingCli.setMoyen_de_paiement(c.getMoyen_de_paiement());
	        	clientRepository.save(existingCli);
	        }
	        return c;
	    }
	public Client findClientById(Long id) {
		return	clientRepository.findById(id)
		.orElseThrow(() -> new UserNotFoundException("client by id " + id + " was not found"));
    }
	@Override
    public List<Relance> relancesClient(Long code_client){
        List<Relance> relancesClient = relanceRepository.findRelanceByClientId(code_client);
        return relancesClient;
    }
	@Override
    public List<Facture> facturesClient(Long code_client){
        List<Facture> facturesClient = factureRepository.findFactureByClientId(code_client);
        return facturesClient;
    }
	@Override
	public void save(MultipartFile file) {

        try {
            List<Client> clients = Helperc.convertExcelToListOfClient(file.getInputStream());
            this.clientRepository.saveAll(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	@Override
	public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }
}
