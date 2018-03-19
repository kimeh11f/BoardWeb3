package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	public LoginController() {
		System.out.println("LoginController-컨트롤러생성");
	}
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		
		System.out.println("로그인 인증처리");
		if(userDAO.getUser(vo) != null){
			System.out.println("로긴");
			return "getBoardList.do";
		}else{
			System.out.println("로긴실패");
			return "login.jsp";
		}
	}
}
