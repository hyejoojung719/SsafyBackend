<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file='../include/header.jsp'%>
</head>
<body>
	<%@ include file='../include/nav.jsp'%>

	<div class="card">
		<c:set var="b" value="${book}"></c:set>
			<div class="card-header">책 제목 : ${b.title}</div>
			<div class="card-body">
				작가 : ${b.author} <br> 가격 : ${b.price}
			</div>
	</div>

	<%@ include file='../include/footer.jsp'%>
</body>
</html>