package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryUsingJDBC {
	
	
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
			Statement statement = connection.createStatement();
			 int result = statement.executeUpdate("insert into student values(106, 'tomi', 'geo');"); 
			if(result==1) {
				System.out.println("database has been updated");
			}
			else { System.out.println("database has not been updated");
			}
		}
		
		catch (Exception e){
		}
	
		finally {
			connection.close();
			
		}
		
		
	}

}
