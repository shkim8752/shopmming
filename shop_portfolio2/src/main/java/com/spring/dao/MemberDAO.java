package com.spring.dao;

import com.spring.dto.ShopMemberDTO;

public interface MemberDAO {
	
	//로그인 체크 
	public ShopMemberDTO Login(String userid);	
	//회원가입
	public int insert(ShopMemberDTO dto);
	//한건 조회
	public ShopMemberDTO selectOne(String userid);
	//수정
	public int update(ShopMemberDTO dto);

}
