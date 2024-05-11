<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.tap.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Body styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        /* Container styles */
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
        }

        /* Form styles */
        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="emai"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ced4da;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
    // Retrieving user information from session or request
    User user = (User) session.getAttribute("user"); // Assuming user information is stored in session
    String fullname = user.getUserName();
    String email = user.getEmail();
    int phone = user.getPhoneNo();
%>

<div class="container">
    <h2>Checkout</h2>
        <label for="fullname">Full Name</label>
        <input type="text" id="fullname" name="fullname" value="<%= fullname %>" required>

        <label for="email">Email Address</label>
        <input type="emai"  name="email" value="<%= email %>" required>

        <label for="phone">Phone Number</label>
        <input type="tel" id="phone" name="phone" value="<%= phone %>" required>

         <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
		
        <input type="submit" value="Payment" onclick="showPaymentOptions()">
        
        <!-- Payment method selection (Initially hidden) -->
        <div id="paymentOptions" style="display: none;">
            <label for="cod">COD</label>
            <input type="radio" id="cod" name="paymentMethod" value="COD">
            
            <label for="card">Card</label>
            <input type="radio" id="card" name="paymentMethod" value="Card">
            
            <label for="upi">UPI</label>
            <input type="radio" id="upi" name="paymentMethod" value="UPI">
        </div>
    
    <form action="final.jsp" method="post">
     		<input type="submit" value="Place Order"  style="margin-left:450px;">
    </form>
       
</div>
  
  <script>
    function showPaymentOptions() {
        document.getElementById("paymentOptions").style.display = "block";
    }
</script>

</body>
</html>
