package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItems;

public interface OrderItemsDao {

	void addOrderItem(OrderItems orderitems);

	OrderItems getOrderItem(int orderItemId);

	OrderItems updateOrderItem(OrderItems user);

	boolean deleteOrderItem(int OrderItemId);

	List<OrderItems> getAllOrderItems();
	
}
