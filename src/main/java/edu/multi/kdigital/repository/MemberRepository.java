package edu.multi.kdigital.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.multi.kdigital.dto.UserDto;

public interface MemberRepository {

	@Insert("insert into user(userId, userPw, userName, userEmail)"
			+ " values(#{userId},#{userPw},#{userName},#{userEmail})")
	void insertmember(UserDto dto);
	
	UserDto selectuserByUserId(@Param("userId")String userId);
	
	@Select("select * from member where userId = #{userId} and userPw = #{userPw}")
	UserDto authenticateUser(@Param("userId")String userId, @Param("userPw")String userPw);
}
