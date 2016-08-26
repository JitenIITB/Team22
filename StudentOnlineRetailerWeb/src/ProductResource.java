import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.*;

@Path( "/product")

public class ProductResource {
	private static List<String> products = new ArrayList<>();

	static {
		products = new ArrayList<>();
		products.add("Bugatti");
		products.add("Yacht");
		products.add("Rubik cube");
	}

	@GET
	@Produces("text/ plain")
	public List<String> getProducts() {
		return products;
	}

	@PUT
	@Consumes("text/plain")
	public void insertProduct(String product) {
		products.add(product);
	}

}
