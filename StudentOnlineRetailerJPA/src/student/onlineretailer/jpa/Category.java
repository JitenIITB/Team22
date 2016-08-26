package student.onlineretailer.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@Table(name="categories")

public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int CategoryID;
	private String CategoryName;
	private String Description;
	private Collection <Products> products = new ArrayList<Products>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getCategoryID()
	{
		return CategoryID;
	}
	public void setCategoryID(int CategoryID){
		this.CategoryID = CategoryID;  
	}
	public void setCategoryName(String name){
		this.CategoryName= name;
	}
	public void setCategoryDescription(String description){
		this.Description= description;
	}
	@OneToMany(mappedBy="categoryID", cascade = ALL)
	public Collection<Products> getProducts() {
		return products;
	}

	public void setProducts(Collection<Products> products) {
		this.products = products;
	}

	
	
	

	public Category() {
		super();
	}
   
}
