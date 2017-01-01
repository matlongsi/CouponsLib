package com.coupon.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBDelete {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String OPS_DB_NAME = "COUPONS_OPS";
	static final String DB_URL = "jdbc:mysql://localhost/" + OPS_DB_NAME;
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "man0jdas";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);

			//open a connection
			System.out.println("Connecting to database ...");		//log in future
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			//create new database
			String sql = "DROP DATABASE " + OPS_DB_NAME;
			stmt.executeUpdate(sql);
			System.out.println(OPS_DB_NAME + " database deleted successfully! ");
			
		}
		catch(SQLException se) {
		      //handle errors for JDBC
		      se.printStackTrace();
		}
		catch(Exception e) {
		      //handle errors for Class.forName
		      e.printStackTrace();
		}
		finally {
			//finally close resources
			try{
				if(stmt != null)
					stmt.close();
				if(conn != null)
		        	conn.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}

		System.out.println("Database delete complete.");

	}

}
