package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;


/**
 * The persistent class for the priceclose database table.
 * 
 */
@Entity
@NamedQuery(name="Priceclose.findAll", query="SELECT p FROM Priceclose p")
public class Priceclose implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPriceClose;

	private BigDecimal priceClose;

	//bi-directional many-to-one association to Marketday
	@ManyToOne
	@JoinColumn(name="MarketDays_idMarketDays")
	@JsonManagedReference
	private Marketday marketday;

	//bi-directional many-to-one association to Ticker
	@ManyToOne
	@JsonManagedReference
	private Ticker ticker;

	public Priceclose() {
	}

	public int getIdPriceClose() {
		return this.idPriceClose;
	}

	public void setIdPriceClose(int idPriceClose) {
		this.idPriceClose = idPriceClose;
	}

	public BigDecimal getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(BigDecimal priceClose) {
		this.priceClose = priceClose;
	}

	public Marketday getMarketday() {
		return this.marketday;
	}

	public void setMarketday(Marketday marketday) {
		this.marketday = marketday;
	}

	public Ticker getTicker() {
		return this.ticker;
	}

	public void setTicker(Ticker ticker) {
		this.ticker = ticker;
	}

}