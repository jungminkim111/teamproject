package edu.multi.kdigital.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.multi.kdigital.dto.UserDto;
import edu.multi.kdigital.repository.MemberRepository;

@Component
public class MemberValidator implements Validator{
	
	MemberRepository memberRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserDto dto = (UserDto) target;
		
		//이미 존재하는 아이디라면 벨리데이터를 통과하지 못함
		if(memberRepository.selectuserByUserId(dto.getUserId()) != null) {
			errors.rejectValue("userId", null, "이미 존재하는 아이디 입니다.");
		}
		
		//비밀번호가 8자리 미만이면 통과 x
		if(dto.getUserPw().length() < 8) {
			errors.rejectValue("password", null, "비밀번호가 8자리 미만");
		}

		
	}
}
