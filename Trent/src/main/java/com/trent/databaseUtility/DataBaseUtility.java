package com.trent.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	public void getDBConnection() throws Throwable {
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jbdc:mysql://localhost:3306", "root", "root");
		}
		catch (Exception e) {
		}
	}

	public void closeDBConnection() throws Throwable {
		try {
		con.close();
		}
		catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result=null;

		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
		}
		catch (Exception e) {
		}
		return result;

	}

	public int executeNonSelectQuery(String query) throws Throwable {
		int result= 0;
		try {
		Statement stat = con.createStatement();
		result = stat.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return result;

	}
}
