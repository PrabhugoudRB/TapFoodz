package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao {
	
	
      void addMenu(Menu menu);
      
      List<Menu> getMenuList(int menuId);
      
      Menu getMenu(int menuId);
      
      String updateMenu(Menu menu);
      
      String  deleteMenu(int menuId);
      
      List<Menu> getAllMenu();
    

}
