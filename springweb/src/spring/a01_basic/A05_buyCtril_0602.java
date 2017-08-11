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
			@RequestParam(value="name", defaultValue="���Է�")String name,
			@RequestParam(value="price", defaultValue="0")int price,
			@RequestParam(value="cnt", defaultValue="0")int cnt, Model m){
		String page="a01_basic/a11_buyForm_0602";
		if(!name.equals("") && price>0 && cnt>0){
			m.addAttribute("msg", "<h2>�����Ͻ� ������ "+name+"�̸� �ܰ��� "+price+"���Դϴ�.</h2><h2>�� "+cnt+"�� �����ϼż� �ѱ��űݾ��� "+price*cnt+"�� �Դϴ�.</h2>");
		}else{
			m.addAttribute("msg", "<h2>������ ������ �����ϴ�.</h2>");
		}
		return page;
		
	}
}
/*
 1) ȸ�����(�ʱ�ȭ��)
 id
 pwd
 �̸�
 email
 ����Ʈ
 [ȸ�����]
 
 2) ��ϰ��
 �̸��� ��ϰ���Դϴ�.
 id: @@@, �н�����: @@ email: @@@
 �ʱⰡ�� ����Ʈ +1000�� �帳�ϴ�. ����Ʈ:@@@

*/

/*
 # get/post ó��
 1) Controller�� ���� RequestMapping annotation ����, get/post ��� ó��
 
 2) @RequestMapping( value="��û�ּ�", method=RequestMethod.GET)
 		- �ش� ��û �ּҷ� get����� ó������ ��
 	
 3) @RequestMapping( value="��û�ּ�", method=RequestMehod.POST)
  		- �ش� ��û �ּҷ� post����� ó������ ��
*/