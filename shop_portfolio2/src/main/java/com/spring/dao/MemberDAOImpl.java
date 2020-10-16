package com.spring.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.ShopMemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Resource
	private SqlSession session;
	
	@Override
	public ShopMemberDTO Login(String userid) {
		return session.selectOne("shopmemberMapper.Login",userid);
	}

	@Override
	public int insert(ShopMemberDTO dto) {
		return session.insert("shopmemberMapper.insert",dto);
	}

	@Override
	public ShopMemberDTO selectOne(String userid) {
		return session.selectOne("shopmemberMapper.selectOne",userid);
	}

	@Override
	public int update(ShopMemberDTO dto) {
		return session.update("shopmemberMapper.update", dto);
	}

	
	
	
	
}
