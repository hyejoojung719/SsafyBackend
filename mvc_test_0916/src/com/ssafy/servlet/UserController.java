package com.ssafy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.User;
import com.ssafy.service.dao.UserDao;

// 서블릿 하나로 합치기
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = UserDao.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// action 파라미터 값에 따라 요청 처리 분기
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		try {
			switch(action) {
			case "list" :
				getUserList(request,response);
				break;
			case "signUp":
				signUp(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	// 회원가입 요청 처리
	private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		User userInfo = new User(id,pass,name);
		System.out.printf("id : %s, pass : %s, name : %s", id, pass, name);

		int cnt = userDao.insert(userInfo);

		if(cnt==1) {
			response.sendRedirect("/mvc");
		}
	}

	protected void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		List<User> userList = userDao.selectAll();


		for(User user : userList) {
			System.out.println(user);
		}

		request.setAttribute("userList", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userList.jsp");
		dispatcher.forward(request, response);


	}

}
