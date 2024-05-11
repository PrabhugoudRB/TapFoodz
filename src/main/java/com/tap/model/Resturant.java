package com.tap.model;


public class Resturant {

	private int resturantId;
	private String name;
	private String imagePath;
	private Float rating;
	private String eta;
	private String cusineType;
	private String address;
	private String isActive;
	private int resturantAdminId;

	public Resturant() {
	}

	public Resturant(int resturantId, String name, String imagePath, Float rating, String eta, String cusineType,
			String address, String isActive, int resturantAdminId) {
		super();
		this.resturantId = resturantId;
		this.name = name;
		this.imagePath = imagePath;
		this.rating = rating;
		this.eta = eta;
		this.cusineType = cusineType;
		this.address = address;
		this.isActive = isActive;
		this.resturantAdminId = resturantAdminId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getCusineType() {
		return cusineType;
	}

	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String isActive() {
		return isActive;
	}

	public void setActive(String isActive) {
		this.isActive = isActive;
	}

	public int getResturantAdminId() {
		return resturantAdminId;
	}

	public void setResturantAdminId(int resturantAdminId) {
		this.resturantAdminId = resturantAdminId;
	}
	
	@Override
	public String toString() {
		return resturantId + " | " + name + " | " +imagePath+ " | " +rating+ " | "  + eta+ " | "+ cusineType + " | " + address +  " | " + isActive + " | " + resturantAdminId + " | ";
	}

}
