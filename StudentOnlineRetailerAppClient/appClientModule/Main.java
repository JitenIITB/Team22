import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import student.onlineretailer.ejb.OnlineRetailerBeanRemote;
import student.onlineretailer.jpa.Products;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * (non-Java-doc)
		 * 
		 * @see java.lang.Object#Object()
		 */
		// Create Properties for JNDI InitialContext.
		try {
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,
					org.jboss.naming.remote.client.InitialContextFactory.class.getName());
			prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			prop.put("jboss.naming.client.ejb.context", true);
			// Create the JNDI InitialContext.
			InitialContext context = new InitialContext(prop);

			// Formulate the full JNDI name for the OnlineRetailer session bean.
			String appName = "StudentOnlineRetailer";
			String moduleName = "StudentOnlineRetailerEJB";
			String beanName = "OnlineRetailerBean";
			String packageName = "student.onlineretailer.ejb";
			String className = "OnlineRetailerBeanRemote";

			// Lookup the bean using the full JNDI name.
			String fullJndiName = String.format("%s/%s/%s!%s.%s", appName, moduleName, beanName, packageName,className);
			OnlineRetailerBeanRemote bean = (OnlineRetailerBeanRemote) context.lookup(fullJndiName);
			
			//System.out.println("Hello");
			bean.addCategoriesAndProducts();

			List<Products> products = bean.getAllProducts();
			displayProducts("All products", products);
//
//			products = bean.getProductsByName("jersey");
//			displayProducts("Products by name", products);
//
//			products = bean.getProductsInCategory("Sports");
//			displayProducts("Products in category", products);
//
//			bean.increaseAllPrices(10);
//			products = bean.getAllProducts();
//			displayProducts("All products after 10.00 price increase", products);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());

		}
	}

	private static void displayProducts(String message, List<Products> products) {

		System.out.printf("\n%s\n", message);
		for (Products product : products) {
			System.out.println(product);
		}
	}

}