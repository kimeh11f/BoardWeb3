package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class GetBoardController{
	@Autowired
	private BoardService boardService;
	
	public GetBoardController() {
		System.out.println("GetBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		BoardVO board = boardService.getBoard(vo);

		model.addAttribute("board", board);
		return "getBoard.jsp";
	}

}
