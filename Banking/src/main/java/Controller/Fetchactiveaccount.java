package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.BankAccount;
import Dto.Customer;
@WebServlet("/fetchActiveAcount")
public class Fetchactiveaccount extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Customer customer=(Customer) req.getSession().getAttribute("Customer");
		
		List<BankAccount> list=customer.getList();
		
		List<BankAccount> accounts=new ArrayList<BankAccount>();
		
		for (BankAccount bankAccount : list) 
		{
			if (bankAccount.isStatus())
			{
				accounts.add(bankAccount);
				resp.getWriter().print("<h1>Active account found<h1>");
			}
		}
		req.getSession().setAttribute("list", accounts);
		req.getRequestDispatcher("account.jsp").include(req, resp);;
		
	}
}
