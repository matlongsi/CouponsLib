package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBSetup {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";
	static final String OPS_DB_NAME = "USER_OPS";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "man0jdas";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try{
			
			//register JDBC driver
			Class.forName(JDBC_DRIVER);

			//open a connection
			System.out.println("Connecting to database server ...");		//log in future
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			//create new database
			sql = "CREATE DATABASE " + OPS_DB_NAME;
			stmt.executeUpdate(sql);
			System.out.println(OPS_DB_NAME + " database created successfully! ");
			
			//select new database for creating tables
			sql = "USE " + OPS_DB_NAME;
			stmt.executeUpdate(sql);
			
			//create tables
			System.out.println("Creating tables:");
			int count = 0;
			sql = "CREATE TABLE user_tbl("
					+ "user_tbl_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, "
					+ "user_name VARCHAR(16) NOT NULL, "
					+ "salt VARCHAR(16) NOT NULL, "
					+ "password_hash VARCHAR() NOT NULL, "
					+ "stamp_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, "
					+ "stamp_insert TIMESTAMP NOT NULL, "
					+ "optimistic_lock_version INT UNSIGNED NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (user_tbl_id),"
					+ "UNIQUE(user_name)) "
					+ "ENGINE = InnoDB; ";
			stmt.executeUpdate(sql);
			System.out.println(++count + ". user_tbl_id");

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

		System.out.println("Database setup complete.");

	}

}
