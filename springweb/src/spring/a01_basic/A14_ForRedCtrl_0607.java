/*
 # Redirect, Forward
 	1) Controller �ܿ��� �ٸ� Controller�� ȣ���ؾ� �� �ʿ䰡 ���� ��, ó���Ѵ�.
 		- ex) �����̳� ��� �� ���� list�� ȭ��ó���� �ؾ� �� ���
 		
    2) Redirect
    	- �Է��ϰų� �Ѱ��ִ� ��û���� �ʿ� ���� ��, 
    	
    3) Forward
    	- ��û���� �Բ� �Ѱ��ָ鼭 Controller���� ȣ���� ��, Ȱ��
    	
    4) ���� : ������ view�� ȣ�� �κп�
    	- return "redirect:/start.do" ,  "forward:/list.do"
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dto.Product;

@Controller
public class A14_ForRedCtrl_0607 {
//	����Ʈ ȣ��	
	@RequestMapping("/redirect01.do")
	public String redirect01(){
		return "redirect:http://www.naver.com";
	}

//	���� Controller ȣ��
	@RequestMapping("/redirect02.do")
	public String redirect02(){
		return "redirect:/start.do";
	}
	
//	���� �ڿ� ȣ�� jsp page ȣ��
	@RequestMapping("/redirect03.do")
	public String redirect03(){
		return "redirect:/index";
	}
	
//	���� �ڿ� ȣ�� 1
	@RequestMapping("/redEmp.do")
	public String redEmp(){
		return "redirect:/emplist.do";
	}
//	http://localhost:7080/spring_web/redEmp.do?ename=F (X)
//	redirect�� �����Ͱ����� ��û���� �ѱ��� ����
	
//	�����ڿ� ȣ�� 2
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
 Ȯ�ο���
 buyProduct.do�� ���� ���ſ� ���õ� ���� ó���� ��Ÿ����.
 ���ο� Controller�� ���ؼ� �Ʒ��� ���� ȭ���� �����ϰ�
 ���Ź���		����			����
    ���			[  ]		[  ]
    [���� �ݾ� �ʱ�ȭ�� ȣ��]
    [���� �ݾ� ����ó��]
    
 ���� Controller�� ȣ���ϸ鼭 ��ư�� ���� �ʱ�ȭ���̳� ��� ó���� ȭ���� ȣ���ϼ���.
*/

