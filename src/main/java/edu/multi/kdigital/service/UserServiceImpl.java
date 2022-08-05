package edu.multi.kdigital.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.dao.UserMapper;
import edu.multi.kdigital.repository.MemberRepository;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Inject
	UserMapper uservice;
	
	public MemberRepository memberRepository;
	
	// 회원가입
	@Override
	public int insertmember(UserDto dto) {
		return uservice.insertmember(dto);
	}
	
	@Override
	public UserDto authenticateUser(String userId, String userPw) {
		return memberRepository.authenticateUser(userId, userPw);
	}
	
	// 로그인 체크
	@Override
	public String loginCheck(UserDto dto, HttpSession session) {
		String userId = uservice.loginCheck(dto);
		if(userId != null) {	// 세션 변수 저장
			session.setAttribute("userId", dto.getUserId());
			session.setAttribute("userPw", dto.getUserPw());
		}
		return userId;
	}
	
	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();// 세션 초기화
	}
	
	// 회원정보
	@Override
	public UserDto memberView(String userId) {
		return uservice.memberView(userId);
	}
	
	// 회원정보 수정
	@Override
	public int memberUpdate(UserDto dto) {
		return uservice.memberUpdate(dto);
	}
	
	// 회원정보 삭제
	@Override
	public int memberDelete(String userId) {
		return uservice.memberDelete(userId);
	}
		
	// 아이디 중복체크
	public int checkId(UserDto dto) {
		int result = uservice.checkId(dto);
		return result;
	}
	
	// 이메일 중복체크
	public int checkEmail(UserDto dto) {
		int result = uservice.checkEmail(dto);
		return result;
	}
	
	// 패스워드 체크
	@Override
	public int passChk(UserDto dto) {
		int result = uservice.passChk(dto);
		return result;
	}
	
	@Override
	public UserDto loginUser(UserDto dto) {
		return uservice.loginUser(dto);
	}

	@Override
	public UserDto findId(UserDto dto) {
		return uservice.findId(dto);
	}

	@Override
	public UserDto findPassword(UserDto dto ) {
		return uservice.findPassword(dto);
	}
	
	@Override
	public UserDto paymentfind(UserDto dto ) {
		return uservice.paymentfind(dto);
	}

	@Override
	public void updatePassword(UserDto dto ) {
		uservice.updatePassword(dto);
	}
	
	@Override
	public UserDto updatefindPassword(UserDto dto) {
		return uservice.updatefindPassword(dto);
	}
}
