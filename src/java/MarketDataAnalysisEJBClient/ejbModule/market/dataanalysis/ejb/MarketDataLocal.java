package market.dataanalysis.ejb;

import java.util.List;

import javax.ejb.Local;

import market.dataanalysis.jpa.Country;

@Local
public interface MarketDataLocal {

	public List<Country> testMethod();
	//public List<String> testMethod();
}
