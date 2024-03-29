package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Book;
import com.ssafy.util.DBUtil;

public class BookDao {

	// 싱글톤
	private BookDao() {}
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return  instance;
	}

	// DBUtil 멤버변수 추가
	DBUtil dbUtil = DBUtil.getInstance();

	// 로직에 따라 메소드 추가

	// 1. 책 목록 조회해서 반환하는 메소드
	public List<Book> selectAll() throws SQLException{
		String sql = "select isbn, title, author, price from book";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			//Result => List<Book> 형태로 변경
			List<Book> list = new ArrayList<Book>();

			while(rs.next()) {
				// 한 행에 대한 데이터 처리
				Book book = new Book();

				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));

				list.add(book);
			}

			return list;
		} finally {
			dbUtil.close(rs,pstmt,conn);
		}
	}

	// 2. 책 정보 등록하기
	public int insert(Book book) throws SQLException {
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

	// 3. 책 상세 정보 조회
	public Book select(String isbn) throws SQLException {
		String sql = "select isbn, title, author, price from book where isbn=?";

		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if(rs.next()) {

				Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), "", "");

				return book;
			}
			return null;

		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}
	
	// 4. 책 정보 삭제
	// 반환 타입 1 => 삭제 된 거, 0 => 삭제 안 된거
	public int deleteByIsbn(String isbn) throws SQLException {
		String sql = "delete from book where isbn=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			return pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
