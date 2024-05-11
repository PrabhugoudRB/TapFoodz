package com.tap.application;

import java.util.List;
import java.util.Scanner;

import com.tap.daoImpl.OrderHistoryImpl;
import com.tap.model.OrderHistory;

public class OrderHistoryApplication {

	static Scanner scan = new Scanner(System.in);
	static OrderHistoryImpl orderHistoryImpl = new OrderHistoryImpl();
	static OrderHistory orderHistory = new  OrderHistory();
	
	static public void insertOrderHistory()
	{
		System.out.println("Enter the details of OrderHistory: ");
		
		System.out.println("Enter OrderId: ");
		orderHistory.setOrderId(scan.nextInt());
		System.out.println("Enter UserId: ");
		orderHistory.setUserId(scan.nextInt());
		
		orderHistoryImpl.addOrderHistory(orderHistory);
	}
	
	public static void getOrderHistoryDetails()
	{
		System.out.println("Enter the UserId to get details of OrderHistory:");
		orderHistory = orderHistoryImpl.getOrderHistory(scan.nextInt());
		System.out.println(orderHistory);
	}
	
	public static void updateOrderHistoryDetails()
	{
		System.out.println("Enter the details to update OrderHistory:");
		System.out.println("Enter the OrderHistoryId to update OrderHistory details:");
		int orderHistoryId = scan.nextInt();
		System.out.println("Enter new orderId: " );
		int orderId = scan.nextInt();
		System.out.println("Enter new userId: " );
		int userId = scan.nextInt();
		
		OrderHistory orderHistory = new OrderHistory(orderHistoryId,orderId,userId);
		System.out.println("Your new details :" + orderHistoryImpl.updateOrderHistory(orderHistory));
	}
	
	public static void deleteOrderHistory()
	{
		System.out.println("Enter the OrderHistoryId you want to delete:");
		System.out.println(orderHistoryImpl.deleteOrderHistory(scan.nextInt()));
	}
	
	public static void allOrderHistoryDetails()
	{
		System.out.println("<-------- All OrderHistory details --------->");
		List<OrderHistory> orderHistoryList = orderHistoryImpl.getAllOrderHistory();
		for (OrderHistory oh : orderHistoryList) 
		{
			System.out.println(oh);
		}
	}
	
	public static void main(String[] args) 
	{
		OrderHistoryApplication.insertOrderHistory();
		OrderHistoryApplication.getOrderHistoryDetails();
		OrderHistoryApplication.updateOrderHistoryDetails();
		OrderHistoryApplication.deleteOrderHistory();
		OrderHistoryApplication.allOrderHistoryDetails();
	}

}
