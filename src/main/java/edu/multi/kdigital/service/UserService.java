package edu.multi.kdigital.service;

import javax.servlet.http.HttpSession;

import edu.multi.kdigital.dto.PaymentDto;
import edu.multi.kdigital.dto.UserDto;

public interface UserService {
	// 회원가입
	public int insertmember(UserDto dto);
	
	// 로그인 체크
	public String loginCheck(UserDto dto, HttpSession session);
	
	// 로그아웃
	public void logout(HttpSession session);
	
	// 회원정보 상세조회
	public UserDto memberView(String userId);
	
	// 회원정보 수정
	public int memberUpdate(UserDto dto);
	
	// 회원정보 삭제
	public int memberDelete(String userId);
	
	// 아이디 중복체크
	public int checkId(UserDto dto);
	
	// 이메일 중복체크
	public int checkEmail(UserDto dto);
	
	public int passChk(UserDto dto);
	
	UserDto authenticateUser(String userId, String userPw);

	UserDto loginUser(UserDto dto);
	
	UserDto findId(UserDto dto);
	
	UserDto findPassword(UserDto dto);
	
	UserDto paymentfind(UserDto dto);
	
	UserDto updatefindPassword(UserDto dto);
	
	void updatePassword(UserDto dto);


}
