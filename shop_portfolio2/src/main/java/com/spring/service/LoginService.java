package com.spring.service;

import java.util.Map;

import com.spring.dto.ShopMemberDTO;

public interface LoginService {
	
	//로그인
	public Map<String, Object> loginCheck(String userid, String passwd);
	
	//회원가입 
	public Map<String, Object> insert(ShopMemberDTO dto);
	
	//회원 한건 검색 
	public ShopMemberDTO selectOne(String userid);
	
	//회원 변경
	public Map<String, Object> update(ShopMemberDTO dto);
}
