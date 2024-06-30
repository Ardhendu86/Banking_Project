<%@page import="Dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Acounthome.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<!-- <h1>Welcome to account home</h1> -->
	
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

    <!---------------------------------------------->
    
	<% List<BankAccount> list=(List<BankAccount>)request.getSession().getAttribute("list"); %>
	<table border="1" cellspacing="0" cellpadding="15">
		<tr>
			<th>Account_Number</th>
			<th>Account_type</th>
			<th>Balance</th>
			<th>Account_limit</th>
			<th>Account_status</th>
			<th>Customer_name</th>
			<th>Customer_id</th>
			<th>Change_status</th>
		</tr>
	
	<%for(BankAccount bankAccount:list){ %>
	
	<tr>
			<th><%= bankAccount.getAcc_no() %></th>
			<th><%= bankAccount.getAccount_type() %></th>
			<th><%= bankAccount.getAmmount() %></th>
			<th><%= bankAccount.getAcc_limit() %></th>
			<th><%= bankAccount.isStatus() %></th>
			<th><%= bankAccount.getCustomer().getName() %></th>
			<th><%= bankAccount.getCustomer().getCustid()  %></th>
			<th><a href="changestatus?acno=<%=bankAccount.getAcc_no()%>"><button class="change">Change_Status</button></a></th>
	</tr>
	
	<%} %>
	
	</table>
	 <a href="account.jsp" class="back"><button>Back</button></a>
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