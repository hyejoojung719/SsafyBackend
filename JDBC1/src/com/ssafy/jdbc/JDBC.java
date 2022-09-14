package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	
	static DBUtil dbUtil = new DBUtil();
	
	public static void main(String[] args) {
		
		//id가 20000인 데이터를 city에서 삭제
		
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//1. Connection 객체 받아오기 
			conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
						, "ssafy", "ssafy");
			//2. pstmt 객체 받아오기 (sql 명령 준비 완료)
			pst = conn.prepareStatement("delete from city where id = ?");
			pst.setInt(1, 20002);
			
			//3. sql 명령 보내기 
			int cnt = pst.executeUpdate();
			
			if(cnt==1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//4. 자원 반납(DBUtil의 close 메소드 사용)
			dbUtil.close(pst,conn);
		}
		
		
	}
}
