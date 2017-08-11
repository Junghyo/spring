package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A12_RegisterCtrl_0602 {
	@RequestMapping("/register.do")
	public String register(){
		String page="a01_basic/a12_registerForm_0602";
		return page;
	}
	@RequestMapping("/reCheck.do")
	public String reCheck(
			@RequestParam(value="id", defaultValue="무입력")String id,
			@RequestParam(value="pwd", defaultValue="무입력")String pwd,
			@RequestParam(value="name", defaultValue="무입력")String name,
			@RequestParam(value="email", defaultValue="무입력")String email,
			@RequestParam(value="point", defaultValue="0")int point, Model m
			){
		String page=null;
		if(id.equals("")||pwd.equals("")||name.equals("")||email.equals("")){
			m.addAttribute("msg", "모든 입력칸을 빠짐없이 입력하세요.");
			page="a01_basic/a12_registerForm_0602";		
		}else{
			m.addAttribute("msg", "<h1>"+name+"님 등록결과입니다.</h1>"+
					"<table>"+
					"<tr>"+"<th>아이디</th>"+"<th>"+id+"</th>"+"</tr>"+
					"<tr>"+"<th>비밀번호</th>"+"<th>"+pwd+"</th>"+"</tr>"+
					"<tr>"+"<th>email</th>"+"<th>"+email+"</th>"+"</tr>"+
					"<tr>"+"<th>포인트</th>"+"<th>"+point+"</th>"+"</tr>"+
					"<tr>"+"<th colspan='2'>"+
					"초기가입시 포인트 +1000을 더드립니다. 가입시 포인트: "+(point+1000)+"</tr>"+
					"</table>");
			page="a01_basic/a12_registerCheck_0602";		
		}
		return page;
		
	}
}
