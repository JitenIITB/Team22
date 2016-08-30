package market.dataanalysis.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import market.dataanalysis.jpa.Country;

/**
 * Session Bean implementation class MarketData
 */
@Local(MarketDataLocal.class)
@Remote(MarketDataRemote.class)
@Stateful
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
		// System.out.println("hello");
		// Execute the query, and get a collection of entities back.
		List<Country> pro = query.getResultList();
		//System.out.println("hellovvv");

//		for (Country i : pro) {
//			displayCountriesOnServerConsole("Got countries in testMethod()", i);
//		}

		return pro;
	}
//	public List<String> testMethod()
//	{
//	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "MarketDataAnalysisJPA-PU" );
//    EntityManager entitymanager = emfactory.createEntityManager();
//
//    //Scalar function
//    Query query = entitymanager.
//    createQuery("Select UPPER(e.countryName) from Country e",Country.class);
//    List<String> list = query.getResultList();
//
//    for(String e:list) {
//       System.out.println("COUNTRY NAME :"+e);
//    }
//    return list;
//	}
	// public List<Priceclose> testMethod2() {
	// // TODO Auto-generated method stub
	//
	// TypedQuery<Priceclose> query= em.createQuery("select p from Priceclose as
	// p where (ticker_idticker = (select idticker from ticker where tickerName=
	// "AAPL"))& MarketDays_idMarketDays between 1 and 30 "), Priceclose.class);
	// // Execute the query, and get a collection of entities back.
	// List<Priceclose> pro =query.getResultList();
	//
	//// for (Priceclose i: pro) {
	//// displayCountriesOnServerConsole("Got countries in testMethod()", i);
	//// }
	//
	// return pro;
	// }
	//

	private void displayCountriesOnServerConsole(String string, Country i) {

		// TODO Auto-generated method stub
		System.out.println(string);
		if (i == null) {
			System.out.print("City is null");
		} else {
			System.out.println(i.getCountryName() + " " + i.getIdcountry() + " " + i.getRegion());
		}

	}

}
