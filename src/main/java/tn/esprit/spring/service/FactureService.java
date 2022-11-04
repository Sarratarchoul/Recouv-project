package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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



public interface FactureService {
	List<Facture> retrieveAllFactures();
	Facture addFacture (Facture f);
	 void deleteFacture(Integer id);
	 Facture updateFacture(Facture f);
	 Facture findFactureById(Integer id);
	List<Facture> save(List<Facture> factures);
	List<Balanceagee> getMontantByRetards();
	List<Statuts> getStatus();
	List<Evolution_retard> getEvolution_retard();
	List<Facture_client> getFacture_client();
	List<Retards> getRetards();
	List<Prevision> getPrevision();
	List<Chiffre_aff> getChiffre_aff();
	List<DSO> getDSO();
	List<Risque> getRisque();
	void save(MultipartFile file);
	List<Facture> getAllFactures();
	
}
