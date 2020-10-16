package com.spring.service;

import java.util.List;

import com.spring.dto.SizeDTO;

public interface SizeService {

	//전체조회
	public List<SizeDTO> selectList(SizeDTO sdto) throws Exception;
	
	//추가
	public SizeDTO selectOne(String code,String size,String qty) throws Exception;
	
	//카운트
	public int selectCnt(String code) throws Exception;
	
	//카운트
	public List<String> selectSize(String code) throws Exception;
	
	//추가
	public int insert(SizeDTO sdto) throws Exception;
	
	//업데이트
	public int update(SizeDTO sdto) throws Exception;
	
	//삭제
	public int delete(String code,String size) throws Exception;
}
