package com.spring.service;

import java.util.Map;

import com.spring.dto.ShopMemberDTO;

public interface LoginService {
	
	//�α���
	public Map<String, Object> loginCheck(String userid, String passwd);
	
	//ȸ������ 
	public Map<String, Object> insert(ShopMemberDTO dto);
	
	//ȸ�� �Ѱ� �˻� 
	public ShopMemberDTO selectOne(String userid);
	
	//ȸ�� ����
	public Map<String, Object> update(ShopMemberDTO dto);
}
