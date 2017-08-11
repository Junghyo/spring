package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A05_buyCtril_0602 {
	@RequestMapping("/buyForm.do")
	public String buyForm(){
		String page="a01_basic/a11_buyForm_0602";
		return page;
	}
	
	@RequestMapping("/buyCheck.do")
	public String requestBuy(
			@RequestParam(value="name", defaultValue="무입력")String name,
			@RequestParam(value="price", defaultValue="0")int price,
			@RequestParam(value="cnt", defaultValue="0")int cnt, Model m){
		String page="a01_basic/a11_buyForm_0602";
		if(!name.equals("") && price>0 && cnt>0){
			m.addAttribute("msg", "<h2>구매하신 물건은 "+name+"이며 단가는 "+price+"원입니다.</h2><h2>총 "+cnt+"개 구입하셔서 총구매금액은 "+price*cnt+"원 입니다.</h2>");
		}else{
			m.addAttribute("msg", "<h2>구매한 물건이 없습니다.</h2>");
		}
		return page;
		
	}
}
/*
 1) 회원등록(초기화면)
 id
 pwd
 이름
 email
 포인트
 [회원등록]
 
 2) 등록결과
 이름님 등록결과입니다.
 id: @@@, 패스워드: @@ email: @@@
 초기가입 포인트 +1000을 드립니다. 포인트:@@@

*/

/*
 # get/post 처리
 1) Controller에 공통 RequestMapping annotation 설정, get/post 방식 처리
 
 2) @RequestMapping( value="요청주소", method=RequestMethod.GET)
 		- 해당 요청 주소로 get방식을 처리했을 때
 	
 3) @RequestMapping( value="요청주소", method=RequestMehod.POST)
  		- 해당 요청 주소로 post방식을 처리했을 때
*/