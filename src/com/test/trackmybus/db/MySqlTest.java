package com.test.trackmybus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlTest {

	/**
	 *
	 * Java program to connect to MySQL Server database running on localhost,
	 * using JDBC type 4 driver.
	 *
	 * @author http://java67.blogspot.com
	 * @throws ClassNotFoundException 
	 */
	public static void main(String args[]) throws ClassNotFoundException {
		String dbURL = "jdbc:mysql://acmetechsystems.com:3306/acmetechsystems_com_MasterDB";
		String username ="dbadmin";
		String password = "acme@db123";

		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query ="select count(*) from feedback";
//		Class.forName("com.mysql.jdbc.Driver");
		try {
			//getting database connection to MySQL server
			dbCon = DriverManager.getConnection(dbURL, username, password);

			//getting PreparedStatment to execute query
			stmt = dbCon.prepareStatement(query);

			//Resultset returned by query
			rs = stmt.executeQuery(query);

			while(rs.next()){
				int count = rs.getInt(1);
				System.out.println("count of stock : " + count);
			}

		} catch (SQLException ex) {
   			Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
		} finally{
			//close connection ,stmt and resultset here
		}

	}  
}