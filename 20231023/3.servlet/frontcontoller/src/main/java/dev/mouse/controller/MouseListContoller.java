package dev.mouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.model.Mouse;
import dev.mouse.service.MouseService;

// 경로 매핑
@WebServlet("/mice")
public class MouseListContoller extends HttpServlet {
	
	private MouseService mouseService = new MouseService();
	
	// service() 구현
	// 랜더링할 페이지 - /WEB-INF/mouseList.jsp
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=utf-8");
    	response.setCharacterEncoding("utf-8");
		
		List<Mouse> mice = mouseService.findAll();
		request.setAttribute("mice", mice);
		
		String path = "/WEB-INF/mouseList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	
	
}
