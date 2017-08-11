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
		d.addAttribute("msg", "���̵�� ��й�ȣ�� �ٽ��ѹ� Ȯ���ϼ���");
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
 	1) Controller�� ������ �� �̸����κ��� ���� ��� ȭ���� �����ϴ� View ��ü�� ���� ��, ���Ǵ� ���� ViewResolve
 	2) �ֿ� ViewResolver�� ���� Ŭ����
 		- InternalResourceViewResolver
 			�� �̸����κ��� jsp�� Tiles������ ���� View ��ü�� �����Ѵ�.
 		- VelocityViewResolver
 			�� �̸����κ��� Velocity������ ���� View ��ü�� �����Ѵ�.
 		- BeanNameViewResolver
 			�� �Ƹ��� ������ �̸��� ���� ��ü�� View�� �����Ѵ�.
 		
 # InternalResourceViewResolver
 	1) �����̳�(xml)���� ����
 		- <bean id="" class="@@.@@.InternalResourceViewResolver">
 			<property name="prefix" value=""> ���ξ� 
 			<property name="suffix" value=""> ���̾� 
 		
 		- Controller�� Viewȣ��
 			public String form(){
 				return"a01_basic/@@@";
 			}
*/

/*
 # ��ü�� ��ü �Ҵ� ó��
 	1) Main()�� �ܺ� Ŭ�������� ȣ�� ����
  		- Woman woman = new Woman();
  		  Man man  = new Man();
  		  man.setWoman(woman);
  		  
  	2) ������(Container) ó��
  		- <bean id="woman" class="@@@.Woman"/>
  		  <bean id="man" class="@@@.Man"/>
  		  		<property name="woman" ref="woman"/>
  		  		
 # autowire
    1. �Ӽ�
    	1) byName
    		- ���������� �̸��� ���� �ش簴ü�� �޼��尡 ���� ��, �ڵ����� �Ҵ��ϰ� �Ǵ°�
*/
