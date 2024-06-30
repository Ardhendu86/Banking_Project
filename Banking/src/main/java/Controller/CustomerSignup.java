package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import Dao.CustomerDao;
import Dto.Customer;


@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String custname=req.getParameter("custname");
		String mobile=req.getParameter("mobile");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		
		long mob=Long.parseLong(mobile);
		
		/*resp.getWriter().print("<h1>name: "+custname+"<h1>");
		resp.getWriter().print("<h1>mobile: "+mobile+"<h1>");
		resp.getWriter().print("<h1>password: "+password+"<h1>");
		resp.getWriter().print("<h1>email: "+email+"<h1>");
		resp.getWriter().print("<h1>gender: "+gender+"<h1>");
		resp.getWriter().print("<h1>dob: "+dob+"<h1>");*/
		
//		resp.getWriter().print("<h1>name: "+custname+"<h1>"
//				+ "<h1>mobile: "+mobile+"<h1>"
//				+ "<h1>password: "+password+"<h1>"
//				+ "<h1>email: "+email+"<h1>"
//				+ "<h1>gender: "+gender+"<h1>"
//				+ "<h1>dob: "+dob+"<h1>");
		
		Date date=Date.valueOf(dob);
		
		Period period=Period.between(date.toLocalDate(), LocalDate.now());
		
		int age=period.getYears();
		
		if (age<18)
		{
			resp.getWriter().print("<h1>He is not eligible to create a Bank Account <h1>");
		}else {
			//resp.getWriter().print("<h1>He is  eligible to create a Bank Account <h1>");
			
			CustomerDao customerDao=new CustomerDao();
			
			List<Customer> list1=customerDao.fetch(mob);
			
			List<Customer> list2=customerDao.fetch(email);
			
			Customer customer=new Customer();
			if (list1.isEmpty() && list2.isEmpty()) 
			{
				
			customer.setName(custname);
			customer.setEmail(email);
			customer.setGender(gender);
			customer.setPwd(password);
			customer.setDob(date);
			customer.setMobile(mob);
			
			
			customerDao.save(customer);
			
			//resp.getWriter().print("<h1>Account has been created successfully<h1>");
			
			Customer fetchemail=customerDao.fetch(email).get(0);
			long id=fetchemail.getCustid();
			
			if (fetchemail.getGender().equals("male")) 
			{
				resp.getWriter().print("<h1> Hello Sir, Your Account Has Been Created Successfully<h1>");
				resp.getWriter().print("<h1> Your Customer id is :"+id+"<h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}else {
				resp.getWriter().print("<h1> Hello Ma'am, Your Account Has Been Created Successfully<h1>");
				resp.getWriter().print("<h1> Your Customer id is :"+id+"<h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
			
			}else 
			{
				resp.getWriter().print("<h1>Account is already existed<h1>");
			}
			
		}
	}
}
