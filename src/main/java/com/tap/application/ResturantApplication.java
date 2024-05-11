package com.tap.application;
import java.util.List;
import java.util.Scanner;

import com.tap.daoImpl.ResturantDaoImpl;
import com.tap.model.Resturant;

public class ResturantApplication {

	static Scanner scan = new Scanner(System.in);
	static ResturantDaoImpl restDaoImpl = new ResturantDaoImpl();
	static Resturant rest = new  Resturant();
	
	public static void insertResturant()
	{
		System.out.println("Enter the details of Resturant: ");
		System.out.println("Enter resturant Name:");
		rest.setName(scan.next());
		System.out.println("Enter ImagePath:");
		rest.setImagePath(scan.next());
		System.out.println("Enter Rating:");
		rest.setRating(scan.nextFloat());
		System.out.println("Enter Estimated Time of Arrival:");
		rest.setEta(scan.next());
		System.out.println("Enter Cusine Type:");
		rest.setCusineType(scan.next());
		System.out.println("Enter adress:");
		rest.setAddress(scan.next());
		System.out.println("Enter resturant is active/not:");
		rest.setActive(scan.next());
		System.out.println("Enter resturant AdminId:");
		rest.setResturantAdminId(scan.nextInt());
		
		restDaoImpl.addResturant(rest);
	}
	
	public static void getResturantDetails()
	{
		System.out.println("Enter the ResturantId to get details of Resturant:");
		Resturant rest1 = restDaoImpl.getResturant(scan.nextInt());
		System.out.println(rest1);
	}
	
	public static void updateResturantDetails()
	{
		System.out.println("Enter the details to be updated:");
		System.out.println("Enter the ResturantId to update Resturant details:");
		int restId = scan.nextInt();
		System.out.println("Enter new resturant name:");
		String restName = scan.next();
		System.out.println("Enter new Image Path:");
		String imagePath = scan.next();
		System.out.println("Enter new Rating:");
		Float rating = scan.nextFloat();
		System.out.println("Enter new Estimated Time of Arrival:");
		String eta = scan.next();
		System.out.println("Enter new cousin type:");
		String cusineType = scan.next();
		System.out.println("Enter new adress:");
		String adress = scan.next();
		System.out.println("Enter active/not:");
		String status = scan.next();
		System.out.println("Enter new Resturant AdminId:");
		int resturantAdminId = scan.nextInt();

		Resturant rest = new Resturant(restId,restName,imagePath,rating,eta,cusineType,adress,status,resturantAdminId);
		System.out.println("Your new details :" + restDaoImpl.updateResturant(rest));
	}
	
	public static void deleteResturant()
	{
		System.out.println("Enter the resturantId you want to delete:");
		System.out.println(restDaoImpl.deleteResturant(scan.next()));
	}
	
	public static void allResturantDetails()
	{
		System.out.println("<-------- All Menu details --------->");
		List<Resturant> rests = restDaoImpl.getAllResturanrt();
		for (Resturant r : rests) 
		{
			System.out.println(r);
		}
	}
	
	public static void main(String[] args) {
		
		//ResturantApplication.insertResturant();
		//ResturantApplication.getResturantDetails();
		ResturantApplication.updateResturantDetails();
		ResturantApplication.deleteResturant();
		ResturantApplication.allResturantDetails();
	}
}
