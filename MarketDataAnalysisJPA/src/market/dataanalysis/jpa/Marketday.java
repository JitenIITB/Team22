package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the marketdays database table.
 * 
 */
@Entity
@Table(name="marketdays")
@NamedQuery(name="Marketday.findAll", query="SELECT m FROM Marketday m")
public class Marketday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMarketDays;

	@Temporal(TemporalType.DATE)
	private Date marketdays;

	//bi-directional many-to-one association to Priceclose
	@OneToMany(mappedBy="marketday")
	private List<Priceclose> pricecloses;

	//bi-directional many-to-one association to Priceopen
	@OneToMany(mappedBy="marketday")
	private List<Priceopen> priceopens;

	public Marketday() {
	}

	public int getIdMarketDays() {
		return this.idMarketDays;
	}

	public void setIdMarketDays(int idMarketDays) {
		this.idMarketDays = idMarketDays;
	}

	public Date getMarketdays() {
		return this.marketdays;
	}

	public void setMarketdays(Date marketdays) {
		this.marketdays = marketdays;
	}

	public List<Priceclose> getPricecloses() {
		return this.pricecloses;
	}

	public void setPricecloses(List<Priceclose> pricecloses) {
		this.pricecloses = pricecloses;
	}

	public Priceclose addPriceclos(Priceclose priceclos) {
		getPricecloses().add(priceclos);
		priceclos.setMarketday(this);

		return priceclos;
	}

	public Priceclose removePriceclos(Priceclose priceclos) {
		getPricecloses().remove(priceclos);
		priceclos.setMarketday(null);

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
		priceopen.setMarketday(this);

		return priceopen;
	}

	public Priceopen removePriceopen(Priceopen priceopen) {
		getPriceopens().remove(priceopen);
		priceopen.setMarketday(null);

		return priceopen;
	}

}