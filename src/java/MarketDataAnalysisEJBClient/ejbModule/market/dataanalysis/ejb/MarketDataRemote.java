package market.dataanalysis.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import market.dataanalysis.jpa.Country;
import market.dataanalysis.jpa.Priceclose;
import market.dataanalysis.jpa.Top5Vol;

@Remote
public interface MarketDataRemote {
	public List<Country> testMethod();
	
	public List<BigDecimal> getTickerInfo(String name1);
	public List<BigDecimal> getTickerInfo(String name1, String date1, String date2);
	public List<BigDecimal> getSectorInfo(String name1);
	public List<BigDecimal> getRegionalInfo();
	public List<Top5Vol> getTop5();

}
