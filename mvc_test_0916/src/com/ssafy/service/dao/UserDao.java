package com.ssafy.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.User;
import com.ssafy.util.DBUtil;

// User DB 관련 로직 처리 
public class UserDao {
	
	DBUtil dbUtil = DBUtil.getInstance();
	
	// 기능만 사용하므로 여러 개의 객체 만들 필요 X => 싱글톤
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	// 회원 목록 조회 기능
	public List<User> selectAll() throws SQLException{
		String sql = "select * from user";
		
		List<User> userList = new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
				
				userList.add(user);
			}
			return userList;
		}finally{
			dbUtil.close(rs,pstmt,conn);
		}
	}
	
	// 회원 가입 기능
	public int insert(User user) throws SQLException {
		
		String sql  = "insert into user (id,pass,name) values (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getName());
			
			return pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	
}
