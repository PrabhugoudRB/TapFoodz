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

import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.User;


@WebServlet("/Register")
public class RegisterControler extends HttpServlet {
	
	
	
	
	
	//adding user details into database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			UserDaoImpl udi = new UserDaoImpl();
			
			User user = new User();
			
			user.setUserName(request.getParameter("username"));
			user.setPhoneNo(Integer.parseInt(request.getParameter("phonenum")));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			int i = udi.addUser(user);
			
			
			if (i>0) {
				RequestDispatcher rd = request.getRequestDispatcher("Resturant");
				rd.forward(request, response);
			} 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
