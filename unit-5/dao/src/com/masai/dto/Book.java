package com.masai.dto;

import java.time.LocalDate;

public class Book {

	
	
	
	private String bookCode;
	private String name;
	private double price;
	private LocalDate publishDate;
	private int pages;
	private String writerName;
	
	
	public Book() {
		super();
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public Book(String bookCode, String name, double price, LocalDate publishDate, int pages, String writerName) {
		super();
		this.bookCode = bookCode;
		this.name = name;
		this.price = price;
		this.publishDate = publishDate;
		this.pages = pages;
		this.writerName = writerName;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", name=" + name + ", price=" + price + ", publishDate=" + publishDate
				+ ", pages=" + pages + ", writerName=" + writerName + "]";
	}
	
	
}



