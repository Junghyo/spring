/*
 # get/post ó��
 1) Controller�� ���� RequestMapping annotation ����, get/post ��� ó��
 
 2) @RequestMapping( value="��û�ּ�", method=RequestMethod.GET)
 		- �ش� ��û �ּҷ� get����� ó������ ��
 	
 3) @RequestMapping( value="��û�ּ�", method=RequestMehod.POST)
  		- �ش� ��û �ּҷ� post����� ó������ ��
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class A06_Get_Post_0602 {
	@RequestMapping(value="/calling.do", method=RequestMethod.GET)
	public String methodGet(){
		return "a01_basic/a13_getForm_0602";
		
	}
	@RequestMapping(value="/calling.do", method=RequestMethod.POST)
	public String methodPost(){
		return "a01_basic/a14_postForm_0602";
	}
}
