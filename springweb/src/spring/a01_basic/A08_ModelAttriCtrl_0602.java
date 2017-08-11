/*
 # ModelAttribute
  1) ��û ó�� ��ü�� ������ �����ͷ� �ѱ� ��, ��û+model�� ����� �ϴ� ��ü�� ���Ѵ�.
  2) ��û ó��
 	- public String call(Member m, Model d){
 	  		Member : ��û ������ �Է�
 	  		Model : View�� �ѱ�� ó��
 	  		==> @ModelAttribute("�̸�") Ŭ������
 	  			���� ��û�� model �Ѳ����� ó��
 	  }

 # ModelAttribute�� ���� ����
  1) Controller ���� ( ���� RequestMapping )
  	- get��� �޼��� : �������� ���� ó��
  	- post��� �޼���
  	
 
 # @ModelAttribute
    1) �ش� Ŭ������ controller���� �������� Ȱ���� �� �ִ�.
    2) Controller
  		- @ModelAttribute("���̸�����")
  		  public Product getProduct(){
  		  		return new Product();
  		  }
*/
package spring.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dto.Exam2;

@Controller
@RequestMapping("/modelexam.do")
public class A08_ModelAttriCtrl_0602 {
	@RequestMapping(method=RequestMethod.GET)
	public String start(@ModelAttribute("exam") Exam2 ex){
		ex.setNum01((int) (Math.floor(Math.random()*9)+1));
		ex.setNum02((int) (Math.floor(Math.random()*9)+1));
		return "a01_basic/a20_callModel_0602";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String call(
				@ModelAttribute("exam") Exam2 ex
			){
		if(ex.getAnswer()==(ex.getNum01()*ex.getNum02())){
			ex.setResult("����");
		}else{
			ex.setResult("����");
		}
		ex.setNum01((int) (Math.floor(Math.random()*9)+1));
		ex.setNum02((int) (Math.floor(Math.random()*9)+1));
		return "a01_basic/a20_callModel_0602";
	}
}

