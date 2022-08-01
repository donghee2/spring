package com.koreait;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.dto.BoardCommentDTO;
import com.koreait.dto.BoardDTO;
import com.koreait.dto.FileDTO;
import com.koreait.dto.MemberDTO;
import com.koreait.service.BoardService;
import com.koreait.service.MemberService;
import com.koreait.vo.PaggingVO;

@Controller
public class MainController {
	private BoardService boardService;
	private MemberService memberService;

	public MainController(BoardService boardService, MemberService memberService) {
		this.boardService = boardService;
		this.memberService = memberService;
	}

	@RequestMapping("/")
	public String main(@RequestParam(name = "pageNo", defaultValue = "1") int pageNo, Model model) {
//		System.out.println(pageNo);
		List<BoardDTO> list = boardService.selectBoardList(pageNo);
		model.addAttribute("list", list);

		// 페이징 처리
		int count = boardService.selectBoardCount();
		PaggingVO vo = new PaggingVO(count, pageNo, 10, 5);
		model.addAttribute("pagging", vo);

		return "main";
	}

	@RequestMapping("/boardView.do")
	public String boardView(int bno, Model model, HttpSession session) {
		BoardDTO dto = boardService.selectBoardDTO(bno);
		List<FileDTO> flist = boardService.selectFileList(bno);
		List<BoardCommentDTO> comment = boardService.selectCommentDTO(bno);
		// 게시글 조회수 증가
		HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("bno_history");
		if (set == null)
			set = new HashSet<Integer>();

		if (set.add(bno))
			boardService.addBoardCount(bno);
		session.setAttribute("bno_history", set);
		model.addAttribute("board", dto);
		model.addAttribute("flist", flist);
		model.addAttribute("comment", comment);
		return "board_detail_view";
	}

	@RequestMapping("loginView.do")
	public String loginView() {
		return "login";
	}

	@RequestMapping("login.do")
	public String login(String id, String pass, HttpSession session) {
		MemberDTO dto = memberService.login(id, pass);
		if (dto != null) {
			session.setAttribute("login", true);
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", dto.getName());
			session.setAttribute("grade", dto.getGradeNo());
			return "redirect:/";
		} else {
			session.setAttribute("login", false);
			return "login";
		}
	}
	
	@RequestMapping("/deleteBoard.do")
	public String boardDelete(int bno) {
		// 파일 삭제
		// 파일 삭제 목록을 불러옴
		List<FileDTO> list = boardService.selectFileList(bno);
		for(int i=0;i<list.size();i++) {
			File file = new File(list.get(i).getPath()); // 전체 경로 받는 부분
			try {
				if(file.delete()) {
					System.out.println("파일 삭제 성공");
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// 게시글 삭제
		boardService.deleteBoard(bno);
		return "redirect:/";
	}
	@RequestMapping("/insertComment.do")
	public void insertComment(int bno, String writer, String content, HttpServletResponse response) {
		BoardCommentDTO dto = new BoardCommentDTO(bno, content, writer);
		int result = boardService.insertBoardComment(dto);
		try {
			response.getWriter().write(String.valueOf(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/plusLikeHate.do")
	public void plusLikeHate(int bno, int mode, HttpSession session, HttpServletResponse response) {
		String id =  (String) session.getAttribute("id");
		int result = 0;
		if(mode == 0) {
			// 좋아요
			result = boardService.insertBoardLike(bno, id);
		} else {
			// 싫어요
			
		}
		try {
			response.getWriter().write(String.valueOf(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}













