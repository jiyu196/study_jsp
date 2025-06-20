<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=page==this%></h2>  <!-- true가 나옴 -->
	<h3><%=request.getSession() == session %></h3>
	<h3><%=request.getServletContext() == session %></h3>
	<%
		
		// 영역객체
		// page, request, session, application
		pageContext.setAttribute("value", 10);
		request.setAttribute("value", 20);
		session.setAttribute("value", 30);
		application.setAttribute("value", 40);
	%>
	<h3>${value}</h3>  <!-- page가 나옴. 가장 가까운것부터 -->
	<h3>${sessionScope.value}</h3>
	
	<%
		request.setAttribute("myValue", new Member());
	%>
	<h3>${value }</h3>
	<h3>${sessionScope.value }</h3>
	
	<%-- <h3>normal exp : <%=((Member)request.getAttribute("myValue")).getName() %></h3>--%>
	<!-- null이라고 나옴 normal exp : null  -->
	<!-- member 쓰고, 맵핑하고, getname한거->  -->
	<h3>exp lang : ${myValue["name"]}</h3>
	<!-- 값이 안나옴 -->
	<h3>${'1' + "2" }</h3> <!--3이 나옴  -->
	<h3>${5 / 2}</h3>  <!--2로나오는게 아니라 2.5라고 나옴 -->
	<h3>${myValue.name eq '새똥이'}</h3>  <!--myValue.name에 있는이름이랑 새똥이라는 값과 같니  -->
	<h3>${myValue.name ne '새똥이'}</h3> <!-- not equal 을 ne라고 씀 -->
	<h3>${10 < 20 }</h3>
	<!-- <h3>${5 div 2}</h3> -->
	<h3>${5 mod 2}</h3>
	<h3>${empty ''}</h3>  <!--  빈문자열이니-> true --> 
	<h3>${not empty null}</h3> <!-- !붙여도 되고, not 붙여도됨 -->
	
</body>
</html>