package com.spring.dao;

import java.util.List;

import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;


public interface ClothesDAO{
	//전체 건수
	public int totolCount(PageDTO pdto) throws Exception;
	//전체조회
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception;
	//top조회
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception;
	//pants조회
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception;
	//shoes조회
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception;
	//한건조회
	public ClothesDTO selectOne(String code) throws Exception;
	//추가
	public int insert(ClothesDTO cdto) throws Exception;
	//수정
	public int update(ClothesDTO cdto) throws Exception;
	//삭제
	public int delete(String code) throws Exception;
}
