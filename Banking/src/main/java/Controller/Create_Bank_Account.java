  package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.BankAccount;
import Dto.Customer;


@WebServlet("/createbankaccount")
public class Create_Bank_Account extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String banktype=req.getParameter("banktype");
		
		Customer customer=(Customer) req.getSession().getAttribute("Customer");
		
		List<BankAccount> list1=customer.getList(); //it will give the list of bank accounts which have been created for current user
		boolean flag=true;
		for (BankAccount bankAccount : list1)
		{
			if (bankAccount.getAccount_type().equals(banktype))
			{
				
				resp.getWriter().print("<h1>Account already exists!<h1>");
				flag=false;
			}		
		}	
		if (flag) 
		{	
			BankAccount bankAccount=new BankAccount();
		
		//bankAccount.setAcc_no(0);  //----it will get generated automatically so its not required to set externally
		//bankAccount.setAmmount(0);
		//bankAccount.setStatus(false);
		
		bankAccount.setAccount_type(banktype);
		
		if (bankAccount.getAccount_type().equals("saving")) 
		{
			bankAccount.setAcc_limit(10000);
		}else {
			bankAccount.setAcc_limit(15000);
		}
		bankAccount.setCustomer(customer);
		
		BankDao bankDao=new BankDao();
		
		bankDao.save(bankAccount);
		
		List<BankAccount>	list2=list1;
		list2.add(bankAccount);
		
		CustomerDao customerDao=new CustomerDao();
		customerDao.update(customer);
		
		resp.getWriter().print("<h1>Bankaccount has been created successfully wating for manager approval<h1>");
		
		req.getRequestDispatcher("admin.html").include(req, resp);
		}
	}
}
