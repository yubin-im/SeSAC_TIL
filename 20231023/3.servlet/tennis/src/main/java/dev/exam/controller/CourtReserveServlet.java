package dev.exam.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.exam.model.Reservation;

@WebServlet("/tennis/reserve")
public class CourtReserveServlet extends HttpServlet {
	private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

	/*
	 * HttpServletRequest - HTTP 요청 객체, HTTP 요청 메시지에 대한 정보 조회 가능
	 * HttpServletResponse - HTTP 응답 객체, HTTP 응답 메시지로 활용 가능
	 */	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String path = "/WEB-INF/unauthorized.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// courtList.jsp 내 폼에서 입력받은 값 추출
		String reservedTimeString = request.getParameter("datetime");
		LocalDateTime reservedTime = LocalDateTime.parse(reservedTimeString, FORMATTER);

		int courtNumber = Integer.parseInt(request.getParameter("court"));
		String centerName = request.getParameter("center");

		// 예매 처리 로직이 수행되었다고 가정
		Reservation reservation = new Reservation(centerName, courtNumber, reservedTime);
		request.setAttribute("reservation", reservation);

		// 아래 경로의 페이지로 이동하도록 코드 구현
		final String path = "/WEB-INF/success.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	
	
	
}
	
	


