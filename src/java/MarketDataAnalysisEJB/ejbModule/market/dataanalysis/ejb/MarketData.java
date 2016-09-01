package market.dataanalysis.ejb;

import java.math.BigDecimal;
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
import market.dataanalysis.jpa.GainerTopMonth;
import market.dataanalysis.jpa.Gainertop5;
import market.dataanalysis.jpa.Stocklastdayinfo;
import market.dataanalysis.jpa.Top5Vol;
import market.dataanalysis.jpa.Top5month;
import market.dataanalysis.jpa.Top5year;
import market.dataanalysis.jpa.TopFiveGainer;

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
	
	public List<Top5month> getTop5MonthAvg()
	{
		
		String sql="select m from Top5month as m";
		TypedQuery<Top5month> query = em.createQuery(sql,Top5month.class);

		List<Top5month> pro = query.setMaxResults(5).getResultList();
		return pro;
	}
	

	public List<Top5year> getTop5YearAvg()
	{
		
		String sql="select y from Top5year as y";
		TypedQuery<Top5year> query = em.createQuery(sql,Top5year.class);

		List<Top5year> pro = query.setMaxResults(5).getResultList();
		return pro;
	}
	
	public List<BigDecimal> getStockMonthAvg(String ticker)
	{
		
		String sql="select m.v from Top5month as m where m.tickerName= :name";
		Query query = em.createQuery(sql);
		query.setParameter("name", ticker);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}
	
	public List<BigDecimal> getStockYearAvg(String ticker)
	{
		
		String sql="select m.v from Top5year as m where m.tickerName= :name";
		Query query = em.createQuery(sql);
		query.setParameter("name", ticker);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}
	
	public List<BigDecimal> getvol(String tick)
	{
		
		String sql="select t.volume from Top5Vol as t" + " where t.marketdays =" + "'2011-12-30'"
		+" and t.tickerName= :name " ;
		Query query = em.createQuery(sql);
		query.setParameter("name", tick);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}
	
	public List<Stocklastdayinfo> getStockInfo(String tick)
	{
		
		String sql="select y from Stocklastdayinfo as y where y.ticker= :name";
		TypedQuery<Stocklastdayinfo> query = em.createQuery(sql,Stocklastdayinfo.class);
		query.setParameter("name", tick);

		List<Stocklastdayinfo> pro = query.getResultList();
		return pro;
	}
	
	public List<Gainertop5> getTop5gainers()
	{
		
		String sql="select t from Gainertop5 as t";
		TypedQuery<Gainertop5> query = em.createQuery(sql,Gainertop5.class);

		List<Gainertop5> pro = query.setMaxResults(5).getResultList();
		return pro;
	}
	
	public List<GainerTopMonth> getTop5MonthGain()
	{
		
		String sql="select m from GainerTopMonth as m order by m.monthlyGain desc";
		TypedQuery<GainerTopMonth> query = em.createQuery(sql,GainerTopMonth.class);
		List<GainerTopMonth> pro = query.setMaxResults(5).getResultList();
		return pro;
	}
	
	public List<TopFiveGainer> getTop5Yeargainer()
	{
		
		String sql="select m from TopFiveGainer as m";
		TypedQuery<TopFiveGainer> query = em.createQuery(sql,TopFiveGainer.class);
		List<TopFiveGainer> pro = query.getResultList();
		return pro;
	}
	
	public List<BigDecimal> getProfit(String ticker)
	{
		
		String sql="select m.dif from Profit as m where m.ticker= :name";
		Query query = em.createQuery(sql);
		query.setParameter("name", ticker);
		List<BigDecimal> pro = query.getResultList();
		return pro;
	}

}
