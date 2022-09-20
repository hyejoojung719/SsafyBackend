<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp" %>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
	
	<h1> 책 상세 화면  </h1>
	
	<c:set var="book" value="${requestScope.book}"></c:set>
	<h2> 번호 : ${book.isbn}</h2>
	<h2> 제목 : ${book.title}</h2>
	<h2> 작가 : ${book.author}</h2>
	<h2> 가격 : ${book.price}</h2>
  
	<%@ include file="../include/footer.jsp" %>
</body>
</html>