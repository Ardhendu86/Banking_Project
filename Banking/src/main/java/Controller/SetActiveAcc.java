package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/setactiveaccount")
public class SetActiveAcc  extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acn=req.getParameter("accno");
		long acnn=Long.parseLong(acn);
		
		req.getSession().setAttribute("acnn", acnn);
		req.getRequestDispatcher("transactionpage.jsp").include(req, resp);
	}
}
