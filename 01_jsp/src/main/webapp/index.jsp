<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.red {color: red}
</style>
</head>
<body>
<h1>나는 인덱스</h1>
<%@ include file="title.jsp" %>
<%=request.getParameter("v") %>
</body>
</html>