package dev.mvc.mouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MouseListController {
	
	@RequestMapping(value = "/mice", method=RequestMethod.GET)
	public void handleRequest() {
		System.out.println("MouseListController called");
	}
}
