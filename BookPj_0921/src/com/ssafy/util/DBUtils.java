package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	// 싱글톤
	
	private DBUtils() {
		// mySql 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static DBUtils dbUtils = new DBUtils();
	public static DBUtils getInstance() {
		return dbUtils;
	}
	
	// getConnection
	public Connection getConnection() throws SQLException {
		String url="jdbc:mysql://127.0.0.1:3306/bookdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String id="ssafy";
		String pwd="ssafy";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		return conn;
	}
	
	// close()
	public void close(AutoCloseable ...resources) {
		for(AutoCloseable resource : resources) {
			if(resource!=null) {
				try {
					resource.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
