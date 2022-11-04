package DTO;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture_client {
private long code_client;
private double ecours;
private double retard;

public Facture_client() {
	super();
}

public Facture_client(long code_client, double ecours, double retard) {
	super();
	this.code_client = code_client;
	this.ecours = ecours;
	this.retard = retard;
}

public long getCode_client() {
	return code_client;
}

public void setCode_client(long code_client) {
	this.code_client = code_client;
}

public double getEcours() {
	return ecours;
}

public void setEcours(double ecours) {
	this.ecours = ecours;
}

public double getRetard() {
	return retard;
}

public void setRetard(double retard) {
	this.retard = retard;
}

}
