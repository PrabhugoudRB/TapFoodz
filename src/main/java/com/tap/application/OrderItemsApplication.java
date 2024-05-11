package com.tap.application;

import java.util.List;
import java.util.Scanner;

import com.tap.daoImpl.OrderItemsDaoImpl;
import com.tap.model.OrderItems;

public class OrderItemsApplication {

	

		static Scanner scan = new Scanner(System.in);
		static OrderItemsDaoImpl orderItemDaoImpl = new OrderItemsDaoImpl();
		static OrderItems oi = new  OrderItems();
		
		static public void insertOrderItem()
		{
			System.out.println("Enter the details of OrderItem: ");
			
			System.out.println("Enter UserId: ");
			oi.setUserID(scan.nextInt());
			System.out.println("Enter MenuId: ");
			oi.setMenuId(scan.nextInt());
			System.out.println("Enter ItemName: ");
			oi.setItemName(scan.next());
			System.out.println("Enter Rating: ");
			oi.setRating(scan.nextFloat());
			System.out.println("Enter Price: ");
			oi.setPrice(scan.nextFloat());
			System.out.println("Enter Quantity: ");
			oi.setQuantity(scan.nextInt());
			
			orderItemDaoImpl.addOrderItem(oi);
		}
		
		public static void getOrderItemDetails()
		{
			System.out.println("Enter the OrderItemId to get details of OrderItems:");
			oi = orderItemDaoImpl.getOrderItem(scan.nextInt());
			System.out.println(oi);
		}
		
		public static void updateOrderItemDetails()
		{
			System.out.println("Enter the details to update OrderItem:");
			System.out.println("Enter the OrderItemId to update OrderItem details:");
			int orderItemId = scan.nextInt();
			System.out.println("Enter UserId: ");
			int userId = scan.nextInt();
			System.out.println("Enter MenuId: ");
			int menuId = scan.nextInt();
			System.out.println("Enter ItemName: ");
			String itemName = scan.next();
			System.out.println("Enter Rating: ");
			float rating = scan.nextFloat();
			System.out.println("Enter Price: ");
			int price = scan.nextInt();
			System.out.println("Enter Quantity: ");
			int quantity = scan.nextInt();
			
			OrderItems oi = new OrderItems(orderItemId,userId,menuId,itemName,rating,price,quantity);
			System.out.println("Your new details :" + orderItemDaoImpl.updateOrderItem(oi));
		}
		
		public static void deleteOrderItem()
		{
			System.out.println("Enter the OrderItemId you want to delete:");
			System.out.println(orderItemDaoImpl.deleteOrderItem(scan.nextInt()));
		}
		
		public static void allOrderItemDetails()
		{
			System.out.println("<-------- All OrderItem details --------->");
			List<OrderItems> oi = orderItemDaoImpl.getAllOrderItems();
			for (OrderItems o : oi) 
			{
				System.out.println(o);
			}
		}
		
		public static void main(String[] args) 
		{
			OrderItemsApplication.insertOrderItem();
			OrderItemsApplication.getOrderItemDetails();
			OrderItemsApplication.updateOrderItemDetails();
			OrderItemsApplication.deleteOrderItem();
			OrderItemsApplication.allOrderItemDetails();
		}

	

}
