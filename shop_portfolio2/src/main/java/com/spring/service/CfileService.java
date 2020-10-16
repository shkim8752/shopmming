package com.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.CfileDTO;

public interface CfileService {
	//파일 저장하고 파일명을 리턴
	public Map<String,String> fileUpload(MultipartFile files) throws Exception;
	//파일명 리스트를 입력받아 파일명 저장
	public int insert(String code, String filename) throws Exception;
	//파일 리스트
	public CfileDTO selectOne(String code) throws Exception;
	//삭제
	public int delete(String code) throws Exception;
	//수정시 일부 파일 삭제
	public int delete_part(String code, List<Integer> fnumList) throws Exception;
	//파일 다운로드
	public void fileDownload(String filename, HttpServletResponse response) throws Exception;
}
