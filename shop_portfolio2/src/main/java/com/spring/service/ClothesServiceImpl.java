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
		//------pdto 구하기----------
				//전체게시물수
				int totCnt = cdao.totolCount(pdto);
				//전체페이지수
				int totPage = totCnt / pdto.getPerPage();
				if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
				pdto.setTotPage(totPage);
				
				//현재페이지
				int curPage = pdto.getCurPage();
				//시작번호
				int startNo = (curPage-1) * pdto.getPerPage();
				pdto.setStartNo(startNo);
				//끝번호
				int endNo = startNo + pdto.getPerPage() -1;
				pdto.setEndNo(endNo);
				//시작페이지
				int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
				pdto.setStartPage(startPage);
				//끝페이지
				int endPage = startPage + pdto.getPerBlock()-1;
				if (endPage > totPage) endPage = totPage;
				pdto.setEndPage(endPage);
				
				// 전체조회
				return cdao.selectList(pdto);
	}
	@Override
	public List<ClothesDTO> selectTop(PageDTO pdto) throws Exception {
		//------pdto 구하기----------
		//전체게시물수
		int totCnt = cdao.totolCount(pdto);
		//전체페이지수
		int totPage = totCnt / pdto.getPerPage();
		if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
		pdto.setTotPage(totPage);
		
		//현재페이지
		int curPage = pdto.getCurPage();
		//시작번호
		int startNo = (curPage-1) * pdto.getPerPage();
		pdto.setStartNo(startNo);
		//끝번호
		int endNo = startNo + pdto.getPerPage() -1;
		pdto.setEndNo(endNo);
		//시작페이지
		int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
		pdto.setStartPage(startPage);
		//끝페이지
		int endPage = startPage + pdto.getPerBlock()-1;
		if (endPage > totPage) endPage = totPage;
		pdto.setEndPage(endPage);
		
		// 전체조회
		return cdao.selectTop(pdto);
	}
	@Override
	public List<ClothesDTO> selectPants(PageDTO pdto) throws Exception {
		//------pdto 구하기----------
		//전체게시물수
		int totCnt = cdao.totolCount(pdto);
		//전체페이지수
		int totPage = totCnt / pdto.getPerPage();
		if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
		pdto.setTotPage(totPage);
		
		//현재페이지
		int curPage = pdto.getCurPage();
		//시작번호
		int startNo = (curPage-1) * pdto.getPerPage();
		pdto.setStartNo(startNo);
		//끝번호
		int endNo = startNo + pdto.getPerPage() -1;
		pdto.setEndNo(endNo);
		//시작페이지
		int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
		pdto.setStartPage(startPage);
		//끝페이지
		int endPage = startPage + pdto.getPerBlock()-1;
		if (endPage > totPage) endPage = totPage;
		pdto.setEndPage(endPage);
		
		// 전체조회
		return cdao.selectPants(pdto);
	}
	@Override
	public List<ClothesDTO> selectShoes(PageDTO pdto) throws Exception {
		//------pdto 구하기----------
		//전체게시물수
		int totCnt = cdao.totolCount(pdto);
		//전체페이지수
		int totPage = totCnt / pdto.getPerPage();
		if ((totCnt % pdto.getPerPage()) != 0 ) totPage = totPage + 1;
		pdto.setTotPage(totPage);
		
		//현재페이지
		int curPage = pdto.getCurPage();
		//시작번호
		int startNo = (curPage-1) * pdto.getPerPage();
		pdto.setStartNo(startNo);
		//끝번호
		int endNo = startNo + pdto.getPerPage() -1;
		pdto.setEndNo(endNo);
		//시작페이지
		int startPage = curPage - ((curPage-1) % pdto.getPerBlock());
		pdto.setStartPage(startPage);
		//끝페이지
		int endPage = startPage + pdto.getPerBlock()-1;
		if (endPage > totPage) endPage = totPage;
		pdto.setEndPage(endPage);
		
		// 전체조회
		return cdao.selectShoes(pdto);
	}

	@Override
	public Map<String, Object> selectOne(String code,String size,String qty) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		
		// 상품 한건조회
		map.put("clothes", cdao.selectOne(code));
		//파일 리스트 조회
		map.put("fdetail",cfservice.selectOne(code));
		//수정폼용
		map.put("size", sizeservice.selectOne(code,size,qty));
		return map;
	}

	@Override
	public String insert(ClothesDTO cdto, MultipartFile cfile,List<String> list,
			List<String> qtylist,SizeDTO sdto) throws Exception {
				
				//파일 저장
				Map<String, String> filename = cfservice.fileUpload(cfile);
				
				//System.out.println(filename.get("filename"));
				// 상품 추가
				cdto.setFilename(filename.get("filename"));	
				cdao.insert(cdto);			//dto에는 값이 없음 
				String code = cdto.getCode();
				//파일 추가
				cfservice.insert(code, filename.get("filename"));
				//size추가
				for(int i=0;i<list.size();i++) {		//리스트는 null
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
				// 상품 수정
				cdao.update(cdto);
				sdao.update(sdto);
				String code = cdto.getCode();
				//파일 삭제
				cfservice.delete_part(code,fnumList);
				
				
				//파일 저장
				Map<String, String> filename = cfservice.fileUpload(cfile);
				
				//파일 추가
				cfservice.insert(code, filename.get("filename"));
				return 0;
	}

	@Transactional
	@Override
	public int delete(String code,String size) throws Exception {
		//주의 : 자식테이블 삭제후 부모테이블 삭제(foreign key관계)
				sizeservice.delete(code, size);
				int cnt = sizeservice.selectCnt(code);
				if(cnt==0) {
					//파일 삭제
					cfservice.delete(code);
					
					cdao.delete(code);
				}
	
				return 0;
	}

}
