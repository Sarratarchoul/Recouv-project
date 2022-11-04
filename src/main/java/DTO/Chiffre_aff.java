package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chiffre_aff {
	private double chiffre_aff;

	public Chiffre_aff() {
		super();
	}

	public Chiffre_aff(double chiffre_aff) {
		super();
		this.chiffre_aff = chiffre_aff;
	}

	public double getChiffre_aff() {
		return chiffre_aff;
	}

	public void setChiffre_aff(double chiffre_aff) {
		this.chiffre_aff = chiffre_aff;
	}
}
