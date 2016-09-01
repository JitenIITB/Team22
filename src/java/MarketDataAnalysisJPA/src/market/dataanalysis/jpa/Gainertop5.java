package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the gainertop5 database table.
 * 
 */
@Entity
@NamedQuery(name="Gainertop5.findAll", query="SELECT g FROM Gainertop5 g")
public class Gainertop5 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date date;

	private BigDecimal gain;

	@Id
	private String ticker;

	public Gainertop5() {
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getGain() {
		return this.gain;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}