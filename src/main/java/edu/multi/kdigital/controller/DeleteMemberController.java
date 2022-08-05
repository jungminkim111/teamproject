package edu.multi.kdigital.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.service.UserService;




@Controller
public class DeleteMemberController {
	
	@Inject
	UserService uservice;
	

	// 회원 탈퇴 get
	@RequestMapping(value="/deletemember", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception{
		return "/deletemember";
	}
	
	@RequestMapping("/delete")
	public String deleteresult(String userId, RedirectAttributes rttr, HttpSession session) {
		int result = uservice.memberDelete(userId);
		if(result == 1) {
			session.invalidate();
			rttr.addFlashAttribute("msg", "정상적으로 회원탈퇴가 완료되었습니다.");
			return "/main";
		}
		return "/main";
	}
	
	// 패스워드 체크
	@ResponseBody
	@RequestMapping(value="/passChk", method = RequestMethod.POST)
	public int passChk(UserDto dto) throws Exception {
		int result = uservice.passChk(dto);
		return result;
	}
}