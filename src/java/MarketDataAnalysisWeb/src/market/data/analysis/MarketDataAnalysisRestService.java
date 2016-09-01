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

	public MarketDataAnalysisRestService() throws NamingException {
		InitialContext context = new InitialContext();
		bean = (MarketDataLocal) context
				.lookup("java:app/MarketDataAnalysisEJB/MarketData!market.dataanalysis.ejb.MarketDataLocal");
	}

	@GET
	@Produces("application/json")
	public List<BigDecimal> getTickerInfo(@QueryParam("filter") @DefaultValue("") String filter) {
		System.out.println(filter);
		return bean.getTickerInfo(filter);
	}

	@GET
	@Path("/getregionalinfo")
	@Produces("application/json")
	public List<BigDecimal> getRegionalInfo() {
		return bean.getRegionalInfo();
	}

	@GET
	@Path("/getsectorinfo/{sector}")
	@Produces("application/json")
	public List<BigDecimal> getSectorInfo(@PathParam("sector") String sector) {
		return bean.getSectorInfo(sector);
	}

	@GET
	@Path("/{filter}/{filter1}/{filter2}")
	@Produces("application/json")
	public List<BigDecimal> getTickerInfo(@PathParam("filter") String filter, @PathParam("filter1") String filter1,
			@PathParam("filter2") String filter2) {
		// System.out.println(filter);
		// return bean.getTickerInfo(filter);
		// }
		List<BigDecimal> list;
		list = bean.getTickerInfo(filter, filter1, filter2);
		return list;
	}
	
	

}
