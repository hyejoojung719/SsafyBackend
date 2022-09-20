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

	<h1> param : ${param.data} </h1> <!-- cookie_session_0920/login.jsp?data=안녕하세요 그러나 우리가 이렇게 쓰는 경우는 별로 X, 데이터 전달할때 request객체 안에 담아서 보내기 때문 -->
	<h1> param2 : ${paramValues.data[1]} </h1> <!-- cookie_session_0920/login.jsp?data=안녕하세요&data=안녕하세요2 그러나 우리가 이렇게 쓰는 경우는 별로 X, 데이터 전달할때 request객체 안에 담아서 보내기 때문 -->

	<div class="container mt-3">
		<h2>Sign in</h2>
		<form action="${pageContext.request.contextPath}/user" method="post"> <!-- ?로 보내버리면 post요청일 때 제대로 안 감 -->
			<input type="hidden" name="action" value="login">
			<div class="mb-3 mt-3">
				<label for="id">Id:</label> <input type="text"
					class="form-control" id="id" placeholder="Enter id"
					name="id" value="${cookie.saveId.value}"> <!-- value에 표현식을 써버리면 들어있는 값이 null일 경우 null이나옴. 반면 el은 아무것도 안나오므로 el 써야함  -->
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> <input type="text"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pwd">
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					아이디 저장하기
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>
</body>
</html>