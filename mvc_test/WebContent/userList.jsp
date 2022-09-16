<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, com.ssafy.dto.User"%>
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
	<h1>유저 목록 화면</h1>

<!-- /mvc/user?action=list -->

	<div class="container mt-3">
		<h2>Basic Table</h2>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<User> userList = (List<User>) request.getAttribute("userList"); //위에 import 하기
					for (User user : userList) {
						out.println("<tr>");
						out.println("<td>" + user.getId() + "</td>");
						out.println("<td>" + user.getPass() + "</td>");
						out.println("<td>" + user.getName() + "</td>");
						out.println("</tr>");
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>