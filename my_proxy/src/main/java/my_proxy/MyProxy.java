package my_proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/proxy")
public class MyProxy extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String u =    req.getParameter("url");
        String test = "https://www.yonhapnewstv.co.kr/browse/feed/";

        URL url = new URL(test);
        InputStream is = url.openStream();
        resp.getOutputStream().write(is.readAllBytes());

    }
}
