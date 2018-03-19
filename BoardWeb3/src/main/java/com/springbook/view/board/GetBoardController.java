package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{
	public GetBoardController() {
		System.out.println("GetBoardController-컨트롤러생성");
	}
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		BoardVO board = boardDAO.getBoard(vo);
		
		//3. 검색 결과와 화면 정보를 ModelAndView에저장하여 리턴한다.
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		return mav;
	}

}
