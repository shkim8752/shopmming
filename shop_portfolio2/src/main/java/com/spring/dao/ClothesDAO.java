package com.spring.dao;

import java.util.List;

import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;


public interface ClothesDAO{
	//��ü �Ǽ�
	public int totolCount(PageDTO pdto) throws Exception;
	//��ü��ȸ
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception;
	//top��ȸ
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception;
	//pants��ȸ
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception;
	//shoes��ȸ
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception;
	//�Ѱ���ȸ
	public ClothesDTO selectOne(String code) throws Exception;
	//�߰�
	public int insert(ClothesDTO cdto) throws Exception;
	//����
	public int update(ClothesDTO cdto) throws Exception;
	//����
	public int delete(String code) throws Exception;
}
