package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 분기
		String action = request.getParameter("action");
		switch(action) {
		// 로그인 페이지로 이동 요청
		case "goLogin":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		// 로그인 요청 처리 
		case "login":
			login(request,response);
			break;
		default:
			break;
		}
	}
	
	// 로그인 요청 처리
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 1. 요청 파라미터 추출 및 필요하다면 가공
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		
		System.out.printf("id : %s, pwd: %s, remember: %s", id, pwd, remember);
		
		// 2. 요청 처리
		// 2-1. DB에 조회 ID, 비밀번호 유저 있는지 조회 (모델에 요청)
		if(id.equals("ssafy") && pwd.equals("1234")) {
			// 2-2. Session에 사용자 정보 저장( 컨트롤러에서 직접)
			// 1) 세션 객체 반환(request.getSession() - session객체가 없으면 만들어서 반환, 있으면 해당 객체 반환)
			HttpSession session = request.getSession();
			// 2) 세션에 정보 저장
			session.setAttribute("id", id);
			
			// 2-3. 아이디 저장하기 체크된 경우
			if(remember!=null) {
				// 1) 쿠키 생성
				Cookie cookie = new Cookie("saveId", id); // 쿠키는 파일로 저장되기 때문에 value값이 무조건 문자열이어야 한다.
				// 2) 쿠키 옵션 설정
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60);
				// 3) response에 추가
				response.addCookie(cookie);
			}else {
				// 아이디 저장하기가 체크되지 않은 경우
				// 이미 만들어져있는 쿠키를 만료시켜야함
				// 1) 쿠키 생성
				Cookie cookie = new Cookie("saveId", id); // 쿠키는 파일로 저장되기 때문에 value값이 무조건 문자열이어야 한다.
				// 2) 쿠키 옵션 설정
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(0);	// 얘만 0으로 바꿔준다.
				// 3) response에 추가
				response.addCookie(cookie);
			}
		}
		
		// 3. 로그인 성공시 페이지 반환(메인 페이지로..)
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");// 인코딩 설정
		doGet(request, response);
	}
	
	

}
