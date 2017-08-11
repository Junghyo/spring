package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/callMethod.do")
public class A07_ComCtrl_0602 {
	@RequestMapping(method=RequestMethod.GET)
	public String useGet(){
		return "/a01_basic/a13_getForm_0602";	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String usePost(){
		return "/a01_basic/a14_postForm_0602";
	}
}

