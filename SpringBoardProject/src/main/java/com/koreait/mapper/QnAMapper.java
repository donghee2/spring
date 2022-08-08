package com.koreait.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.dto.QnADTO;

@Mapper
public interface QnAMapper {

	int insertQnA(QnADTO dto);

	List<QnADTO> selectQnaList(Map<String, Object> map);
	
}