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
	<div class="container mt-3">
		<h2>회원 가입</h2>
		<!--  action=signUp & id=? & pass=? & nams=? 의 파라미터가 넘겨진다.-->
		<form action="/mvc/user" method="post" >
			<input type="hidden" name="action" value="signUp">
			<div class="mb-3 mt-3">
				<label for="id">ID : </label> <input type="text"
					class="form-control" id="id" placeholder="Enter id"
					name="id">
			</div>
			<div class="mb-3">
				<label for="pass">Password : </label> <input type="password"
					class="form-control" id="pass" placeholder="Enter password"
					name="pass"> <!-- name은 가져오려는 db 이름과 동일한게 좋다 -->
			</div>
			<div class="mb-3">
				<label for="name">Name : </label> <input type="text"
					class="form-control" id="name" placeholder="Enter name"
					name="name">
			</div>
			<button type="submit" class="btn btn-primary">가입</button>
		</form>
	</div>
</body>
</html>