package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class Test {
	
	//필드 
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//사용자가 요청할 수 있도록 만들어줘야하기 때문에 주소와 method 방식를 나타내준다.
	//@RequestMapping(value="/list", method=RequestMethod.GET)
	//get,post방식 둘다 사용할때 
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	//@RequestMapping("/list")--> 생략된 문법(위와같음)
	
	public String TestPrint() {
		System.out.println("TestPrint");	
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value = "/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String TestPrint2() {
		System.out.println("TestPrint2");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value = "/write", method={RequestMethod.GET, RequestMethod.POST})
	public String TestPrint3() {
		System.out.println("TestPrint2");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
}
