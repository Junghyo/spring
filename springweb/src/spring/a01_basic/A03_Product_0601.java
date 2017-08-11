package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dto.Products;

@Controller
public class A03_Product_0601 {
	@RequestMapping("/save.do")
	public String save(){
		String page="a01_basic/a07_prodSave_0601";
		return page;
	}
	
	@RequestMapping("/prodCheck.do")
	public String prodCheck(Products p, Model m){
		String page = "a01_basic/a08_prodCheck_0601";
		m.addAttribute("msg", "총 구매금액은 "+(p.getCnt01()*2000+p.getCnt02()*3000)+"원 입니다.");
		return page;
	}
}
