package com.tap.daoImpl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.tap.dao.ResturantDao;
import com.tap.model.Resturant;



public class ResturantDaoImpl implements ResturantDao
{

	private Connection connection;
	static PreparedStatement pstmt;
	Statement statement;
	ResultSet res;
	
	public ResturantDaoImpl() {

		final String url = "jdbc:mysql://localhost:3306/tapfoods";
		final String uname = "root";
		final String password = "2580";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addResturant(Resturant rest) 
	{
		try {
			String sql = "INSERT into `resturant` (  `name` ,`imagePath` , `rating` , `eta` , `cusineType` , `address` , `isActive`, `resturantAdminId` ) values (?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, rest.getName());
			pstmt.setString(2, rest.getImagePath());
			pstmt.setFloat(3, rest.getRating());
			pstmt.setString(4, rest.getEta());
			pstmt.setString(5, rest.getCusineType());
			pstmt.setString(6, rest.getAddress());
			pstmt.setString(7, rest.isActive());
			pstmt.setInt(8, rest.getResturantAdminId());

			int i = pstmt.executeUpdate();
			
			if (i>0) 
			{
				System.out.println("Successfull...");
				
					 res = pstmt.getGeneratedKeys();
					 if(res.next())
					 {
						 System.out.println("Your ResturantId is: " + res.getInt(1));
					 }
			} 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
 
	
	}

	@Override
	public Resturant getResturant(int restId) {
		Resturant rest=null;
		String query = " select * from resturant where restaurantId = ? ";
		 try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, restId);
			res = pstmt.executeQuery();
			res.next();
			rest = new Resturant(res.getInt(1),res.getString(2),res.getString(3),res.getFloat(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9));
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return rest;
	}

	@Override
	public Resturant updateResturant(Resturant rest) {
		int i=0;
		String query = "update resturant set name = ? , imagePath = ? ,rating = ?, eta = ? , cusineType = ? , address = ? , isActive = ? , resturantAdminId = ? where restaurantId = ? ";
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, rest.getName());
			pstmt.setString(2, rest.getImagePath());
			pstmt.setFloat(3, rest.getRating());
			pstmt.setString(4, rest.getEta());
			pstmt.setString(5, rest.getCusineType());
			pstmt.setString(6, rest.getAddress());
			pstmt.setString(7, rest.isActive());
			pstmt.setInt(8, rest.getResturantAdminId());
			pstmt.setInt(9, rest.getResturantId());
			i = pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(i==1)
		{
			return rest;
		}
		return rest;
	}

	@Override
	public boolean deleteResturant(String restId) {
		int i=0;
		String query ="delete from resturant where restaurantId = ?";
		 try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, restId);
			 i = pstmt.executeUpdate();
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		 if(i==1)
		 {
			 return true;
		 }
		 return false;
	}

	@Override
	public List<Resturant> getAllResturanrt() {
		
		ArrayList<Resturant> restList = new ArrayList<Resturant>();
		
		try {
			String query = " select * from resturant " ;
			 statement = connection.createStatement();
			res = statement.executeQuery(query);
			
			while (res.next())
			{
				int resturantId = res.getInt(1);
				String name = res.getString(2);
				String imagePath = res.getString(3);
				float rating = res.getFloat(4);
				String eta = res.getString(5);
				String cusineType = res.getString(6);
				String address = res.getString(7);
				String isActive = res.getString(8);
				int resturantAdminId = res.getInt(9);
				
				Resturant r = new Resturant(res.getInt(1),res.getString(2),res.getString(3),res.getFloat(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9));
				restList.add(r);
			}
		} 
		catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return restList;
	}

	
	
}
