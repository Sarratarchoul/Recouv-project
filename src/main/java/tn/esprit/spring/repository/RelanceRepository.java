package tn.esprit.spring.repository;

import java.util.List;

import tn.esprit.spring.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DTO.Nbr_relance;
import DTO.Retards;
import tn.esprit.spring.entity.Relance;

@Repository
public interface RelanceRepository extends JpaRepository<Relance, Long>{
	@Query("select r from Relance r where r.idclient=:x")
	public List<Relance> findRelanceByClientId(@Param("x")Long code_client);
	@Query(value = "SELECT new DTO.Nbr_relance(COUNT(*)) FROM Relance")
	public List<Nbr_relance> getNbr_relance();
}
