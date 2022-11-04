package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table( name = "Relance")
public class Relance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idR;
	@Temporal(TemporalType.DATE)
	private Date date_action;
    private String type_action;
	private String action;
    private float montant_action;
   /* @ManyToOne
	Utilisateur utilisateur;*/
    private long idclient;
    @ManyToOne
    @JsonProperty(access=Access.READ_WRITE)
	private Client client;
    
	public Relance() {
		super();
	}
	
	public Relance(Long idR, Date date_action, String type_action, String action, float montant_action, long idclient,
			Client client) {
		super();
		this.idR = idR;
		this.date_action = date_action;
		this.type_action = type_action;
		this.action = action;
		this.montant_action = montant_action;
		this.idclient = idclient;
		this.client = client;
	}

	public Relance(Date date_action, String type_action, String action, float montant_action, long idclient, Client client) {
		super();
		this.date_action = date_action;
		this.type_action = type_action;
		this.action = action;
		this.montant_action = montant_action;
		this.idclient = idclient;
		this.client = client;
	}

	public Long getIdR() {
		return idR;
	}

	public void setIdR(Long idR) {
		this.idR = idR;
	}

	public Date getDate_action() {
		return date_action;
	}
	public void setDate_action(Date date_action) {
		this.date_action = date_action;
	}
	public String getType_action() {
		return type_action;
	}
	public void setType_action(String type_action) {
		this.type_action = type_action;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public float getMontant_action() {
		return montant_action;
	}
	public void setMontant_action(float montant_action) {
		this.montant_action = montant_action;
	}

/*	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
*/
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getIdclient() {
		return idclient;
	}

	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}
    
}
