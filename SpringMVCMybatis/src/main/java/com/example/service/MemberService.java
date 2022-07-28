package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.MemberDTO;
import com.example.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}

	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	public void insertMemberDTO(MemberDTO dto) {
		mapper.insertMemberDTO(dto);
	}	
	
}
