package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the nasdaq database table.
 * 
 */
@Entity
@NamedQuery(name="Nasdaq.findAll", query="SELECT n FROM Nasdaq n")
public class Nasdaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPriceClose;

	@Temporal(TemporalType.DATE)
	private Date marketdays;

	private BigDecimal priceIndex;

	public Nasdaq() {
	}

	public int getIdPriceClose() {
		return this.idPriceClose;
	}

	public void setIdPriceClose(int idPriceClose) {
		this.idPriceClose = idPriceClose;
	}

	public Date getMarketdays() {
		return this.marketdays;
	}

	public void setMarketdays(Date marketdays) {
		this.marketdays = marketdays;
	}

	public BigDecimal getPriceIndex() {
		return this.priceIndex;
	}

	public void setPriceIndex(BigDecimal priceIndex) {
		this.priceIndex = priceIndex;
	}

}