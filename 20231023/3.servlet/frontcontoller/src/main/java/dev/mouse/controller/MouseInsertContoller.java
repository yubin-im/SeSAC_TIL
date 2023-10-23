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

@WebServlet("/mice/add")
public class MouseInsertContoller extends HttpServlet {
	
	private MouseService mouseService = new MouseService();
	private MouseListContoller mouseListContoller = new MouseListContoller();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=utf-8");
    	response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse mouse = new Mouse(name, country, address);
		mouseService.add(mouse);
		
		// 리스트 출력
		// mouseListContoller.service(request, response);
		
		response.sendRedirect(request.getContextPath() + "/mice");
	}
	
	
}
