package com.tap.application;

import java.util.List;
import java.util.Scanner;

import com.tap.daoImpl.OrderDaoImpl;
import com.tap.model.Order;
import com.tap.model.User;

public class OrderApplication {
	
	static Scanner scan=new Scanner(System.in);
	static Order order = new Order();
	
	static OrderDaoImpl orderDaoImpl= new OrderDaoImpl();
	
	
	public static void toInsert()
	{
		System.out.println("Enter the order  details Want to insert:");
        System.out.println("Enter the restaurantId:");
		order.setResturantId(scan.nextInt());
        System.out.println("Enter the userid:");
		order.setUserId(scan.nextInt());
        System.out.println("Enter the totalAmount:");
		order.setTotalAmount(scan.nextInt());
		System.out.println("Enter the modeOfPayment(UPI,COD,CreditCard,DebitCard)");
		order.setModeOfPayment(scan.next());
		System.out.println("Enter the status:");
		order.setStatus(scan.next());
		orderDaoImpl.addOrder(order);
		
		System.out.println("Successfully Inserted");
		
	}
		
	
	public static void toSelect() 
	{
		
		
		System.out.println("Enter the orderId to get orderDetails:");
        order = orderDaoImpl.getOrder(scan.nextInt());
        System.out.println(order);

	}
	public static void toUpdate() 
	{
		System.out.println("Enter the details to Update Order ");

		System.out.println("Enter OrderId to update :");

		int orderId = scan.nextInt();

		System.out.println("Enter the restaurantId:");
		int restaurantId= scan.nextInt();

		System.out.println("Enter the userId:");
		int userId = scan.nextInt();

		System.out.println("Enter the totalAmount:");
		float totalAmount = scan.nextFloat();

		System.out.println("Enter the modeOfPayment(UPI,CASHONDELEVERY,CREDITCARD,DEBITCARD:");
		String modeOfPayment = scan.next();

		System.out.println("Enter the status:");
		String status = scan.next();
		
		
		Order order2 = new Order(restaurantId,userId,totalAmount,modeOfPayment,status);
		
		System.out.println(orderDaoImpl.updateOrder(order2));
		
	}		
	public static void toDelete()

	{

		System.out.println("Enter the orderId  to delete order:");
		int orderid = scan.nextInt();
		System.out.println(orderDaoImpl.deleteOrder(orderid));

	}
	public static void toSelectAll()

	{

		System.out.println("<------------------All order details----------->");
		List<Order> allorders = orderDaoImpl.getAllOrder();

		for (Order o : allorders) {
			System.out.println(o);
		}
		}
	

	public static void main(String[] args) {
		
		OrderApplication.toInsert();
		OrderApplication.toSelect();
		OrderApplication.toUpdate();
		OrderApplication.toDelete();
		OrderApplication.toSelect();
		
		
		
		
		
			}

		
	}


