package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MenuItem;
import com.example.demo.entities.MenuItemDto;
import com.example.demo.entities.Order;


@Repository
public interface MenuItemRepos extends JpaRepository<MenuItem, Integer>{

	
	@Query("select m from MenuItem m where m.total < :pr")
	public List<MenuItem> getMenuItemBelowCertainPrice(@Param("pr") Integer price);
		
	@Query("select m from MenuItem m where m.total < ?1")
	public List<MenuItem> getMenuItemBelowCertainPrice1(Integer price);
	
	
	@Query("select new com.example.demo.entities.MenuItemDto(m.name,m.price) from MenuItem m ORDER BY m.price DESC")
	public List<MenuItemDto> getFiveMenuItemPriceDesc();
	
	
	
	
}
