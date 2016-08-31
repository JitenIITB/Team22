package market.dataanalysis.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import market.dataanalysis.jpa.Country;

/**
 * Session Bean implementation class MarketData
 */
@Local(MarketDataLocal.class)
@Remote(MarketDataRemote.class)
@Stateless
public class MarketData implements MarketDataRemote, MarketDataLocal {

	/**
	 * Default constructor.
	 */
	public MarketData() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(name = "MarketDataAnalysisJPA-PU")
	private EntityManager em;

	@Override
	public List<Country> testMethod() {
		// TODO Auto-generated method stub

		TypedQuery<Country> query = em.createQuery("select c from Country as c", Country.class);

		List<Country> pro = query.getResultList();
		return pro;
	}

	@Override
	 public List<BigDecimal> getTickerInfo(String name1) {
	//public String getTickerInfo(String name1) {
		 Query query = em.createQuery("select t.priceClose from TickersInfo as t where t.tickerName= :name");

		 query.setParameter("name", name1 );
		 List<BigDecimal> pro = query.getResultList();
		return pro;
	}

}
