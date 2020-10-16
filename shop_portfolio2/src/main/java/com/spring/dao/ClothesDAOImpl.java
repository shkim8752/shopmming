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
		//��ü�Ǽ�
		return session.selectOne("clothesMapper.totCount", pdto);
	}

	@Override
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception {
		// ��ü��ȸ
		return session.selectList("clothesMapper.selectList", pdto);
	}
	
	@Override
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception {
		// ��ü��ȸ
		return session.selectList("clothesMapper.selectTop", pdto);
	}
	@Override
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception {
		// ��ü��ȸ
		return session.selectList("clothesMapper.selectPants", pdto);
	}
	@Override
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception {
		// ��ü��ȸ
		return session.selectList("clothesMapper.selectShoes", pdto);
	}

	@Override
	public ClothesDTO selectOne(String code) throws Exception {
		// �Ѱ���ȸ
		return session.selectOne("clothesMapper.selectOne", code);
	}

	@Override
	public int insert(ClothesDTO cdto) throws Exception {
		// �߰�
		return session.insert("clothesMapper.insert",cdto );
	}

	@Override
	public int update(ClothesDTO cdto) throws Exception {
		// ����
		return session.update("clothesMapper.update",cdto);
	}

	@Override
	public int delete(String code) throws Exception {
		// ����
		return session.delete("clothesMapper.delete",code);
	}

}
