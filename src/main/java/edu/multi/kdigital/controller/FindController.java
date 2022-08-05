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
public class FindController {

	@Inject
	UserService uservice;
	
    // 아이디 찾기 페이지 이동
	@RequestMapping(value="/find_id_form")
	public String findIdView() {
		return "/findId";
	}
	
    // 아이디 찾기 실행
	@RequestMapping(value="/find_id", method=RequestMethod.POST)
	public String findIdAction(UserDto dto, Model model) {
		UserDto user = uservice.findId(dto);
		
		if(user == null) { 
			model.addAttribute("check", 1);
		} else { 
			model.addAttribute("check", 0);
			model.addAttribute("id", user.getUserId());
		}
		
		return "/findId";
	}
	
    // 비밀번호 찾기 페이지로 이동
	@RequestMapping(value="/find_password_form")
	public String findPasswordView() {
		return "/findPassword";
	}
	
    // 비밀번호 찾기 실행
	@RequestMapping(value="/find_password", method=RequestMethod.POST)
	public String findPasswordAction(UserDto dto, Model model) {
		UserDto user = uservice.findPassword(dto);
		
		if(user == null) { 
			model.addAttribute("check", 1);
		} else { 
			model.addAttribute("check", 0);
			model.addAttribute("updateid", user.getUserId());
		}
		
		return "/findPassword";
	}
	
    // 비밀번호 바꾸기 실행
	@RequestMapping(value="/update_password", method=RequestMethod.POST)
	public String updatePasswordAction(@RequestParam(value="updateid", defaultValue="", required=false) String userId,
			UserDto UserDto) {
		UserDto.setUserId(userId);
		System.out.println(UserDto);
		uservice.updatePassword(UserDto);
		return "/findPasswordConfirm";
	}
	
    // 비밀번호 바꾸기할 경우 성공 페이지 이동
	@RequestMapping(value="/check_password_view")
	public String checkPasswordForModify(HttpSession session, Model model) {
		UserDto loginUser = (UserDto) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "/login";

		}
		return "/login";
	}
}