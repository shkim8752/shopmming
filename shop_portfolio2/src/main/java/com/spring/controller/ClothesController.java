package com.spring.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.ClothesDTO;
import com.spring.dto.PageDTO;
import com.spring.service.CfileService;
import com.spring.service.ClothesService;
import com.spring.dto.SizeDTO;
import com.spring.service.SizeService;


@Controller
@RequestMapping("clothes")
public class ClothesController {
	
	@Resource 
	private ClothesService cservice;

	@Resource 
	private CfileService cfservice;
	
	@Resource
	private SizeService sizeservice;
	
	//���� ������ �̵�
	@RequestMapping("/main")
	public String listMove() throws Exception {
		
		return "shop/main";
	}
	
	//��ȸ
	//@ModelAttribute("pdto") : view���� ���� ����
	//@ModelAttribute �� @SessionAttributes�� �� ����
	@RequestMapping("/list")
	public String clothesList(@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		List<ClothesDTO> clist = cservice.selectList(pdto);
		model.addAttribute("clist", clist);
		return "clothes/clothesList";
	}
	
	//�߰�������
	@RequestMapping(value="/manage", method = RequestMethod.GET)
	public void clothesAdd() throws Exception {}
	
	//�߰�
	@RequestMapping(value="/manage", method = RequestMethod.POST)
	public String clothesAdd(ClothesDTO cdto,@RequestParam("size") List<String> list,
			@RequestParam("qty") List<String> qtylist,
			SizeDTO sdto, MultipartFile cfile, RedirectAttributes rattr) throws Exception {
		cservice.insert(cdto, cfile,list,qtylist,sdto);
		//rattr.addFlashAttribute("msg", "�߰��Ϸ�");
		return "redirect:/clothes/list";		
	}
	
	//�Ѱ���ȸ�� ���������� �̵�
	@RequestMapping("/detail")
	public void clothesDetail(String code,String size,String qty, Model model) throws Exception {
		
		Map<String, Object> resultMap = cservice.selectOne(code,size,qty);
		
		model.addAttribute("sizeList",sizeservice.selectSize(code));	//�̰͵� �ʿ� ����� �մ�
		model.addAttribute("clothes", resultMap.get("clothes"));
		model.addAttribute("fdetail", resultMap.get("fdetail"));
	}
	
	//����
	@RequestMapping("/delete")
	public String clothesDelete(String code,String size, Model model, RedirectAttributes rattr) throws Exception {
		System.out.println(code+size);
		cservice.delete(code,size);
		//rattr.addFlashAttribute("msg", "�����Ϸ�");
		return "redirect:/clothes/list";
	}
	
	//����������
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void clothesModify(String code,String size,String qty, Model model) throws Exception {		
		 Map<String, Object> resultMap = cservice.selectOne(code,size,qty);
		 model.addAttribute("clothes", resultMap.get("clothes"));
		 model.addAttribute("fdetail", resultMap.get("fdetail"));
		 model.addAttribute("size", resultMap.get("size"));

	}
	
	//����
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String clothesModify(ClothesDTO cdto,SizeDTO sdto,
			@RequestParam(value="fnum", required = false) List<Integer> fnumList,
			MultipartFile cfile,
			RedirectAttributes rattr) throws Exception {
		cservice.update(cdto,sdto,fnumList,cfile);
		//rattr.addFlashAttribute("msg", "�����Ϸ�");
		rattr.addAttribute("code", cdto.getCode());
		return "redirect:/clothes/list";
	}
	
	//���� �ٿ�ε�
	@RequestMapping("/filedownload")
	public void fileDownload(String filename, HttpServletResponse response) throws Exception {
		cfservice.fileDownload(filename, response);
	}
	
	//���� ����(@SessionAttributes("pdto"))
	@RequestMapping("/sessionDelete")
	public String sessionDelete(SessionStatus status) {
		//������ �����
		status.setComplete();
		return "redirect:/clothes/list";
	}
	
	@RequestMapping(value="/top", method = RequestMethod.GET)
	public String top(@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		List<ClothesDTO> clist = cservice.selectTop(pdto);
		
		model.addAttribute("clist", clist);
		return"clothes/top";
	}
	
	@RequestMapping(value="/pants", method = RequestMethod.GET)
	public String pants(@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		List<ClothesDTO> clist = cservice.selectPants(pdto);
		System.out.println(clist);
		model.addAttribute("clist", clist);
		return"clothes/pants";
	}
	
	@RequestMapping(value="/shoes", method = RequestMethod.GET)
	public String shoes(@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		List<ClothesDTO> clist = cservice.selectShoes(pdto);
		System.out.println(clist);
		model.addAttribute("clist", clist);
		return"clothes/shoes";
	}
	
	@RequestMapping(value="/cart", method = RequestMethod.GET )
	public String cart(@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		List<ClothesDTO> clist = cservice.selectShoes(pdto);
		System.out.println(clist);
		model.addAttribute("clist", clist);
		return"shop/cart";
	}
	
	
}
