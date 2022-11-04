package tn.esprit.spring.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import tn.esprit.spring.exception.UserNotFoundException;
import tn.esprit.spring.helper.Helper;
import tn.esprit.spring.repository.FactureRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
@Service
public class FactureServiceImpl implements FactureService{
	
	@Autowired
    FactureRepository factureRepository;
	
	private static final Logger L = LogManager.getLogger(ClientServiceImpl.class);
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures=(List<Facture>) factureRepository.findAll();
		for (Facture facture : factures){
			L.info("facture +++ :" + facture);
		}
		return factures;
	}
	@Override
	public void save(MultipartFile file) {

        try {
            List<Facture> factures = Helper.convertExcelToListOfFacture(file.getInputStream());
            this.factureRepository.saveAll(factures);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	@Override
	public List<Facture> getAllFactures() {
        return this.factureRepository.findAll();
    }
	@Override
	public Facture addFacture(Facture f) {
		return factureRepository.save(f);
		 }

	@Override
	public void deleteFacture(Integer id) {
		Optional<Facture> facture = factureRepository.findById(id);
		if (facture.isPresent()){
			factureRepository.deleteById(id);
		}else{
			L.info("No Facture exist");
		}
	}
	@Override
	 public List<Facture> save(List<Facture> factures) {
	        return factureRepository.saveAll(factures);
	    }
	@Override
	 public List<Balanceagee> getMontantByRetards() {
	        return factureRepository.getMontantByRetards();
	    }
	@Override
	 public List<Statuts> getStatus() {
	        return factureRepository.getStatus();
	    }
	@Override
	 public List<Evolution_retard> getEvolution_retard() {
	        return factureRepository.getEvolution_retard();
	    }
	 @Override
	 public List<Facture_client> getFacture_client() {
	        return factureRepository.getFacture_client();
	    }
	 @Override
	 public List<Retards> getRetards() {
	        return factureRepository.getRetards();
	    }
	 @Override
	 public List<Prevision> getPrevision() {
	        return factureRepository.getPrevision();
	    }
	 @Override
	 public List<Chiffre_aff> getChiffre_aff() {
	        return factureRepository.getChiffre_aff();
	    }
	 @Override
	 public List<DSO> getDSO() {
	        return factureRepository.getDSO();
	    }
	 @Override
	 public List<Risque> getRisque() {
	        return factureRepository.getRisque();
	    }
	@Override
	public Facture updateFacture(Facture f) {
		 Facture existingFac = factureRepository.findById(f.getNum_facture()).orElse(null);
	        System.out.println(f);
	        if(existingFac == null) {
	            System.out.println("Facture non trouvable");
	            return  factureRepository.save(f);
	        }else  {
	        	existingFac.setDate_emission(f.getDate_emission());
	        	existingFac.setDate_echeance(f.getDate_echeance());
	        	existingFac.setMontant_initial(f.getMontant_initial());
	        	existingFac.setMontant_restant(f.getMontant_restant());
	        	existingFac.setStatus(f.getStatus());
	        	existingFac.setDelai_paimentF(f.getDelai_paimentF());
	        	existingFac.setGarantie_assureur(f.getGarantie_assureur());
	        	existingFac.setLimite_credit(f.getLimite_credit());
	        	existingFac.setIdclient(f.getIdclient());
	        	existingFac.setClient(f.getClient());
	            factureRepository.save(existingFac);
	        }
	        return f;
	    }
	public Facture findFactureById(Integer id) {
		return	factureRepository.findById(id)
		.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
	
}
