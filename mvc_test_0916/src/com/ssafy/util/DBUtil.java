package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	// 싱글톤
	// 1. 생성자 막기 -> private
	// 2. 객체 생성하기
	// 3. 객체 반환 메소드 
	
	
	// 드라이버 클래스 로딩
	// 1. private로 생성자 막기
	private DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. 객체 생성하기
	private static DBUtil instance = new DBUtil();
	// 3. 객체 반환 메소드
	public static DBUtil getInstance() {
		return instance;
	}
	
	// Connection 객체 반환 메소드
	public Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://127.0.0.1:3306/bookdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String id = "ssafy";
		String password = "ssafy";
		
		return DriverManager.getConnection(url, id, password);
	}
	
	// close 자원 반납 메소드
	public void close(AutoCloseable ...resources) {
		for(AutoCloseable resource : resources) {
			if(resource != null) {
				try {
					resource.close();	// 자원 반납
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
