package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table( name = "Client") 
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id  
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long code_client;
	private String nom_client;
    private String senario_relance;
    private String adresse_client;
    private String email;
    private  String profil_payeur;
    private  String numTel;
    private String personne_contact;
    private String nom_groupe;
    private String moyen_de_paiement;
    @ManyToOne
    @JsonProperty(access=Access.READ_WRITE)
	Utilisateur utilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    @JsonProperty(access=Access.WRITE_ONLY)
	private Set<Facture> factures;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    @JsonProperty(access=Access.WRITE_ONLY)
	private Set<Relance> relances;
    
   

	public Client() {
		super();
	}
	
	public Client(String senario_relance, String adresse_client, String email,
			String profil_payeur, String numTel, String personne_contact, String nom_groupe) {
		super();
		this.senario_relance = senario_relance;
		this.adresse_client = adresse_client;
		this.email = email;
		this.profil_payeur = profil_payeur;
		this.numTel = numTel;
		this.personne_contact = personne_contact;
		this.nom_groupe = nom_groupe;
	}

	
	

	public Long getCode_client() {
		return code_client;
	}

	public void setCode_client(Long code_client) {
		this.code_client = code_client;
	}

	public String getAdresse_client() {
		return adresse_client;
	}

	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}

	public String getProfil_payeur() {
		return profil_payeur;
	}

	public void setProfil_payeur(String profil_payeur) {
		this.profil_payeur = profil_payeur;
	}

	public String getNom_groupe() {
		return nom_groupe;
	}

	public void setNom_groupe(String nom_groupe) {
		this.nom_groupe = nom_groupe;
	}


	public String getSenario_relance() {
		return senario_relance;
	}
	public void setSenario_relance(String senario_relance) {
		this.senario_relance = senario_relance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getPersonne_contact() {
		return personne_contact;
	}
	public void setPersonne_contact(String personne_contact) {
		this.personne_contact = personne_contact;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Set<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	public Set<Relance> getRelances() {
		return relances;
	}

	public void setRelances(Set<Relance> relances) {
		this.relances = relances;
	}

	public String getMoyen_de_paiement() {
		return moyen_de_paiement;
	}

	public void setMoyen_de_paiement(String moyen_de_paiement) {
		this.moyen_de_paiement = moyen_de_paiement;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
    
    
}
