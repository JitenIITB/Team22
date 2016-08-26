package student.onlineretailer.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import student.onlineretailer.jpa.Category;
import student.onlineretailer.jpa.Products;

/**
 * Session Bean implementation class OnlineRetailerBean
 */
@Stateless
@Remote(OnlineRetailerBeanRemote.class) 
@Local(OnlineRetailerBeanLocal.class)
public class OnlineRetailerBean implements OnlineRetailerBeanRemote, OnlineRetailerBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="StudentOnlineRetailerJPA-PU")
	private EntityManager em;
	
	
	public void addCategoriesAndProducts(){
		Category cat1 = new Category();
		cat1.setCategoryID(1);
		cat1.setCategoryName("Cars");
		cat1.setCategoryDescription("These are cars");
		
		Products prod1 = new Products();
		prod1.setProductID(1);
		prod1.setProductName("Lamborghini");
		prod1.setUnitPrice(300000.00);
		prod1.setUnitsInStocks(100);
		prod1.setReorderLevel(1);
		cat1.getProducts().add(prod1);
		em.persist(prod1);
		System.out.println("persisted: "+prod1);
		
		Products prod2 = new Products();
		prod2.setProductID(2);
		prod2.setProductName("Ferrari");
		prod2.setUnitPrice(200000.00);
		prod2.setUnitsInStocks(200);
		prod2.setReorderLevel(1);
		cat1.getProducts().add(prod2);
		em.persist(prod2);
		System.out.println("persisted: "+prod2);
	}
	public List<Products> getAllProducts() {

        TypedQuery<Products> query = em.createQuery("SELECT p FROM Product AS p", Products.class);

        // Execute the query, and get a collection of entities back.
        List<Products> product = query.getResultList();

        for (Products products: product) {
            displayProductsOnServerConsole("Got product in getAllProducts()", products);
        }

        return product;
    }
	public List<Products> getProductsByName(String productName) {

    	String sql = "SELECT p FROM Product AS p WHERE p.productName LIKE '%" + productName + "%'";
        System.out.println(sql);
        TypedQuery<Products> query = em.createQuery(sql, Products.class);

        // Execute the query, and get a collection of products back.
        List<Products> products = query.getResultList();

        for (Products product: products) {
            displayProductsOnServerConsole("Got product in getProductsByName()", product);
        }

        return products;
    }
	public List<Products> getProductsInCategory(String categoryName) {

        TypedQuery<Products> query = em.createQuery("SELECT p FROM Product AS p WHERE p.category.categoryName = :name", Products.class);
        query.setParameter("name", categoryName);

        // Execute the query, and get a collection of products back.
        List<Products> products = query.getResultList();

        for (Products product: products) {
            displayProductsOnServerConsole("Got product in getProductsInCategory()", product);
        }

        return products;
    }
	public void increaseAllPrices(double delta) {

        // Get all products from the database.
        List<Products> products = getAllProducts();

        for (Products product: products) {
            double currentPrice = product.getUnitPrice();
            double newPrice = currentPrice + delta;
            product.setUnitPrice(newPrice);
        }

        // No need to manually save in database, EM will do it automatically.
    }
	private void displayProductsOnServerConsole(String message, Products product) {

        System.out.println(message);
        if (product == null) {
            System.out.print("Product is null");
        } else {
            System.out.println(product);
        }
    }
	
    public OnlineRetailerBean() {
    	
    		
    	}
        // TODO Auto-generated constructor stub

}
