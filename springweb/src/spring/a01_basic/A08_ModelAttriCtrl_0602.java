/*
 # ModelAttribute
  1) 요청 처리 객체의 내용을 데이터로 넘길 때, 요청+model을 기능을 하는 객체를 말한다.
  2) 요청 처리
 	- public String call(Member m, Model d){
 	  		Member : 요청 데이터 입력
 	  		Model : View단 넘기는 처리
 	  		==> @ModelAttribute("이름") 클래스명
 	  			으로 요청과 model 한꺼번에 처리
 	  }

 # ModelAttribute를 통한 수학
  1) Controller 생성 ( 공통 RequestMapping )
  	- get방식 메서드 : 랜덤으로 문제 처리
  	- post방식 메서드
  	
 
 # @ModelAttribute
    1) 해당 클래스를 controller에서 공통으로 활용할 수 있다.
    2) Controller
  		- @ModelAttribute("모델이름선언")
  		  public Product getProduct(){
  		  		return new Product();
  		  }
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dto.Exam2;

@Controller
@RequestMapping("/modelexam.do")
public class A08_ModelAttriCtrl_0602 {
	@RequestMapping(method=RequestMethod.GET)
	public String start(@ModelAttribute("exam") Exam2 ex){
		ex.setNum01((int) (Math.floor(Math.random()*9)+1));
		ex.setNum02((int) (Math.floor(Math.random()*9)+1));
		return "a01_basic/a20_callModel_0602";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String call(
				@ModelAttribute("exam") Exam2 ex
			){
		if(ex.getAnswer()==(ex.getNum01()*ex.getNum02())){
			ex.setResult("정답");
		}else{
			ex.setResult("오답");
		}
		ex.setNum01((int) (Math.floor(Math.random()*9)+1));
		ex.setNum02((int) (Math.floor(Math.random()*9)+1));
		return "a01_basic/a20_callModel_0602";
	}
}

