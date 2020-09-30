package com.mahendra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
//## Real URL: http://localhost:8080/MyApp3/
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		//Using ViewResolver defined in servlet-context.xml file at line#18
		//"hello" becomes "/WEB-INF/views/hello.jsp"
		return "hello";
	}
	
}
