package kr.co.mycom.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mycom.board.Service.EmpService;
import kr.co.mycom.board.model.EmpDTO;

//Controller를 상속또는 implements를 앋고 POJO방식으로 작성

@Controller
public class EmpController {

	@Resource
	private EmpService empService;
	
	@RequestMapping("/loginForm.htm")
	public String loginForm(){
		return "loginForm";
	}//ModelAndView를 리턴하는것과 같음
	
	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request, EmpDTO dto){ 
		dto = empService.select(dto);
		System.out.println(dto);
		request.setAttribute("login", dto);
		return (dto != null)?"login":"fail";
		
	}
}
