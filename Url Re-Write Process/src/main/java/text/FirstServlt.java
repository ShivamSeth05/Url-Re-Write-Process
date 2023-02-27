package text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/first")
public class FirstServlt extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		BookBean bb = new RetrieveBookDAO().retrieve(req);
		if(bb==null) {
			pw.println("Invalid BookCode...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}else {
			pw.println("Valid bookCode...<br>");
			pw.println("<a href='second?code="+bb.getCode()
			+"&name="+bb.getName()
			+"&author="+bb.getAuthor()
			+"&price="+bb.getPrice()
			+"&qty="+bb.getQty()+"'>ViewDetails</a>");
		}
	}
}
