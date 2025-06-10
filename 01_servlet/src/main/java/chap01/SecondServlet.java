package chap01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = {"/SecondServlet", "/Servlet2"})  //어노테이션 웹 서블릿에서 등록한거
public class SecondServlet extends HttpServlet{
	
	// text/html, text/plain, text/xml, application/json
	// image/png 
	// mine-type

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 기본 응답 형태 text/plain
		resp.setContentType("text/html; charset=euc-kr");
		PrintWriter out = resp.getWriter();
		out.write("이런것도 됨");
		System.out.println("서버 콘솔에 출력");
		out.println("화면에 출력 abcd");
	}

	

}
