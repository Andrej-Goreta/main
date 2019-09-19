package practice1.shoppingStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Product{

	String name = "";
	double price = 0.00;
	int quantity = 0;
	String type = "";
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Product> getAllProducts() throws SQLException{
		List<Product> storeItems = new ArrayList<Product>();
		 
		try {
				Class.forName("org.postgresql.Driver");
			} 	catch (ClassNotFoundException e) {
				
				e.printStackTrace();
				}  
			  
			   
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shoppingStore",
					   "postgres", "postgres1");
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM product");
		ResultSet Rs = stmt.executeQuery();
		while(Rs.next()) {
			Product aProduct = new Product();
			aProduct.setName(Rs.getString("product_name"));
			aProduct.setPrice(Rs.getDouble("price"));
			aProduct.setQuantity(Rs.getInt("quantity"));
			aProduct.setType(Rs.getString("type"));
			storeItems.add(aProduct);
		}
			    
		return storeItems;
	}
	
	public int getProductQuantity(String productName) throws SQLException {
		DatabaseConnection aConn = new DatabaseConnection();
		aConn.main(null);
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shoppingStore",
				   "postgres", "postgres1");
		PreparedStatement stmt = con.prepareStatement("SELECT product_name, quantity FROM product");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			if(Rs.getString("product_name").equalsIgnoreCase(productName)) {
				int productQuantity = Rs.getInt("quantity");
				return productQuantity;
			}
		}
		return 0;

		
	}
	
	public String getProductName(String productName) throws SQLException {
		DatabaseConnection aConn = new DatabaseConnection();
		aConn.main(null);
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shoppingStore",
				   "postgres", "postgres1");
		PreparedStatement stmt = con.prepareStatement("SELECT product_name FROM product");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			if(Rs.getString("product_name").equalsIgnoreCase(productName)) {
				String nameOfProduct = Rs.getString("product_name");
				return nameOfProduct;
			}
			
		}

		return "";
	}
	
	public double getProductPrice(String productName) throws SQLException {
		DatabaseConnection aConn = new DatabaseConnection();
		aConn.main(null);
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shoppingStore",
				   "postgres", "postgres1");
		PreparedStatement stmt = con.prepareStatement("SELECT product_name, price FROM product");
		ResultSet Rs = stmt.executeQuery();
		
		while(Rs.next()) {
			if(Rs.getString("product_name").equalsIgnoreCase(productName)) {
				double priceOfProduct = Rs.getDouble("price");
				return priceOfProduct;
			}
		}
		return 0.00;
	}
}
