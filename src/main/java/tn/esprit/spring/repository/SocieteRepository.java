package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Societe;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long>{

}
