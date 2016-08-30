package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCompany;

	private String companyName;

	//bi-directional many-to-one association to Sector
	@ManyToOne
	@JsonManagedReference
	private Sector sector;

	//bi-directional many-to-one association to Ticker
	@OneToMany(mappedBy="company")
	@JsonBackReference
	private List<Ticker> tickers;

	public Company() {
	}

	public int getIdCompany() {
		return this.idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<Ticker> getTickers() {
		return this.tickers;
	}

	public void setTickers(List<Ticker> tickers) {
		this.tickers = tickers;
	}

	public Ticker addTicker(Ticker ticker) {
		getTickers().add(ticker);
		ticker.setCompany(this);

		return ticker;
	}

	public Ticker removeTicker(Ticker ticker) {
		getTickers().remove(ticker);
		ticker.setCompany(null);

		return ticker;
	}

}