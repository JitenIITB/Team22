package market.dataanalysis.ejb;

import java.util.List;

import javax.ejb.Remote;

import market.dataanalysis.jpa.Country;

@Remote
public interface MarketDataRemote {
	public List<Country> testMethod();
	//public List<String> testMethod();
	
}
