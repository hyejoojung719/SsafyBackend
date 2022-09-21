package com.ssafy.service;

import java.sql.SQLException;

import com.ssafy.dao.UserDao;
import com.ssafy.dto.User;

public class UserService {
	
	private UserService() {}
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	
	UserDao userDao = UserDao.getInstance();
	
	// 회원 가입
	public int insertUser(User user) throws SQLException {
		return userDao.insertUser(user);
	}
	
	// 로그인
	public boolean signInCheck(String id, String pwd) throws SQLException {
		return userDao.signInCheck(id, pwd);
	}

}
