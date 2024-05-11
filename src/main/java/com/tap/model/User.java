package com.tap.model;

import java.util.Date;

public class User {

	private int userId;
	private String email;
	private int phoneNo;
	private String adress;
	private String userName;
	private String password;
	private String role;
	private Date craetedDate;
	private Date lastLogIn;

	public User() {
	}

	public User(int userId, String email, int phoneNo, String adress, String userName, String password,
			String role, Date craetedDate, Date lastLogIn) {
		super();
		this.userId = userId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.adress = adress;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.craetedDate = craetedDate;
		this.lastLogIn = lastLogIn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCraetedDate() {
		return craetedDate;
	}

	public void setCraetedDate(Date craetedDate) {
		this.craetedDate = craetedDate;
	}

	public Date getLastLogIn() {
		return lastLogIn;
	}

	public void setLastLogIn(Date lastLogIn) {
		this.lastLogIn = lastLogIn;
	}

	@Override
	public String toString() {
		return userId + " | " + email + " | " + phoneNo + " | "+ adress + " | " + userName + " | " + password + " | " + role + " | ";
	}
}
