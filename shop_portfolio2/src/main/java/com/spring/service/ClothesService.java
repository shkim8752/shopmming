package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;
import com.spring.dto.SizeDTO;

public interface ClothesService {
	//��ü��ȸ
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception;
	//top��ȸ
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception;
	//pants��ȸ
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception;
	//shoes��ȸ
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception;
	//�Ѱ���ȸ
	public Map<String, Object> selectOne(String code,String size,String qty) throws Exception;
	//�߰�
	public String insert(ClothesDTO cdto, MultipartFile cfile,List<String> list,List<String> qtylist,SizeDTO sdto) throws Exception;
	//����
	public int update(ClothesDTO cdto,SizeDTO sdto, List<Integer> fnumList,MultipartFile cfile) throws Exception;
	//����
	public int delete(String code,String size) throws Exception;

}
