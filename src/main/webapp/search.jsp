<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" java.sql.Connection,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
<link rel="stylesheet" href="z.css">
<style>
body{
	background-color: white;
}
header {
    color: black;
    margin-top:30px;
    padding: 10px 50px;
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
        <header><div class="logo"><h1>TapFoods</h1></div></header>
                
                    <ul>
                        <li><a href="Resturant"><i class='bx bxs-home-smile'>Home</i></a></li>
                        <form action="search.jsp" method="post">
                        <li>
	                        <input type="text" placeholder="Search" name="search" ><button type="submit"><i class='bx bx-search'></i></button>
	                     </li>
                        </form>
                        
                        <li><a href="Cart.jsp"><i class='bx bxs-cart-add'></i>Cart</a></li>
                        <li><a href="order.jsp"><i class='bx bxs-heart-circle'></i>My Order</a></li>
                        <li><a href="signIn.jsp"><i class='bx bxs-user'></i>SignIn</a></li>
                    </ul>
               
        </div>
</section>
<%
String url = "jdbc:mysql://localhost:3306/tapfoods";
String username = "root";
String password = "2580"; 
Connection connection;
int z=0;
try {
	String search=request.getParameter("search");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection(url, username, password);
	
	Statement st = connection.createStatement();
	ResultSet res = st.executeQuery("select * from menu where name like '%"+search+"%' or description like '%"+search+"%' and isAvailable='Available' ");
	while(res.next())
	{
		z=1;
%>
<div class="menu-container">
    
                <div class="menu-item">
                    <div class="menu-item-info">
				        <h4><%= res.getString(2) %></h4>
				        <p style="margin-top:8px;"><i class='bx bx-rupee'><%= res.getString(3) %></i> </p> 
				        <p style="margin-top:20px;"><%= res.getString(4) %></p>
				    </div>
				    <div class="menu-item-image">
				        <img src="<%=  res.getString(5)  %>" alt="Menu Item" >
				        
					     
		                   <a href="CartControler?menuId=<%=  res.getString(1)  %>"> <input type="submit"  value="Add" style="margin-left:610px;border-radius:3px;background-color:white;color:black;border-color:white;width:80px;text-align:center;height:25px;" ></a>
	                   
				    </div>
                   
                </div>
</div>

<%} } catch(ClassNotFoundException e) {
	e.printStackTrace();
} catch (SQLException e) {
	e.printStackTrace();
} %>

	
<% 
if(z==0)
{%>
	<h1>No such food found</h>
<% }%>
		
		
	
	







</body>
</html>