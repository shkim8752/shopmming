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
	
	//로그인
	@Override
	public Map<String, Object> loginCheck(String userid, String passwd) {
		//result : 0(로그인성공), 1(아이디미존재), 2(패스워드불일치)
		logger.debug(userid);
		String msg = null;
		int result = -1;
		ShopMemberDTO mdto = dao.selectOne(userid);
		
		System.out.println(mdto);
		Map<String, Object> resultMap = new HashMap<>();
		
		if(mdto == null) { //아이디 없음
			msg = "아이디가 없습니다";
			result = 1;
		}else {
			//평문을 암호화시킨 값과 db에 저장된 암호문과 비교
			if(encode.matches(passwd, mdto.getPasswd())) {
				msg = "로그인 성공";
				result = 0;
				resultMap.put("mdto", mdto);
			}
			else {
				msg = "패스워드가 불일치";
				result = 2;
			}
		}
		
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
	}
	
	//회원가입 
	public Map<String, Object> insert(ShopMemberDTO dto){
		String msg = null;
		int result = -1;
		//아이디 중복 체크
		//저장성공하면 result :0, 실패 result :1
		ShopMemberDTO rdto = dao.selectOne(dto.getUserid());
		
		if(rdto == null) {	//기존아이디가 미존재시 
			//암호화 처리  //평문암호를 암호문으로 
			dto.setPasswd(encode.encode(dto.getPasswd()));	
			//db에 저장 
			int cnt = dao.insert(dto);
			logger.info(String.valueOf(cnt));
			msg= "회원가입 완료";
			result =0;
		}else {	//아이디 존내
			msg ="아이디가 존재합니다";
			result = -1;
		}
		Map<String, Object>  resultMap =new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
	}
	
	//한검 검색 
	@Override
	public ShopMemberDTO selectOne(String userid) {
		return dao.selectOne(userid);
	}
	
	//회원 변경  
	@Override
	public Map<String, Object> update(ShopMemberDTO dto) {
		String msg = null;
		int result = -1;
		System.out.println("요기요기"+dto.getPasswd());
		dto.setPasswd(encode.encode(dto.getPasswd())); 
		int cnt = dao.update(dto);
		
		if(cnt>0) {
			result = 0;
			msg = "수정이 완료되었습니다";
		}else {
			result = 1;
			msg = "수정 에러";
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
	}
	
}
