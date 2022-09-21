<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file='../include/header.jsp' %>
</head>
<body>
	<%@ include file='../include/nav.jsp' %>
	
	<div class="container mt-3">
		<h2>로그인</h2>
		<form action="${root}/user" method="post">
			<input type="hidden" name="action" value="signIn">
			<div class="mb-3 mt-3">
				<label for="id">아이디 :</label> <input type="text"
					class="form-control" id="id" placeholder="Enter id"
					name="id">
			</div>
			<div class="mb-3 mt-3">
				<label for="pwd">비밀번호 :</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter pwd"
					name="pwd">
			</div>
			<button type="submit" class="btn btn-primary"> 로그인  </button>
		</form>
	</div>
	
	<%@ include file='../include/footer.jsp' %>
</body>
</html>