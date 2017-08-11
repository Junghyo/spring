/*
 # Model and View
 	1) Model�� View�� ���� ó���� �ϳ��� Ŭ�������� ó���� �� Ȱ��ȴ�.
 		- public ModelAndView �޼����(){
 		  		ModelAndView mav = new ModelAndView();
 		  		mav.setViewName("view�� ȣ��");
 		  		mav.addObject("��ó��", �𵨰�ü);
 		  		return mav;
 		  }
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.dto.Product;

@Controller
public class A13_ModelAndViewCtril_0607 {
	@RequestMapping("/mav.do")
	public ModelAndView mavexp(){
		ModelAndView mav = new ModelAndView();

//		Model�� ���� ó��
		mav.addObject("model", "Hello World!");
		mav.addObject("prod", new Product("������",670000));
		mav.setViewName("a01_basic/a24_mav_0607");
		return mav;
	}
}

