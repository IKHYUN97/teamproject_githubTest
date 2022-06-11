package ks43team01.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks43team01.dto.User;
import ks43team01.mapper.UserMapper;

@Service
@Transactional
public class UserService {
	//DI//	
	private final UserMapper userMapper;
	public  UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public int addUserInsert(User user) { //회원가입//
		
		int result = userMapper.addUserInsert(user);
		
		return result;
	}
}	
