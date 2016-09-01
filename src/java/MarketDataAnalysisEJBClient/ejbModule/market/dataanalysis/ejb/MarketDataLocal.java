package market.dataanalysis.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import market.dataanalysis.jpa.Country;
import market.dataanalysis.jpa.GainerTopMonth;
import market.dataanalysis.jpa.Gainertop5;
import market.dataanalysis.jpa.Stocklastdayinfo;
import market.dataanalysis.jpa.Top5Vol;
import market.dataanalysis.jpa.Top5month;
import market.dataanalysis.jpa.Top5year;
import market.dataanalysis.jpa.TopFiveGainer;

@Local
public interface MarketDataLocal {

	public List<Country> testMethod();
	public List<BigDecimal> getTickerInfo(String name1, String date1, String date2);
	public List<BigDecimal> getTickerInfo(String name1);
	public List<BigDecimal> getSectorInfo(String name1);
	public List<BigDecimal> getRegionalInfo();
	public List<Top5Vol> getTop5();
	public List<Top5month> getTop5MonthAvg();
	public List<Top5year> getTop5YearAvg();
	public List<BigDecimal> getStockMonthAvg(String ticker);
	public List<BigDecimal> getStockYearAvg(String ticker);
	public List<BigDecimal> getvol(String tick);
	public List<Stocklastdayinfo> getStockInfo(String tick);
	public List<Gainertop5> getTop5gainers();
	public List<GainerTopMonth> getTop5MonthGain();
	public List<TopFiveGainer> getTop5Yeargainer();
	public List<BigDecimal> getProfit(String ticker);

}
