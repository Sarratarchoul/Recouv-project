package tn.esprit.spring.service;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import DTO.Nbr_relance;
import DTO.Retards;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Relance;
import tn.esprit.spring.exception.UserNotFoundException;
import tn.esprit.spring.helper.Helper;
import tn.esprit.spring.helper.Helperr;
import tn.esprit.spring.repository.RelanceRepository;

@Service
public class RelanceServiceImpl implements RelanceService{
	
	@Autowired
	RelanceRepository relanceRepository;
	
	private static final Logger L = LogManager.getLogger(ClientServiceImpl.class);
	@Override
	public List<Relance> retrieveAllRelances() {
		List<Relance> relances=(List<Relance>) relanceRepository.findAll();
		for (Relance relance : relances){
			L.info("relance +++ :" + relance);
		}
		return relances;
	}
	@Override
	 public List<Relance> save(List<Relance> relances) {
	        return relanceRepository.saveAll(relances);
	    }
	@Override
	public List<Relance> retrieveRelancesClient(Long id) {
		List<Relance> relances = relanceRepository.findAll();
		List<Relance> relancess=new ArrayList<>();
		for(Relance r : relances){
			if(r.getClient().getCode_client()==id)
				relancess.add(r);
		}
		return relancess;
	}
	@Override
	public Relance addRelance(Relance r) {
		return relanceRepository.save(r);
		 }
	@Override
	 public List<Nbr_relance> getNbr_relance() {
	        return relanceRepository.getNbr_relance();
	    }
	@Override
	public void deleteRelance(Long idR) {
		Optional<Relance> relance = relanceRepository.findById(idR);
		if (relance.isPresent()){
			relanceRepository.deleteById(idR);
		}else{
			L.info("No Relance exist");
		}
	}

	@Override
	public Relance updateRelance(Relance r) {
		Relance existingRel = relanceRepository.findById(r.getIdR()).orElse(null);
        System.out.println(r);
        if(existingRel == null) {
            System.out.println("Relance non trouvable");
            return  relanceRepository.save(r);
        }else  {
        	existingRel.setDate_action(r.getDate_action());
        	existingRel.setType_action(r.getType_action());
        	existingRel.setAction(r.getAction());
        	existingRel.setMontant_action(r.getMontant_action());
        	existingRel.setIdclient(r.getIdclient());
        	existingRel.setClient(r.getClient());
        	relanceRepository.save(existingRel);
        }
        return r;
    }
	
	public Relance findRelanceById(Long idR) {
		return	relanceRepository.findById(idR)
		.orElseThrow(() -> new UserNotFoundException("User by id " + idR + " was not found"));
    }
	@Override
	public void save(MultipartFile file) {

        try {
            List<Relance> relances = Helperr.convertExcelToListOfRelance(file.getInputStream());
            this.relanceRepository.saveAll(relances);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	@Override
	public List<Relance> getAllRelances() {
        return this.relanceRepository.findAll();
    }
}
