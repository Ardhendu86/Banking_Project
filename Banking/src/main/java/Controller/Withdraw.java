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


@WebServlet("/withdraw")
public class Withdraw extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String amount=req.getParameter("amount");
		double amt=Double.parseDouble(amount);
		
		long acno=(long) req.getSession().getAttribute("acnn");
		
		BankDao  bankDao=new BankDao();
		
		BankAccount  bankAccount=bankDao.fetch_by_accno(acno);
		
		if (bankAccount.getAmmount()<amt)
		{
			resp.getWriter().print("<h1>Insufficient balance <br>your actual balance is : " +bankAccount.getAmmount());
		}
		else
		{
			if (amt>bankAccount.getAcc_limit())
			{
				resp.getWriter().print("<h1>Your amount limit is exceeding <br>your actual amount is : " + bankAccount.getAcc_limit());
			}
			else 
			{
				bankAccount.setAmmount((bankAccount.getAmmount()-amt)); //before putting any data inside database we should set the data
				
				BankTransaction bankTransaction= new BankTransaction();
				//bankTransaction.setTid(0);
				bankTransaction.setDeposit(0);
				bankTransaction.setBalance(bankAccount.getAmmount());
				bankTransaction.setWithdraw(amt);
				bankTransaction.setLocalDateTime(LocalDateTime.now());
				
				bankDao.update(bankAccount);
				List<BankTransaction>	list=bankAccount.getBankTransactions();//older Previous transaction history
				list.add(bankTransaction);
				
				 bankDao.update(bankAccount);
				 
				 resp.getWriter().print("<h1>Amount has been withdraw successfully<h1>");
				 
				 req.getRequestDispatcher("transactionpage.jsp").include(req, resp);
			}
		} 
	}
}
