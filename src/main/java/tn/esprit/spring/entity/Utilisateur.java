package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Utilisateur",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "code"
				+ ""),
		@UniqueConstraint(columnNames = "email") 
	})
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_utilisateur;
	private String code;
	private String prenom;
	private String nom;
	private String email;
	private String telephone;
    private String image;
	private String password;
	private boolean actif = true;
	private boolean supprimer = false;
	@Enumerated(EnumType.STRING)
	private  Role role;
	
	//private String token;
	//@ManyToOne
	//Societe societe;
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="utilisateur")
	private Set<Facture> factures;*/
	@OneToMany(cascade = CascadeType.ALL, mappedBy="utilisateur")
	 @JsonProperty(access=Access.WRITE_ONLY)
	private Set<Client> clients;
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="utilisateur")
	private Set<Relance> relances;*/
	
	public Utilisateur() {
		super();
	}
	
	
	public Utilisateur(String code, String prenom, String nom, String email, String telephone, String image,
			String password, boolean actif, boolean supprimer, Role role) {
		super();
		this.setCode(code);
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.image = image;
		this.password = password;
		this.actif = actif;
		this.supprimer = supprimer;
		this.role = role;
	}



	/*public Societe getSociete() {
		return societe;
	}


	public void setSociete(Societe societe) {
		this.societe = societe;
	}*/


	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public Long getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}


	/*public Set<Facture> getFactures() {
		return factures;
	}


	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
*/
	@JsonManagedReference
	public Set<Client> getClients() {
		return clients;
	}


	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public boolean isSupprimer() {
		return supprimer;
	}


	public void setSupprimer(boolean supprimer) {
		this.supprimer = supprimer;
	}


/*	public Set<Relance> getRelances() {
		return relances;
	}


	public void setRelances(Set<Relance> relances) {
		this.relances = relances;
	}

*/



}
