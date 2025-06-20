<%@page import="java.util.List"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanMember" class="domain.Member" />
<c:set var="setMember" value="<%=new Member() %>"/>
<c:set var="str" value ="<script>alert()</script>" />


<h3>beanMember : ${beanMember }</h3>
<h3>setMember : ${setMember }</h3>
<h3>setMember : <c:out value="${setMember}" /></h3>
<hr>
<!-- <h3>${str}</h3> -->
<h3><c:out value= "${str}" /> </h3>

<c:if test="${setMember.name == '새똥이'}">
	<h3>이름 출력 ${setMember.name}</h3>
</c:if>
<c:choose>
	<c:when test="${setMember.name == '개똥이' }">
	<h3>이름은 개똥이 입니다</h3>
	</c:when>
	<c:otherwise>
		<h3>이름은 개똥이가 아닙니다</h3>
	</c:otherwise>
</c:choose>
<hr>
<c:forEach begin="2" end="9" var="i" step="3">
	<c:forEach begin="1" end="9" var="j" step="7">
		<h4>${i} * ${j} = ${i*j}</h4>
	</c:forEach>
</c:forEach>

<c:forEach begin="10" end="100" step="10" var="i" varStatus="stat">
	<h4>var : ${i}, stat's index : ${stat.index}, stat;s count : ${stat.count}</h4>
</c:forEach>

<ul>
<c:forEach begin="1" end="5" varStatus="stat" >
	<li style="color:${stat.first ? 'red' : stat.last ? 'blue' : 'black'}">요소</li>
</c:forEach>

<%
	List<String> list = List.of("가", "나", "다", "라");
	pageContext.setAttribute("list", list);
%>
<h3>${list}</h3>
<c:forEach items="${list}" begin="2" var="i">
	<h3>${i}</h3>
</c:forEach>

<c:forTokens items="1+2+3" delims="+" var="i">
	<h3>${i}</h3>
</c:forTokens>
</ul>
</body>
</html>