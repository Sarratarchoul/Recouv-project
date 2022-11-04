package DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statuts {
private long count;
private String status;

public Statuts() {
	super();
}
public Statuts(long count, String status) {
	super();
	this.count = count;
	this.status = status;
}
public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
