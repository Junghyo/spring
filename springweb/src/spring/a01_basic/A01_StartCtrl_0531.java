/* 
 # 스프링 프레임워크
 1) Rod Johnson이 만든 오픈소스 프레임워크
 2) 복잡한 엔터프라이즈 애플리케이션 개발을 겨냥
 3) 단순성, 테스트 용이성, 느슨한 결합성의 측면이 스프링의 이점을 제시하고 있다.
 ==> 경량의 제어 역행(DI)과 관점지향(AOP) 컨테이너로 구성되어 있는 프레임워크
 
 		     경량												    제어역행
 	- 전체 스프량의 크기									- 제어역행이라는 기술을
 	  1mb남짓 하나의 jar파일								  통해 애플리케이션의 느슨한 결합
 	  스프링에 의해 처리됨
 	
 		    관점지향											   컨테이너
 	- 스프링은 관점지향 프로그래밍을 위한						- 생명주기와 설정을 포함하고
 	  풍부한 지원을 한다.									   관리하는 일종의 컨테이너가 있다.

 
 # 스프링 모듈
 1) core
 	- framework에서 가장 기본적인 부분이고 의존성삽입(Dependency Injection)기능을 제공한다.
 	
 2) DAO
  	- jdbc 코딩과 데이터베이스 업체별 특정 처리할 필요가 없는 jdbc 추상화 레이어를 제공
  	
 3) ORM
 	- 객체 관계 매핑 API를 위한 통합 레이어를 제공한다.
 	  Mybatis를 활용해서 DB 처리를 효율화 한다.
 	  
 4) Web
  	- 화면 View뿐만이 아니라 웹에서 파일업로드, 다운로드
  	
 5) MVC
 	- 웹 애프리케이션의 모델2 패턴을 스프링에서 지원
 	
 
 # web.xml
 	1. url을 통해서 웹서버를 호출할 때 가장 먼저 호출되는 곳
 		- http://localhost:7080/spring_web/
 		
 	2. front단 controller 선언(DispatcherServlet)
 		1) 공통으로 스프링에서 지원하는 servlet 선언
 		2) 어떤 url 패턴으로 스프링의 servlet이 호출되는 지도 선언
 			- do ==> 스프링에 사용하는 servlet을 선언
 			- default 스프링 컨테이너 설정파일
 	
 	3. 스프링에서 지원하는 한글 encodingFilter 선언(CharactrerEncodingFilter)
 		 			
*/

package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dto.Member;

// 메모리에 로딩하기(import)
// 1. 각 클래스 선언 위에 annotation으로 Controller 선언
// 2. dispatcher.xml에 xml등록 방식으로 bean 등록
@Controller
public class A01_StartCtrl_0531 {
//	http://localhost:6080/spring_web/start.do
//	호출될 메서드. annotation으로 RequestMapping("마지막 호출명")
	@RequestMapping("/start.do")
	public String start(){
//		1. 요청값
//		2. business login 처리 (service를 통해서 model)
//		3. view단 호출

//		return : 화면단 호출		
		return "a01_basic/a01_start_0531";
	}
	
//	http://localhost:7080/spring_web/send.do?id=himan&pwd=7777	
	@RequestMapping("/send.do")
	public String send(Member mem, Model d){
//		1. 요청값 처리		
		System.out.println(mem.getId()+" : "+mem.getPwd());
//		2. 모델데이터
//		msg "id는 @@@이고 password는 @@@ 입니다."
		d.addAttribute("msg", "id는 "+mem.getId()+"이고 password는 "+mem.getPwd()+" 입니다.");
		return "a01_basic/a02_send_0601";
	}

//	로그인 초기화면
	@RequestMapping("/login.do")
	public String login(){
		return "a01_basic/a03_login_0601";
	}

//	로그인 체크 처리
	@RequestMapping("/check.do")
	public String check(Member mem, Model d){
		String page = "a03_login_0601";
		d.addAttribute("msg", "아이디와 비밀번호를 다시한번 확인해주세요.");
		if(mem.getId().equals("himan") && mem.getPwd().equals("7777")){
			page="a04_login_ok_0601";
			d.addAttribute("msg", mem.getId()+"님 환영합니다.");
		}
		return "a01_basic/"+page;	
	}
}
/*
 # 요청 처리 및 모델 처리
 1) http://localhost:7080/springweb/start.do
		- 요청값 처리(query string) : ?id=himan&pwd=7777
		- 받는 데이터 : 모델

 2) @RequestMapping("/start.do")

 3) public String start( 요청값 전달 객체, view단에 보내는 객체 ){
		return " jsp";
	}	
		- public String start( Member m, Model d )		

 # 요청값 받는 클래스 선언
 1) ?id=himan&pwd=7777

 2) public String start( Member m, Model d )
		- Member class에서 property id, pwd
		- setId(String name)
		- setPwd(String pwd)
		
 3) 뷰단에서 모델 데이터 받기
		- d.addAttribute("call", "call me");
		- view ==> ${call}
		- return "view단 jsp 호출";	
		
 # post 방식 id, pwd 체크
 1) login.do		
			
*/
