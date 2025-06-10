package review_api;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Review;
import service.ReviewService;

@WebServlet("/review/*")
public class ReviewServlet extends HttpServlet{
	private static final String ID = "/review/";
	
	private String getURI(HttpServletRequest req) {
		String uri = req.getRequestURI();
		uri = uri.substring(uri.indexOf(ID) + ID.length());
		return uri;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("health check");
//		// uri
//		// /review/list
//		System.out.println(req.getContextPath());
//		System.out.println(req.getRequestURI());
//      //review_api/review/list/asdf
		
		String uri = getURI(req);
		ReviewService service = new ReviewService();
		Gson gson = new Gson();
		String ret = "";
		if(uri.startsWith("list") || uri.equals("*")) { //목록조회
			ret = gson.toJson(service.list());
			
		}
		else { //단일조회
			ret = gson.toJson(service.findBy(Long.parseLong(uri)));
			
		}
		System.out.println(ret);
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(ret);
		// json
		
		// /review/1
	}    

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = getURI(req);
		Long rno = Long.valueOf(uri);
		boolean result = new ReviewService().remove(rno) > 0;
		
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(new Gson().toJson(Map.of("result", result)));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String ret = String.join("", req.getReader().lines().toList());
		
		Review review = new Gson().fromJson(ret, Review.class);
		new ReviewService().register(review);
		
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(new Gson().toJson(Map.of("result", true)));
		
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = getURI(req);
		Long rno = Long.valueOf(uri);  //수정은 권한이 필요함. 이 두개를 통해서 조회부터 해야함. 
		
		req.setCharacterEncoding("utf-8");
		String ret = String.join("", req.getReader().lines().toList());
		Review review = new Gson().fromJson(ret, Review.class);
		
		boolean result = new ReviewService().register(review) > 0;
		
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(new Gson().toJson(Map.of("result", result)));
	
	}
	
	
}
