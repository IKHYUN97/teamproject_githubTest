package ks43team01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks43team01.dto.User;
import ks43team01.dto.goodsTopCategory;



@Mapper
public interface UserMapper {
	
	//회원가입//	
	public int addUserInsert(User user);

	//판매자 비지니스 탑카테고리//
	public List<goodsTopCategory> getTopCategory();
		
}
