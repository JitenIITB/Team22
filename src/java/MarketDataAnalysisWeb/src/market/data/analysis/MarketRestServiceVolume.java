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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import market.dataanalysis.ejb.MarketDataLocal;
import market.dataanalysis.jpa.Top5Vol;
import market.dataanalysis.jpa.Top5month;
import market.dataanalysis.jpa.Top5year;

/**
 * @author Grad45
 *
 */
@RequestScoped
@Path("/volume")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MarketRestServiceVolume {
	
	private MarketDataLocal bean;

	public MarketRestServiceVolume() throws NamingException {
		InitialContext context = new InitialContext();
		bean = (MarketDataLocal) context
				.lookup("java:app/MarketDataAnalysisEJB/MarketData!market.dataanalysis.ejb.MarketDataLocal");
	}
	
	@GET
	@Produces("application/json")
	public List<Top5Vol> getTickerInfo() {
		return bean.getTop5();
	}
	
	@GET
	@Path("/month")
	@Produces("application/json")
	public List<Top5month> getTrendingMonth() {
		return bean.getTop5MonthAvg();
	}
	
	@GET
	@Path("/year")
	@Produces("application/json")
	public List<Top5year> getTrendingYear() {
		return bean.getTop5YearAvg();
	}
	
	@GET
	@Path("/month/{tick}")
	@Produces("application/json")
	public List<BigDecimal> getStockVolmonth(@PathParam("tick") String tick) {
		return bean.getStockMonthAvg(tick);
	}

	@GET
	@Path("/year/{tick}")
	@Produces("application/json")
	public List<BigDecimal> getStockVolYear(@PathParam("tick") String tick) {
		return bean.getStockYearAvg(tick);
	}
	
	@GET
	@Path("/day/{tick}")
	@Produces("application/json")
	public List<BigDecimal> getvol(@PathParam("tick") String tick) {
		return bean.getvol(tick);
	}

}
