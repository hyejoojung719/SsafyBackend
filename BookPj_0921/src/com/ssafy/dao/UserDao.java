package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.User;
import com.ssafy.util.DBUtils;

public class UserDao {
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	DBUtils dbUtils = DBUtils.getInstance();
	
	// 회원 가입
	public int insertUser(User user) throws SQLException {
		String sql = "insert into user values(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = dbUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPass());
			pst.setString(4, user.getRec_id());
			
			return pst.executeUpdate();
		} finally {
			dbUtils.close(pst,conn);
		}
	}
	
	// 로그인
	public boolean signInCheck(String id, String pwd) throws SQLException {
		
		String sql = "select * from user where id=? && pass=?";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			User user = null;
			while(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			if(user==null) {
				return false;
			}else return true;
			
		} finally {
			dbUtils.close(rs,pst,conn);
		}
	}

}
