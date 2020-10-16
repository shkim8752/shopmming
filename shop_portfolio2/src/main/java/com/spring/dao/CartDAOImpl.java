package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Resource 
	private SqlSession session;
	
	@Override
	public int insert(CartDTO cartdto) throws Exception {
		return session.insert("cartMapper.insert",cartdto);
	}

	@Override
	public int totPrice_update(CartDTO cartdto) throws Exception {
		return session.update("catMapper.totPrice_update",cartdto);
	}

	@Override
	public List<CartDTO> selectList(String userid) throws Exception {
		return session.selectList("cartMapper.selectList",userid);
	}

	@Override
	public int delete(int cartnum) throws Exception {
		return session.delete("cartMapper.delete",cartnum);
	}

	@Override
	public int totselect(String userid) throws Exception {
		int result = 0;
		CartDTO dto = session.selectOne("cartMapper.totupdate",userid);
		System.out.println("totselect"+dto);
		  if (dto != null) result = dto.getTotprice();
		  
		  System.out.println("dao"+result);
		 
		
		return result;
	}

	@Override
	public int allDelete(String userid) throws Exception {
		 return session.delete("cartMapper.allDelete", userid);
	}
	
	






}
