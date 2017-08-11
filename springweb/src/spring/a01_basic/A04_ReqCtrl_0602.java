/*
 # Controller를 통한 요청처리
 1) 요청
 	- http://localhost:7080/spring_web/callctrl.do
 	
 2) 자바 Controller
 	- @RequestMapping("/callctrl.do")
 	  public String call(요청, 결과로 Model){
 	  		요청 DTO
 	  		결과 Model : jsp단
			return "/@@@";
 	  }
 
 # 요청 처리를 해주는 여러 객체들
 1. public String call( @@@@, Model d){
 		1) 클래스 선언
 			- Member m : ?id=himan&pwd=7777
 		2) 한개 단위 입력값 처리
 			- @RequestParam(value="id". defaultValue="") 
 				value : query string key를 지칭
 				defaultValue : 실제 string key가 없거나 데이터를 할당하지 않을 경우
 				start.do?XXXXX
 	}
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 1. annotation 선언
// 2. 조립기(dispathcer-servlet.xml)에 등록
@Controller
public class A04_ReqCtrl_0602 {
// 	http://localhost:7080/spirng_web/reqexp01.do
//	http://localhost:7080/spring_web/reqexp01.do?greet1=hi&greet2=man
	@RequestMapping("/reqexp01.do")
	public String requestCall(
			@RequestParam(value="greet1", defaultValue="초기인사1")String greet01,
			@RequestParam(value="greet2", defaultValue="초기인사2")String greet02,
			@RequestParam(value="callnum1", defaultValue="-1")int num01
			){
		System.out.println("요청값1: "+greet01);
		System.out.println("요청값1: "+greet02);
		System.out.println("요청값3: "+num01);
		String page="a01_basic/a10_calling_0602";
		return page;
		
	}
}

