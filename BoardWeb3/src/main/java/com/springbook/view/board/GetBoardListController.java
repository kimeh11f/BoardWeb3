package com.springbook.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController{
	
	@Autowired
	private BoardService boardService;
	
	public GetBoardListController() {
		System.out.println("GetBoardListController-컨트롤러생성");
	}
	
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap()
	{
		System.out.println("conditionMap");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		
		//Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		System.out.println("@RequestMapping /getBoardList.do");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
}
