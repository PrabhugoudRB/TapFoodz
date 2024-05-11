<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Resturant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="z.css">
    <link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
<style>
body{
	background-color: white;
}
	
header {
    color: black;
    margin-top:30px;
    padding: 10px 50px;
}

.restaurant-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    padding: 50px;
    transition: transform 0.3s ease-in-out;
}

.restaurant-card {
    width: 250px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow:0 0 10px black;
    margin-top:10px;
}

.restaurant-card img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
}

.restaurant-details {
    padding: 10px;
    background-color: white;
    border-radius: 8px;
}

.restaurant-details h2 {
    margin-top: 0;
}

.restaurant-details p {
    margin: 5px ;
}

footer {
    background-color: rgb(227, 227, 219);
    width : 100%;
    color: black;
    text-align: center;
    padding: 2px ;
}
 .category{
         padding: 10px 50px;
       
        display: flex;
        justify-content: center;
        margin-bottom: 20px;
    }
    .category .list-items{
        width: 100%;
        position: relative;
        margin-top: 100px;
         padding: 10px 50px;
    }
    .category .list-items h3{
    margin-top:-90px;
        font-size: 20px;
        font-weight: 600;
        font-family: sans-serif;
        margin-bottom: 70px;
    }
    .category .list-items .card-list{
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        margin-top: 0px;
        width: auto;
    }
    
    .category .card-list .card{
        margin-left:50px;
        margin-right:100px;
        height: auto;
        display: flex;
        position: relative;
     }
     
    .category .card-list .card img{
        width: 100px;
        height: 100px;
        bottom: 50px;
        left: 5px;
        object-fit: cover;
        object-position: center;
        background-repeat: no-repeat;
        position: absolute;
        box-shadow: 0 10px 10px #faad96;
        border-radius: 50%;
        margin: 5px;
        margin-left: 0%;
    }
    .category .card-list .card .food-title{
        padding: 60px 0 10px;

    }
    .category .card-list .card .food-title h1{
       text-align: left;
       font-weight:bold ;
       font-size: 16px;
       font-family: sans-serif;
       padding-top: 20px; 
       padding-left: 20px;
    }
</style>
</head>
<body>
<section class="menu">
        <div class="nav">
        <header><div class="logo"><h1>TapFoods</h1></div></header>
                
                    <ul>
                        <li><a href="Resturant"><i class='bx bxs-home-smile'>Home</i></a></li>
                        <form action="search.jsp" method="post">
                        <li>
	                        <input type="text" placeholder="Search" name="search" ><button type="submit"><i class='bx bx-search'></i></button>
	                     </li>
                        </form>
                        <li><a href="CartControler"><i class='bx bxs-cart-add'></i>Cart</a></li>
                        <li><a href="order.jsp"><i class='bx bxs-heart-circle'></i>My Order</a></li>
                        <li><a href="profile.jsp"><i class='bx bxs-user'></i>Profile</a></li>
                    </ul>
               
        </div>
    </section>
    
    <section class="category">
        <div class="list-items">
            <h3>Popular Dishes</h3>
            <div class="card-list">
                <div class="card">
                    <a href=""><img src="images\ckloli.jpg"></a>
                    <div class="food-title">
                        <h1>Chicken</h1>
                    </div>
                </div>
                <div class="card">
                    <a href=""><img src="images\bx2.jpg"></a>
                    <div class="food-title">
                        <h1>Burger</h1>
                    </div>
                </div>
                <div class="card">
                    <a href=""><img src="images\px1.jpg"></a>
                    <div class="food-title">
                        <h1>Pizza</h1>
                    </div>
                 </div>
                <div class="card">
                    <a href=""><img src="images\dx1.jpg"></a>
                    <div class="food-title">
                        <h1>Dessert</h1>
                    </div>
                </div>
               
            </div>
        </div>
    </section>
    
    
    <header>
        <h2>Restaurants</h2>
    </header>
    
   <main>
        <div class="restaurant-list">
            <% List<Resturant> restaurants = (List<Resturant>) request.getAttribute("resturant");
               if (restaurants != null) {
                   for (Resturant restaurant : restaurants) { %>
                    <a href="MenuControler?rId=<%= restaurant.getResturantId() %>" style=" text-decoration: none; color:black;">
                       <div class="restaurant-card">
                       		<img src="<%= restaurant.getImagePath() %>" alt="Restaurant Image">
                           <div class="restaurant-details">
                               <h3 ><%= restaurant.getName() %><i class='bx bxs-calendar-star' style="margin-left: 10px;"><%= restaurant.getRating() %></i></h3>
                               <p>  <%= restaurant.getCusineType() %> , <%= restaurant.getAddress() %></p>
                               	<div style="display: flex; align-items: center;">
							        <div style="margin-right: 5px;"><i class='bx bx-time-five'><%= restaurant.getEta() %></i></div>
							        <div><pre style="margin-bottom: 0;margin-left:100px;"> <%= restaurant.isActive() %></pre></div>
							    </div>
                           </div>
                       </div>
            </a>
            <%} } %>
        </div>
    </main>
    
    <footer>
        <p>&copy; 2024 TapFoods. All rights reserved.</p>
    </footer>
</body>
</html>
