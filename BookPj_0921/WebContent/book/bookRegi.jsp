<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file='../include/header.jsp'%>
</head>
<body>
	<%@ include file='../include/nav.jsp'%>
	<div class="container mt-3">
		<h2>책 정보 등록</h2>
		<form action="${root}/book" method="post">
			<input type="hidden" name="action" value="regist">
			<div class="mb-3 mt-3">
				<label for="isbn">책 번호 :</label> <input type="text"
					class="form-control" id="isbn" placeholder="Enter isbn"
					name="isbn">
			</div>
			<div class="mb-3 mt-3">
				<label for="title">책 제목 :</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">
			</div>
			<div class="mb-3 mt-3">
				<label for="author">작가 :</label> <input type="text"
					class="form-control" id="author" placeholder="Enter author"
					name="author">
			</div>
			<div class="mb-3 mt-3">
				<label for="price">가격 :</label> <input type="text"
					class="form-control" id="price" placeholder="Enter price"
					name="price">
			</div>
			<div class="mb-3 mt-3">
				<label for="description">설명 :</label> <input type="text"
					class="form-control" id="description" placeholder="Enter description"
					name="description">
			</div>
			<div class="mb-3 mt-3">
				<label for="img">이미지 :</label> <input type="text"
					class="form-control" id="img" placeholder="Enter img"
					name="img">
			</div>
			<button type="submit" class="btn btn-primary"> 책 등록 </button>
		</form>
	</div>

	<%@ include file='../include/footer.jsp'%>
</body>
</html>