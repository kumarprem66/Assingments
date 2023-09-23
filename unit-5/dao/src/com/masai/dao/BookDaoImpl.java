package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.masai.dto.Book;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class BookDaoImpl implements BookDao{

	@Override
	public void addBook(Book book) throws SomethingWentWrongException {
	
		Connection conn  = null;
		try {
		 conn = DBUtils.getConnection();
		 System.out.println("connection successfull");
		 String addQuery = "INSERT INTO book (book_code,name,price,publish_date,number_of_pages,writer_name) VALUES (?, ?, ?, ?, ?, ?)";
			
		 PreparedStatement ps = conn.prepareStatement(addQuery);
		 ps.setString(1,book.getBookCode());
		 ps.setString(2, book.getName());
		 ps.setDouble(3, book.getPrice());
		 ps.setDate(4, Date.valueOf(book.getPublishDate()));
		 ps.setInt(5, book.getPages());
		 ps.setString(6, book.getWriterName());
		 
		 
		 ps.executeUpdate(addQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomethingWentWrongException("Unable to add book");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void updateBook(Book book) throws SomethingWentWrongException, NoRecordFoundException {
	
		Connection conn  = null;
		try {
		 conn = DBUtils.getConnection();
		 String addQuery = "UPDATE book SET book_code = ?, name = ?,price = ?,publish_date = ?,number_of_pages = ?,writer_name = ? WHERE book_code = ?";
			
		 PreparedStatement ps = conn.prepareStatement(addQuery);
		 
		 ps.setString(1,book.getBookCode());
		 ps.setString(2, book.getName());
		 ps.setDouble(3, book.getPrice());
		 ps.setDate(4, Date.valueOf(book.getPublishDate()));
		 ps.setInt(5, book.getPages());
		 ps.setString(6, book.getWriterName());
		 
		 
		 ps.executeUpdate(addQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NoRecordFoundException("No book is availble with this id");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		
		
		return (!rs.isBeforeFirst() && rs.getRow()==0);
		
	}
	@Override
	public void deleteBook(String code) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn  = null;
		try {
		 conn = DBUtils.getConnection();
		
		 String deleteQuery = "DELETE FROM book WHERE book_code = ?";
			
		 PreparedStatement ps = conn.prepareStatement(deleteQuery);
		 
		 ps.setString(1,code);
		
		 
		 
		 ps.executeUpdate(deleteQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NoRecordFoundException("No book is availble with this id");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Book> findAllBooks(int startingpage, int endingPages, int year)
			throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn  = null;
		try {
		 conn = DBUtils.getConnection();
		 String selectQuery = "SELECT book_code,name,price,publish_date,number_of_pages,writer_name FROM book WHERE number_of_pages < ? and number_of_pages > ?";
			
		 PreparedStatement ps = conn.prepareStatement(selectQuery);
		
	
		 
		 
		 ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NoRecordFoundException("No book is availble with this input");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

	@Override
	public Book findBook(String code) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection conn  = null;
		Book book = null;
		try {
		 conn = DBUtils.getConnection();
		 String selectQuery = "SELECT book_code,name,price,publish_date,number_of_pages,writer_name FROM book WHERE book_code = ?";
			
		 PreparedStatement ps = conn.prepareStatement(selectQuery);
		 ps.setString(1,code);
		
		 ResultSet rs = ps.executeQuery();
		 if(isResultSetEmpty(rs)) {
			 throw new NoRecordFoundException("No book is availble with this id");
		 }else {
			 
			 book = new Book(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getDate(4).toLocalDate(),rs.getInt(5),rs.getString(6));
		 }
		 
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NoRecordFoundException("No book is availble with this id");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return book;
		
	}

	
	
}
