package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MenuItem;
import com.example.demo.exception.MenuItemException;
import com.example.demo.repository.MenuItemRepos;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	private MenuItemRepos menuItemRepos;
	
	@Override
	public MenuItem saveMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuItem getMenuById(Integer id) throws MenuItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuItem> getAllMenu() {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public MenuItem deletemenuById(Integer id) throws MenuItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuItem updateMenuItem(Integer id) throws MenuItemException {
		// TODO Auto-generated method stub
		return null;
	}

}
