package com.tap.application;


import java.util.List;
import java.util.Scanner;

import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.User;

public class UserApplication {

	static Scanner scan = new Scanner(System.in);
	static UserDaoImpl userDaoImpl = new UserDaoImpl();
	static User user = new  User();
	
	static public void insertUser()
	{
		System.out.println("Enter the details of User: ");
		
		
		System.out.println("Enter email: ");
		user.setEmail(scan.next());
		System.out.println("Enter PhoneNo: ");
		user.setPhoneNo(scan.nextInt());
		System.out.println("Enter adress: ");
		user.setAdress(scan.next());
		System.out.println("Enter Username: ");
		user.setUserName(scan.next());
		System.out.println("Enter Password: ");
		user.setPassword(scan.next());
		System.out.println("Enter role ('Customer','Resturant admin','Delivery agent','System admin'): " );
		user.setRole(scan.next());
		
		userDaoImpl.addUser(user);
	}
	
	public static void getUserDetails()
	{
		System.out.println("Enter the UserId to get details of User:");
		user = userDaoImpl.getUser(scan.next(), scan.next());
		System.out.println(user);
	}
	
	public static void updateUserDetails()
	{
		System.out.println("Enter the details to update user:");
		System.out.println("Enter the userId to update user details:");
		int userID = scan.nextInt();
		System.out.println("Enter new Name: " );
		String name = scan.next();
		System.out.println("Enter new Email: " );
		String email = scan.next();
		System.out.println("Enter new PhoneNum: " );
		int phoneNo = scan.nextInt();
		System.out.println("Enter new Adress: " );
		String adress = scan.next();
		System.out.println("Enter new Username: " );
		String userName = scan.next();
		System.out.println("Enter new Password: " );
		String password = scan.next();
		System.out.println("Enter new Role ('Customer','Resturant admin','Delivery boy','System admin'): " );
		String role = scan.next();
		
		User user2 = new User(userID,email,phoneNo,adress,userName,password,role,null,null);
		System.out.println("Your new details :" + userDaoImpl.updateUser(user2));
	}
	
	public static void deleteUser()
	{
		System.out.println("Enter the UserId you want to delete:");
		System.out.println(userDaoImpl.deleteUser(scan.nextInt()));
	}
	
	public static void allUserDetails()
	{
		System.out.println("<-------- All Users details --------->");
		List<User> users = userDaoImpl.getAllUsers();
		for (User u : users) 
		{
			System.out.println(u);
		}
	}
	
	public static void main(String[] args) 
	{
		UserApplication.insertUser();
		UserApplication.getUserDetails();
		UserApplication.updateUserDetails();
		UserApplication.deleteUser();
		UserApplication.allUserDetails();
	}

}

