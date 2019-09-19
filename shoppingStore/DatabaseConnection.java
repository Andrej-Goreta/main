package practice1.shoppingStore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

	public void main(String[] args) throws SQLException {
	
		try {
			Class.forName("org.postgresql.Driver");
		} 	
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}  
		  
	}

}
