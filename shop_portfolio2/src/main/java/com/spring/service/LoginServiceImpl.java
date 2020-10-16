package com.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.ShopMemberDTO;

@Service
public class LoginServiceImpl implements LoginService  {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Resource
	private MemberDAO dao;
	
	@Resource
	private BCryptPasswordEncoder encode;
	
	//�α���
	@Override
	public Map<String, Object> loginCheck(String userid, String passwd) {
		//result : 0(�α��μ���), 1(���̵������), 2(�н��������ġ)
		logger.debug(userid);
		String msg = null;
		int result = -1;
		ShopMemberDTO mdto = dao.selectOne(userid);
		
		System.out.println(mdto);
		Map<String, Object> resultMap = new HashMap<>();
		
		if(mdto == null) { //���̵� ����
			msg = "���̵� �����ϴ�";
			result = 1;
		}else {
			//���� ��ȣȭ��Ų ���� db�� ����� ��ȣ���� ��
			if(encode.matches(passwd, mdto.getPasswd())) {
				msg = "�α��� ����";
				result = 0;
				resultMap.put("mdto", mdto);
			}
			else {
				msg = "�н����尡 ����ġ";
				result = 2;
			}
		}
		
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
	}
	
	//ȸ������ 
	public Map<String, Object> insert(ShopMemberDTO dto){
		String msg = null;
		int result = -1;
		//���̵� �ߺ� üũ
		//���强���ϸ� result :0, ���� result :1
		ShopMemberDTO rdto = dao.selectOne(dto.getUserid());
		
		if(rdto == null) {	//�������̵� ������� 
			//��ȣȭ ó��  //�򹮾�ȣ�� ��ȣ������ 
			dto.setPasswd(encode.encode(dto.getPasswd()));	
			//db�� ���� 
			int cnt = dao.insert(dto);
			logger.info(String.valueOf(cnt));
			msg= "ȸ������ �Ϸ�";
			result =0;
		}else {	//���̵� ����
			msg ="���̵� �����մϴ�";
			result = -1;
		}
		Map<String, Object>  resultMap =new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
	}
	
	//�Ѱ� �˻� 
	@Override
	public ShopMemberDTO selectOne(String userid) {
		return dao.selectOne(userid);
	}
	
	//ȸ�� ����  
	@Override
	public Map<String, Object> update(ShopMemberDTO dto) {
		String msg = null;
		int result = -1;
		System.out.println("�����"+dto.getPasswd());
		dto.setPasswd(encode.encode(dto.getPasswd())); 
		int cnt = dao.update(dto);
		
		if(cnt>0) {
			result = 0;
			msg = "������ �Ϸ�Ǿ����ϴ�";
		}else {
			result = 1;
			msg = "���� ����";
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
	}
	
}
