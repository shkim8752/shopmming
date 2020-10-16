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
		//������ �޽��� ȭ�鿡 ����
				rattr.addFlashAttribute("msg", resultMap.get("msg"));
				int result = (int)resultMap.get("result");
				//redirect : ȭ���̵� �ּ� �̵�(@RequestMapping�� ���� �̵�������) 
				if (result == 0) { //�α��� ������
					session.setAttribute("mdto", resultMap.get("mdto")); //���ǿ� dto ����
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
	
		
	//ȸ������ db�� ������ login�� �̵�
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(RedirectAttributes rattr,ShopMemberDTO dto,String userid,String passwd, String name, String email, String address ) {
		logger.info(dto.toString());
		Map<String, Object> resultMap = service.insert(dto);
		rattr.addFlashAttribute("msg", resultMap.get("msg"));
		
		if ((int)resultMap.get("result") == 0) { //ȸ������ ����
			return "redirect:/login/";
		}else {  //ȸ������ ����
			return "redirect:/join";
		}
	}
	
	//�α׾ƿ�
	@RequestMapping(value="/logout")
	public String LogOut(HttpSession session, RedirectAttributes rattr) {
		session.invalidate(); //�������� �Ҹ�
		rattr.addFlashAttribute("msg", "�α׾ƿ��Ǿ����ϴ�.");
		return "redirect:/main";
	}
	
	//�Ѱ� ��ȸ 
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
	
	//ȸ�� ���� 
	@RequestMapping(value="/mypage", method = RequestMethod.POST)
	public String modify(ShopMemberDTO dto,Model model) {
		Map<String, Object> resultMap = service.update(dto);
		System.out.println(dto.toString());
		model.addAttribute("msg",resultMap.get("msg"));
		return "shop/main";
	}
	

	

	
	
}
