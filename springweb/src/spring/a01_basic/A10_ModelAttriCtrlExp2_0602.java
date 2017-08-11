package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dto.Person;

@Controller
@RequestMapping("/modelExp2.do")
public class A10_ModelAttriCtrlExp2_0602 {
	@ModelAttribute("person")
	public Person getPerson(){
		return new Person("4��Ÿ��", 25);
	}
	@RequestMapping(method=RequestMethod.GET)
	public String goPage(){
		return "a01_basic/a23_modelAtriPerson_0602";
	}
}

/*
 # ���� ModelAttribute ����
 ����
 [	]select[��Ģ����] [	 ] = [		]
 		[�����]
*/