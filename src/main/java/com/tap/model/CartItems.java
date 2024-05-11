package com.tap.model;

public class CartItems {

	private int itemId;
	private int resturantId;
	private String itemName;
	private int quantity;
	private double price;

	public CartItems() {
	}

	public CartItems(int itemId, int resturantId, String itemName, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.resturantId = resturantId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	

	@Override
	public String toString() {
		return "CartItems [itemId=" + itemId + ", resturantId=" + resturantId + ", itemName=" + itemName + ", quantity="
				+ quantity + ", price=" + price +  "]";
	}

	

}
