package spring.h01_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.c01_database.service.A01_EmpService;
import spring.dto.Emp;

@Controller
@RequestMapping("/ajax.do")
public class A01_AjaxCtrl {
	@Autowired(required=false)
	A01_EmpService service;
	@RequestMapping(params="method=ajaxForm")
	public String form(){
		return "h01_ajax/a01_form";
	}
	@RequestMapping(params="method=jsonList")
	public ModelAndView jsonList(Emp sch, ModelAndView mav){
//		dispatcher-servlet.xml에서 선언한 json viewer		
		mav.setViewName("pageJsonReport");
		mav.addObject("emplist",service.empList(sch) );
		return mav;
	}
}
