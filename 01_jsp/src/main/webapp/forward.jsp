<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내 응답은?</h1>
<%
	System.out.println(request.getParameter("v"));
	request.getRequestDispatcher("index.jsp").forward(request, response);
%>
</body>
</html>