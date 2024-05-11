package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemsDao;
import com.tap.model.OrderItems;

public class OrderItemsDaoImpl implements OrderItemsDao{

	private Connection connection;
	static PreparedStatement pstmt;
	Statement statement;
	ResultSet res;

	public OrderItemsDaoImpl() {

		final String url = "jdbc:mysql://localhost:3306/tapfoods";
		final String uname = "root";
		final String password = "2580";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addOrderItem(OrderItems orderitems) {
		try {
			String sql = "INSERT into `orderitems` (`userId` , `menuId` , `itemName` , `rating` , `price` , `quantity` ) values (?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, orderitems.getUserID());
			pstmt.setInt(2, orderitems.getMenuId());
			pstmt.setString(3, orderitems.getItemName());
			pstmt.setFloat(4, orderitems.getRating());
			pstmt.setFloat(5, orderitems.getPrice());
			pstmt.setInt(6, orderitems.getQuantity());

			int i = pstmt.executeUpdate();

			if (i > 0) {
				System.out.println("Successfull...");

				res = pstmt.getGeneratedKeys();
				if (res.next()) {
					System.out.println("Your OrderItemId is: " + res.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderItems getOrderItem(int orderItemId) {
		
		OrderItems orderitem = null;
		String query = " select * from orderitemds where orderItemId = ? ";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, orderItemId);
			res = pstmt.executeQuery();
			res.next();
			orderitem = new OrderItems(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getFloat(5),
					res.getFloat(6), res.getInt(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderitem;
	}

	@Override
	public OrderItems updateOrderItem(OrderItems orderItem) {
		
		int i = 0;
		String query = "update orderitem set  userId = ? , menuId = ? ,itemName = ?, rating = ? , price = ? , quantity = ? where orderItemId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, orderItem.getUserID());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setString(3, orderItem.getItemName());
			pstmt.setFloat(4, orderItem.getRating());
			pstmt.setFloat(5, orderItem.getPrice());
			pstmt.setInt(6, orderItem.getQuantity());
			pstmt.setInt(7, orderItem.getOrderItemId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			return orderItem;
		}
		return orderItem;
	}

	@Override
	public boolean deleteOrderItem(int OrderItemId) {
		
		int i = 0;
		String query = "delete from orderItems er where orderItemId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, OrderItemId);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (i == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		
		List<OrderItems> orderitems = new ArrayList<OrderItems>();
		try {
			String query = " select * from user ";
			statement = connection.createStatement();
			res = statement.executeQuery(query);

			while (res.next()) {
				int orderItemId = res.getInt(1);
				int userId = res.getInt(2);
				int menuId = res.getInt(3);
				String itemName = res.getString(5);
				float rating = res.getFloat(6);
				float price = res.getFloat(7);
				int quantity = res.getInt(4);

				OrderItems oi = new OrderItems(orderItemId, userId, menuId, itemName , rating,price,quantity);
				orderitems.add(oi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderitems;
	}

}
