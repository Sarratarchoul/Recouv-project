package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Utilisateur;


public interface UtilisateurService {

	
	List<Utilisateur> findAllBySupprimer(boolean supprimer);
	 Utilisateur addUtilisateur (Utilisateur u);
	 void deleteUtilisateur(Long id_utilisateur);
	 Utilisateur updateUtilisateur(Utilisateur u);
	 Utilisateur findUtilisateurById(Long id_utilisateur);
	//public Utilisateur register(Utilisateur utilisateur);
//	public Utilisateur login(Utilisateur utilisateur);
	//public List<Utilisateur> getAllByEmail(String email);
	public Optional<Utilisateur> login(String email);
	public Optional<Utilisateur> findById(Long id_utilisateur);
	public long save(Utilisateur Utilisateur);
	public void update(Long id_utilisateur, Utilisateur utilisateur);
}
