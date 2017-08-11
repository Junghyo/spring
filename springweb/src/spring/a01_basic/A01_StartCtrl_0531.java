/* 
 # ������ �����ӿ�ũ
 1) Rod Johnson�� ���� ���¼ҽ� �����ӿ�ũ
 2) ������ ������������ ���ø����̼� ������ �ܳ�
 3) �ܼ���, �׽�Ʈ ���̼�, ������ ���ռ��� ������ �������� ������ �����ϰ� �ִ�.
 ==> �淮�� ���� ����(DI)�� ��������(AOP) �����̳ʷ� �����Ǿ� �ִ� �����ӿ�ũ
 
 		     �淮												    �����
 	- ��ü �������� ũ��									- ������̶�� �����
 	  1mb���� �ϳ��� jar����								  ���� ���ø����̼��� ������ ����
 	  �������� ���� ó����
 	
 		    ��������											   �����̳�
 	- �������� �������� ���α׷����� ����						- �����ֱ�� ������ �����ϰ�
 	  ǳ���� ������ �Ѵ�.									   �����ϴ� ������ �����̳ʰ� �ִ�.

 
 # ������ ���
 1) core
 	- framework���� ���� �⺻���� �κ��̰� ����������(Dependency Injection)����� �����Ѵ�.
 	
 2) DAO
  	- jdbc �ڵ��� �����ͺ��̽� ��ü�� Ư�� ó���� �ʿ䰡 ���� jdbc �߻�ȭ ���̾ ����
  	
 3) ORM
 	- ��ü ���� ���� API�� ���� ���� ���̾ �����Ѵ�.
 	  Mybatis�� Ȱ���ؼ� DB ó���� ȿ��ȭ �Ѵ�.
 	  
 4) Web
  	- ȭ�� View�Ӹ��� �ƴ϶� ������ ���Ͼ��ε�, �ٿ�ε�
  	
 5) MVC
 	- �� ���������̼��� ��2 ������ ���������� ����
 	
 
 # web.xml
 	1. url�� ���ؼ� �������� ȣ���� �� ���� ���� ȣ��Ǵ� ��
 		- http://localhost:7080/spring_web/
 		
 	2. front�� controller ����(DispatcherServlet)
 		1) �������� ���������� �����ϴ� servlet ����
 		2) � url �������� �������� servlet�� ȣ��Ǵ� ���� ����
 			- do ==> �������� ����ϴ� servlet�� ����
 			- default ������ �����̳� ��������
 	
 	3. ���������� �����ϴ� �ѱ� encodingFilter ����(CharactrerEncodingFilter)
 		 			
*/

package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dto.Member;

// �޸𸮿� �ε��ϱ�(import)
// 1. �� Ŭ���� ���� ���� annotation���� Controller ����
// 2. dispatcher.xml�� xml��� ������� bean ���
@Controller
public class A01_StartCtrl_0531 {
//	http://localhost:6080/spring_web/start.do
//	ȣ��� �޼���. annotation���� RequestMapping("������ ȣ���")
	@RequestMapping("/start.do")
	public String start(){
//		1. ��û��
//		2. business login ó�� (service�� ���ؼ� model)
//		3. view�� ȣ��

//		return : ȭ��� ȣ��		
		return "a01_basic/a01_start_0531";
	}
	
//	http://localhost:7080/spring_web/send.do?id=himan&pwd=7777	
	@RequestMapping("/send.do")
	public String send(Member mem, Model d){
//		1. ��û�� ó��		
		System.out.println(mem.getId()+" : "+mem.getPwd());
//		2. �𵨵�����
//		msg "id�� @@@�̰� password�� @@@ �Դϴ�."
		d.addAttribute("msg", "id�� "+mem.getId()+"�̰� password�� "+mem.getPwd()+" �Դϴ�.");
		return "a01_basic/a02_send_0601";
	}

//	�α��� �ʱ�ȭ��
	@RequestMapping("/login.do")
	public String login(){
		return "a01_basic/a03_login_0601";
	}

//	�α��� üũ ó��
	@RequestMapping("/check.do")
	public String check(Member mem, Model d){
		String page = "a03_login_0601";
		d.addAttribute("msg", "���̵�� ��й�ȣ�� �ٽ��ѹ� Ȯ�����ּ���.");
		if(mem.getId().equals("himan") && mem.getPwd().equals("7777")){
			page="a04_login_ok_0601";
			d.addAttribute("msg", mem.getId()+"�� ȯ���մϴ�.");
		}
		return "a01_basic/"+page;	
	}
}
/*
 # ��û ó�� �� �� ó��
 1) http://localhost:7080/springweb/start.do
		- ��û�� ó��(query string) : ?id=himan&pwd=7777
		- �޴� ������ : ��

 2) @RequestMapping("/start.do")

 3) public String start( ��û�� ���� ��ü, view�ܿ� ������ ��ü ){
		return " jsp";
	}	
		- public String start( Member m, Model d )		

 # ��û�� �޴� Ŭ���� ����
 1) ?id=himan&pwd=7777

 2) public String start( Member m, Model d )
		- Member class���� property id, pwd
		- setId(String name)
		- setPwd(String pwd)
		
 3) ��ܿ��� �� ������ �ޱ�
		- d.addAttribute("call", "call me");
		- view ==> ${call}
		- return "view�� jsp ȣ��";	
		
 # post ��� id, pwd üũ
 1) login.do		
			
*/
