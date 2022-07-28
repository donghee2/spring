package com.example.service;

import org.springframework.stereotype.Service;

import com.example.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}	
	
}
