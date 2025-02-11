package Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class BankAccount 
{
	
	@Id
	@SequenceGenerator(initialValue = 45678432, allocationSize = 1,sequenceName ="accno", name="accno")
	@GeneratedValue(generator = "accno")
	long acc_no;
	
	String account_type;
	
	double ammount;
	
	double acc_limit;
	
	boolean status;
	
	@ManyToOne
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL) //Directly we can save the data without et.begin(),em.persist(),et.commit().
	List<BankTransaction>BankTransactions;

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public double getAcc_limit() {
		return acc_limit;
	}

	public void setAcc_limit(double acc_limit) {
		this.acc_limit = acc_limit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<BankTransaction> getBankTransactions() {
		return BankTransactions;
	}

	public void setBankTransactions(List<BankTransaction> bankTransactions) {
		BankTransactions = bankTransactions;
	}
	
}
