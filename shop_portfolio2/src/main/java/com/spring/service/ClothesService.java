package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;
import com.spring.dto.SizeDTO;

public interface ClothesService {
	//전체조회
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception;
	//top조회
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception;
	//pants조회
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception;
	//shoes조회
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception;
	//한건조회
	public Map<String, Object> selectOne(String code,String size,String qty) throws Exception;
	//추가
	public String insert(ClothesDTO cdto, MultipartFile cfile,List<String> list,List<String> qtylist,SizeDTO sdto) throws Exception;
	//수정
	public int update(ClothesDTO cdto,SizeDTO sdto, List<Integer> fnumList,MultipartFile cfile) throws Exception;
	//삭제
	public int delete(String code,String size) throws Exception;

}
