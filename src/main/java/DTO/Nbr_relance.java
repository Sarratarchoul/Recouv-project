package DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nbr_relance {
	private long relance;

	public Nbr_relance() {
		super();
	}

	public Nbr_relance(long relance) {
		super();
		this.relance = relance;
	}

	public long getRelance() {
		return relance;
	}

	public void setRelance(long relance) {
		this.relance = relance;
	}
	

}
