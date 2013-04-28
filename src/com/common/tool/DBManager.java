package com.common.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	public static void close(java.sql.Connection ocon) {
		try {
			if (ocon != null && (!ocon.isClosed())) {
				ocon.close();
				ocon = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void close(java.sql.PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
				pst = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(java.sql.ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(java.sql.Statement st) {
		try {
			if (st != null) {
				st.close();
				st = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			// File f=new File("a.txt");
			// System.out.println("�����ļ���·����"+f.getAbsolutePath());
			/*
			 * hanjune.lan ע�� Properties p=new Properties(); FileInputStream
			 * fis=new FileInputStream("DbConStr.properties");
			 * BufferedInputStream bis=new BufferedInputStream(fis);
			 * p.load(bis);
			 */
			String driver = "oracle.jdbc.driver.OracleDriver";// p.getProperty("driver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ora9i";// p.getProperty("url");
			String uid = "gtcs";// p.getProperty("uid");
			String pwd = "11";// p.getProperty("pwd");
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pwd);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static java.sql.Connection getOracleConnection() {
		java.sql.Connection con = null;
		try {
			/*
			 * Properties p=new Properties(); FileInputStream fis=new
			 * FileInputStream("DbConStr.properties"); BufferedInputStream
			 * bis=new BufferedInputStream(fis); p.load(bis); String
			 * driver=p.getProperty("driver"); String url=p.getProperty("url");
			 * String uid=p.getProperty("uid"); String pwd=p.getProperty("pwd");
			 */
			String driver = "oracle.jdbc.driver.OracleDriver";// p.getProperty("driver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ora9i";// p.getProperty("url");
			String uid = "gtcs";// p.getProperty("uid");
			String pwd = "11";// p.getProperty("pwd");
			Class.forName(driver);

			con = DriverManager.getConnection(url, uid,
					pwd);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
