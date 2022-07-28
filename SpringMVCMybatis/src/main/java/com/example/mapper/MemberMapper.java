package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	List<MemberDTO> selectAllMember();

	void insertMemberDTO(MemberDTO dto);
	
}
