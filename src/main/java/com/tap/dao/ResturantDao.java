package com.tap.dao;

import java.util.List;

import com.tap.model.Resturant;


public interface ResturantDao {

	void addResturant(Resturant rest);

	Resturant getResturant(int restId);

	Resturant updateResturant(Resturant rest);

	boolean deleteResturant(String restId);

	List<Resturant> getAllResturanrt();
}
