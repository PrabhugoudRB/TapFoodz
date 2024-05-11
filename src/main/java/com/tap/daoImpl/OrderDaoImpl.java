package com.tap.daoImpl;

import java.util.List;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.dao.OrderDao;
import com.tap.model.Order;

public class OrderDaoImpl implements OrderDao{

	private Connection connection;
	static PreparedStatement pstmt;
	Statement statement;
	ResultSet res;
	
	public OrderDaoImpl() {
		
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
	public void addOrder(Order order) {
		try {
			String sql = "INSERT into `order` ( `resturantId` , `userId` , `totalAmount` , `modeOfPayment` , `status`) values (?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			
			pstmt.setInt(1, order.getResturantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getModeOfPayment());
			pstmt.setString(5, order.getStatus());

			int i = pstmt.executeUpdate();

			if (i > 0) {
				System.out.println("Successfull...");

				res = pstmt.getGeneratedKeys();
				if (res.next()) {
					System.out.println("Your OrderId is: " + res.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public Order getOrder(int orderId) {
		
		Order order=null;
		String query = " select * from order where orderId = ? ";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, orderId);
			res = pstmt.executeQuery();
			res.next();
			order = new Order( res.getInt(2), res.getInt(3), res.getFloat(4), res.getString(5),res.getString(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		
		int i = 0;
		String query = "update order set  resturantId = ? , userId = ? ,totalAmount = ?, modeOfPayment = ? , status = ? where orderId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, order.getResturantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getModeOfPayment());
			pstmt.setString(5, order.getStatus());
			pstmt.setInt(5, order.getOrderId());

			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			return order;
		}
		return order;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		int i = 0;
		String query = "delete from order where orderId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, orderId);
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
	public List<Order> getAllOrder() {
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			String query = " select * from order ";
			statement = connection.createStatement();
			res = statement.executeQuery(query);

			while (res.next()) {
				int resturantId = res.getInt(2);
				int userId = res.getInt(3);
				
				float totalAmount = res.getFloat(4);
				String modeOfPayment = res.getString(5);
				String status = res.getString(6);
				
				Order o = new Order(resturantId,userId,totalAmount,modeOfPayment,status);
				orderList.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	
	
	
	
	
}
