package text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Code:"+req.getParameter("code"));
		pw.println("<br>Name:"+req.getParameter("name"));
		pw.println("<br>Author:"+req.getParameter("author"));
		pw.println("<br>Price:"+req.getParameter("price"));
		pw.println("<br>Qty:"+req.getParameter("qty"));
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}
