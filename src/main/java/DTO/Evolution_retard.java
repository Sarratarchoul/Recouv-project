package DTO;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evolution_retard {
private double ecoursT;
private double ecoursR;
private String mois;
private double tauxR;

public Evolution_retard() {
	super();
}

public Evolution_retard(double ecoursT, double ecoursR, String mois, double tauxR) {
	super();
	this.ecoursT = ecoursT;
	this.ecoursR = ecoursR;
	this.mois = mois;
	this.tauxR = tauxR;
}

public double getEcoursT() {
	return ecoursT;
}

public void setEcoursT(double ecoursT) {
	this.ecoursT = ecoursT;
}

public double getEcoursR() {
	return ecoursR;
}

public void setEcoursR(double ecoursR) {
	this.ecoursR = ecoursR;
}

public String getMois() {
	return mois;
}

public void setMois(String mois) {
	this.mois = mois;
}

public double getTauxR() {
	return tauxR;
}

public void setTauxR(double tauxR) {
	this.tauxR = tauxR;
}


}
