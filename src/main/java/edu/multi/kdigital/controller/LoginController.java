package edu.multi.kdigital.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.service.UserService;

@Controller
public class LoginController {
	@Inject
	UserService uService;
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@PostMapping("/user")
	public ModelAndView loginCheck(@ModelAttribute UserDto dto, HttpSession session , Model model) {
		String userId = uService.loginCheck(dto, session);
		ModelAndView mv = new ModelAndView();
		if (userId != null) {	// 로그인 성공 시
			model.addAttribute("로그인 되었습니다");
			mv.setViewName("/main"); // 뷰의 이름
		} else { // 로그인 실패 시
			mv.setViewName("/login");
			mv.addObject("msg", "error");
		}
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mv) {
		uService.logout(session);
		mv.setViewName("/login");
		mv.addObject("msg", "logout");
		return mv;
	}
}
