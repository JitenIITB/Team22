package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the priceopen database table.
 * 
 */
@Entity
@NamedQuery(name="Priceopen.findAll", query="SELECT p FROM Priceopen p")
public class Priceopen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPriceOpen;

	private BigDecimal priceOpen;

	//bi-directional many-to-one association to Marketday
	@ManyToOne
	@JoinColumn(name="MarketDays_idMarketDays")
	private Marketday marketday;

	//bi-directional many-to-one association to Ticker
	@ManyToOne
	private Ticker ticker;

	public Priceopen() {
	}

	public int getIdPriceOpen() {
		return this.idPriceOpen;
	}

	public void setIdPriceOpen(int idPriceOpen) {
		this.idPriceOpen = idPriceOpen;
	}

	public BigDecimal getPriceOpen() {
		return this.priceOpen;
	}

	public void setPriceOpen(BigDecimal priceOpen) {
		this.priceOpen = priceOpen;
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