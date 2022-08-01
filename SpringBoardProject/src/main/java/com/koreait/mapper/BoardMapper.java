package com.koreait.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.dto.BoardCommentDTO;
import com.koreait.dto.BoardDTO;
import com.koreait.dto.FileDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> selectBoardList(int pageNo);
	int selectBoardCount();
	BoardDTO selectBoardDTO(int bno);
	List<FileDTO> selectFileList(int bno);
	List<BoardCommentDTO> selectCommentDTO(int bno);
	int addBoardCount(int bno);
	int deleteBoard(int bno);
	int addBoardComment(BoardCommentDTO dto);
	int insertBoardLike(Map<String, Object> map);
	void deleteBoardLike(Map<String, Object> map);

}