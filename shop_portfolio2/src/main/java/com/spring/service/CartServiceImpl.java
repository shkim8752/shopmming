package com.spring.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.dao.CartDAO;
import com.spring.dao.SizeDAO;
import com.spring.dto.CartDTO;
import com.spring.dto.SizeDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Resource
	private CartDAO cartdao;
	   
	@Resource
	private SizeDAO sdao;
	
	@Override
	public int insert(CartDTO cartdto) throws Exception {
		SizeDTO sdto = new SizeDTO();
	      
	      //cart insert
	      int cnt = cartdao.insert(cartdto);
	      
	      //sizeÅ×ÀÌºí qty -1
	      sdto.setCode(cartdto.getCode());
	      sdto.setSize(cartdto.getSize());
	      sdto.setQty(cartdto.getQty());
	      sdao.qtyDown_update(sdto);
	     
	      return cnt;
	}

	@Override
	public List<CartDTO> selectlist(String userid) throws Exception {
		return  cartdao.selectList(userid);
	}

	@Override
	public int delete(int cartnum) throws Exception {
		return cartdao.delete(cartnum);
	}

	@Override
	public int totselect(String userid) throws Exception {
		return cartdao.totselect(userid);
	}

	@Override
	public int allDelete(String userid) throws Exception {
		return cartdao.allDelete(userid);
	}







}
