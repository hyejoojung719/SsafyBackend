package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응용 => 로그인 했을 때 id값이 출력 되게끔 해줄 수 있다. 
		
		// 쿠키 만들기
		Cookie cookie = new Cookie("id","ssafy"); // key, value
		// 쿠키 유효기간 설정(초 단위)
		cookie.setMaxAge(60*60);	// 1시간
		// 쿠키 제거 시엔(0초로 설정)
		
		// 쿠키 경로 지정
		cookie.setPath(request.getContextPath());
		// 응답 객체에 쿠키 담기
		response.addCookie(cookie);
		
		
		response.sendRedirect(request.getContextPath()+"/index.jsp"); // sendredirect는 context 루트를 붙여야한당
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
