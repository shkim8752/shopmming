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

	//servlet-context.xml�� ���� ���� ���丮 ��
	@Resource(name="saveDir")
	String saveDir; 
	
	@Resource
	private CfileDAO cdao;
	
	
	// ���� ���ε��ϰ� �����̸� ����Ʈ ��ȯ
	@Override
	public Map<String,String> fileUpload(MultipartFile file) throws Exception {
		
			Map<String,String> map = new HashMap<>();
			//�����̸� ����
			System.out.println(file.getOriginalFilename());
			if (file.getOriginalFilename() != "") { //���ϸ��� �����Ҷ��� �ݺ�
				String filename = System.currentTimeMillis()+file.getOriginalFilename();
				//������ ���ϰ�ο� �̸� ����
				File f = new File(saveDir, filename);
				try {
					file.transferTo(f);
					map.put("filename",filename); //�����̸� �߰�
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		return map;
	}

	
	//���ϸ� ����
	@Override
	public int insert(String code, String filename) throws Exception {
			CfileDTO cdto = new CfileDTO();
			cdto.setCode(code);
			cdto.setFilename(filename);
			
			cdao.insert(cdto);
			return 0;
		}
	
	//���� ����Ʈ
	@Override
	public CfileDTO selectOne(String code) throws Exception {
		return cdao.selectOne(code);
	}

	//������ �Ϻ� ���� ����
	@Override
	public int delete(String code) throws Exception {
		return cdao.delete(code);
	}

	//���� �ٿ�ε�
	@Override
	public int delete_part(String code, List<Integer> fnumList) throws Exception {
		String fnums = "";
		//nulló��
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
			//���� �б� ��Ʈ�� ����
			FileInputStream fis = new FileInputStream(fileUrl);
			
			//�ѱ������̸� ���ڵ�
			filename = URLEncoder.encode(filename, "utf-8");
			//filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
			
			//���䰴ü�� ������� ����
			//÷������ ���·� ����
			//�����̸� ����
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			
			
			//���� �������� ��Ʈ��  ����
			OutputStream out = response.getOutputStream();
			//inputstream���� ����Ÿ�� �о outputstream���� ������
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
