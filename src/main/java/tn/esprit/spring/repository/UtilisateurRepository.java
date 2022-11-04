package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	@Query("select u from Utilisateur u where u.role<>'ADMINISTRATEUR' AND u.supprimer=false")
	public List<Utilisateur> findAllBySupprimer(boolean supprimer);
	Optional<Utilisateur> findByNom(String nom);

	Optional<Utilisateur> findAllByEmail(String email);
}
