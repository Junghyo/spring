/*
 # Model and View
 	1) Model과 View에 대한 처리를 하나의 클래스에서 처리할 때 활용된다.
 		- public ModelAndView 메서드명(){
 		  		ModelAndView mav = new ModelAndView();
 		  		mav.setViewName("view단 호출");
 		  		mav.addObject("모델처리", 모델객체);
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

//		Model에 대한 처리
		mav.addObject("model", "Hello World!");
		mav.addObject("prod", new Product("아이폰",670000));
		mav.setViewName("a01_basic/a24_mav_0607");
		return mav;
	}
}

