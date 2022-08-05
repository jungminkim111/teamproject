package edu.multi.kdigital.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.service.UserService;


@Controller
public class MypagePwController {

	@Inject
	UserService uservice;
	
    // 아이디 찾기 페이지 이동
	@RequestMapping(value="/mypagepw_form")
	public String findIdView() {
		return "/mypagePw";
	}
	
    // 비밀번호 찾기 실행
	@RequestMapping(value="/pw_injeung", method=RequestMethod.POST)
	public String updatefindPasswordAction(UserDto dto, Model model) {
		UserDto user = uservice.updatefindPassword(dto);
		
		if(user == null) { 
			model.addAttribute("check", 1);
		} else { 
			model.addAttribute("check", 0);
		}
		
		return "/mypagePw";
	}

}