//package com.ssafy.servlet;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ssafy.dto.User;
//import com.ssafy.service.dao.UserDao;
//
//@WebServlet("/userList")
//public class UserList extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	UserDao userDao = UserDao.getInstance();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 1. DB로부터 유저정보 받아오기
//		// 유저 목록 저장
//
//		List<User> userList = null;
//		try {
//			userList = userDao.selectAll();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		for(User user : userList) {
//			System.out.println(user);
//		}
//
//		// 2. 유저 목록 화면 반환
//		// 요청을 userList.jsp 쪽으로 넘김(forward)
//		request.setAttribute("userList", userList);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/userList.jsp");
//		dispatcher.forward(request, response);
//		
//		// redirect
////		response.sendRedirect("/mvc/userList.jsp");
//		// 에러가 뜬다.  java.lang.NullPointerException
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
