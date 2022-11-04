package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Balanceagee {
	
private double echu;
private double nonechupremier;
private double nonechudeux;
private double nonechutrois;
private double nonechuquatre;

public Balanceagee(double echu, double nonechupremier, double nonechudeux, double nonechutrois, double nonechuquatre) {
	super();
	this.echu = echu;
	this.nonechupremier = nonechupremier;
	this.nonechudeux = nonechudeux;
	this.nonechutrois = nonechutrois;
	this.nonechuquatre = nonechuquatre;
}
public double getEchu() {
	return echu;
}
public void setEchu(double echu) {
	this.echu = echu;
}
public double getNonechupremier() {
	return nonechupremier;
}
public void setNonechupremier(double nonechupremier) {
	this.nonechupremier = nonechupremier;
}
public double getNonechutrois() {
	return nonechutrois;
}
public void setNonechutrois(double nonechutrois) {
	this.nonechutrois = nonechutrois;
}
public double getNonechudeux() {
	return nonechudeux;
}
public void setNonechudeux(double nonechudeux) {
	this.nonechudeux = nonechudeux;
}
public double getNonechuquatre() {
	return nonechuquatre;
}
public void setNonechuquatre(float nonechuquatre) {
	this.nonechuquatre = nonechuquatre;
}

}
