package com.koreait.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.dto.QnADTO;

@Mapper
public interface QnAMapper {

	int insertQnA(QnADTO dto);
	
}
