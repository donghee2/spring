package com.example;

import org.springframework.stereotype.Controller;

import com.example.service.EmployeeService;

@Controller
public class MainController {
	private EmployeeService service;

	public MainController(EmployeeService service) {
		this.service = service;
	}
	
	
}
