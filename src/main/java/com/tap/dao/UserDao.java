package com.tap.dao;

import java.util.List;


import com.tap.model.User;

public interface UserDao {
	
	int addUser(User user);

	User getUser(String userName, String password);

	User updateUser(User user);

	boolean deleteUser(int userId);

	List<User> getAllUsers();
	
	int addAddress(String address, String name);
}
