package com.spring.service;

import java.util.HashMap;
import java.util.List;

import com.spring.dto.CartDTO;

public interface CartService {
	
	public int insert(CartDTO cartdto) throws Exception;
	
	public List<CartDTO> selectlist(String userid) throws Exception;
	
	public int delete(int cartnum) throws Exception;
	
	public int totselect(String userid) throws Exception;
	
	public int allDelete(String userid) throws Exception;
}
