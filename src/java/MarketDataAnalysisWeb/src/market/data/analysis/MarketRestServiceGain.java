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
import market.dataanalysis.jpa.GainerTopMonth;
import market.dataanalysis.jpa.Gainertop5;
import market.dataanalysis.jpa.TopFiveGainer;

@RequestScoped
@Path("/gain")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MarketRestServiceGain {
	
	private MarketDataLocal bean;

	public MarketRestServiceGain() throws NamingException {
		InitialContext context = new InitialContext();
		bean = (MarketDataLocal) context
				.lookup("java:app/MarketDataAnalysisEJB/MarketData!market.dataanalysis.ejb.MarketDataLocal");
	}
	
	@GET
	@Produces("application/json")
	public List<Gainertop5> gettopGainers() {
		return bean.getTop5gainers();
	}
	
	@GET
	@Path("/month")
	@Produces("application/json")
	public List<GainerTopMonth> gettopGainersMonth() {
		return bean.getTop5MonthGain();
	}
	
	@GET
	@Path("/year")
	@Produces("application/json")
	public List<TopFiveGainer> gettopGainersYear() {
		return bean.getTop5Yeargainer();
	}
	
	@GET
	@Path("/profit/{tick}")
	@Produces("application/json")
	public List<BigDecimal> getProfit(@PathParam("tick") String tick) {
		return bean.getProfit(tick);
	}
	


	
}
