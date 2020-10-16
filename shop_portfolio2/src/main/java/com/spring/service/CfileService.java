package com.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.CfileDTO;

public interface CfileService {
	//���� �����ϰ� ���ϸ��� ����
	public Map<String,String> fileUpload(MultipartFile files) throws Exception;
	//���ϸ� ����Ʈ�� �Է¹޾� ���ϸ� ����
	public int insert(String code, String filename) throws Exception;
	//���� ����Ʈ
	public CfileDTO selectOne(String code) throws Exception;
	//����
	public int delete(String code) throws Exception;
	//������ �Ϻ� ���� ����
	public int delete_part(String code, List<Integer> fnumList) throws Exception;
	//���� �ٿ�ε�
	public void fileDownload(String filename, HttpServletResponse response) throws Exception;
}
