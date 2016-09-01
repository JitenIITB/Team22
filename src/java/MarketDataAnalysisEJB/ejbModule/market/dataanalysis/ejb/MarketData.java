package market.dataanalysis.ejb;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import market.dataanalysis.jpa.Country;
import market.dataanalysis.jpa.Top5Vol;

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

	// method to get the price close for particular task all the year
	@Override
	public List<BigDecimal> getTickerInfo(String name1) {
		Query query = em.createQuery("select t.priceClose from TickersInfo as t where t.tickerName= :name");

		query.setParameter("name", name1);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}

	// method to get the average Price Close for particular sector all the year
	@Override
	public List<BigDecimal> getSectorInfo(String name1) {
		Query query = em.createQuery("select s.avgPriceClose from SectorsInfo as s where s.sectorName= :name");

		query.setParameter("name", name1);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}

	// to get the price close values for nasdaq
	@Override
	public List<BigDecimal> getRegionalInfo() {
		// TODO Auto-generated method stub

		Query query = em.createQuery("select n.priceIndex from Nasdaq as n");

		List<BigDecimal> pro = query.getResultList();
		return pro;
	}

	//// method to get the price close for particular stock for a particular
	//// time period
	public List<BigDecimal> getTickerInfo(String name1, String date1, String date2) {

		Date startDate = null;
		Date endDate = null;

		String[] arr = date1.split("-");
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int day = Integer.parseInt(arr[2]);

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day, 0, 0, 0);
		startDate = calendar.getTime();

		String[] arr1 = date2.split("-");
		int year1 = Integer.parseInt(arr1[0]);
		int month1 = Integer.parseInt(arr1[1]);
		int day1 = Integer.parseInt(arr1[2]);

		calendar.set(year1, month1 - 1, day1, 0, 0, 0);
		endDate = calendar.getTime();

		String sql = "select t.priceClose from TickersInfo as t where t.tickerName= :name"
				+ " and t.marketdays between :atemp1 and :atemp2";

		Query query = em.createQuery(sql);
		query.setParameter("name", name1);
		query.setParameter("atemp1", startDate, TemporalType.DATE);
		query.setParameter("atemp2", endDate, TemporalType.DATE);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}
	
	//method to return top 5 trending stocks(Based on volume) for the present(last date) date
	
	public List<Top5Vol> getTop5()
	{
		
		String sql="select t from Top5Vol as t" + " where t.marketdays =" + "'2011-12-30'"
		+" order by t.volume desc " ;
		TypedQuery<Top5Vol> query = em.createQuery(sql,Top5Vol.class);

		List<Top5Vol> pro = query.setMaxResults(5).getResultList();
		return pro;
	}

}
