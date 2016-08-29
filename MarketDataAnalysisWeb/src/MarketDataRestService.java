import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import market.dataanalysis.ejb.MarketDataLocal;
import market.dataanalysis.jpa.Country;

@RequestScoped
@Path("/market")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MarketDataRestService {
	
	private MarketDataLocal bean;
	
	public MarketDataRestService(){
		
		try {
			InitialContext context= new InitialContext();
			bean = (MarketDataLocal)context.lookup("java:app/MarketDataAnalysisEJB/MarketData!market.dataanalysis.ejb.MarketDataLocal");
			System.out.println("helloo");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

	@GET
	@Produces("application/json")
	public List<Country> testing(){
		
		
		List<Country> l;
		
		l=(List<Country>)bean.testMethod();
		
		
		
		return l;
				
	}
	
	
	
	
	

}
