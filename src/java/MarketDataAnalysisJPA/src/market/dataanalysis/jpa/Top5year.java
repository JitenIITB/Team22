package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the top5year database table.
 * 
 */
@Entity
@NamedQuery(name="Top5year.findAll", query="SELECT t FROM Top5year t")
public class Top5year implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tickerName;

	private BigDecimal v;

	public Top5year() {
	}

	public String getTickerName() {
		return this.tickerName;
	}

	public void setTickerName(String tickerName) {
		this.tickerName = tickerName;
	}

	public BigDecimal getV() {
		return this.v;
	}

	public void setV(BigDecimal v) {
		this.v = v;
	}

}