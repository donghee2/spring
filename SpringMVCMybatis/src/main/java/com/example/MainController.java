package com.example;

import org.springframework.stereotype.Controller;

import com.example.service.MemberService;

@Controller
public class MainController {
	private MemberService service;

	public MainController(MemberService service) {
		this.service = service;
	}
	
}
