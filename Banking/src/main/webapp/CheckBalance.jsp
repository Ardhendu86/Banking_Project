<%@page import="Dto.Customer"%>
<%@page import="Dto.BankAccount"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Check_balance.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	
	


			
	
	
 
	  <%
		long acno=(long)request.getSession().getAttribute("acnn");
	
		BankDao bankDao=new BankDao();
		BankAccount bankAccount=bankDao.fetch_by_accno(acno);
		Customer customer=bankAccount.getCustomer();
	  %>
	
	
		    <!---------------here we will write a code header------------------->
	<div class=" ctn1">
	    <img src="Bank.png" alt="">
	    <h1>AXIS BANK</h1>
	
	
	    <div class="btn">
	        
	        <a href="Customersignup.html"><button class="sign">Signup</button></a>
	        <a href="CustomerLogin.html"><button class="login">Login</button></a>
	        <a href="admin.html"><button class="admin">Admin</button></a>
	        
	    </div>
	
	</div> 
		
		
	    <div class="main">
	        <!--<h1>Welcome_to_Check_balance_page</h1>-->
	       <div class="imgs">
	        <img src="checkbalimgs.png" alt="">
	        <h2>Axisbank Passbook</h2>
	       </div>
	   
	 
		  <h1> <%=customer.getName() %> <br><br><br> Your account balance is : <%= bankAccount.getAmmount() %></h1>
	    </div>
		
		
	     <!--------------here write a code footer-------------------->
	     <footer> 
	        <div class="contact">
	            <h2>Contact Us</h2>
	            <div><i class="fa-solid fa-envelope"></i> customer.service@axisbank.com</div>
	            <div><i class="fa-solid fa-phone"></i>+919951860002</div>
	        </div>
	       <div><h4>Copyright &#169; Axis Bank &#8482;  2023 Contributed by Ardhendu_Bag.  All rights reserved.</h4></div>
	    </footer>
	
	 <!---------------------------------------------->
	
</body>
</html>