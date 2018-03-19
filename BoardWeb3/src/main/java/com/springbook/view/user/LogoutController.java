package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	public LogoutController() {
		System.out.println("LogoutController-컨트롤러생성");
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		
		// 2. 세션 종료 후, 메인 화면으로 이동한다.
		return "login.jsp";
	}

}
