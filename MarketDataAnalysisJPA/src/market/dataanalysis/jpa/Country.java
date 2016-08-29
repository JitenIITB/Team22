package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcountry;

	private String countryName;

	//bi-directional many-to-one association to Region
	@ManyToOne
	private Region region;

	//bi-directional many-to-one association to Stockexchange
	@OneToMany(mappedBy="country")
	private List<Stockexchange> stockexchanges;

	public Country() {
	}

	public int getIdcountry() {
		return this.idcountry;
	}

	public void setIdcountry(int idcountry) {
		this.idcountry = idcountry;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Stockexchange> getStockexchanges() {
		return this.stockexchanges;
	}

	public void setStockexchanges(List<Stockexchange> stockexchanges) {
		this.stockexchanges = stockexchanges;
	}

	public Stockexchange addStockexchange(Stockexchange stockexchange) {
		getStockexchanges().add(stockexchange);
		stockexchange.setCountry(this);

		return stockexchange;
	}

	public Stockexchange removeStockexchange(Stockexchange stockexchange) {
		getStockexchanges().remove(stockexchange);
		stockexchange.setCountry(null);

		return stockexchange;
	}

}