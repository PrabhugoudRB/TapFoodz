package com.tap.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.User;

@WebServlet("/HomeControler")
public class HomeControler extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDaoImpl udi = new UserDaoImpl();
		
    	
    	String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User user = udi.getUser(username,password);
        
        
			if (user != null) 
			    {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
			    	RequestDispatcher rd = req.getRequestDispatcher("Resturant");
			    	rd.forward(req, resp);
			    } 
			    else 
			    {
			        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			        requestDispatcher.forward(req, resp);
			    }
		
	}

}
