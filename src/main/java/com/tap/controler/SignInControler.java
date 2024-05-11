package com.tap.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.User;

@WebServlet("/SignIn")
public class SignInControler extends HttpServlet {
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	UserDaoImpl udi = new UserDaoImpl();
		
    	
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = udi.getUser(username,password);
        
        
			if (user != null) 
			    {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
			    	RequestDispatcher rd = request.getRequestDispatcher("Resturant");
			    	rd.forward(request, response);
			    } 
			    else 
			    {
			        RequestDispatcher requestDispatcher = request.getRequestDispatcher("SignIn2.jsp");
			        requestDispatcher.forward(request, response);
			    }
	
        
     
    }
}
