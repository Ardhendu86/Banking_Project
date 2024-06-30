<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="selectbanktype.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
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
        
        <!-- <h1>Welcome To Account Creation Page</h1> -->
        
        
        <!-- <% Customer customer=(Customer)request.getSession().getAttribute("Customer"); %> -->
        
        <div class="main">

            <h3>Hello Sir,    <%=customer.getName()%></h3>
        
        <form action="createbankaccount" method="post">
            
            <h1>Select bank type</h1>
            <label for="">
                <input type="radio" name="banktype" value="Saving" required="required">Saving
            </label>
            
            <label for="">
                <input type="radio" name="banktype" value="Current" >Current 
            </label>
        
        <button>Submit</button>  <button type="reset">Cancel</button>
        
        </form>
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