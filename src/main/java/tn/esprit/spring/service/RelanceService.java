package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import DTO.Nbr_relance;
import tn.esprit.spring.entity.Relance;

public interface RelanceService {
	List<Relance> retrieveAllRelances();
	Relance addRelance (Relance r);
	 void deleteRelance(Long idR);
	 Relance updateRelance(Relance r);
	 Relance findRelanceById(Long idR);
	 List<Relance> retrieveRelancesClient(Long id);
	 List<Relance> save(List<Relance> relances);
	 List<Nbr_relance> getNbr_relance();
	 void save(MultipartFile file);
	List<Relance> getAllRelances();
}
