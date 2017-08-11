package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.dto.Members;
import spring.z01_database.MembersDAO;

@Controller
@SessionAttributes("mem")
public class A16_SessionCtrlExp_0607 {
	@ModelAttribute("mem")
	public Members getMember(){
		return new Members();
	}
	
	@RequestMapping("/movieLogin.do")
	public String login(@ModelAttribute("mem") Members mem, Model d){
		String page="a01_basic/a26_login_0607";
		d.addAttribute("msg", "아이디와 비밀번호를 다시한번 확인하세요");
		if(mem.getJspend()-mem.getJpoint()>0){
			mem.setJpoint(mem.getJpoint()-mem.getJspend());
			page="a01_basic/a27_main_0607";
		}else if(new MembersDAO().memInfo(mem)!=null){
			mem.setJname(new MembersDAO().memInfo(mem).getJname());
			mem.setJpoint(new MembersDAO().memInfo(mem).getJpoint());
			page="a01_basic/a27_main_0607";
		}	
		return page;
	}
}

/*
 # ViewResolver
 	1) Controller가 지정한 뷰 이름으로부터 응답 결과 화면을 생성하는 View 객체를 구할 때, 사용되는 것이 ViewResolve
 	2) 주요 ViewResolver의 구현 클래스
 		- InternalResourceViewResolver
 			뷰 이름으로부터 jsp나 Tiles연동을 위한 View 객체를 리턴한다.
 		- VelocityViewResolver
 			뷰 이름으로부터 Velocity연동을 위한 View 객체를 리턴한다.
 		- BeanNameViewResolver
 			뷰 아름과 동일한 이름을 갖는 빈객체를 View로 리턴한다.
 		
 # InternalResourceViewResolver
 	1) 컨테이너(xml)에서 설정
 		- <bean id="" class="@@.@@.InternalResourceViewResolver">
 			<property name="prefix" value=""> 접두어 
 			<property name="suffix" value=""> 접미어 
 		
 		- Controller에 View호출
 			public String form(){
 				return"a01_basic/@@@";
 			}
*/

/*
 # 객체에 객체 할당 처리
 	1) Main()나 외부 클래스에서 호출 형태
  		- Woman woman = new Woman();
  		  Man man  = new Man();
  		  man.setWoman(woman);
  		  
  	2) 조립기(Container) 처리
  		- <bean id="woman" class="@@@.Woman"/>
  		  <bean id="man" class="@@@.Man"/>
  		  		<property name="woman" ref="woman"/>
  		  		
 # autowire
    1. 속성
    	1) byName
    		- 참조변수의 이름과 같은 해당객체의 메서드가 있을 때, 자동으로 할당하게 되는것
*/
