package edu.multi.kdigital.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.multi.kdigital.dto.UserDto;

@Mapper
@Repository("user")
public interface UserMapper {

	// 회원가입
	public int insertmember(UserDto dto);
	
	// 로그인 체크
	public String loginCheck(UserDto dto);
	
	// 회원 정보 조회
	public UserDto memberView(String userId);
	
	// 회원 정보 수정
	public int memberUpdate(UserDto dto);
	
	// 회원정보 삭제
	public int memberDelete(String userId);
	
	// 아이디 중복체크
	public int checkId(UserDto dto);
	
	// 이메일 중복체크
	public int checkEmail(UserDto dto);

	// 패스워드 체크
	public int passChk(UserDto dto);
	
	public UserDto loginUser(UserDto dto);

	public UserDto findId(UserDto dto);

	public UserDto findPassword(UserDto dto);
	
	public void updatePassword(UserDto dto) ;
	
	public UserDto updatefindPassword(UserDto dto);
	
	public UserDto paymentfind(UserDto dto);

	
}