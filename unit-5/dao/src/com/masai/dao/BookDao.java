package com.masai.dao;

import java.util.List;

import com.masai.dto.Book;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface BookDao {

	
	public void addBook(Book book) throws SomethingWentWrongException;
	public void updateBook(Book book) throws SomethingWentWrongException,NoRecordFoundException;
	public void deleteBook(String code) throws SomethingWentWrongException,NoRecordFoundException;
	public List<Book> findAllBooks(int startingpage,int endingPages, int year) throws SomethingWentWrongException,NoRecordFoundException;
	public Book findBook(String code) throws SomethingWentWrongException,NoRecordFoundException;
	
}
