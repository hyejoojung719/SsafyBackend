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
		<h2>회원 가입</h2>
		<form action="${root}/user" method="post">
			<input type="hidden" name="action" value="signUp">
			<div class="mb-3 mt-3">
				<label for="id">아이디 :</label> <input type="text"
					class="form-control" id="id" placeholder="Enter id"
					name="id">
			</div>
			<div class="mb-3 mt-3">
				<label for="name">이름 :</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name"
					name="name">
			</div>
			<div class="mb-3 mt-3">
				<label for="pwd">비밀번호 :</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter pwd"
					name="pwd">
			</div>
			<div class="mb-3 mt-3">
				<label for="rec_id">추천인아이디:</label> <input type="text"
					class="form-control" id="rec_id" placeholder="Enter rec_id"
					name="rec_id">
			</div>
			<button type="submit" class="btn btn-primary"> 회원 가입 </button>
		</form>
	</div>
	
	<%@ include file='../include/footer.jsp' %>
</body>
</html>