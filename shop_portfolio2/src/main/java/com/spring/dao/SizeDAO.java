package com.spring.dao;

import java.util.List;

import com.spring.dto.SizeDTO;

public interface SizeDAO {

	//��ü��ȸ
	public List<SizeDTO> selectList(SizeDTO sdto) throws Exception;
	
	//�߰�
	public SizeDTO selectOne(SizeDTO sdto) throws Exception;
	
	//�߰�
	public int selectCnt(String code) throws Exception;
	
	//�߰�
	public List<String> selectSize(String code) throws Exception;
	
	//�߰�
	public int insert(SizeDTO sdto) throws Exception;
	
	//�߰�
	public int update(SizeDTO sdto) throws Exception;
	
	//����
	public int delete(SizeDTO sdto) throws Exception;
	
	public int qtyDown_update(SizeDTO dto)  throws Exception;	
}
