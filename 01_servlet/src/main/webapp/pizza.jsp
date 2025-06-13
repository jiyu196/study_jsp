<%@page import="java.util.Enumeration"%>
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
		<p><label>감자<input type="checkbox" name="topping" value="potato"></label></p>
		<p><label>방울 토마토<input type="checkbox" name="topping" value="tomato"></label></p>
		<p><label>페퍼로니<input type="checkbox" name="topping" value="papper"></label></p>
		<p><label>베이컨<input type="checkbox" name="topping" value="bacon"></label></p>
		<button>토핑 선택</button>
	</form>
	<%
		String topping = request.getParameter("topping");
		String[] toppings = request.getParameterValues("topping");
	%>
	<h3><%=topping %></h3>
	<h3><%=toppings %></h3>
	<hr>
	<%
		if(toppings != null) {
			for(String t : toppings) {
				out.println(String.format("<h3>%s</he>\n", t));
			}
		}
	
		Enumeration<String> names =  request.getParameterNames();;
		while(names.hasMoreElements()) {
			out.println(request.getParameter(names.nextElement()));
		}
	%>
</body>
</html>