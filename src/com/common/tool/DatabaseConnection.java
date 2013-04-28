package com.common.tool;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseConnection {
	private static DataSource ds = null;
	private static Connection con = null;
	private static Properties pp = null;
	static {
		try {
			/*
			 * pp=new Properties();File ff=new File(getConfigFile());
			 * FileInputStream fis = new FileInputStream(ff);
			 * BufferedInputStream bis = new BufferedInputStream(fis);
			 * pp.load(bis);bis.close();fis.close();
			 */
		} catch (Exception ex) {
			pln("DatabaseConnection.static " + ex.getMessage());
		}
	}

	public static Connection close(Connection con) {
		try {
			if (con != null && (!con.isClosed())) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			pln(e);
		}
		return null;
	}

	@SuppressWarnings("null")
	public static boolean close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null || !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static PreparedStatement close(PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
				pst = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Statement close(Statement st) {
		try {
			if (st != null) {
				st.close();
				st = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConn(Connection conn) throws Exception {
		close(conn);
	}

	public static void closePs(PreparedStatement pstmt) throws Exception {
		close(pstmt);
	}

	public static void closeRs(ResultSet rs) throws Exception {
		close(rs);
	}

	public static void closeStmt(Statement stmt) throws Exception {
		close(stmt);
	}

	public static String getConfigFile() {
		String s = "";
		try {
			s = DatabaseConnection.class.getResource("/").getPath();
			File ff = new File(s);
			if (ff.exists() == false)
				s = Thread.currentThread().getContextClassLoader().getResource(
						"/").getPath();
			s = s + "/jdbc.properties";
			System.out.println(s + " ");
		} catch (Exception ex) {
			s = replace(s, "%20", " ");
			pln("DatabaseConnection.getConfigFile()�쳣��" + ex.getMessage());
		}
		return s;
	}

	public static Connection getConnection() {
		try {
			String flag = "true";// getProperty("ConUsePool");
			if ("true".equals(flag)) {
				InitialContext ctx = null;
				ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("base_gov");// getProperty("DsName"));
				con = ds.getConnection();
			} else {
				con = makeConnection();
			}
		} catch (Exception e) {// ���Դ�����쳣��תjdbcֱ������
			con = makeConnection();
		}
		return con;
	}

	public static String getProperty(String name) {
		String ss = "";
		try {
			ss = pp.getProperty(name);
		} catch (Exception ex) {
			pln("DatabaseConnection.getProperty() " + ex.getMessage());
		}
		return ss;
	}

	public static Connection makeConnection() {
		try {
			String dri = "oracle.jdbc.driver.OracleDriver";// pp.getProperty("driver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ora9i";// pp.getProperty("url");
			String uid = "base_gov";// pp.getProperty("uid");
			String pwd = "11";// pp.getProperty("pwd");
			// System.out.println(url+"---"+uid+"***"+pwd);
			Class.forName(dri);
			con = DriverManager.getConnection(url, uid, pwd);
		} catch (Exception ex) {
			pln("DatabaseConnection.makeConnection() " + ex.getMessage());
		}
		return con;
	}

	public static void pln(Object obj) {
		System.out.println(obj);
	}

	public static String replace(String source, String oldString,
			String newString) {
		StringBuffer output = new StringBuffer();
		int lengthOfSource = source.length(); // Դ�ַ���
		int lengthOfOld = oldString.length(); // ���ַ���
		int posStart = 0; // ��ʼ����λ��
		int pos; // ���������ַ��λ��
		while ((pos = source.indexOf(oldString, posStart)) >= 0) {
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengthOfOld;
		}
		if (posStart < lengthOfSource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	public void close() {
		close(con);
	}
}
