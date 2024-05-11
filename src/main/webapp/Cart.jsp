<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map,java.util.List" %>
<%@ page import="com.tap.model.CartItems" %>
<%@ page import="com.tap.model.*" %>
<%@ page import="com.tap.model.Cart" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
     <link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
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
            max-width: 1200px;
            margin: 20px auto;
            padding: 0 20px;
        }

        /* Cart item styles */
        .cart-item {
            background-color: #fff;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            margin-bottom: 20px;
            overflow: hidden;
            margin-left: 220px;
            margin-right: 220px;
        }

        .cart-item h3 {
            margin-top: 0;
            margin-bottom: 10px;
            font-size: 18px;
            color: #333;
        }

        .cart-item p {
            margin: 5px 0;
            font-size: 16px;
            color: #666;
        }

        .cart-item .quantity-control {
            margin-top: 10px;
        }

        .cart-item .quantity-control button {
            background-color: #f8f9fa;
            color: #333;
            border: 1px solid #ced4da;
            padding: 5px 10px;
            cursor: pointer;
        }

        .cart-item .quantity-control input[type="number"] {
            width: 40px;
            text-align: center;
            border: 1px solid #ced4da;
            padding: 5px;
        }

        .cart-item .quantity-control button:hover {
            background-color: #e9ecef;
        }

        .cart-item .remove-button {
            margin-top: 10px;
        }

        .cart-item .remove-button button {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        .cart-item .remove-button button:hover {
            background-color: #c82333;
        }

        /* Cart summary styles */
        .cart-summary {
            background-color: #fff;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            padding: 20px;
            margin-bottom: 20px;
            margin-left: 220px;
            margin-right: 220px;
            text-align: center;
        }

        .cart-summary h4 {
            margin-top: 0;
            margin-bottom: 10px;
            font-size: 18px;
            color: #333;
        }

        .cart-summary p {
            margin: 5px 0;
            font-size: 16px;
            color: #666;
        }

        /* Checkout button styles */
        .checkout-button {
            text-align: center;
        }

        .checkout-button button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 18px;
            border-radius: 5px;
            cursor: pointer;
        }

        .checkout-button button:hover {
            background-color: #0056b3;
        }

       input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 6px 10px;
            font-size: 12px;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        
    </style>
</head>
<body>

<div class="container">
    <div class="restaurant-info">
        <% Resturant restaurant = (Resturant) request.getAttribute("resturantDetails");
           if (restaurant != null) {%>
            <img alt="" src="<%=restaurant.getImagePath() %>">
            <h3><%= restaurant.getName() %><span style="margin-left: 600px;"></h3>
            <p style="font-size: 14px;"><%=restaurant.getAddress() %></p>
        <% } %>
 </div>
    

    <div class="cart-item">
        <% Cart cart = (Cart) session.getAttribute("cart");
           double totalPrice = 0.0;
           CartItems item=null;
           
           if (cart != null) {
               Map<Integer, CartItems> cartItemsMap = cart.getItems();
               if (cartItemsMap != null && !cartItemsMap.isEmpty()) {
                   for (Map.Entry<Integer, CartItems> entry : cartItemsMap.entrySet()) {
                        item = entry.getValue();
                       totalPrice += item.getPrice() * item.getQuantity();
        %>
        <form action="CartControler" method="GET">
            <div class="quantity-control">
                <p style="text-align: center;">
                    <%= item.getItemName() %>
                    <i class='bx bx-rupee'><%= item.getPrice() %></i>
                    <button type="button" onclick="decrementQuantity(this)" style="text-align: center;margin-left:10px;">-</button>
                    <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" max="99" >
                    <button type="button" onclick="incrementQuantity(this)" >+</button>
                </p>
	            <input type="hidden" name="action" value="update">
	            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
	            <input type="submit" value="Update" style="text-align: center;margin-left:600px;background-color: #0056b3;color:white;">
            </div>
        </form>
        
         <form action="CartControler" method="GET">
            <input type="hidden" name="action" value="remove">
            <input type="hidden" name="itemId"  value="<%= item.getItemId() %>">
            <input type="submit" value="Remove" style="text-align: center;margin-left:600px;background-color: red;color:white;">
        </form>
        
        
<% } } } %>
<a href="MenuControler?rId=<%= item.getResturantId()%>" style="text-align: center;background-color: black;color:white;text-decoration: none;">Add More Items</a>
    </div>

   <div class="cart-summary">
	    <h4>Bill Details</h4>
	    <p>Delivery Fees: <i class='bx bx-rupee'>10</i></p>
	    <p>Total Price: <i class='bx bx-rupee'><%= new DecimalFormat("0.00").format(totalPrice) %></i></p>
	</div>

<div class="checkout-button">
    <form action="checkoutControler?totalPrice=<%= totalPrice + 10 %>" method="post">
        <p>TO PAY : <i class='bx bx-rupee'><%= new DecimalFormat("0.00").format(totalPrice + 10) %></i></p>
        <!-- Place Order button -->
        <input type="submit" value="Checkout" style="background-color: black;color:white;margin-left:500px;">
    </form>
</div>


 

<script>
    function incrementQuantity(button) {
        var input = button.parentNode.querySelector('input[type="number"]');
        var value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        input.value = value;
    }

    function decrementQuantity(button) {
        var input = button.parentNode.querySelector('input[type="number"]');
        var value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        if (value > 1) {
            value--;
            input.value = value;
        }
    }

  

</script>

</body>
</html>
