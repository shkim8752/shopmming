package com.spring.service;

import java.util.List;

import com.spring.dto.SizeDTO;

public interface SizeService {

	//��ü��ȸ
	public List<SizeDTO> selectList(SizeDTO sdto) throws Exception;
	
	//�߰�
	public SizeDTO selectOne(String code,String size,String qty) throws Exception;
	
	//ī��Ʈ
	public int selectCnt(String code) throws Exception;
	
	//ī��Ʈ
	public List<String> selectSize(String code) throws Exception;
	
	//�߰�
	public int insert(SizeDTO sdto) throws Exception;
	
	//������Ʈ
	public int update(SizeDTO sdto) throws Exception;
	
	//����
	public int delete(String code,String size) throws Exception;
}
