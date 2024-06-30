package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;


@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String custid=req.getParameter("custid");
		String pwd=req.getParameter("pwd");
		
		long id=Long.parseLong(custid);
		
		CustomerDao customerDao=new CustomerDao();
		
		Customer customer=customerDao.fetchByCustId(id);
		
		if (customer==null)
		{
			resp.getWriter().print("<h1>You Entered Invalid Customer Id<h1>");
			req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
		}else {
			//resp.getWriter().print("<h1>Successfully Login<h1>");
			
			if (customer.getPwd().equals(pwd)) 
			{
				resp.getWriter().print("<h1>Login Success<h1>");
				
				req.getSession().setAttribute("Customer", customer);
				
				req.getRequestDispatcher("CustomerHome.html").include(req, resp);
			}else {
				resp.getWriter().print("<h1>You Entered Invalid Password<h1>");
				req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
			}
		}
	}
}
