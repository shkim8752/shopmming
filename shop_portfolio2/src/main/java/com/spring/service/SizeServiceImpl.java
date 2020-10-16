package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.dao.SizeDAO;
import com.spring.dto.SizeDTO;


@Service
public class SizeServiceImpl implements SizeService{

	@Resource
	private SizeDAO sdao;
	
	@Override
	public List<SizeDTO> selectList(SizeDTO sdto) throws Exception {
		// TODO Auto-generated method stub
		return sdao.selectList(sdto);
	}

	@Override
	public int insert(SizeDTO sdto) throws Exception {
		
		return sdao.insert(sdto);
	}

	@Override
	public int delete(String code,String size) throws Exception {
		SizeDTO sdto = new SizeDTO();
		sdto.setCode(code);
		sdto.setSize(size);
		return sdao.delete(sdto);
	}

	@Override
	public SizeDTO selectOne(String code, String size,String qty) throws Exception {
		SizeDTO sdto = new SizeDTO();
		sdto.setCode(code);
		sdto.setSize(size);
		sdto.setQty(qty);
		return sdao.selectOne(sdto);
	}

	@Override
	public int update(SizeDTO sdto) throws Exception {
		
		return sdao.update(sdto);
	}

	@Override
	public int selectCnt(String code) throws Exception {
		// TODO Auto-generated method stub
		return sdao.selectCnt(code);
	}

	@Override
	public List<String> selectSize(String code) throws Exception {
		// TODO Auto-generated method stub
		return sdao.selectSize(code);
	}


}
