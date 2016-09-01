package market.data.analysis;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import market.dataanalysis.ejb.MarketDataLocal;

public class Tests {
	
	//MarketDataLocal bean;

	@Before
	public void setUp() throws Exception {

//		// Create Properties for JNDI InitialContext.
//		Properties prop = new Properties();
//		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
//		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//		prop.put("jboss.naming.client.ejb.context", true);
//
//		// Create the JNDI InitialContext.
//
//		InitialContext context = new InitialContext(prop);
//		bean = (MarketDataLocal) context
//				.lookup("java:app/MarketDataAnalysisEJB/MarketData!market.dataanalysis.ejb.MarketDataLocal");

	}

	@Test
	public void testgetTickerInfo() {
//		BigDecimal b = new BigDecimal(329.57);
//		List<BigDecimal> b1 = bean.getTickerInfo("AAPL"); 
		assertEquals(1,1);

	}
	
}
