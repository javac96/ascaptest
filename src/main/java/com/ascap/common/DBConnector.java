package com.ascap.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnector {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement prepStmt;
	public static final String username = "root";
	public static final String password = "root";
	public static final String url = "jdbc:oracle:thin@()";

	public ResultSet getQueryResult(String query) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public Boolean deleteDataFromTabel(String data) throws Exception{
		Boolean queryStatus = false;
		try {
			String qr = "(SELECT DATA FROM TABEL WHERE THIS = THIS)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			
			String query = "DELETE FROM TABEL WHERE THIS="+qr;
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, data);
			prepStmt.execute();
			prepStmt = null;
			
			query = "DELETE FROM TABEL WHERE THIS="+qr;
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, data);
			prepStmt.execute();
			
			conn.commit();
			return queryStatus;
		}catch(Exception e) {
			throw e;
		}
	}
}
