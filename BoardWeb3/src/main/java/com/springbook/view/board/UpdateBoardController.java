package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {
	public UpdateBoardController() {
		System.out.println("UpdateBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {

		boardDAO.updateBoard(vo);

		//3. 화면 네비게이션
		return "redirect:getBoardList.do";
	}

}
