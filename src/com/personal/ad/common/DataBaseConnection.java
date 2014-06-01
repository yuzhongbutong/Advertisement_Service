package com.personal.ad.common;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataBaseConnection {

	private static ComboPooledDataSource dataSource;

	public ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(ComboPooledDataSource dataSource) {
		DataBaseConnection.dataSource = dataSource;
	}

	public static Connection getConnection() {
		if (dataSource != null) {
			try {
				return dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * static { try { Class.forName(GeneralOperation
	 * .getProperties(FinalConstant.DB_DRIVER)); } catch (ClassNotFoundException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public static Connection getConnection() { // TODO Auto-generated method
	 * stub Connection connection = null; try { connection =
	 * DriverManager.getConnection(
	 * GeneralOperation.getProperties(FinalConstant.DB_URL),
	 * GeneralOperation.getProperties(FinalConstant.DB_USER),
	 * GeneralOperation.getProperties(FinalConstant.DB_PASS)); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return connection; }
	 */
}
