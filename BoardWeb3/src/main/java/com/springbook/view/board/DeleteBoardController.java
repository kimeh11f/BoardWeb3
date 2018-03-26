package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController{
	
	@Autowired
	private BoardService boardService;
	
	public DeleteBoardController() {
		System.out.println("DeleteBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

}
