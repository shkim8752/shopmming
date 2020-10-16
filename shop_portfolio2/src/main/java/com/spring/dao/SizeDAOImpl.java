package com.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.SizeDTO;


@Repository
public class SizeDAOImpl implements SizeDAO{

	@Resource
	private SqlSession session;
	
	@Override
	public List<SizeDTO> selectList(SizeDTO sdto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("sizeMapper.selectList", sdto);
	}

	@Override
	public int insert(SizeDTO sdto) throws Exception {
		
		return session.insert("sizeMapper.insert",sdto );
	}

	@Override
	public int delete(SizeDTO sdto) throws Exception {
		// TODO Auto-generated method stub
		return session.delete("sizeMapper.delete",sdto);
	}

	@Override
	public SizeDTO selectOne(SizeDTO sdto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("sizeMapper.selectOne",sdto);
	}

	@Override
	public int update(SizeDTO sdto) throws Exception {
		// TODO Auto-generated method stub
		return session.update("sizeMapper.update",sdto);
	}

	@Override
	public int selectCnt(String code) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("sizeMapper.selectCnt",code);
	}

	@Override
	public List<String> selectSize(String code) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("sizeMapper.selectSize",code);
	}

	@Override
	public int qtyDown_update(SizeDTO dto) throws Exception {
		return session.update("sizeMapper.sizeupdate",dto);
	}




}
