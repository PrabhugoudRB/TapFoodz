<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.Resturant, com.tap.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Items</title>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
    <link rel="stylesheet" href="z.css"> <!-- Link your CSS file here -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
     <style>
         body{
         background-color: white;
         }
        .restaurant-info {
            padding: 20px;
            margin-top: 20px;
            margin-left:250px;
            margin-right:250px;
            
        }
        .restaurant-info p {
            margin: 5px ;
            margin-left:20px:
            
        }
        .menu-container {
            display: flex;
            flex-wrap: wrap;
           height:auto;
        }
        .menu-item {
            display: flex;
            margin: 20px;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
         box-shadow: 0 3px 3px #faad96;
         margin-left:250px;
         margin-right:250px;
        }

.menu-item-image img {
    width: 100px; 
    height:auto;
    border-radius: 8px;
    margin-left: 600px; 
}

    </style>
</head>
<body>
    
    <section class="menu">
        <div class="nav">
            
                <div class="logo"><h1 style="margin-left:100px;">TapFoods</h1></div>
            
            <ul>
                <li><a href="Resturant"><i class='bx bxs-home-smile'></i> Home</a></li>
				<form action="search.jsp" method="post">
                        <li>
	                        <input type="text" placeholder="Search" name="search" ><button type="submit"><i class='bx bx-search'></i></button>
	                     </li>
                </form>
                <li><a href="Cart.jsp"><i class='bx bxs-cart-add'></i> Cart</a></li>
                <li><a href="order.jsp"><i class='bx bxs-heart-circle'></i> Orders</a></li>
                <li><a href="profile.jsp"><i class='bx bxs-user'></i> Profile</a></li>
            </ul>
        </div>
    </section>

    <div class="restaurant-info">
        <% Resturant restaurant = (Resturant) request.getAttribute("resturantDetails");
           if (restaurant != null) {%>
               
                    <h3><%= restaurant.getName() %><span style="margin-left: 600px;"><i class='bx bxs-star' style="color: rgb(224, 161, 23);"><%= restaurant.getRating() %></i></h3>
                    <p style="font-size: 14px;"><%= restaurant.getCusineType() %></p>
                    <p style="font-size: 14px;"><%=restaurant.getAddress() %></p>
                    <p><i class='bx bx-time' style="font-size: 14px;"><%= restaurant.getEta() %></i>  | <i class='bx bx-rupee' style="font-size: 14px;">40 Delivery fee will apply </i></p>
               <% } %>
    <hr style="border:none;height:1px;background-color: #f0f0f0; margin-top: 20px; margin-bottom: 20px; border-style: dotted; border-color: #ccc; border-width: 1.3px;">
               
    </div>
          
    <h3 style="margin-left:270px; margin-right:250px;">Recomended</h3><br>
    <i class="fa fa-leaf" aria-hidden="true"  style="margin-left:270px;font-size: 15px; "> PURE VEG</i> 
    <div class="menu-container">
        <% List<Menu> menuList = (List<Menu>) request.getAttribute("menu");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menu : menuList) { %>
                    <div class="menu-item">
                        <div class="menu-item-info">
                            <h4><%= menu.getName() %></h4>
                            <p style="margin-top:8px;"><i class='bx bx-rupee'><%= menu.getPrice() %></i> </p> 
                            <p style="margin-top:20px;"><%= menu.getDescription() %></p>
                        </div>
                        <div class="menu-item-image">
                            <img src="<%= menu.getImagePath() %>" alt="Menu Item" >
                            
                            <form action="CartControler?rId= <%= restaurant.getResturantId() %>" method="GET">
                                <input type="hidden" name="action" value="add"> <!-- Setting the action parameter -->
                                <input type="hidden" name="itemId" value="<%= menu.getMenuId()%>"> <!-- Include item ID -->
                                <div style="align-items: center;">
								    <input type="number" name="quantity" value="1" min="1" style="margin-left: 610px; border-radius: 3px; background-color: white; color: black; border-color: white; width: 80px; text-align: center; height: 25px;"> <!-- Quantity input -->
								    <input type="submit" value="Add" name="action" style="margin-left: 610px; border-radius: 3px; box-shadow: 0 3px 3px BLACK; background-color: white; color: black; border-color: white; width: 80px; text-align: center; height: 25px;">
								</div>

                            </form>
                            
                        </div>
                       
                    </div>
        
        <% } }%>
    </div>

    <hr style="border:none;height:1px;background-color: rgb(227, 227, 219); margin-top: 20px;margin-left:250px; margin-right:250px;">




</body>
</html>
