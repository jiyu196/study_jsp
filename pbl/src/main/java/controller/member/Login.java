package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import service.MemberService;

@WebServlet("/member/login")
@Slf4j
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//파라미터 수집
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		log.info("{} {}", id, pw);
		
		//인스턴스 만들지 않아 (register에서 이미 계정을 만들었으니까)
		//service.login(id,pw) 호출
		boolean ret = new MemberService().login(id, pw); 
		//memberservice login 에 만들어놨던 로그인 메서드 사용하려고 쓴거다
		log.info("{}", ret);
		
		if(ret) { // 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("member", new MemberService().findById(id));
			resp.sendRedirect(req.getContextPath() + "/index");
			// contextPath >> /pbl	
		}
		else { //로그인 실패
			resp.sendRedirect("login?msg=fail");
			
		}
		
		//index 리디렉션
		//	resp.sendRedirect("../index");
		
		
	}

	
	

}
