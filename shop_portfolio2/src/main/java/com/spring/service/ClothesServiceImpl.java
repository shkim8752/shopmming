package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dao.ClothesDAO;
import com.spring.dao.SizeDAO;
import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;
import com.spring.dto.SizeDTO;



@Service
public class ClothesServiceImpl implements ClothesService{

	
	@Resource
	private ClothesDAO cdao;
	
	@Resource
	private SizeDAO sdao;
	
	@Resource
	private SizeService sizeservice;
	
	
	@Resource
	private CfileService cfservice;
	
	
	@Override
	public List<ClothesDTO> selectList(PageDTO pdto) throws Exception {
		//------pdto ���ϱ�----------
				//��ü�Խù���
				int totCnt = cdao.totolCount(pdto);
				//��ü��������
				int totPage = totCnt / pdto.getPerPage();
				if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
				pdto.setTotPage(totPage);
				
				//����������
				int curPage = pdto.getCurPage();
				//���۹�ȣ
				int startNo = (curPage-1) * pdto.getPerPage();
				pdto.setStartNo(startNo);
				//����ȣ
				int endNo = startNo + pdto.getPerPage() -1;
				pdto.setEndNo(endNo);
				//����������
				int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
				pdto.setStartPage(startPage);
				//��������
				int endPage = startPage + pdto.getPerBlock()-1;
				if (endPage > totPage) endPage = totPage;
				pdto.setEndPage(endPage);
				
				// ��ü��ȸ
				return cdao.selectList(pdto);
	}
	@Override
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception {
		//------pdto ���ϱ�----------
		//��ü�Խù���
		int totCnt = cdao.totolCount(pdto);
		//��ü��������
		int totPage = totCnt / pdto.getPerPage();
		if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
		pdto.setTotPage(totPage);
		
		//����������
		int curPage = pdto.getCurPage();
		//���۹�ȣ
		int startNo = (curPage-1) * pdto.getPerPage();
		pdto.setStartNo(startNo);
		//����ȣ
		int endNo = startNo + pdto.getPerPage() -1;
		pdto.setEndNo(endNo);
		//����������
		int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
		pdto.setStartPage(startPage);
		//��������
		int endPage = startPage + pdto.getPerBlock()-1;
		if (endPage > totPage) endPage = totPage;
		pdto.setEndPage(endPage);
		
		// ��ü��ȸ
		return cdao.selectTop(pdto);
	}
	@Override
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception {
		//------pdto ���ϱ�----------
		//��ü�Խù���
		int totCnt = cdao.totolCount(pdto);
		//��ü��������
		int totPage = totCnt / pdto.getPerPage();
		if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
		pdto.setTotPage(totPage);
		
		//����������
		int curPage = pdto.getCurPage();
		//���۹�ȣ
		int startNo = (curPage-1) * pdto.getPerPage();
		pdto.setStartNo(startNo);
		//����ȣ
		int endNo = startNo + pdto.getPerPage() -1;
		pdto.setEndNo(endNo);
		//����������
		int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
		pdto.setStartPage(startPage);
		//��������
		int endPage = startPage + pdto.getPerBlock()-1;
		if (endPage > totPage) endPage = totPage;
		pdto.setEndPage(endPage);
		
		// ��ü��ȸ
		return cdao.selectPants(pdto);
	}
	@Override
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception {
		//------pdto ���ϱ�----------
		//��ü�Խù���
		int totCnt = cdao.totolCount(pdto);
		//��ü��������
		int totPage = totCnt / pdto.getPerPage();
		if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
		pdto.setTotPage(totPage);
		
		//����������
		int curPage = pdto.getCurPage();
		//���۹�ȣ
		int startNo = (curPage-1) * pdto.getPerPage();
		pdto.setStartNo(startNo);
		//����ȣ
		int endNo = startNo + pdto.getPerPage() -1;
		pdto.setEndNo(endNo);
		//����������
		int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
		pdto.setStartPage(startPage);
		//��������
		int endPage = startPage + pdto.getPerBlock()-1;
		if (endPage > totPage) endPage = totPage;
		pdto.setEndPage(endPage);
		
		// ��ü��ȸ
		return cdao.selectShoes(pdto);
	}

	@Override
	public Map<String, Object> selectOne(String code,String size,String qty) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		
		// ��ǰ �Ѱ���ȸ
		map.put("clothes", cdao.selectOne(code));
		//���� ����Ʈ ��ȸ
		map.put("fdetail",cfservice.selectOne(code));
		//��������
		map.put("size", sizeservice.selectOne(code,size,qty));
		return map;
	}

	@Override
	public String insert(ClothesDTO cdto, MultipartFile cfile,List<String> list,
			List<String> qtylist,SizeDTO sdto) throws Exception {
				
				//���� ����
				Map<String, String> filename = cfservice.fileUpload(cfile);
				
				//System.out.println(filename.get("filename"));
				// ��ǰ �߰�
				cdto.setFilename(filename.get("filename"));	
				cdao.insert(cdto);			//dto���� ���� ���� 
				String code = cdto.getCode();
				//���� �߰�
				cfservice.insert(code, filename.get("filename"));
				//size�߰�
				for(int i=0;i<list.size();i++) {		//����Ʈ�� null
					if(!list.get(i).equals("")) {
						sdto.setSize(list.get(i));
						sdto.setQty(qtylist.get(i));
						sdao.insert(sdto);
					}					
					
				}		
				return code;				
	}

	@Override
	public int update(ClothesDTO cdto,SizeDTO sdto, List<Integer> fnumList, MultipartFile cfile) throws Exception {
				// ��ǰ ����
				cdao.update(cdto);
				sdao.update(sdto);
				String code = cdto.getCode();
				//���� ����
				cfservice.delete_part(code,fnumList);
				
				
				//���� ����
				Map<String, String> filename = cfservice.fileUpload(cfile);
				
				//���� �߰�
				cfservice.insert(code, filename.get("filename"));
				return 0;
	}

	@Transactional
	@Override
	public int delete(String code,String size) throws Exception {
		//���� : �ڽ����̺� ������ �θ����̺� ����(foreign key����)
				sizeservice.delete(code, size);
				int cnt = sizeservice.selectCnt(code);
				if(cnt==0) {
					//���� ����
					cfservice.delete(code);
					
					cdao.delete(code);
				}
	
				return 0;
	}

}
