package com.ssafy.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Book;
import com.ssafy.util.DBUtil;

public class BookDao {

	DBUtil dbUtil = DBUtil.getInstance();
	
	private BookDao() {}
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	
	// 책 목록 불러오기
	public List<Book> selectAll() throws Exception{
		String sql = "select * from book";
		
		List<Book> bookList = new ArrayList<Book>();
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			
				bookList.add(book);
			}
			
			return bookList;
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	
	// 책 정보 입력하기
	public int insert(Book book) throws Exception{
		String sql = "insert into book (isbn, title, author, price) values (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			
			return pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	// 책 상세정보 불러오기
	public Book select(String isbn) throws Exception{
		String sql = "select * from book where isbn=?";
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				
				return book;
			}
			return null;
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	
			
}
