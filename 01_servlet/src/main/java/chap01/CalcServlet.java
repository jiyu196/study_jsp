package chap01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServ")
public class CalcServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 콘솔에 가감승제 결과 출력
		// 여기에 코드작성
		
		//서블릿은 자바의 영역이기 때문에 여기에 아까 webapp에서 result에 적었던 부분을 다시 적어야함.  
		int num1 = Integer.parseInt(req.getParameter("value1"));
		int num2 = Integer.parseInt(req.getParameter("value2"));
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		
		// 이거는 제일 마지막줄
		resp.sendRedirect("calc_form.jsp");
		
//		resp.sendRedirect("calc_form.jsp?v=" + (num1 + num2));
		//이렇게 쓰고, webinf에 form 에는
		// <h3><%=request.getParameter("v")%> </h3> 이거 추가해주면 화면에도 뜸
		
		// *페이지간의 이동은 기본적으로 파라미터로함*
		
	}

	
	
}
