package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dto.User;
import com.ssafy.service.UserService;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = UserService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		switch(action) {
		case "goSignup":
			goSignUp(request, response);
			break;
		case "signUp":
			try {
				signUp(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "goSignIn":
			goSignIn(request,response);
			break;
		case "signIn":
			try {
				signIn(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "signOut":
			signOut(request,response);
			break;
		default:
			break;
		}
	}

	// 로그아웃
	private void signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		response.sendRedirect(request.getContextPath());
	}

	// 로그인 페이지 이동
	private void goSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() +  "/user/signIn.jsp");
	}

	// 로그인
	private void signIn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 로그인
		boolean result = userService.signInCheck(id, pwd);
		
		if(result) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", id);
		}
		
		response.sendRedirect(request.getContextPath());
	}


	// 회원 가입 페이지 이동
	private void goSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() +  "/user/signUp.jsp");
	}


	// 회원 가입
	private void signUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String rec_id = request.getParameter("rec_id");

		User user = new User(id,name,pwd,rec_id);
		int cnt = userService.insertUser(user);

		response.sendRedirect(request.getContextPath());

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
