package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.exception.UserNotFoundException;
import tn.esprit.spring.repository.UtilisateurRepository;
import java.security.SecureRandom;
import java.util.Base64;
@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{
	@Autowired
    UtilisateurRepository utilisateurRepository;
	
	private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64enocder = Base64.getUrlEncoder();

	

	private static final Logger L = LogManager.getLogger(UtilisateurServiceImpl.class);
	@Override
	public List<Utilisateur> findAllBySupprimer(boolean supprimer) {
		List<Utilisateur> utilisateurs=(List<Utilisateur>) utilisateurRepository.findAllBySupprimer(supprimer);
		for (Utilisateur utilisateur : utilisateurs){
			L.info("utilisateur +++ :" + utilisateur);
		}
		return utilisateurs;
	}

	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		return utilisateurRepository.save(u);
		 }
	@Override
	public long save(Utilisateur Utilisateur) {
        return utilisateurRepository.save(Utilisateur)
                             .getId_utilisateur();
    }
	@Override
	public void deleteUtilisateur(Long id_utilisateur){
		utilisateurRepository.deleteById(id_utilisateur);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) {
        Utilisateur existingUTI = utilisateurRepository.findById(u.getId_utilisateur()).orElse(null);
        System.out.println(u);
        if(existingUTI == null) {
            System.out.println("Utilisateur non trouvable");
            return  utilisateurRepository.save(u);
        }else  {
        	existingUTI.setPrenom(u.getPrenom());
        	existingUTI.setNom(u.getNom());
        	existingUTI.setEmail(u.getEmail());
        	existingUTI.setTelephone(u.getTelephone());
        	existingUTI.setImage(u.getImage());
        	existingUTI.setPassword(u.getPassword());
        	existingUTI.setActif(u.isActif());
        	existingUTI.setSupprimer(u.isSupprimer());
        	existingUTI.setRole(u.getRole());
            utilisateurRepository.save(existingUTI);
        }
        return u;
    }
	@Override
	public void update(Long id_utilisateur, Utilisateur Utilisateur) {
        Optional<Utilisateur> utilisateurr = utilisateurRepository.findById(id_utilisateur);
        if (utilisateurr.isPresent()) {
        	Utilisateur utilisateur = utilisateurr.get();
        	utilisateur.setPrenom(Utilisateur.getPrenom());
        	utilisateur.setNom(Utilisateur.getNom());
        	utilisateur.setEmail(Utilisateur.getEmail());
        	utilisateur.setPassword(Utilisateur.getPassword());
        	utilisateur.setImage(Utilisateur.getImage());
        	utilisateur.setRole(Utilisateur.getRole());
        	utilisateur.setActif(Utilisateur.isActif());
        	utilisateur.setTelephone(Utilisateur.getTelephone());
        	utilisateur.setSupprimer(Utilisateur.isSupprimer());
	        utilisateurRepository.save(utilisateur);
        }
    }
	public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }
	//public List<Utilisateur> getAllByEmail(String email) {
   // 	return utilisateurRepository.findAllByEmail(email);	    	
   // }
	public Optional<Utilisateur> login(String email) {
        return utilisateurRepository.findAllByEmail(email);
    }
	public Utilisateur findUtilisateurById(Long id_utilisateur) {
		return	utilisateurRepository.findById(id_utilisateur)
		.orElseThrow(() -> new UserNotFoundException("User by id " + id_utilisateur + " was not found"));
    }
//	public Utilisateur register(Utilisateur utilisateur) {
        // Check if user with username exist ir not
    //    if(checkUserExist(utilisateur)== true)
    //        return null;

    //    utilisateur.setToken(generateToken());

      //  return utilisateurRepository.save(utilisateur);

  //  }

  /*  private String generateToken() {

        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64enocder.encodeToString(token);

    }

    private boolean checkUserExist(Utilisateur utilisateur) {
    	Utilisateur existingUtilisateur = utilisateurRepository.findById(utilisateur.getId_utilisateur()).orElse(null);

        if(existingUtilisateur == null)
            return false;
        return true;
    }*/
    
   /* public Utilisateur login(Utilisateur utilisateur) {
    	Utilisateur existingUtilisateur = utilisateurRepository.findById(utilisateur.getId_utilisateur()).orElse(null);

        if(existingUtilisateur.getId_utilisateur().equals(utilisateur.getId_utilisateur()) &&
                existingUtilisateur.getPassword().equals(utilisateur.getPassword()) &&
                existingUtilisateur.getRole().equals(utilisateur.getRole())) {
            existingUtilisateur.setPassword("");
            return existingUtilisateur;
        }

        return null;

    }*/
}
