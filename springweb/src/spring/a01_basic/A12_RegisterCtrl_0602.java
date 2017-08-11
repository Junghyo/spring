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
			@RequestParam(value="id", defaultValue="���Է�")String id,
			@RequestParam(value="pwd", defaultValue="���Է�")String pwd,
			@RequestParam(value="name", defaultValue="���Է�")String name,
			@RequestParam(value="email", defaultValue="���Է�")String email,
			@RequestParam(value="point", defaultValue="0")int point, Model m
			){
		String page=null;
		if(id.equals("")||pwd.equals("")||name.equals("")||email.equals("")){
			m.addAttribute("msg", "��� �Է�ĭ�� �������� �Է��ϼ���.");
			page="a01_basic/a12_registerForm_0602";		
		}else{
			m.addAttribute("msg", "<h1>"+name+"�� ��ϰ���Դϴ�.</h1>"+
					"<table>"+
					"<tr>"+"<th>���̵�</th>"+"<th>"+id+"</th>"+"</tr>"+
					"<tr>"+"<th>��й�ȣ</th>"+"<th>"+pwd+"</th>"+"</tr>"+
					"<tr>"+"<th>email</th>"+"<th>"+email+"</th>"+"</tr>"+
					"<tr>"+"<th>����Ʈ</th>"+"<th>"+point+"</th>"+"</tr>"+
					"<tr>"+"<th colspan='2'>"+
					"�ʱⰡ�Խ� ����Ʈ +1000�� ���帳�ϴ�. ���Խ� ����Ʈ: "+(point+1000)+"</tr>"+
					"</table>");
			page="a01_basic/a12_registerCheck_0602";		
		}
		return page;
		
	}
}
