package ks43team01.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks43team01.dto.User;



@Mapper
public interface UserMapper {
	
	//회원가입//	
	public int addUserInsert(User user);

}
