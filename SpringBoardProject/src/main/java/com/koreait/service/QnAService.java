package com.koreait.service;

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
	
	
}
