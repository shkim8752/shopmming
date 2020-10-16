package com.spring.dao;

import com.spring.dto.CfileDTO;

public interface CfileDAO {
	//파일조회
	public CfileDTO selectOne(String code) throws Exception;
	//추가
	public int insert(CfileDTO cdto) throws Exception;
	//수정
	public int update(CfileDTO cdto) throws Exception;
	//삭제
	public int delete(String code) throws Exception;
	//수정시 일부파일 삭제
	public int delete_part(String code, String fnums);
}
