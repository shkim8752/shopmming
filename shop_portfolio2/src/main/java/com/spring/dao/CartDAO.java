package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.dto.CartDTO;

public interface CartDAO {
	
	public int insert(CartDTO cartdto) throws Exception;
	
	public int totPrice_update(CartDTO cartdto) throws Exception;
	
	public List<CartDTO> selectList(String userid) throws Exception;
	
	public int delete(int cartnum) throws Exception;
	
	public int totselect(String userid) throws Exception;
	
	public int allDelete(String userid) throws Exception; 
}
