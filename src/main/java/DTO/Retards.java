package DTO;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retards {
private double retardsT;

public Retards() {
	super();
}

public Retards(double retardsT) {
	super();
	this.retardsT = retardsT;
}

public double getRetardsT() {
	return retardsT;
}

public void setRetardsT(double retardsT) {
	this.retardsT = retardsT;
}

}
