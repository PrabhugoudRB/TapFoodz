package com.tap.daoImpl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoImpl implements UserDao {
	
	private Connection connection;
	static PreparedStatement pstmt;
	Statement statement;
	ResultSet res;

	public UserDaoImpl() {

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
	public int addUser(User user) {
		
		int i=0;
		try {
			String sql = "INSERT into `user` (`email` , `phoneNo` , `userName` , `password`) values ( ? , ? , ? , ? )";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(3, user.getUserName());
			pstmt.setString(1, user.getEmail());
			pstmt.setInt(2, user.getPhoneNo());
			pstmt.setString(4, user.getPassword());

			 i = pstmt.executeUpdate();

			if (i > 0) {
				System.out.println("Successfull...");

				res = pstmt.getGeneratedKeys();
				if (res.next()) {
					System.out.println("Your UserId is: " + res.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public User getUser(String userName, String password) {

	    User user = null;
	    String query = "SELECT * FROM `user` WHERE userName = ? AND password = ?";
	    try {
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, userName);
	        pstmt.setString(2, password);
	        res = pstmt.executeQuery();
	        
	        if (res.next()) {
	            user = new User(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), null, null);
	            return user;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}


	@Override
	public User updateUser(User user) {
		int i = 0;
		String query = "update user set   email = ? ,phoneNo = ?, adress = ? , userName = ? , password = ? , role = ? where userId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(8, user.getUserId());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getPhoneNo());
			pstmt.setString(4, user.getAdress());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getPassword());
			pstmt.setString(7, user.getRole());
			
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			return user;
		}
		return user;
	}

	@Override
	public boolean deleteUser(int userId) {

		int i = 0;
		String query = "delete from user where userId = ?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, userId);
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
	public List<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			String query = " select * from user ";
			statement = connection.createStatement();
			res = statement.executeQuery(query);

			while (res.next()) {
				int userId = res.getInt(1);
				String email = res.getString(3);
				int phoneNo = res.getInt(4);
				String adress = res.getString(5);
				String userName = res.getString(6);
				String password = res.getString(7);
				String role = res.getString(8);
				Date createdDate = res.getDate(9);
				Date lastLogIn = res.getDate(10);

				User u = new User(userId, email, phoneNo , adress,userName,password,role,createdDate,lastLogIn);
				userList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}
	
	@Override
	public int addAddress(String address, String name) {
		
		
		int i=0;
		try {
			String sql = "update user set adress = ? where userName = ? ";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, address);
			pstmt.setString(2, name);

			 i = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	

}
