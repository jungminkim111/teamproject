package edu.multi.kdigital.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.service.UserService;

@Controller
public class RegisterController {
	@Inject
	UserService uservice;
		

	
	// agreement.jsp
	@RequestMapping("/Agreement")
	public String agreement(Model model) {
		return "/agreement";
	}
	
	// register.jsp
	@RequestMapping("/Agreeregister")
	public String Agreeregister(Model model) {
		return "/register";
	}
	
	// register.jsp
	@RequestMapping("/register")
	public String register(Model model) {
		return "/register";
	}
	
	@PostMapping("/register")
	public String register(UserDto dto) {
		int result = uservice.checkId(dto);
		int result2 = uservice.checkEmail(dto);
			if(result == 1) {
				return "/register";
			} else if(result2 == 1) {
				return "/register";
			} else if(result == 0) {
				uservice.insertmember(dto);
				return "/login";
			}
		return "/login";
	}
	
	@ResponseBody
	@PostMapping("/checkId")
	public int checkId(UserDto dto) {
		int result = uservice.checkId(dto);
		return result;
	}
	
	@ResponseBody
	@PostMapping("/checkEmail")
	public int checkEmail(UserDto dto) {
		int result = uservice.checkEmail(dto);
		return result;
	}
}
