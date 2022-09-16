package com.ssafy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.Book;
import com.ssafy.service.dao.BookDao;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookDao bookDao = BookDao.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		try {
			switch (action) {
			case "list":
				getBookList(request,response);
				break;
			case "bookRegi":
				bookRegi(request,response);
				break;
			case "bookDetail":
				bookDetail(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getBookList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Book> bookList = bookDao.selectAll();
		
		request.setAttribute("bookList", bookList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void bookRegi(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		Book bookInfo = new Book(isbn, title, author, Integer.parseInt(price));
		
		bookDao.insert(bookInfo);
		response.sendRedirect("/mvc/book?action=list");
	}
	
	private void bookDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String isbn = request.getParameter("isbn");
		Book book = bookDao.select(isbn);
		
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detailBook.jsp");
		dispatcher.forward(request, response);
	}

}
