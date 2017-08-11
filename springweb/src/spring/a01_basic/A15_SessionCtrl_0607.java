/*
 # Session
 	1. Controller단에서 처리하는 방식
 		1) HttpSession을 활용
	 		- public String login(요청처리, HttpSession hs){
	 		  		ses.attribute("세션key", 객체);
	 		  }
	 	
	 	2) HttpServletRequest를 활용
	 		- public String loginCom(요청처리, HttpServletRequest request){
	 		  		HttpSession hs = request.getSession();
	 		  		hs.attribute("세션key", 객체);
	 		  }
	 		
	 	3) @SessionAttributes("세션key")	
	 	 	- @ModelAttribute("세션key")
	 	 	  public VO클래스 form(){
	 	 	  		return new VO클래스();
	 	 	  }
*/
package spring.a01_basic;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import spring.dto.Member;
import spring.dto.Product;
import spring.dto.Schedule;


@Controller
@SessionAttributes("schedule")
public class A15_SessionCtrl_0607 {
	@ModelAttribute("schedule")
	public Schedule getSchedule(){
		return new Schedule();
	}
	@RequestMapping("/input_schedule.do")
	public String inputSchedule(@ModelAttribute("schedule") Schedule sc){
		String page="a01_basic/a29_recordSchedule_0607";
		return page;
	}
	@RequestMapping("/session_login.do")
	public String login(Member m, HttpSession hs){
		String page="a01_basic/a26_login_0607";
		if(m.getId()!=null &&  m.getPwd()!=null && m.getId().equals("himan") && m.getPwd().equals("7777")){
			hs.setAttribute("mem", m);
			return "a01_basic/a27_main_0607";
		}
		return page;
	}
	
	@RequestMapping("/session_cart01.do")
	public String getCart(Product prod, HttpServletRequest hsr){
		String page="a01_basic/a28_prod_0607";
		if(prod.getName()!=null){
			HttpSession hs = hsr.getSession();
			ArrayList<Product> cartList = null;
			if(hs.getAttribute("cartList")==null){
				cartList = new ArrayList<Product>(); 
			}else{
				cartList = (ArrayList<Product>)hs.getAttribute("cartList");
			}
			cartList.add(prod);
			hs.setAttribute("cartList", cartList);
			page="a01_basic/a28_cartList_0607";
		}
		return page;
	}
	
}
