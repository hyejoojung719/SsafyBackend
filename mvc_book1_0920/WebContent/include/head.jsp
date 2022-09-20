<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- core 태그 라이브러리 사용  --%>
<%@  taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<%-- context path 변수 --%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<%-- head 태그 안에 들어갈 내용 --%>
<meta charset="UTF-8">
<!-- 부트스트랩 관련 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>책 관리 사이트</title>
