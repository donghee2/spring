package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.EmployeeService;

@Controller
public class MainController {
	private EmployeeService service;

	public MainController(EmployeeService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String main() {
		return "employee_search";
	}
	
	
}
