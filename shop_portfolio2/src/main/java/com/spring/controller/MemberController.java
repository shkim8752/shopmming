package com.spring.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.ShopMemberDTO;
import com.spring.service.LoginService;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource
	private LoginService service;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String clothing() {		
		return "shop/main";
	}
	
	@RequestMapping(value= "login", method= RequestMethod.GET)
	public String login() {
		return "shop/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(String userid,String passwd,HttpSession session,RedirectAttributes rattr) {
		logger.info(userid+""+passwd);		
		Map<String, Object> resultMap = service.loginCheck(userid, passwd);
		logger.debug(resultMap.toString());
		//서비스의 메시지 화면에 전달
				rattr.addFlashAttribute("msg", resultMap.get("msg"));
				int result = (int)resultMap.get("result");
				//redirect : 화면이동 주소 이동(@RequestMapping에 의한 이동만가능) 
				if (result == 0) { //로그인 성공시
					session.setAttribute("mdto", resultMap.get("mdto")); //세션에 dto 저장
					session.setMaxInactiveInterval(60*60*2);					
					return "redirect:/main";
				}else {
					return "redirect:/login/";
				}
	}
	
	@RequestMapping(value= "/join", method= RequestMethod.GET)
	public String join() {
		return "shop/join";
	}
	
		
	//회원가입 db에 저장훈 login로 이동
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(RedirectAttributes rattr,ShopMemberDTO dto,String userid,String passwd, String name, String email, String address ) {
		logger.info(dto.toString());
		Map<String, Object> resultMap = service.insert(dto);
		rattr.addFlashAttribute("msg", resultMap.get("msg"));
		
		if ((int)resultMap.get("result") == 0) { //회원가입 성공
			return "redirect:/login/";
		}else {  //회원가입 실패
			return "redirect:/join";
		}
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String LogOut(HttpSession session, RedirectAttributes rattr) {
		session.invalidate(); //세션정보 소멸
		rattr.addFlashAttribute("msg", "로그아웃되었습니다.");
		return "redirect:/main";
	}
	
	//한건 조회 
	@RequestMapping(value= "/mypage", method= RequestMethod.GET)
	public String mypage(HttpSession session, Model model) {
		
		if(((ShopMemberDTO)session.getAttribute("mdto")) == null) {
			return "shop/login";
		}else {
			String userid = ((ShopMemberDTO)session.getAttribute("mdto")).getUserid();
			
			ShopMemberDTO dto = service.selectOne(userid);
			model.addAttribute("dto", dto);
			return "shop/mypage";
		}		
	}
	
	//회원 변경 
	@RequestMapping(value="/mypage", method = RequestMethod.POST)
	public String modify(ShopMemberDTO dto,Model model) {
		Map<String, Object> resultMap = service.update(dto);
		System.out.println(dto.toString());
		model.addAttribute("msg",resultMap.get("msg"));
		return "shop/main";
	}
	

	

	
	
}
