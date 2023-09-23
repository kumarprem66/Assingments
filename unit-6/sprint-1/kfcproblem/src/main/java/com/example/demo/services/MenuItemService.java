package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.MenuItem;
import com.example.demo.exception.MenuItemException;

public interface MenuItemService {

	
	MenuItem saveMenuItem(MenuItem menuItem);
	MenuItem getMenuById(Integer id) throws MenuItemException;
	List<MenuItem> getAllMenu();
	MenuItem deletemenuById(Integer id) throws MenuItemException;
	MenuItem updateMenuItem(Integer id) throws MenuItemException;
}
