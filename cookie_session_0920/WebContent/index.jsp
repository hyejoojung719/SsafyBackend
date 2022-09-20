<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-light">
	<%= session.getAttribute("id") %>
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user?action=goLogin">로그인</a></li> <!-- 무조건 controller로 보낸다. -->
				<% if(session.getAttribute("id")!=null) %>
				<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link 3</a></li>
			</ul>
		</div>

	</nav>


	<h1>메인 화면</h1>

	${cookie.id.value}

</body>
</html>