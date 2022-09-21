package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dao.BookDao;
import com.ssafy.dto.Book;

public class BookService {

	// 싱글톤
	private BookService() {}
	private static BookService instance = new BookService();
	public static BookService getInstance() {
		return instance;
	}
	
	// dao 객체 멤버 추가
	BookDao bookDao = BookDao.getInstance();
	
	public List<Book> selectAll() throws SQLException{
		return bookDao.selectAll();
	}
	
	public int insert(Book book) throws SQLException{
		return bookDao.insert(book);
	}
	
	public int delete(String isbn) throws SQLException{
		return bookDao.delete(isbn);
	}
	
	public Book selectByIsbn(String isbn) throws SQLException{
		return bookDao.selectByIsbn(isbn);
	}
	
}
