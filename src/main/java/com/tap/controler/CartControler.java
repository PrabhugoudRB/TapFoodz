package com.tap.controler;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImpl.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItems;
import com.tap.model.Menu;


@WebServlet("/CartControler")
public class CartControler extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addItemToCart(request, cart);
        } else if (action.equals("update")) {
        	updateCartItem(request, cart);
        } else if (action.equals("remove")) {
        	removeItemFromCart(request, cart);
        }
    

        session.setAttribute("cart", cart);
        response.sendRedirect("Cart.jsp");
    }
    
 


	// Inside the addItemToCart method
    private void addItemToCart(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Assuming you have a MenuDAO and CartItem class
        MenuDaoImpl menuDAO = new MenuDaoImpl();
        Menu menuItem = menuDAO.getMenu(itemId);
        
        if (menuItem != null) {
            HttpSession session = request.getSession();
            session.setAttribute("restaurantId", menuItem.getRestaurantId());
            
            CartItems cartItem = new CartItems(
                    menuItem.getMenuId(),
                    menuItem.getRestaurantId(),
                    menuItem.getName(),
                    quantity,  // Quantity is an int
                    menuItem.getPrice()
            );
            cart.addItems(cartItem);
        }
    }


    private void updateCartItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Assuming you have a method in Cart to update item quantity
        cart.updateItems(itemId, quantity);
    }

    private void removeItemFromCart(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        // Assuming you have a method in Cart to remove an item by itemId
        cart.removeItem(itemId);
    }

}