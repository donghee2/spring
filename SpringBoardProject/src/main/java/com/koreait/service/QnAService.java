package com.koreait.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.koreait.dto.QnADTO;
import com.koreait.mapper.QnAMapper;

@Service
public class QnAService {
	private QnAMapper mapper;

	public QnAService(QnAMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public int insertQnA(QnADTO dto) {
		return mapper.insertQnA(dto);
	}

	public List<QnADTO> selectQnaList(String writer, int page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("writer", writer);
		map.put("page", page);		
		return mapper.selectQnaList(map);
	}
	
	
}