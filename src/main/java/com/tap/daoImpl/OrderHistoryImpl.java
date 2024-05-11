package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderHistoryDao;
import com.tap.model.OrderHistory;


public class OrderHistoryImpl implements OrderHistoryDao{

	private Connection connection;
	static PreparedStatement pstmt;
	Statement statement;
	ResultSet res;

	public OrderHistoryImpl() {

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
	public void addOrderHistory(OrderHistory orderHistory) {

		try {
			String sql = "INSERT into `user` (`orderId` , `userId` ) values (?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, orderHistory.getOrderId());
			pstmt.setInt(2, orderHistory.getUserId());

			int i = pstmt.executeUpdate();

			if (i > 0) {
				System.out.println("Successfull...");

				res = pstmt.getGeneratedKeys();
				if (res.next()) {
					System.out.println("Your OrderHistoryId is: " + res.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {

		OrderHistory orderHistory = null;
		String query = " select * from orderhistory where orderHistoryId = ? ";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, orderHistoryId);
			res = pstmt.executeQuery();
			res.next();
			orderHistory = new OrderHistory(res.getInt(1), res.getInt(2), res.getInt(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderHistory;
	}

	@Override
	public OrderHistory updateOrderHistory(OrderHistory orderHistory) {
		int i = 0;
		String query = "update orderhistory set  orderId = ? , userId = ?  where orderHistoryId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(3, orderHistory.getUserId());
			pstmt.setInt(1, orderHistory.getOrderId());
			pstmt.setInt(2, orderHistory.getUserId());
			
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			return orderHistory;
		}
		return orderHistory;
	}

	@Override
	public boolean deleteOrderHistory(int orderHistoryId) {

		int i = 0;
		String query = "delete from orderhistory where orderHistoryId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, orderHistoryId);
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
	public List<OrderHistory> getAllOrderHistory() {
		ArrayList<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
		try {
			String query = " select * from orderhistory ";
			statement = connection.createStatement();
			res = statement.executeQuery(query);

			while (res.next()) {
				int orderHistoryId = res.getInt(1);
				int orderId = res.getInt(2);
				int userId = res.getInt(3);

				OrderHistory u = new OrderHistory(orderHistoryId,orderId,userId);
				orderHistoryList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderHistoryList;
	}

}
