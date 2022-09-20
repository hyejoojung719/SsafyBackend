package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.Book;
import com.ssafy.model.dao.BookDao;

public class BookService {
	// 싱글톤
	private BookService() {}
	private static BookService instance = new BookService();
	public static BookService getInstance() {
		return instance;
	}
	
	// Dao 객체 멤버 변수 추가
	BookDao bookDao = BookDao.getInstance();
	
	public List<Book> selectAll() throws SQLException{
		return bookDao.selectAll();
	}
	
	public int insert(Book book) throws SQLException {
		return bookDao.insert(book);
	}
}
