package com.tap.application;

import java.util.List;
import java.util.Scanner;

import com.tap.daoImpl.MenuDaoImpl;
import com.tap.model.Menu;

public class MenuApplication {
	static Scanner scan=new Scanner(System.in);
	static Menu menu = new Menu();
	static MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
	
	public static void toInsert()
	{
		
		System.out.println("Enter the menu details Want to insert:");
        System.out.println("Enter the name:");
		menu.setName(scan.next());
        System.out.println("Enter the price:");
		menu.setPrice(scan.nextDouble());
        System.out.println("Enter the description:");
		menu.setDescription(scan.next());
		System.out.println("Enter the imagePath:");
		menu.setImagePath(scan.next());
		System.out.println("Enter the isAvailable:");
		menu.setAvailable(scan.next());
		System.out.println("Enter the restaurantId:");
		menu.setRestaurantId(scan.nextInt());
		System.out.println("Enter the ratings");
		menu.setRatings(scan.nextDouble());
		
        menuDaoImpl.addMenu(menu);
        
		System.out.println("Successfully Inserted");

	}
	public static void toSelect() 
	{
		
		
		System.out.println("Enter the MenuId to get userDetails:");
        menu= menuDaoImpl.getMenu(scan.nextInt());
        System.out.println(menu);

	}
	public static void toUpdate() 
	{
		System.out.println("Enter the details to upadate menu ");

		System.out.println("Enter menuId to update :");
		
        int menuId= scan.nextInt();
        
        System.out.println("Enter the name:");
		String name = scan.next();

		System.out.println("Enter the price:");
		double price = scan.nextDouble();

		System.out.println("Enter the description:");
		String description= scan.next();

		System.out.println("Enter the imagePath:");
		String imagePath = scan.next();

		System.out.println("Enter the isAvailable:");
		String isAvailable = scan.next();
		
		System.out.println("Enter the restaurantId:");
		int restaurantId = scan.nextInt();
		
		System.out.println("Enter the ratings");
		Double ratings=scan.nextDouble();
		
        
        
		Menu menu2 = new Menu(menuId,name,price,description,imagePath,isAvailable,restaurantId,ratings);
		
		System.out.println(menuDaoImpl.updateMenu(menu2));
	}
	
	public static void toDelete()

	{

		System.out.println("Enter the userId  to delete user:");
		int menuId = scan.nextInt();
		System.out.println(menuDaoImpl.deleteMenu(menuId));

	}
	public static void toSelectAll()

	{

		System.out.println("<------------------All menu details----------->");
		List<Menu> allMenus = menuDaoImpl.getAllMenu();

		for (Menu m : allMenus) {
			System.out.println(m);
		}
	}
	
	public static void main(String[] args) {
		
		//MenuApplication.toInsert();
		//MenuApplication.toSelect();
		//MenuApplication.toUpdate();
		//MenuApplication.toDelete();
		MenuApplication.toSelectAll();
		
		
	}

}
