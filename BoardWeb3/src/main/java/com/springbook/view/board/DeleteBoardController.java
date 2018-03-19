package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController{
	public DeleteBoardController() {
		System.out.println("DeleteBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {

		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

}
