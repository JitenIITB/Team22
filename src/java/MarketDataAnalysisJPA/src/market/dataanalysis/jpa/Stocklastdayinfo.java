package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the stocklastdayinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Stocklastdayinfo.findAll", query="SELECT s FROM Stocklastdayinfo s")
public class Stocklastdayinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal close;

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal open;

	@Id
	private String ticker;

	public Stocklastdayinfo() {
	}

	public BigDecimal getClose() {
		return this.close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getHigh() {
		return this.high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return this.low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getOpen() {
		return this.open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

}