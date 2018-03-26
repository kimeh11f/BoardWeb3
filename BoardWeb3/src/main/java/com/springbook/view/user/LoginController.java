package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	public LoginController() {
		System.out.println("LoginController-컨트롤러생성");
	}

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		if(vo.getId() == null || "".equals(vo.getId())) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}

		UserVO user = userService.getUser(vo);
		System.out.println("로그인 인증처리");
		if(user != null){
			System.out.println("로그인 성공");
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}else{
			System.out.println("로그인 실패");
			return "login.jsp";
		}
	}
}
