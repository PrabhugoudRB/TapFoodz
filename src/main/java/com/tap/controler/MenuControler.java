package com.tap.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.MenuDaoImpl;
import com.tap.daoImpl.ResturantDaoImpl;
import com.tap.model.Menu;
import com.tap.model.Resturant;


@WebServlet("/MenuControler")
public class MenuControler extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		MenuDaoImpl menu = new MenuDaoImpl();
		
		Integer restid = Integer.parseInt(req.getParameter("rId"));
		
		List<Menu> menus = menu.getMenuList(restid);
		
		ResturantDaoImpl resturant = new ResturantDaoImpl();
		
		Resturant resturantDetails = resturant.getResturant(restid);
		
		req.setAttribute("menu", menus);
		req.setAttribute("resturantDetails", resturantDetails);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.include(req, resp);
		
		
	}
}
