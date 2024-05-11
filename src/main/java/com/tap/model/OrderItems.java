package com.tap.model;

public class OrderItems {

	private int orderItemId;
	private int userID;
	private int menuId;
	private String itemName;
	private float rating;
	private float price;
	private int quantity;
	

	public OrderItems() {
	}

	public OrderItems(int orderItemId, int userID, int menuId, String itemName, float rating, float price, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.userID = userID;
		this.menuId = menuId;
		this.itemName = itemName;
		this.rating = rating;
		this.price = price;
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
