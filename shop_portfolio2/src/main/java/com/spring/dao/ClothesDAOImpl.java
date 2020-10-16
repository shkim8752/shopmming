package com.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;

@Repository
public class ClothesDAOImpl implements ClothesDAO{

	@Resource
	private SqlSession session;
	
	@Override
	public int totolCount(PageDTO pdto) throws Exception {
		//전체건수
		return session.selectOne("clothesMapper.totCount", pdto);
	}

	@Override
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception {
		// 전체조회
		return session.selectList("clothesMapper.selectList", pdto);
	}
	
	@Override
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception {
		// 전체조회
		return session.selectList("clothesMapper.selectTop", pdto);
	}
	@Override
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception {
		// 전체조회
		return session.selectList("clothesMapper.selectPants", pdto);
	}
	@Override
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception {
		// 전체조회
		return session.selectList("clothesMapper.selectShoes", pdto);
	}

	@Override
	public ClothesDTO selectOne(String code) throws Exception {
		// 한건조회
		return session.selectOne("clothesMapper.selectOne", code);
	}

	@Override
	public int insert(ClothesDTO cdto) throws Exception {
		// 추가
		return session.insert("clothesMapper.insert",cdto );
	}

	@Override
	public int update(ClothesDTO cdto) throws Exception {
		// 수정
		return session.update("clothesMapper.update",cdto);
	}

	@Override
	public int delete(String code) throws Exception {
		// 삭제
		return session.delete("clothesMapper.delete",code);
	}

}
