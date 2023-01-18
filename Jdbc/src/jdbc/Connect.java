package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect {
	private static Connection con;
	
	public static void openConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");//reflection
		System.out.println("Driver Loaded....");

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac22", "root", "root123");
		System.out.println("Connected To DB.....");
		
	}

	public static Connection getCon() {
		return con;
	}


}
