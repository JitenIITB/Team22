package market.dataanalysis.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import market.dataanalysis.jpa.Country;
import market.dataanalysis.jpa.Priceclose;

@Remote
public interface MarketDataRemote {
	public List<Country> testMethod();
	// public List<String> testMethod();
	// public List<BigDecimal> getPriceOfStock(String tickerName1);

	// public List<Priceclose> gettest(int tick);

	public List<BigDecimal> getTickerInfo(String name1);

	// public String getTickerInfo(String name1) ;

}
