package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;


@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String acno1=req.getParameter("acno");
		
		long acno2=Long.parseLong(acno1);
		
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_by_accno(acno2);
		
		if (bankAccount.isStatus())
		{
			bankAccount.setStatus(false);
		}else {
			bankAccount.setStatus(true);
		}
		bankDao.update(bankAccount);
		List<BankAccount> list=bankDao.fetch_All_Bank_Details();
		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("AcountHome.jsp").include(req, resp);
		resp.getWriter().print("<h1>Bank status has been updated<h1>");
	}
}
