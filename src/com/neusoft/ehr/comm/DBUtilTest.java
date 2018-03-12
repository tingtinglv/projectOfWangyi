package com.neusoft.ehr.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilTest {
	static String mysqlurl = "jdbc:mysql://localhost:3306/ehr";
	static String mysqluname = "root";
	static String mysqlpassword = "dimo";
	static String className = "com.mysql.jdbc.Driver";
	static Connection conn;
	
	public static Connection getConn()
	{
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(mysqlurl,mysqluname,mysqlpassword);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return conn;
		
	}
	public static void dbclose(ResultSet rs,PreparedStatement st,Connection conn)
	{
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}//Class
