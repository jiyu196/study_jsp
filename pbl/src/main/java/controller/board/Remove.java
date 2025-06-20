package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import domain.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import service.BoardService;
import util.AlertUtil;

@WebServlet("/board/remove")
public class Remove extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getParameter("bno") == null) {
			AlertUtil.alert("잘못된 접근입니다", "/board/list", req, resp);
			return;
		}
		
		//이렇게 파라미터로 가져오면 있을수도 있고 없을 수도 있는데 없으면 어떻게 할건지도 적어줘야함.
		//없다면 최소 listpage로 이동해야함
//		String bno = req.getParameter("bno"); 
//		if(bno == null) {
//			resp.setContentType("text/html; charset=utf-8");
//			PrintWriter pw = resp.getWriter();
//			pw.print("<script>");
//			pw.print("alert('잘못된 접근입니다');");
//			pw.print("location.href = 'list' ");
//			pw.print("</script>");
//			return; //더이상 진행하지 말라고
//		}
		
		BoardService service = new BoardService();
		service.remove(Long.valueOf(req.getParameter("bno")));
		Criteria cri = Criteria.init(req);
		AlertUtil.alert("글이 삭제되었습니다", "/board/list?=" + cri.getQs2(), req, resp); //글쓰기작성 후 1페이지로 보내겠다
	}

	

}
