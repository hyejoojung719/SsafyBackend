<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp" %>
<script>
	window.onload = function(){
		
		let deleteBtns = document.querySelectorAll(".deleteBtn");
		console.log("deleteBtns " + deleteBtns);
		deleteBtns.forEach(function(el/*, idx, arr*/){
			console.log("el : " + el);
			el.addEventListener("click", function(e){
				console.log("e : " + e);
				e.preventDefault();
				
				let isbn = this.parentNode.parentNode.children[1].children[].innerText;
					
				if(confirm("해당 책 정보 삭제하시겠습니까?")){
					location.href="${root}/book?action=delete&isbn="+isbn;
				}
			})
		})
		
	}
</script>
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
        <th></th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${requestScope.list}" var="book"> <%-- requestScope은 생략 가능 --%>
    		<tr>
    			<td>${book.isbn}</td> <%-- book.getIsbn()과 같은거 jstl에서는 get 뺌 --%>
    			<td ><a href='${root}/book?action=detail&isbn=${book.isbn}'>${book.title}</a></td>
    			<td>${book.author}</td>
    			<td>${book.price}</td>
    			<td><a class="deleteBtn">삭제</a></td>
    		</tr>
    	</c:forEach>
    </tbody>
  </table>
  
	<%@ include file="../include/footer.jsp" %>
</body>
</html>