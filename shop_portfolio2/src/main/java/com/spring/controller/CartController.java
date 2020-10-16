package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.CartDTO;
import com.spring.dto.ShopMemberDTO;
import com.spring.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
		
	@Resource
	private CartService cartService;
	
	  @RequestMapping(value = "/cart", method = RequestMethod.GET)
	  public String MyCart(HttpSession session,Model model) throws Exception {
		  System.out.println("MyCart Session mdto:" + session.getAttribute("mdto"));
		 String userid = ((ShopMemberDTO)session.getAttribute("mdto")).getUserid();		
		 System.out.println(userid);
		 if(userid.equals("")) {
			 return "shop/login";
		 }else {
			 List<CartDTO> cartlist = cartService.selectlist(userid);
			  model.addAttribute("cartlist", cartlist);
			 return "shop/cart";
		 }
	   
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/addCart",method=RequestMethod.POST, produces = "application/text; charset=utf-8")
	   public String insert(@RequestBody CartDTO cartdto) throws Exception {
		System.out.println(cartdto);
		cartService.insert(cartdto); 		
	      return "장바구니에 추가되었습니다";      
	   }
	  
	  @RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/text; charset=utf-8")
	  public String selectList(String userid,Model model) throws Exception {
		  System.out.println("ordfgdgd"+userid);
		  List<CartDTO> cartlist = cartService.selectlist(userid);		
		  System.out.println(cartlist);
		  model.addAttribute("cartlist", cartlist);
		  return "shop/cart";
	  }
	  
	  @ResponseBody
	  @RequestMapping(value = "/delete",method = RequestMethod.GET)
	  public Map<String,Integer> delete(int cartnum,String userid,String code,String size, String qty) throws Exception {
	      cartService.delete(cartnum);
	      System.out.println("유저아이디"+userid);
	      int totprice = cartService.totselect(userid);
	      Map<String, Integer> map = new HashMap<>();
	      map.put("totprice", totprice);
		  return map;
	  }
	  
	   @RequestMapping(value = "/payment")
	   public String payment(HttpSession session, String userid,int totprice ,Model model) throws Exception {
	    	 List<CartDTO> cartlist = cartService.selectlist(userid);	
	         model.addAttribute("cartlist", cartlist);
	         model.addAttribute("totprice", totprice);
	         return "shop/payment";      
	   }
	   
	  
	   @RequestMapping("/allDelete")
	   public String allDelete(String userid) throws Exception {
		  System.out.println("전체삭제:"+ userid);
	      int cnt = cartService.allDelete(userid);
	      return "shop/main";
	   }
	   
	   
}
