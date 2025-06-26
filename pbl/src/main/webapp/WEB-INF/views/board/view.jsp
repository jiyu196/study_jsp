<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/head.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.13/dayjs.min.js" integrity="sha512-FwNWaxyfy2XlEINoSnZh1JQ5TRRtGow0D6XcmAWmYCRgvqOUTnzCxPc9uF35u5ZEpirk1uhlPVA19tflhvnW1g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.13/locale/ko.min.js" integrity="sha512-ycjm4Ytoo3TvmzHEuGNgNJYSFHgsw/TkiPrGvXXkR6KARyzuEpwDbIfrvdf6DwXm+b1Y+fx6mo25tBr1Icg7Fw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.13/plugin/relativeTime.min.js" integrity="sha512-MVzDPmm7QZ8PhEiqJXKz/zw2HJuv61waxb8XXuZMMs9b+an3LoqOqhOEt5Nq3LY1e4Ipbbd/e+AWgERdHlVgaA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<div class="container p-0">
	
	    <main>
        <div class="samll border-bottom border-3 p-0 pb-2"><a href="#" class="small" class="small"><span class="text-primary">자유게시판 카테고리</a></span></div>
        <div class="small p-0 py-2">
        <span class="px-2 border-end border-1">잡담</span> 
        <span class="px-2">${board.title}</span> 
           	<div class="float-end small">
	            <span class="text-muted"><i class="fa-solid fa-eye"></i> ${board.cnt}</span>
	            <span class="text-muted"><i class="fa-regular fa-comment-dots"></i> 3</span>
            </div>
        </div>
        <div class="p-0 py-2 bg-light small border-top border-2 border-muted">
	        <span class="px-2">${board.id}</span>
	        <a href="#" class="text-muted small">board.html</a>
	        <span class="float-end text-muted small me-3">${board.regdate}</span>
        </div>
        <div class="p-0 py-5 ps-1 small border-bottom border-1 border-muted">${board.content}</div>
       <%--  ${board.content} --%>
        <div>
            <a href="list?${cri.qs2}" class="btn btn-secondary btn-sm"><i class="fa-solid fa-list-ul"></i> 목록</a>
            
            <a href="modify?bno=${board.bno}&${cri.qs2}" class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square"></i> 수정</a>
            <a href="remove?bno=${board.bno}&${cri.qs2}" class="btn btn-danger btn-sm" onclick="return confirm('삭제하시겠습니까?')">
            	<i class="fa-solid fa-trash"></i> 삭제
           	</a>
            
            <div class="float-end">
                <button class="btn btn-outline-primary btn-sm"><i class="fa-solid fa-share-nodes"></i> 공유</button>
                <button class="btn btn-outline-primary btn-sm"><i class="fa-solid fa-clipboard"></i> 스크랩</button>
            </div>
        </div>
        
   <div class="smll p-0 py-2 border-top border-bottom border-1 border-muted mt-4 clearfix align-items-center d-flex">
        	<div class="col">
	       		<i class="fa-regular fa-comment-dots"></i> <span class="px-1 text-primary">Reply</span>
    		</div>
	    <div class="col text-end">
	    <c:if test="${empty member}">
	    <a class="small text-primary" href="${cp}/member/login">댓글을 작성 시 로그인 필요</a>
	    </c:if>
	    <c:if test="${not empty member}">
	       <button class="btn-write-form btn btn-sm btn-primary">댓글 작성</button>
	    </c:if>
      </div>
   </div>
   <ul class="list-group list-group-flush mt-3 reviews">
   </ul>
        <div class="d-grid">
        	<button class="btn btn-primary btn-block btn-reply-more d-none">댓글 더보기</button>
        </div>
    </main>
    </div>
    <div class="modal fade" id="reviewModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Reply Form</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form>
            <div class="mb-3 mt-3">
                <label for="content" class="form-label text-primary"><i class="fa-solid fa-comment"></i> Content</label>
                <textarea class="form-control resize-none" id="content" placeholder="Enter content" name="content" rows="5"></textarea>
            </div>
            <div class="mb-3">
                <label for="writing" class="form-label text-primary"><i class="fa-solid fa-user"></i> Writer</label>
                <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer"value="${member.id}" disabled>
            </div>
            
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-sm btn-write-submit" >Write</button>
        
        <button type="button" class="btn btn-warning btn-sm btn-modify-submit">Modify</button>
        <button type="button" class="btn btn-danger btn-sm" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
	dayjs.extend(window.dayjs_plugin_relativeTime);
	dayjs.locale('ko');
	const dayForm = 'YYYY-MM-DD HH:mm:ss';

        $(function(){
        	const bno = '${board.bno}'
            const url = '${cp}' + '/reply/';
            const modal = new bootstrap.Modal($("#reviewModal").get(0), {})
            
            // makeReplyLi(reply) > str
            
            function makeReplyLi(r) {
           		return `
           			<li class="list-group-item ps-5 profile-img" data-rno="\${r.rno}">
                   
	                   <p class="small text-secondary">
	                       <span class="me-3">\${r.id}</span>
	                       <span class="mx-3">\${dayjs(r.regdate, dayForm).fromNow() }</span>
	                   </p>
	                   <p class="small ws-pre-line">\${r.content}</p>
                       <button class="btn btn-danger btn-sm float-end btn-remove-submit">삭제</button>
                       <button class="btn btn-warning btn-sm float-end mx-3 btn-modify-form ">수정</button>
           		</li> 
                  `; 			
                		}
    
            function list(bno , lastRno){
            	lastRno = lastRno ? ('/' + lastRno) : ''; 
            	let reqUrl = url + 'list/' + bno  + lastRno;
            	
                $.ajax({
                    url : reqUrl,
                    success : function(data) {
                        if(!data || data.length === 0) {  //이거때문에 초기화가 되는거임
                        	if($(".reviews li").length === 0) { //처음부터 아예 댓글이 없는 상태
                        		$(".reviews").html('<li class="list-group-item text-center text-muted">댓글이 없습니다</li>');
                        	
                        	}
                        	else {
                        		$(".btn-reply-more").prop("disabled", true).text("추가 댓글이 없습니다");
                        		// 댓글이 존재하는데 더이상 없으면 이게 나오는거
                        		// 이렇게되면 버튼이 눌리지 않음, 색도 바뀜. 
                        	}
                        	return;
                        } 
                        $(".btn-reply-more").removeClass("d-none");
                        let str = '';
                        for(let r of data) {
                            console.log(r); 
                            str += makeReplyLi(r);
                          
                        }
                        $(".reviews").append(str);  //교체x - 추가해야함
                    }
                });
            }
            list(bno);

            // modal.show();
            
            //글쓰기 폼 활성화 btn-write-form
            $(".btn-write-form").click(function(){
                console.log("글쓰기 폼");
                $("#reviewModal form").get(0).reset();
                $("#reviewModal .modal-footer button").show().eq(1).hide();
                modal.show();
            });
            
            //글쓰기 버튼 이벤트 btn-write-submit --모달쪽
            $(".btn-write-submit").click(function(){
                const result = confirm("등록 하시겠습니까?");
                if(!result) return;

                const content = $("#content").val().trim();
                const id = $("#writer").val().trim();

                const obj = {content, id, bno};
                console.log(obj);
                console.log("글쓰기 전송");

                $.ajax({
                    url,
                    method : 'POST',
                    data : JSON.stringify(obj),
                    success : function(data) {
                        if(data.result) {
                            modal.hide();  //성공했으니까 modal창 hide시킨거
							// 작성된 댓글 (append 말고 )
                            // 글을 썼다 -> 응답이와야한다 ->]
                            if(data.reply) { // not null, not undefined
	                            data.reply.regdate = dayjs().format(dayForm); 
                            	// dayjs~ 이거 콘솔에서 확인함
                            	const strLi = makeReplyLi(data.reply);
                            	// reviews에 0번째 위치에다가 붙인다고
                            	$(".reviews").prepend(strLi); 
                            	// 작성한 글이 위로 올라가야하기 때문에 append가 아니라 prepend여야함
                            } 
                        }
                    }
                })
                
            });
    
            //글수정 폼 활성화 btn-modify-form   
            $(".reviews").on("click", ".btn-modify-form", function() {
                console.log("글수정 폼");
                const rno = $(this).closest("li").data("rno");  //여기까지가 수정 폼 눌렀을 때 모달 창 뜨는. 가져와야하니까 변수로 만듦
                $.getJSON(url + rno, function(data){
                    $("#reviewModal .modal-footer button").show().eq(0).hide();
                    $("#content").val(data.content);
                    $("#id").val(data.id);
                    $("#reviewModal").data("rno", rno);
                    console.log(data);  //수정 폼까지 완성. 수정 눌렀을 때 적었던 내용 수정가능하게 나옴.
                    modal.show();
                })
                
            })

            //글수정 버튼 이벤트 btn-modify-submit  --모달쪽
            $(".btn-modify-submit").click(function(){
                const result = confirm("수정 하시겠습니까?");
                if(!result) return;

                const rno = $("#reviewModal").data("rno");
                console.log(rno);

                const content = $("#content").val().trim();
                const id = $("#id").val();

                const obj = {content, id, rno};
                const $li = $(this).closest("li");
                $.ajax({
                    url : url + rno,
                    method : 'PUT',
                    data : JSON.stringify(obj),
                    success : function(data) {
                        if(data.result) {
                           // list();  //참일때 리스트를 다시 불러와라
                            modal.hide();
                           // 재호출(get을). 가져온 데이터를 문자열로 바꿔야하고 교체도 해야함
                           $.getJSON(url + rno, function(data) {
                        	   console.log(data); 
                        	   // 문자열 생성
                        	   makeReplyLi(data); //이게 문자열임. 존의 값을 가져와서 문자열로 교체하겠다.
                        	   // 글 등록시에 했던거. 기존꺼에 덮어씌워지는
                        	   const strLi = makeReplyLi(data);
                        	   // rno를 가지고 수정할 li를 탐색, rno는 이미 알고있으니까 (같은 scope에서 이미 알고 있어서)
                        	   $(`.reviews li[data-rno='\${rno}']`); 
                        	   // []-> 속성 선택자 이걸 rno로 갈아끼울거다. 아까 "10" 이걸 rno로 갈아끼운거. 백틱사용해서 했음
                        	   // 대괄호 위치 신경쓰기
                        	   /* console.log($li.html()); */
                        	   // replaceWith로 내용 교체
                        	   $li.replaceWith(strLi);
                           })
                           // 수정버튼 눌렀을 때 모달이 내려와서 모달 데이터도 다시 훑어야하기 때문에 연쇄적 호출때문에 복잡한거임
                           //포멧팅 해놓은게 있으니까 다시 조회를 해야함. 호출하고나서 다시 재호출
            // 수정했을 때도 5개가 다 있어야함 
            // 수정시에 다 바껴야함. 
                        }
                    }
                })
                       
                console.log("글수정 전송");
               
           });
            
    
            //글삭제 버튼 이벤트 btn-remove-submit
            $(".reviews").on("click", ".btn-remove-submit", function() {
                
                //return flase; //이렇게하면 이벤트 전파를 막는다. 
                const result = confirm("삭제 하시겠습니까?");
                if(!result) return;
                
                const $li = $(this).closest("li");
                const rno = $li.data("rno");
                console.log("글삭제 전송");
                $.ajax({
                    url : url + rno,
                    method : 'DELETE',
                    success : function(data) {
                        if(data.result) {
                        	$li.remove();
	       // list();  //참일때 리스트를 다시 불러와라
	       // 여기까지 온거는 서버에서 지워진거고, 화면에 남아있는걸 지워야함. li태그를 지워야하는거임
	       // rno 탐색을 미루면됨. 삭제는 삭제 대상만 가져오면됨
                        }
                    }
                })
            })
            
            // 댓글 더보기 버튼 이벤트
            $(".btn-reply-more").click(function(){
            	//현재 댓글 목록 중 마지막 댓글의 댓글 번호를 가져오기
            	const lastRno = $(".reviews li:last").data("rno");  //번호가 나오는지 console에서 확인. 있으면.
            	console.log(lastRno);
            	list(bno, lastRno)  //댓글더보기 누르면 있었던 댓글들이 다 나오게됨.
            	
            	//list(bno, lastRno)   .댓글번호는 li태그의 댓글번호로 관리됨
            	
            });
            
        });
    </script>
</body>
</html>