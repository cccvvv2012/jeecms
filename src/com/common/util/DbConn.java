package com.common.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConn {
private DbConn(){}
	
	public static Connection getConn(){
		//1:
		Connection conn =  null;
		try{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
//					,"javasspm","javasspm");
			//1:
			
//			//2:
			InitialContext ctx = new InitialContext();
			//3:
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/testDs");
			
			conn = ds.getConnection();
			System.out.println("now use datasource-");
		}catch(Exception err){
			err.printStackTrace();
		}
		return conn;
	}	
}

