/*
 # Redirect, Forward
 	1) Controller 단에서 다른 Controller를 호출해야 할 필요가 있을 때, 처리한다.
 		- ex) 수정이나 등록 후 메인 list로 화면처리를 해야 할 경우
 		
    2) Redirect
    	- 입력하거나 넘겨주는 요청값이 필요 없을 때, 
    	
    3) Forward
    	- 요청값도 함께 넘겨주면서 Controller단을 호출할 때, 활용
    	
    4) 형식 : 마지박 view단 호출 부분에
    	- return "redirect:/start.do" ,  "forward:/list.do"
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dto.Product;

@Controller
public class A14_ForRedCtrl_0607 {
//	사이트 호출	
	@RequestMapping("/redirect01.do")
	public String redirect01(){
		return "redirect:http://www.naver.com";
	}

//	내부 Controller 호출
	@RequestMapping("/redirect02.do")
	public String redirect02(){
		return "redirect:/start.do";
	}
	
//	내부 자원 호출 jsp page 호출
	@RequestMapping("/redirect03.do")
	public String redirect03(){
		return "redirect:/index";
	}
	
//	내부 자원 호출 1
	@RequestMapping("/redEmp.do")
	public String redEmp(){
		return "redirect:/emplist.do";
	}
//	http://localhost:7080/spring_web/redEmp.do?ename=F (X)
//	redirect는 데이터값으로 요청값을 넘기지 않음
	
//	내부자원 호출 2
//	http://localhost:7080/spring_web/forEmp.do?ename=F (O)
	@RequestMapping("/forEmp.do")
	public String forEmp(){
		return "forward:/emplist.do";
	}
	
	@RequestMapping("/buyProd.do")
	public String buyProd(@RequestParam(value="phase", defaultValue="0") int phaseNum){
		String page="a01_basic/a25_initPage_0607";
		if(phaseNum==1){
			page= "redirect:/buy2.do";
		}else if(phaseNum==2){
			page= "forward:/buy2.do";
		}
		return page;
		
	}
	

}

/*
 확인예제
 buyProduct.do는 물건 구매에 관련된 누적 처리가 나타난다.
 새로운 Controller를 통해서 아래와 같이 화면을 구성하고
 구매물건		가격			갯수
    사과			[  ]		[  ]
    [구매 금액 초기화면 호출]
    [구매 금액 누적처리]
    
 같은 Controller를 호출하면서 버튼에 따라 초기화면이나 계산 처리된 화면을 호출하세요.
*/

