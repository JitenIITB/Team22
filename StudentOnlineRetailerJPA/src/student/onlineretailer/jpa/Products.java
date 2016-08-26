package student.onlineretailer.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Products
 *
 */
@Entity
@Table(name="products")

public class Products implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private long ProductID;
	private long CategoryID;
	private String ProductName;
	private Double UnitPrice;
	private int UnitsInStocks;
	private int ReorderLevel;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getProductID()
	{
		return ProductID;
	}
	public void setProductID(long ProductID){
		this.ProductID = ProductID;  
	}
	public void setProductName(String name){
		this.ProductName = name;
	}
	public void setUnitPrice(Double price){
		this.UnitPrice = price;
	}
	public void setUnitsInStocks(int units){
		this.UnitsInStocks = units;
	} 
	public void setReorderLevel(int reorder){
		this.ReorderLevel = reorder;
	}
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="CategoryID")
	public long getCategoryID()
	{
		return CategoryID;
	}
	public void setCategoryID(long categoryID){
		this.CategoryID=categoryID;
	}

	public Products() {
		super();
	}
	public double getUnitPrice() {
		// TODO Auto-generated method stub
		return this.UnitPrice;
	}
   
}
