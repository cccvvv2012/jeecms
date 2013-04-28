package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *数据库的连接类
 */
public class JDBCConnection {
	public static Connection getConnection() {
		try {
			/*
			 * String url = "jdbc:oracle:thin:@127.0.0.1:1521:ora9i";
			 * Class.forName("oracle.jdbc.driver.OracleDriver");
			 */
			/*
			 * sql String url =
			 * "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=wpgl";
			 * Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			 */

			/*
			 * String url = "jdbc:mysql://127.0.0.1/wpgl";
			 * Class.forName("com.mysql.jdbc.Driver");
			 */

			// access
			// String url =
			// "jdbc\\:odbc\\:driver\\={Microsoft Access Driver (*.mdb)};DBQ\\=E:\\workspace\\anyData003.mdb";
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// Connection con = DriverManager.getConnection(url, "", "");

			String strurl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\workspace\\anyData003.mdb";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection(strurl);
			// System.out.println("数据库连接成功");
			return con;

		} catch (Exception e) {
			System.out.println("---" + e.toString());
			e.printStackTrace();
		}
		return null;
	}
}
