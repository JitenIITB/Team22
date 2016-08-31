package market.dataanalysis.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import market.dataanalysis.jpa.Country;
import market.dataanalysis.jpa.Priceclose;

@Local
public interface MarketDataLocal {

	public List<Country> testMethod();
	// public List<String> testMethod();
	// public List<BigDecimal> getPriceOfStock(String tickerName1);

	public List<BigDecimal> getTickerInfo(String name1);

	// public String getTickerInfo(String name1) ;

	// public List<Priceclose> gettest(int tick);

}
