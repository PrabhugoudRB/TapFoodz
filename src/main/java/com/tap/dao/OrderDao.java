package com.tap.dao;

import java.util.List;

import com.tap.model.Order;

public interface OrderDao {
	
	void addOrder(Order order);

	Order getOrder(int orderId);

	Order updateOrder(Order order);

	boolean deleteOrder(int orderId);

	List<Order> getAllOrder();


}
