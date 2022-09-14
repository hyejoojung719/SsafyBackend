package com.ssafy.jdbc;

public class DBUtil {

	// 한번만 수행하도록 
	public DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 클래스 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 자원 반납
	public  void close(AutoCloseable ...resources) { 
		for(AutoCloseable  resource : resources) {
			if(resource != null)
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
