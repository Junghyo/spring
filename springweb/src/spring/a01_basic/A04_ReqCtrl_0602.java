/*
 # Controller�� ���� ��ûó��
 1) ��û
 	- http://localhost:7080/spring_web/callctrl.do
 	
 2) �ڹ� Controller
 	- @RequestMapping("/callctrl.do")
 	  public String call(��û, ����� Model){
 	  		��û DTO
 	  		��� Model : jsp��
			return "/@@@";
 	  }
 
 # ��û ó���� ���ִ� ���� ��ü��
 1. public String call( @@@@, Model d){
 		1) Ŭ���� ����
 			- Member m : ?id=himan&pwd=7777
 		2) �Ѱ� ���� �Է°� ó��
 			- @RequestParam(value="id". defaultValue="") 
 				value : query string key�� ��Ī
 				defaultValue : ���� string key�� ���ų� �����͸� �Ҵ����� ���� ���
 				start.do?XXXXX
 	}
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 1. annotation ����
// 2. ������(dispathcer-servlet.xml)�� ���
@Controller
public class A04_ReqCtrl_0602 {
// 	http://localhost:7080/spirng_web/reqexp01.do
//	http://localhost:7080/spring_web/reqexp01.do?greet1=hi&greet2=man
	@RequestMapping("/reqexp01.do")
	public String requestCall(
			@RequestParam(value="greet1", defaultValue="�ʱ��λ�1")String greet01,
			@RequestParam(value="greet2", defaultValue="�ʱ��λ�2")String greet02,
			@RequestParam(value="callnum1", defaultValue="-1")int num01
			){
		System.out.println("��û��1: "+greet01);
		System.out.println("��û��1: "+greet02);
		System.out.println("��û��3: "+num01);
		String page="a01_basic/a10_calling_0602";
		return page;
		
	}
}

