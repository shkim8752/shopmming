package com.spring.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dao.CfileDAO;
import com.spring.dto.CfileDTO;

@Service
public class CfileServiceImpl implements CfileService{

	//servlet-context.xml에 파일 저장 디렉토리 빈
	@Resource(name="saveDir")
	String saveDir; 
	
	@Resource
	private CfileDAO cdao;
	
	
	// 파일 업로드하고 파일이름 리스트 반환
	@Override
	public Map<String,String> fileUpload(MultipartFile file) throws Exception {
		
			Map<String,String> map = new HashMap<>();
			//파일이름 생성
			System.out.println(file.getOriginalFilename());
			if (file.getOriginalFilename() != "") { //파일명이 존재할때만 반복
				String filename = System.currentTimeMillis()+file.getOriginalFilename();
				//전송할 파일경로와 이름 생성
				File f = new File(saveDir, filename);
				try {
					file.transferTo(f);
					map.put("filename",filename); //파일이름 추가
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		return map;
	}

	
	//파일명 저장
	@Override
	public int insert(String code, String filename) throws Exception {
			CfileDTO cdto = new CfileDTO();
			cdto.setCode(code);
			cdto.setFilename(filename);
			
			cdao.insert(cdto);
			return 0;
		}
	
	//파일 리스트
	@Override
	public CfileDTO selectOne(String code) throws Exception {
		return cdao.selectOne(code);
	}

	//수정시 일부 파일 삭제
	@Override
	public int delete(String code) throws Exception {
		return cdao.delete(code);
	}

	//파일 다운로드
	@Override
	public int delete_part(String code, List<Integer> fnumList) throws Exception {
		String fnums = "";
		//null처리
		if (fnumList != null) {	//fnumList ?
			fnums = fnumList.toString().replace("[", "").replace("]", "");
		}
		cdao.delete_part(code, fnums);

		return 0;
	}

	@Override
	public void fileDownload(String filename, HttpServletResponse response) throws Exception {
		String fileUrl = saveDir + "/" +filename;

		try {
			//파일 읽기 스트림 생성
			FileInputStream fis = new FileInputStream(fileUrl);
			
			//한글파일이름 인코딩
			filename = URLEncoder.encode(filename, "utf-8");
			//filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
			
			//응답객체의 헤더설정 변경
			//첨부파일 형태로 변경
			//파일이름 지정
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			
			
			//파일 내보내기 스트림  생성
			OutputStream out = response.getOutputStream();
			//inputstream에서 데이타를 읽어서 outputstream으로 내보냄
			FileCopyUtils.copy(fis, out);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
