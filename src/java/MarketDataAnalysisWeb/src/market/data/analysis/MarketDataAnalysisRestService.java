/**
 * 
 */
package market.data.analysis;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import market.dataanalysis.ejb.MarketDataLocal;

/**
 * @author Grad45
 *
 */
@RequestScoped
@Path("/market")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MarketDataAnalysisRestService {
	
	private MarketDataLocal bean;
	public MarketDataAnalysisRestService() throws NamingException{
		InitialContext context = new InitialContext();
		bean = (MarketDataLocal)context.lookup("java:app/MarketDataAnalysisEJB/MarketData!market.dataanalysis.ejb.MarketDataLocal");
	}
	
	@GET
	@Produces("application/json")
	public List<BigDecimal> testing2(@QueryParam("filter")@DefaultValue("") String filter) {
		System.out.println(filter);
		return bean.getTickerInfo(filter);
	}

}
