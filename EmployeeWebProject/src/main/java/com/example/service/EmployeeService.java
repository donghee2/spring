package com.example.service;

import org.springframework.stereotype.Service;

import com.example.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	private EmployeeMapper mapper;

	public EmployeeService(EmployeeMapper mapper) {
		this.mapper = mapper;
	}
	
	
}
