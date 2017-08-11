/*
 # get/post 처리
 1) Controller에 공통 RequestMapping annotation 설정, get/post 방식 처리
 
 2) @RequestMapping( value="요청주소", method=RequestMethod.GET)
 		- 해당 요청 주소로 get방식을 처리했을 때
 	
 3) @RequestMapping( value="요청주소", method=RequestMehod.POST)
  		- 해당 요청 주소로 post방식을 처리했을 때
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
