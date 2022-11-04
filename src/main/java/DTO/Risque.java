package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Risque {
	private long code_client;
	private double ecours_creance;
	private double ecours_total;
	private double retard;
	private double tauxR;
	private double garantie_assureur;
	private double autres_garanties;
	private double risque_actuel;
	private double risque_actuel_pourcent;
	private double risque;
	private double limite_credit;
	private double encours_disponible;
	
	public Risque() {
		super();
	}
	public Risque(long code_client, double ecours_creance, double ecours_total, double retard, double tauxR,
			double garantie_assureur, double autres_garanties, double risque_actuel, double risque_actuel_pourcent,
			double risque, double limite_credit, double encours_disponible) {
		super();
		this.code_client = code_client;
		this.ecours_creance = ecours_creance;
		this.ecours_total = ecours_total;
		this.retard = retard;
		this.tauxR = tauxR;
		this.garantie_assureur = garantie_assureur;
		this.autres_garanties = autres_garanties;
		this.risque_actuel = risque_actuel;
		this.risque_actuel_pourcent = risque_actuel_pourcent;
		this.risque = risque;
		this.limite_credit = limite_credit;
		this.encours_disponible = encours_disponible;
	}
	public long getCode_client() {
		return code_client;
	}
	public void setCode_client(long code_client) {
		this.code_client = code_client;
	}
	public double getEcours_creance() {
		return ecours_creance;
	}
	public void setEcours_creance(double ecours_creance) {
		this.ecours_creance = ecours_creance;
	}
	public double getEcours_total() {
		return ecours_total;
	}
	public void setEcours_total(double ecours_total) {
		this.ecours_total = ecours_total;
	}
	public double getRetard() {
		return retard;
	}
	public void setRetard(double retard) {
		this.retard = retard;
	}
	public double getTauxR() {
		return tauxR;
	}
	public void setTauxR(double tauxR) {
		this.tauxR = tauxR;
	}
	public double getGarantie_assureur() {
		return garantie_assureur;
	}
	public void setGarantie_assureur(double garantie_assureur) {
		this.garantie_assureur = garantie_assureur;
	}
	public double getAutres_garanties() {
		return autres_garanties;
	}
	public void setAutres_garanties(double autres_garanties) {
		this.autres_garanties = autres_garanties;
	}
	public double getRisque_actuel() {
		return risque_actuel;
	}
	public void setRisque_actuel(double risque_actuel) {
		this.risque_actuel = risque_actuel;
	}
	public double getRisque_actuel_pourcent() {
		return risque_actuel_pourcent;
	}
	public void setRisque_actuel_pourcent(double risque_actuel_pourcent) {
		this.risque_actuel_pourcent = risque_actuel_pourcent;
	}
	public double getRisque() {
		return risque;
	}
	public void setRisque(double risque) {
		this.risque = risque;
	}
	public double getLimite_credit() {
		return limite_credit;
	}
	public void setLimite_credit(double limite_credit) {
		this.limite_credit = limite_credit;
	}
	public double getEncours_disponible() {
		return encours_disponible;
	}
	public void setEncours_disponible(double encours_disponible) {
		this.encours_disponible = encours_disponible;
	}
	
}
