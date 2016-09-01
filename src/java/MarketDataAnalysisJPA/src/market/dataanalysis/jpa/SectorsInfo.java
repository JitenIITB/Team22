package market.dataanalysis.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sectors_info database table.
 * 
 */
@Entity
@Table(name="sectors_info")
@NamedQuery(name="SectorsInfo.findAll", query="SELECT s FROM SectorsInfo s")
public class SectorsInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal avgPriceClose;

	@Id
	private int idPriceClose;

	@Temporal(TemporalType.DATE)
	private Date marketdays;

	private String sectorName;

	public SectorsInfo() {
	}

	public BigDecimal getAvgPriceClose() {
		return this.avgPriceClose;
	}

	public void setAvgPriceClose(BigDecimal avgPriceClose) {
		this.avgPriceClose = avgPriceClose;
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

	public String getSectorName() {
		return this.sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

}