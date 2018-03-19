package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {
	public InsertBoardController() {
		System.out.println("InsertBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {

		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
		
	}
}
