package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the gainer_top_month database table.
 * 
 */
@Entity
@Table(name="gainer_top_month")
@NamedQuery(name="GainerTopMonth.findAll", query="SELECT g FROM GainerTopMonth g")
public class GainerTopMonth implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal monthlyGain;

	@Id
	private String ticker;

	private int tickerID;

	public GainerTopMonth() {
	}

	public BigDecimal getMonthlyGain() {
		return this.monthlyGain;
	}

	public void setMonthlyGain(BigDecimal monthlyGain) {
		this.monthlyGain = monthlyGain;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getTickerID() {
		return this.tickerID;
	}

	public void setTickerID(int tickerID) {
		this.tickerID = tickerID;
	}

}