package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table( name = "Societe")
public class Societe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idS;
	private String nom_societe;
	private String adress_societe;
	private String email_societe;
	private String tel_societe;
	private String web;
    private String identifient_legal;
	private String logo;
	private String code_postale;
	private String IBAN;
	private String BAC;
	private String numTVA;
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="societe")
	//private Set<Utilisateur> utilisateurs;
	
	public Societe() {
		super();
	}
	public Societe(String nom_societe, String adress_societe, String email_societe, String tel_societe, String web,
			String identifient_legal, String logo, String code_postale, String iBAN, String bAC, String numTVA) {
		super();
		this.nom_societe = nom_societe;
		this.adress_societe = adress_societe;
		this.email_societe = email_societe;
		this.tel_societe = tel_societe;
		this.web = web;
		this.identifient_legal = identifient_legal;
		this.logo = logo;
		this.code_postale = code_postale;
		IBAN = iBAN;
		BAC = bAC;
		this.numTVA = numTVA;
	}
	
	public Long getIdS() {
		return idS;
	}
	public void setIdS(Long idS) {
		this.idS = idS;
	}
	public String getNom_societe() {
		return nom_societe;
	}
	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}
	public String getAdress_societe() {
		return adress_societe;
	}
	public void setAdress_societe(String adress_societe) {
		this.adress_societe = adress_societe;
	}
	public String getEmail_societe() {
		return email_societe;
	}
	public void setEmail_societe(String email_societe) {
		this.email_societe = email_societe;
	}
	public String getTel_societe() {
		return tel_societe;
	}
	public void setTel_societe(String tel_societe) {
		this.tel_societe = tel_societe;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getIdentifient_legal() {
		return identifient_legal;
	}
	public void setIdentifient_legal(String identifient_legal) {
		this.identifient_legal = identifient_legal;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCode_postale() {
		return code_postale;
	}
	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getBAC() {
		return BAC;
	}
	public void setBAC(String bAC) {
		BAC = bAC;
	}
	public String getNumTVA() {
		return numTVA;
	}
	public void setNumTVA(String numTVA) {
		this.numTVA = numTVA;
	}
	/*public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}*/
	
	
}
