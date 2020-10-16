package com.spring.dao;

import com.spring.dto.CfileDTO;

public interface CfileDAO {
	//������ȸ
	public CfileDTO selectOne(String code) throws Exception;
	//�߰�
	public int insert(CfileDTO cdto) throws Exception;
	//����
	public int update(CfileDTO cdto) throws Exception;
	//����
	public int delete(String code) throws Exception;
	//������ �Ϻ����� ����
	public int delete_part(String code, String fnums);
}
