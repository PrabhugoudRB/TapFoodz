package com.tap.daoImpl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;
import com.tap.model.User;

public class MenuDaoImpl implements MenuDao {

	final static String INSERT_QUERY = "INSERT into `menu` "
			+ "(`menuId`,`name`,`price`,`description`,`imagePath`,`isAvailable`,`restaurantId`,`ratings`)"
			+ "values(?,?,?,?,?,?,?,?)";

	final static String SELECT_QUERY = "SELECT * FROM `menu` WHERE `restaurantId`= ? ";

	final static String UPDATE_QUERY = "UPDATE `menu` SET  `name` = ?, `price` = ?,`description`= ?,`imagePath`=?,`isAvailable`= ?,`restaurantId`=?,`ratings`=? WHERE `menuId` =?";

	final static String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId`= ?";

	final static String SELECT_ALL_QUERY = "SELECT * FROM `menu`";

	private Connection connection;

	public MenuDaoImpl() {

		String url = "jdbc:mysql://localhost:3306/tapfoods";
		String username = "root";
		String password = "2580";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addMenu(Menu menu) {

		try {
			PreparedStatement prepareStatement = null;
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			prepareStatement.setInt(1, menu.getMenuId());
			prepareStatement.setString(2, menu.getName());
			prepareStatement.setDouble(3, menu.getPrice());
			prepareStatement.setString(4, menu.getDescription());
			prepareStatement.setString(5, menu.getImagePath());
			prepareStatement.setString(6, menu.getIsAvailable());
			prepareStatement.setInt(7, menu.getRestaurantId());
			prepareStatement.setDouble(8, menu.getRatings());

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Menu> getMenuList(int restaurantId) {
	    ArrayList<Menu> menuList = new ArrayList<Menu>();
	    PreparedStatement prepareStatement = null;
	    ResultSet res = null;
	    try {
	        prepareStatement = connection.prepareStatement(SELECT_QUERY);
	        prepareStatement.setInt(1, restaurantId);
	        res = prepareStatement.executeQuery();
	        while (res.next()) {
	            int menuId = res.getInt("menuId");
	            String name = res.getString("name");
	            double price = res.getDouble("price");
	            String description = res.getString("description");
	            String imagePath = res.getString("imagePath");
	            String isAvailable = res.getString("isAvailable");
	            double ratings = res.getDouble("ratings");

	            Menu menu = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
	            menuList.add(menu);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    
	    return menuList;
	}

	@Override
	public Menu getMenu(int menuId) {

		Menu menu = null;
		String query = " select * from menu where menuId = ? ";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, menuId);
			ResultSet res = pstmt.executeQuery();
			res.next();
			menu = new Menu(res.getInt(1), res.getString(2), res.getDouble(3), res.getString(4), res.getString(5),
					res.getString(6),res.getInt(7), res.getDouble(8));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet res = statement.executeQuery(SELECT_ALL_QUERY);
			while (res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				int restaurantId = res.getInt("restaurantId");
				double ratings = res.getDouble("ratings");
				
				Menu menu = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
				menuList.add(menu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuList;
	}
	@Override
	public String updateMenu(Menu menu) {

		PreparedStatement prepareStatement = null;
		int i = 0;

		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, menu.getName());
			prepareStatement.setDouble(2, menu.getPrice());
			prepareStatement.setString(3, menu.getDescription());
			prepareStatement.setString(4, menu.getImagePath());
			prepareStatement.setString(5, menu.getIsAvailable());
			prepareStatement.setInt(6, menu.getRestaurantId());
			prepareStatement.setDouble(7, menu.getRatings());
			prepareStatement.setInt(8, menu.getMenuId());

			i = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return "Updated";
		} else {
			return "Not Updated";
		}
	}

	@Override
	public String deleteMenu(int menuId) {

		int i = 0;
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, menuId);
			i = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return "Deleted";
		} else {
			return "Failed";
		}

	}


}
