package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
	
	public static String getData(String columnName) throws ClassNotFoundException, SQLException {
		  // Setting mySql porperties
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  String sqlUrl = "jdbc:mysql://localhost:3306/october2020";
		  String userName = "root";
		  String password = "admin";
		  String query = "select * from users";
		  // Creating a connection to local DB
		  Connection conn = DriverManager.getConnection(sqlUrl, userName, password);
		  // Empowering the conn ref. variable to execute queries
		  Statement smt = conn.createStatement();
		  // Delevering the query
		  ResultSet rs = smt.executeQuery(query);
		  while (rs.next()) {
		   return rs.getString(columnName);
		  }
		  return columnName;
		 }
	

}
