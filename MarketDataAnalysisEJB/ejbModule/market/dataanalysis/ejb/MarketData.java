package market.dataanalysis.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    
    
    @PersistenceContext(name="MarketDataAnalysisJPA-PU")
    private EntityManager em;

    

	@Override
	public List<Country> testMethod() {
		// TODO Auto-generated method stub
		
		Query query= em.createNamedQuery("SELECT p from country as p", Country.class);
		 // Execute the query, and get a collection of entities back.
        List<Country> pro =query.getResultList();

        for (Country i: pro) {
            displayCountriesOnServerConsole("Got product in getAllProducts()", i);
        }

        return pro;
}
	
	
	private void displayCountriesOnServerConsole(String string, Country i) {
		
		// TODO Auto-generated method stub
		System.out.println(string);
        if (i == null) {
            System.out.print("City is null");
        } else {
            System.out.println(i);
        }
		
	}
		
		
		
	



}
