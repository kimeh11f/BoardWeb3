package com.springbook.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class DataTransformController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	@CrossOrigin
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	//xml로 다건
/*	@RequestMapping("/dataTransform.do")
	@ResponseBody
	@CrossOrigin
	public BoardListVO dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}*/
	
	//xml로 단건
/*	@RequestMapping("/dataTransform.do")
	@ResponseBody
	@CrossOrigin
	public BoardVO dataTransform(BoardVO vo){
		vo.setSeq(1);
		BoardVO board = boardService.getBoard(vo);
		return board;
	}*/
}
