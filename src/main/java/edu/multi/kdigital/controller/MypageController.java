package edu.multi.kdigital.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.service.UserService;

@Controller
public class MypageController {
	@Inject
	UserService uservice;

	// mypage.jsp
	@GetMapping("/mypage")
	public String memberView(String userId, Model model) {
		// 회원 정보를 model에 저장
		model.addAttribute("dto", uservice.memberView(userId));
		return "/mypage";
	}

	@GetMapping("/update")
	public String updateform(String id) {
		return "/mypage";
	}

	@PostMapping("/update")
	public ModelAndView updateresult(UserDto dto) {
		int result = uservice.memberUpdate(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("/mypage");
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/checkEmail2")
	public int checkEmail(UserDto dto) {
		int result = uservice.checkEmail(dto);
		return result;
	}

}

