package com.spring.dao;

import com.spring.dto.ShopMemberDTO;

public interface MemberDAO {
	
	//�α��� üũ 
	public ShopMemberDTO Login(String userid);	
	//ȸ������
	public int insert(ShopMemberDTO dto);
	//�Ѱ� ��ȸ
	public ShopMemberDTO selectOne(String userid);
	//����
	public int update(ShopMemberDTO dto);

}
