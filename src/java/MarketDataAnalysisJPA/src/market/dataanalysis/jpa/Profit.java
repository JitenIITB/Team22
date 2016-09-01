package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the profit database table.
 * 
 */
@Entity
@NamedQuery(name="Profit.findAll", query="SELECT p FROM Profit p")
public class Profit implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal dif;

	@Id
	private String ticker;

	public Profit() {
	}

	public BigDecimal getDif() {
		return this.dif;
	}

	public void setDif(BigDecimal dif) {
		this.dif = dif;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}