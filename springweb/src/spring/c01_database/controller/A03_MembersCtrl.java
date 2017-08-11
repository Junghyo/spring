package spring.c01_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import spring.c01_database.service.A03_MembersService;
import spring.dto.Member1;

@Controller
public class A03_MembersCtrl {
	@Autowired(required=false)
	private A03_MembersService service;
	@RequestMapping("/memList_mybatis.do")
	public String empList(Member1 sch, Model m){
		m.addAttribute("memList", service.memList(sch));
		return "c01_database/a03_memList_0609";
	}
	@RequestMapping("/memDetail_mybatis.do")
	public String memInfo(@RequestParam(value="id", defaultValue="") String id, Model m){
		m.addAttribute("mem", service.memInfo(id));
		return "c01_database/a03_memDetail_0612";
	}
	@RequestMapping("/memUpdate_mybatis.do")
	public String memUpdate(Member1 upt){
		service.MemUpdate(upt);
		return "forward:/memDetail_mybatis.do";
	}
}


