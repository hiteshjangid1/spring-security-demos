package com.mahendra.demo8.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@PreAuthorize("permitAll")
	@GetMapping
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/contactus")
	public String contactus() {
		return "contactus";
	}
}
