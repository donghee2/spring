package com.koreait.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.koreait.dto.BoardCommentDTO;
import com.koreait.dto.BoardDTO;
import com.koreait.dto.FileDTO;
import com.koreait.mapper.BoardMapper;

@Service
public class BoardService {
	private BoardMapper mapper;

	public BoardService(BoardMapper mapper) {
		this.mapper = mapper;
	}

	public List<BoardDTO> selectBoardList(int pageNo) {
		return mapper.selectBoardList(pageNo);
	}

	public int selectBoardCount() {
		return mapper.selectBoardCount();
	}

	public BoardDTO selectBoardDTO(int bno) {
		return mapper.selectBoardDTO(bno);
	}

	public List<FileDTO> selectFileList(int bno) {
		return mapper.selectFileList(bno);
	}

	public List<BoardCommentDTO> selectCommentDTO(int bno) {
		return mapper.selectCommentDTO(bno);
	}

	public int addBoardCount(int bno) {
		return mapper.addBoardCount(bno);
	}

	public int deleteBoard(int bno) {
		return mapper.deleteBoard(bno);
	}

	public int insertBoardComment(BoardCommentDTO dto) {
		return mapper.addBoardComment(dto);
	}

	public int insertBoardLike(int bno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		int result = 0;
		try {
			result = mapper.insertBoardLike(map);			
		} catch (Exception e) {
			mapper.deleteBoardLike(map);						
		}
		return result;
	}

	public int insertBoardHate(int bno, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		int result = 0;
		try {
			result = mapper.insertBoardHate(map);			
		} catch (Exception e) {
			mapper.deleteBoardHate(map);						
		}
		return result;
	}

	public int inserBoard(BoardDTO dto) {
		int bno = mapper.selectBoardNo(); // 게시글 번호 받아옴
		dto.setBno(bno); // dto에 게시글 번호 셋팅
		mapper.insertBoard(dto); // 게시글 등록
		return bno;
	}

	public int insertFileList(FileDTO fileDTO) {
		return mapper.insertFileList(fileDTO);
	}

	public String selectFile(int bno, int fno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("fno", fno);
		return mapper.selectFile(map);
	}

	
}




