<%@page import="Dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link rel="stylesheet" href="Account.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<!--  <h1>Welcome to the Account Page</h1>-->
	

	
	      <!-- /* here we will write a code header*/ -->
      <div class=" ctn1">
        <img src="Bank.png" alt="">
        <h1>AXIS BANK</h1>


        <div class="btn">
            
            <a href="Customersignup.html" ><button class="signup">Signup</button></a>
	        <a href="CustomerLogin.html"><button class="login">Login</button></a>
            <a href="admin.html"><button class="admin">Admin</button></a>
            
        </div>

        <div class="article">
            <h2>WELCOME TO </h2> 
            <h3>ACCOUNT PAGE</h3>
            <p>Axis Bank is the third largest private sector bank in India offering an entire
                comprehensive spectrum of financial services.</p>
                
			
	 <% List<BankAccount> list = (List<BankAccount>)request.getSession().getAttribute("list");
	
			if(list.isEmpty())
		{%>
	
			<h1>No Active Accounts Founds</h1>	
	
	   <%}else{%>
	
		<%for(BankAccount bankAccount:list) { %>
		<a  href="setactiveaccount?accno=<%= bankAccount.getAcc_no()%>"  class="acbtn"><button ><%= bankAccount.getAcc_no() %></button></a>
	
	<%}%>
	
	<%}%>	
       
        </div>
        
 

        <div class="space">
            <div class="spaceimg"></div>
            <h4>YUOR FUTURE</h4>
            <p>Axis Bank is the third largest private sector bank in India offering an entire
                comprehensive spectrum of financial services.</p>
        </div>
    </div> 
<!------------------------------------->
   
   

    <!-- /* here we will write a code footer*/ -->
  <footer> 
    <div class="contact">
        <h2>Contact Us</h2>
        <div><i class="fa-solid fa-envelope"></i> customer.service@axisbank.com</div>
        <div><i class="fa-solid fa-phone"></i>+919951860002</div>
    </div>
   <div><h4>Copyright &#169; Axis Bank &#8482;  2023 Contributed by Ardhendu_Bag.  All rights reserved. </h4></div>
</footer>
<!------------------------------> 

		
</body>
</html>