<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/head.jsp" %>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<div class="container p-0">
	
	<main>
        <form method="post" action="modify" onsubmit="return confirm('수정하시겠습니까?')">
        <div class="samll border-bottom border-3 p-0 pb-2"><a href="#" class="small" class="small"><span class="text-primary">자유게시판</span> 카테고리</a></div>
        <div class="small p-0 py-2">
            <input placeholder="title"  class="form-control" name="title" id="title" value="${board.title}">
        </div>
        <div class="p-0 py-2 bg-light small border-2 border-muted">
              <textarea name="content" id="editor1" class="form-control resize-none">${board.content}</textarea>
        </div>
      
        <div>
            <button class="btn btn-secondary btn-sm"><i class="fa-solid fa-list-ul"></i> 목록</button>
            <div class="float-end">
                <button class="btn btn-outline-warning btn-sm"><i class="fa-solid fa-pen-fancy"></i> 글수정</button>
            </div>
        </div>
        <input type="hidden" name="id" value="${member.id}" />
        <input type="hidden" name="bno" value="${board.bno}" />
        <input type="hidden" name="cno" value="${cri.cno}" />
        <input type="hidden" name="page" value="${cri.page}" />
        <input type="hidden" name="amount" value="${cri.amount}" />
        <input type="hidden" name="type" value="${cri.type}" />
        <input type="hidden" name="keyword" value="${cri.keyword}" />
        </form>
    </main>
</div>
 <script>
   
      $(function() {
          CKEDITOR.replace('editor1', {
              height: 400
          });
      });
   
  </script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>