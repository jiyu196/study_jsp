<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input name= "kor">
		<input name= "eng">
		<input name= "mat">
		<button>계산</button>
		
	</form>
	<%
		
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String mat = request.getParameter("mat");
		
		if(kor != null && eng != null && mat != null) {
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(mat);
			double avg = total / 3.0;
		
	%>
	<h3><%=total%></h3>
	<h3><%=avg%></h3>
	
	<% } %>
	
	
</body>
</html>