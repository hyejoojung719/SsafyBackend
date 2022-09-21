package com.ssafy.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Book;
import com.ssafy.util.DBUtils;

public class BookDao {

	// 싱글톤 
	private BookDao() {}
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	
	
	// dbutil 객체 멤버 추가
	DBUtils dbUtil = DBUtils.getInstance();
	
	// 책 목록 불러오기
	public List<Book> selectAll() throws SQLException{
		String sql = "select * from book";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Book> list = new ArrayList<>();
		
		try {
			conn = dbUtil.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				
				Book book = new Book(rs.getString(1), rs.getString(2)
						, rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
				
				list.add(book);
			}
			return list;
		} finally {
			dbUtil.close(rs,pst,conn);
		}
	}
	
	// 책 등록하기
	public int insert(Book book) throws SQLException {
		String sql = "insert into book values (?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn = dbUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getIsbn());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getAuthor());
			pst.setInt(4, book.getPrice());
			pst.setString(5, book.getDescription());
			pst.setString(6, book.getImg());
			
			return pst.executeUpdate();
			
		} finally {
			dbUtil.close(pst, conn);
		}
	}
	
	// 책 삭제하기
	public int delete(String isbn) throws SQLException{
		String sql = "delete from book where isbn = ?";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = dbUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, isbn);
			
			return pst.executeUpdate();
			
		} finally {
			dbUtil.close(pst, conn);
		}
	}
	
	// 책 상세페이지
	public Book selectByIsbn(String isbn) throws SQLException{
		String sql = "select * from book where isbn = ?";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, isbn);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6));
				return book;
			}
			return null;
		}finally {
			dbUtil.close(rs, pst, conn);
		}
	}
}
