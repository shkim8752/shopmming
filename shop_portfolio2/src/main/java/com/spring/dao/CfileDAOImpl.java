package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.CfileDTO;

@Repository
public class CfileDAOImpl implements CfileDAO{
	
	@Resource 
	private SqlSession session;

	@Override
	public CfileDTO selectOne(String code) throws Exception {
		return session.selectOne("cfileMapper.selectOne", code);
	}

	@Override
	public int insert(CfileDTO cdto) throws Exception {
		return session.insert("cfileMapper.insert", cdto);
	}

	@Override
	public int update(CfileDTO cdto) throws Exception {
		return session.update("cfileMapper.update", cdto);
	}

	@Override
	public int delete(String code) throws Exception {
		return session.delete("cfileMapper.delete", code);
	}
	
	//수정시 일부파일 삭제
	@Override
	public int delete_part(String code, String fnums) {
		Map<String, Object> map = new HashMap<>();
		map.put("code",code );
		map.put("fnums",fnums );
		return session.delete("cfileMapper.delete_part", map);
	}
	
}
