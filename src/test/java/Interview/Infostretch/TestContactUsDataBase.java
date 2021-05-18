package Interview.Infostretch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class TestContactUsDataBase extends Base {

	//connection, statement, resultset, driver;
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultset;
	public WebDriver driver;
	
	
	@BeforeTest
	public void connectingDataBase() throws SQLException {
		connection=null;
		connection=DriverManager.getConnection("url", "username", "password");
		if(connection !=null)
			System.out.println("Successfully connected to the DataBase...");
	}
	
	
	@Test
	public void testCase9() throws SQLException {
		statement = connection.createStatement();
		resultset = connection.createStatement().executeQuery("SELECT*FROM infostretch.new_table");
		
		while(resultset.next()) {
			String values = resultset.getString("Employee Name");
			System.out.println(values);
		}
	}
	
	
	@AfterTest
	public void closingDataBase() throws SQLException {
		if(connection !=null)
			System.out.println("DataBase is closing...");
			connection.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
