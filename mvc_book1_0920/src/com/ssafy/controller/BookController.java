package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.Book;
import com.ssafy.model.service.BookService;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체 멤버 변수 추가
	// 멤버 변수에 BookService 추가
	BookService bookService = BookService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// action 파라미터에 따라 요청 분기(프론트 컨트롤러 패턴 적용)
		String action = request.getParameter("action");

		try {
			switch(action) {
			case "list":
				getBookList(request, response);
				break;
			case "goRegistPage":
				response.sendRedirect("book/bookRegi.jsp");
				break;
			case "regist":
				bookRegist(request, response);
				break;
			case "detail":
				bookDetail(request, response);
				break;
			case "delete":
				bookDelete(request, response);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	// 책 정보 삭제
	private void bookDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//1. 요청 파라미터 추출 => isbn
		String isbn = request.getParameter("isbn");
		
		//2. DB에서 책 정보 삭제
		int cnt = bookService.deleteByIsbn(isbn);
		
		//3. 삭제 완료 시 책 목록 조회 화면 반환 
		response.sendRedirect(request.getContextPath() +  "/book?action=list"); // 바로 bookList.jsp로 보내는게 아님(컨트롤러를 안 거치고 가기 때문에 아무것도 안 뜸)
		
	}


	// 책 상세 페이지 조회 처리
	private void bookDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String isbn = request.getParameter("isbn"); 
		Book book = bookService.select(isbn);
		
		request.setAttribute("book", book);
		request.getRequestDispatcher("/book/bookDetail.jsp").forward(request, response);
	}


	// 책 목록 조회 요청 처리
	private void getBookList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		// 1. 책목록 조회 =>  bookService의 selectAll 메소드 호출
		List<Book> list = bookService.selectAll();
		for(Book book : list) {
			System.out.println(book);
		}

		// 2. request객체에 책목록 데이터 담아서 뷰에 요청 넘기기
		request.setAttribute("list", list);
		request.getRequestDispatcher("/book/bookList.jsp").forward(request, response);
	}

	// 책 정보 등록
	private void bookRegist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		
		Book book = new Book(isbn, title, author, Integer.parseInt(price), "", "");
		bookService.insert(book);
		response.sendRedirect(request.getContextPath()+"/book?action=list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 요청 파라미터 한글 인코딩
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		doGet(request, response);
	}

}
