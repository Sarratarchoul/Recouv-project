package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prevision {
	private double nonechu;
	private double promesse;
	private String mois;
	
	
	public Prevision() {
		super();
	}
	public Prevision(double nonechu, double promesse, String mois) {
		super();
		this.nonechu = nonechu;
		this.promesse = promesse;
		this.mois = mois;
	}
	public double getNonechu() {
		return nonechu;
	}
	public void setNonechu(double nonechu) {
		this.nonechu = nonechu;
	}
	public double getPromesse() {
		return promesse;
	}
	public void setPromesse(double promesse) {
		this.promesse = promesse;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	
}
