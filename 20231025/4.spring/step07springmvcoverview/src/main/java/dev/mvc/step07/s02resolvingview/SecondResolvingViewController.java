package dev.mvc.step07.s02resolvingview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondResolvingViewController {
	
	@RequestMapping(value = "/s02/second-view-controller", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		ModelAndView mnv = new ModelAndView();
		
		// test.jsp로 랜더링되도록 구현
		mnv.setViewName("test");
		
		return mnv;
		
	}

}
