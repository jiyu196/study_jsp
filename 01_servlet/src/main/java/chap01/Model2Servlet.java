package chap01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReviewService;

@WebServlet("/m2")
public class Model2Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(404);
		req.setAttribute("reviews", new ReviewService().list());
		req.getRequestDispatcher("/WEB-INF/reviewListMVC.jsp").forward(req, resp);
	}
	
}
