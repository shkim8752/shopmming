package com.spring.dao;

import java.util.List;

import com.spring.dto.SizeDTO;

public interface SizeDAO {

	//전체조회
	public List<SizeDTO> selectList(SizeDTO sdto) throws Exception;
	
	//추가
	public SizeDTO selectOne(SizeDTO sdto) throws Exception;
	
	//추가
	public int selectCnt(String code) throws Exception;
	
	//추가
	public List<String> selectSize(String code) throws Exception;
	
	//추가
	public int insert(SizeDTO sdto) throws Exception;
	
	//추가
	public int update(SizeDTO sdto) throws Exception;
	
	//삭제
	public int delete(SizeDTO sdto) throws Exception;
	
	public int qtyDown_update(SizeDTO dto)  throws Exception;	
}
