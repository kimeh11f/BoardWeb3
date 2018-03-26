package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller 
@SessionAttributes("board") //세션에 "board" Attribute가 없다면, 에러남.
public class UpdateBoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	public UpdateBoardController() {
		System.out.println("UpdateBoardController-컨트롤러생성");
	} 
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("@RequestMapping /updateBoard.do");
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자  이름 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		
		System.out.println("boardDAO.updateBoard");
		boardService.updateBoard(vo);

		//3. 화면 네비게이션
		return "redirect:getBoardList.do";
	}

}
