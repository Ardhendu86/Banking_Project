package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.crypto.Data;

@Entity
public class Customer 
{
	@Id
	@SequenceGenerator(initialValue = 1132431666,allocationSize = 1,sequenceName ="custid" ,name="custid")
	@GeneratedValue(generator = "custid")
	long custid;
	
	String name;
	
	String email;
	 
	long mobile;
	
	Date Dob;
	
	String gender;
	
	String pwd;

	@OneToMany
	List<BankAccount> list;

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<BankAccount> getList() {
		return list;
	}

	public void setList(List<BankAccount> list) {
		this.list = list;
	}
	
}
