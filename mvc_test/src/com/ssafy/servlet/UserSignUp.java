//package com.ssafy.servlet;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ssafy.dto.User;
//import com.ssafy.service.dao.UserDao;
//
//
//@WebServlet("/userSignUp")
//public class UserSignUp extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	UserDao userDao = UserDao.getInstance();
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
////		System.out.println("doPost() 실행");
//		
//		//1. 회원 가입 정보 추출
//		String id = request.getParameter("id");
//		String pass = request.getParameter("pass");
//		String name = request.getParameter("name");
//		User userInfo = new User(id,pass,name);
//		System.out.printf("id : %s, pass : %s, name : %s", id, pass, name);
//		
//		//2. DB에 회원 정보 추가
//		int cnt = 0 ;
//		try {
//			cnt = userDao.insert(userInfo);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		//3. 성공했을 때 화면 반환, 실패했을 때 화면 반환
//		if(cnt==1) {
//			// 회원가입 성공 -> 메인화면 이동
//			response.sendRedirect("/mvc"); // web.xml에서 보면 index.html이동하게 돰
//		}
//		
//		
//		
//	}
//
//}
