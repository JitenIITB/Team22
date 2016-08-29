package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ticker database table.
 * 
 */
@Entity
@NamedQuery(name="Ticker.findAll", query="SELECT t FROM Ticker t")
public class Ticker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idticker;

	private String tickerName;

	//bi-directional many-to-one association to Priceclose
	@OneToMany(mappedBy="ticker")
	private List<Priceclose> pricecloses;

	//bi-directional many-to-one association to Priceopen
	@OneToMany(mappedBy="ticker")
	private List<Priceopen> priceopens;

	//bi-directional many-to-one association to Company
	@ManyToOne
	private Company company;

	//bi-directional many-to-one association to Stockexchange
	@ManyToOne
	private Stockexchange stockexchange;

	public Ticker() {
	}

	public int getIdticker() {
		return this.idticker;
	}

	public void setIdticker(int idticker) {
		this.idticker = idticker;
	}

	public String getTickerName() {
		return this.tickerName;
	}

	public void setTickerName(String tickerName) {
		this.tickerName = tickerName;
	}

	public List<Priceclose> getPricecloses() {
		return this.pricecloses;
	}

	public void setPricecloses(List<Priceclose> pricecloses) {
		this.pricecloses = pricecloses;
	}

	public Priceclose addPriceclos(Priceclose priceclos) {
		getPricecloses().add(priceclos);
		priceclos.setTicker(this);

		return priceclos;
	}

	public Priceclose removePriceclos(Priceclose priceclos) {
		getPricecloses().remove(priceclos);
		priceclos.setTicker(null);

		return priceclos;
	}

	public List<Priceopen> getPriceopens() {
		return this.priceopens;
	}

	public void setPriceopens(List<Priceopen> priceopens) {
		this.priceopens = priceopens;
	}

	public Priceopen addPriceopen(Priceopen priceopen) {
		getPriceopens().add(priceopen);
		priceopen.setTicker(this);

		return priceopen;
	}

	public Priceopen removePriceopen(Priceopen priceopen) {
		getPriceopens().remove(priceopen);
		priceopen.setTicker(null);

		return priceopen;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Stockexchange getStockexchange() {
		return this.stockexchange;
	}

	public void setStockexchange(Stockexchange stockexchange) {
		this.stockexchange = stockexchange;
	}

}