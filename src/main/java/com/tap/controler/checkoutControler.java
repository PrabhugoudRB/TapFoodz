package com.tap.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImpl.OrderDaoImpl;
import com.tap.model.Order;
import com.tap.model.Resturant;
import com.tap.model.User;

@WebServlet("/checkoutControler")
public class checkoutControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
//    	UserDaoImpl udi = new UserDaoImpl();
//    	
//    	String address = request.getParameter("address");
//    	String name = request.getParameter("fullname");
//    	
//    	udi.addAddress(address,name);
    	
    	OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    	
    	
    	Resturant resturant = new Resturant();
    	int resturantId2 = resturant.getResturantId();
    	
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	int userId = user.getUserId();
    	
    	Double price = Double.parseDouble(request.getParameter("totalPrice"));
    	
    	Order order = new Order(resturantId2,userId,price,null,null);
    	
    	
    	orderDaoImpl.addOrder(order);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("checkOut.jsp");
    	rd.forward(request, response);
    	
    }
}
