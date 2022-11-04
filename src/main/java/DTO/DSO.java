package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DSO {
	private double DSO;
	private double DSO_retard;
	private double DSO_contractuel;
	private double tauxR;
	private String mois;
	public DSO() {
		super();
	}
	
	public DSO(double dSO, double dSO_retard, double dSO_contractuel, double tauxR, String mois) {
		super();
		DSO = dSO;
		DSO_retard = dSO_retard;
		DSO_contractuel = dSO_contractuel;
		this.tauxR = tauxR;
		this.mois = mois;
	}


	public double getDSO() {
		return DSO;
	}
	public void setDSO(double dSO) {
		DSO = dSO;
	}
	public double getDSO_retard() {
		return DSO_retard;
	}
	public void setDSO_retard(double dSO_retard) {
		DSO_retard = dSO_retard;
	}
	public double getDSO_contractuel() {
		return DSO_contractuel;
	}
	public void setDSO_contractuel(double dSO_contractuel) {
		DSO_contractuel = dSO_contractuel;
	}
	public double getTauxR() {
		return tauxR;
	}
	public void setTauxR(double tauxR) {
		this.tauxR = tauxR;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}
	
	
}
