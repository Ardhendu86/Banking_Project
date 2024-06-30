package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.BankAccount;
import Dto.BankTransaction;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String amount=req.getParameter("amount");
		double amt=Double.parseDouble(amount);
		
		long acno=(long) req.getSession().getAttribute("acnn");
		
		BankDao  bankDao=new BankDao();
		
		BankAccount  bankAccount=bankDao.fetch_by_accno(acno);
		
		 bankAccount.setAmmount((bankAccount.getAmmount()+amt)); //before putting any data inside database we should set the data
	
		 bankDao.update(bankAccount);
		 
		 BankTransaction bankTransaction= new BankTransaction();
			//bankTransaction.setTid(0);
			bankTransaction.setDeposit(amt);
			bankTransaction.setBalance(bankAccount.getAmmount());
			bankTransaction.setWithdraw(0);
			bankTransaction.setLocalDateTime(LocalDateTime.now());
			 
			List<BankTransaction>	list=bankAccount.getBankTransactions();//older Previous transaction history
			list.add(bankTransaction);
		 
			bankDao.update(bankAccount);
		 resp.getWriter().print("<h1>Amount added successfully<h1>");
		 req.getRequestDispatcher("transactionpage.jsp").include(req, resp);
	}
}
