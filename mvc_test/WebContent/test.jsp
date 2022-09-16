<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 크롬에서 test.jsp 실행하고 엣지에서 Main을 실행하면.. -->

	서블릿 컨텍스트 데이터 : 
	<%= application.getAttribute("A") %> 
	<br>
	세션 데이터  : 
	<%= session.getAttribute("C") %>
	<!-- Session 객체는 접속하는 클라이언트당 하나씩 만들어지고 클라이언트끼리 공유 불가능, applicaiton 객체는 서버에 하나만 만들어지고 계속 유지되어 클라이언트 끼리 공유 가능 -->
	<br>
	Request 데이터 :
	<%= request.getAttribute("f") %> 
	
	<!-- context root 변경
		1. 프로젝트 properties / web project setting 에서 이름 변경
		2. server.xml에서 path 이름 변경 -->
</body>
</html>