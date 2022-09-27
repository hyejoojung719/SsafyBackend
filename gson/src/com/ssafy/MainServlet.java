package com.ssafy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// gson 객체 추가하기
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet 호출 됨");

		String abc = request.getParameter("abc");
		String def = request.getParameter("def");
		System.out.println(abc + " : " + def);

		// JSON 데이터를 받은 경우
		BufferedReader br =  new BufferedReader(request.getReader());
		String json = br.readLine();
		System.out.println("요청데이터 원본 형태\n"+json);
		// json 문자열을 Map 객체로 변환
		Map data = gson.fromJson(json, Map.class);
		//        System.out.println(data);
		double value = (double)data.get("abc");
		System.out.println("json abc 값 : " + value);
		//---------------

		// 응답할 때는 아래로
		// JSON 데이터로 변환
		List<User> list = new ArrayList<User>();

		list.add(new User("aaa",10));
		list.add(new User("bbb",20));
		list.add(new User("ccc",30));


		// List<User> => json 형태로 변환
		String json2 = gson.toJson(list); // 반환 값으로 String 값이 온다.
		System.out.println(json);

		// 데이터를 응답으로 주기
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json2);
		out.close();
		// ------------
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
