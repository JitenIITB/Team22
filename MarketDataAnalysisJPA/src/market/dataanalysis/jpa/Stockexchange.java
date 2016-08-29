package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stockexchange database table.
 * 
 */
@Entity
@NamedQuery(name="Stockexchange.findAll", query="SELECT s FROM Stockexchange s")
public class Stockexchange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idStockExchange;

	private String stockExchangeName;

	//bi-directional many-to-one association to Country
	@ManyToOne
	private Country country;

	//bi-directional many-to-one association to Ticker
	@OneToMany(mappedBy="stockexchange")
	private List<Ticker> tickers;

	public Stockexchange() {
	}

	public int getIdStockExchange() {
		return this.idStockExchange;
	}

	public void setIdStockExchange(int idStockExchange) {
		this.idStockExchange = idStockExchange;
	}

	public String getStockExchangeName() {
		return this.stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Ticker> getTickers() {
		return this.tickers;
	}

	public void setTickers(List<Ticker> tickers) {
		this.tickers = tickers;
	}

	public Ticker addTicker(Ticker ticker) {
		getTickers().add(ticker);
		ticker.setStockexchange(this);

		return ticker;
	}

	public Ticker removeTicker(Ticker ticker) {
		getTickers().remove(ticker);
		ticker.setStockexchange(null);

		return ticker;
	}

}