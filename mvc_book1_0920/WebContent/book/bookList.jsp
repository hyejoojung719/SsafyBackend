<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp" %>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
	
	<h1> 책 목록 화면 </h1>
	
	<table class="table">
    <thead>
      <tr>
      	<th>고유 번호</th>
        <th>제목</th>
        <th>저자 </th>
        <th>가격 </th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${requestScope.list}" var="book"> <%-- requestScope은 생략 가능 --%>
    		<tr>ㅇ
    			<td>${book.isbn}</td> <%-- book.getIsbn()과 같은거 jstl에서는 get 뺌 --%>
    			<td ><a href="${root}/book?action=detail&isbn="+${book.isbn}>${book.title}</a></td>
    			<td>${book.author}</td>
    			<td>${book.price}</td>
    		</tr>
    	</c:forEach>
    </tbody>
  </table>
  
	<%@ include file="../include/footer.jsp" %>
</body>
</html>