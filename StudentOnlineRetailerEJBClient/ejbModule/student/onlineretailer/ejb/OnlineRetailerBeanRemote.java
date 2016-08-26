package student.onlineretailer.ejb;

import java.util.List;

import javax.ejb.Remote;

import student.onlineretailer.jpa.Products;

@Remote
public interface OnlineRetailerBeanRemote {
	public void addCategoriesAndProducts();
	public List<Products> getAllProducts();
	public List<Products> getProductsByName(String productName);
	public List<Products> getProductsInCategory(String categoryName);
	public void increaseAllPrices(double delta);
}
