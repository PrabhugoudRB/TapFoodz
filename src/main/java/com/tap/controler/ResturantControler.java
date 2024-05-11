package com.tap.controler;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.ResturantDaoImpl;
import com.tap.model.Resturant;


@WebServlet("/Resturant")
public class ResturantControler extends HttpServlet {
	

	
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	   ResturantDaoImpl restI = new ResturantDaoImpl();
	   
	   List<Resturant> allResturanrt = restI.getAllResturanrt();
	   
	  
	   req.setAttribute("resturant", allResturanrt);
	     
	   RequestDispatcher rd = req.getRequestDispatcher("resturant.jsp");
	   rd.forward(req, resp);
	   
   }

	

}
