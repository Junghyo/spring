package spring.c01_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.c01_database.service.A02_DeptService;
import spring.dto.Dept;

@Controller
public class A02_DeptCtrl {
	@Autowired(required=false)
	private A02_DeptService service;
	@RequestMapping("/deptList_mybatis.do")
	public String deptLsit(Model m){
		m.addAttribute("deptList", service.deptList());
		return "c01_database/a02_deptList_0608";
	}
	@RequestMapping("/deptDetail_mybatis.do")
	public String deptInfo(@RequestParam(value="deptno", defaultValue="0")int deptno, Model m){
		m.addAttribute("dept", service.deptInfo(deptno));
		return "c01_database/a02_deptDetail_0612";
	}
	
	@RequestMapping("/deptUpt_mybatis.do")
	public String deptUpdate(Dept upt){
		service.deptUpdate(upt);
		return "redirect:/deptList_mybatis.do";
	}
}

