package dev.mvc.step07.s01processrequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecondController {
	
	@RequestMapping(value = "/s01/second-controller", method=RequestMethod.GET)
	public void handleRequest() {
		System.out.println("secondController called");
	}
}
