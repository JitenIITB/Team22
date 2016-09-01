package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the top_five_gainers database table.
 * 
 */
@Entity
@Table(name="top_five_gainers")
@NamedQuery(name="TopFiveGainer.findAll", query="SELECT t FROM TopFiveGainer t")
public class TopFiveGainer implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal gain;

	@Id
	private String ticker;

	public TopFiveGainer() {
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