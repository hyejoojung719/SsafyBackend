package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.Book;
import com.ssafy.service.BookService;

/**
 * Servlet implementation class bookController
 */
@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookService bookservice = BookService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "list":
			try {
				getList(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "goRegist":
			goRegist(request,response);
			break;
		case "regist":
			try {
				registBook(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				deleteBook(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "detail":
			try {
				detailBook(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

	// 로그인 세션 관리 
	
	// 책 상세페이지
	private void detailBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String isbn = request.getParameter("isbn");
		
		Book book = bookservice.selectByIsbn(isbn);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/book/bookDetail.jsp").forward(request, response);
	}

	// 책 삭제하기
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String isbn = request.getParameter("isbn");
		int cnt = bookservice.delete(isbn);
		
		response.sendRedirect(request.getContextPath() + "/book?action=list");
	}

	// 책 등록하기
	private void registBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		String img = request.getParameter("img");
		
		Book book = new Book(isbn, title, author, price, description, img);
		
		int cnt= bookservice.insert(book);
		
		response.sendRedirect(request.getContextPath()+"/book?action=list");
		
	}

	// 책 등록 페이지로 이동
	private void goRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/book/bookRegi.jsp");
	}

	// 책 목록 페이지로 이동
	private void getList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Book> list = new ArrayList<>();

		list = bookservice.selectAll();

		request.setAttribute("list", list);
		request.getRequestDispatcher("/book/bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
