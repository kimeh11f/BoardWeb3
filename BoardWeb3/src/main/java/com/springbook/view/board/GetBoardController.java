package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class GetBoardController{
	public GetBoardController() {
		System.out.println("GetBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {

		BoardVO board = boardDAO.getBoard(vo);

		model.addAttribute("board", board);
		return "getBoard.jsp";
	}

}
