package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the top_5_vol database table.
 * 
 */
@Entity
@Table(name="top_5_vol")
@NamedQuery(name="Top5Vol.findAll", query="SELECT t FROM Top5Vol t")
public class Top5Vol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPriceClose;

	@Temporal(TemporalType.DATE)
	private Date marketdays;

	private BigDecimal priceClose;

	private String tickerName;

	private int volume;

	public Top5Vol() {
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

	public BigDecimal getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(BigDecimal priceClose) {
		this.priceClose = priceClose;
	}

	public String getTickerName() {
		return this.tickerName;
	}

	public void setTickerName(String tickerName) {
		this.tickerName = tickerName;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}