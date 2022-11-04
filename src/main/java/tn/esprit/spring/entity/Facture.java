package tn.esprit.spring.entity;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Days;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.text.ParseException;   
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table( name = "Facture")
public class Facture implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer num_facture;
	@Temporal(TemporalType.DATE)
	private Date date_emission;
    // Date now = new Date();
   //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
   //  String currentTime = formatter.format(now);
	@Temporal(TemporalType.DATE)
	private Date date_echeance;
	private float montant_initial;
	private float montant_restant;
    private String status;
    private float retards;
    // private long retardss = TimeUnit.DAYS.convert((now.getTime() - date_echeance.getTime()), TimeUnit.MILLISECONDS);
    //Period.between(now, date_echeance);//= Days.daysBetween(new DateTime(date_echeance), new DateTime(date_emission)).getDays();
    @Temporal(TemporalType.DATE)
	private Date delai_paimentF;
	private float garantie_assureur;
	private float autres_garanties;
	private  float limite_credit;
	private String notation_credit;
	private long idclient;
	/*@ManyToOne
	Utilisateur utilisateur;*/
	@ManyToOne
	@JsonProperty(access=Access.READ_WRITE)
	private Client client;
	
	public Facture() {
		super();
	}
	
	public Facture(Integer num_facture, Date date_emission, Date date_echeance, float montant_initial,
			float montant_restant, String status, Integer retards, Date delai_paimentF, float garantie_assureur, float autres_garanties, 
			float limite_credit,String notation_credit, long idclient, Client client) {
		super();
		this.num_facture = num_facture;
		this.date_emission = date_emission;
		this.date_echeance = date_echeance;
		this.montant_initial = montant_initial;
		this.montant_restant = montant_restant;
		this.status = status;
		this.retards = retards;
		this.delai_paimentF = delai_paimentF;
		this.garantie_assureur = garantie_assureur;
		this.autres_garanties = autres_garanties;
		this.limite_credit = limite_credit;
		this.notation_credit = notation_credit;
		this.idclient = idclient;
		this.client = client;
	}

	public Facture(Date date_emission, Date date_echeance, float montant_initial, float montant_restant, String status,
			float retards, Date delai_paimentF, float garantie_assureur, float autres_garanties, float limite_credit,  String notation_credit, 
			long idclient, Client client) {
		super();
		this.date_emission = date_emission;
		this.date_echeance = date_echeance;
		this.montant_initial = montant_initial;
		this.montant_restant = montant_restant;
		this.status = status;
		this.retards = retards;
		this.delai_paimentF = delai_paimentF;
		this.garantie_assureur = garantie_assureur;
		this.autres_garanties = autres_garanties;
		this.limite_credit = limite_credit;
		this.notation_credit = notation_credit;
		this.idclient = idclient;
		this.client = client;
	}
	public Facture(Date date_emission, Date date_echeance, float montant_initial, float montant_restant, String status,
			 Date delai_paimentF, float garantie_assureur, float autres_garanties, float limite_credit, String notation_credit,
			 long idclient, Client client) {
		super();
		this.date_emission = date_emission;
		this.date_echeance = date_echeance;
		this.montant_initial = montant_initial;
		this.montant_restant = montant_restant;
		this.status = status;
		this.delai_paimentF = delai_paimentF;
		this.garantie_assureur = garantie_assureur;
		this.autres_garanties = autres_garanties;
		this.limite_credit = limite_credit;
		this.notation_credit = notation_credit;
		this.idclient = idclient;
		this.client = client;
	}

	public Integer getNum_facture() {
		return num_facture;
	}
	public void setNum_facture(Integer num_facture) {
		this.num_facture = num_facture;
	}
	public Date getDate_emission() {
		return date_emission;
	}
	public void setDate_emission(Date date_emission) {
		this.date_emission = date_emission;
	}
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public float getMontant_initial() {
		return montant_initial;
	}
	public void setMontant_initial(float montant_initial) {
		this.montant_initial = montant_initial;
	}
	public float getMontant_restant() {
		return montant_restant;
	}
	public void setMontant_restant(float montant_restant) {
		this.montant_restant = montant_restant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDelai_paimentF() {
		return delai_paimentF;
	}
	public void setDelai_paimentF(Date delai_paimentF) {
		this.delai_paimentF = delai_paimentF;
	}
	public float getGarantie_assureur() {
		return garantie_assureur;
	}
	public void setGarantie_assureur(float garantie_assureur) {
		this.garantie_assureur = garantie_assureur;
	}
	/*public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	*/
	 
	public float getRetards() {
		return retards;
	}
	public void setRetards(float retards) {
		this.retards = retards;
	}
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	public float getAutres_garanties() {
		return autres_garanties;
	}

	public void setAutres_garanties(float autres_garanties) {
		this.autres_garanties = autres_garanties;
	}

	public float getLimite_credit() {
		return limite_credit;
	}

	public void setLimite_credit(float limite_credit) {
		this.limite_credit = limite_credit;
	}

	public String getNotation_credit() {
		return notation_credit;
	}

	public void setNotation_credit(String notation_credit) {
		this.notation_credit = notation_credit;
	}

	public long getIdclient() {
		return idclient;
	}

	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}




	

//	public LocalDateTime getNow() {
//		return now;
//	}

//	public void setNow(LocalDateTime now) {
//		this.now = now;
//	}
	
	
    
    
}
