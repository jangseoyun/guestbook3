package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	
	//필드 
	//생성자
	//메소드g,s
	
	//메소드 일반
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("phone/writeForm");
		//포워드할 주소
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping(value="/write", method = {RequestMethod.GET,RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {//저장
		
		System.out.println("phone/write");
		System.out.println(personVo);
		
		//저장
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		//리다이렉트 
		return "redirect:/phone/list";
		
	}
	
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		
		System.out.println("phone/list");
		
		//dao에서 리스트를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		//컨트롤러가 --> DS 데이터를 보낸다 (어트리뷰트에 담기는것)
		model.addAttribute("personList", personList);
		
		//jsp정보를 리턴한다(view)
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("personId") int personId) {
		
		System.out.println("phone/delete");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(personId);
		
		return "redirect:/phone/list";
		
	}
	
	@RequestMapping(value="/updateForm", method = {RequestMethod.GET, RequestMethod.POST} )
	public String updateForm(@RequestParam("personId") int personId, Model model) {
		
		System.out.println("phone/updateForm");
		
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(personId);
		
		model.addAttribute("personVo", personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	@RequestMapping(value="/update", method = {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		
		System.out.println("/phone/update");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		System.out.println("update : " +personVo);
		
		return "redirect:/phone/list";
	}
	
	/*
	@RequestMapping(value="/phone/write", method = {RequestMethod.GET,RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {//파라미터를 따로 독립적으로 받아와야하는 경우 사용 
		
		System.out.println("phone/write");
		System.out.println(name+"/"+hp+"/"+ company);
		
		//저장
		PersonVo personVo = new PersonVo(name,hp,company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "";
		
	}
	*/
	
	
	
	
}
