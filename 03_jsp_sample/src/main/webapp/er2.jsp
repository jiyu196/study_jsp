<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="er3.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int v1 = Integer.parseInt(request.getParameter("v1"));
		int v2 = Integer.parseInt(request.getParameter("v2"));
		
		int result = v1 / v2;
		// NumberFormatException -> null 값 포함하려고해도, 문자가와도 뜸
		// Artihmetic -> 0이면 산술제어 이게 뜸
		
	%>
	<h3>결과는 <%=result %></h3>
</body>
</html>