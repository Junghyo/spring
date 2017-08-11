/*
 Ȯ�ο���
 1) ������
 	- �����̸�
 	- ����(autowired)
 	- void eatLunch(){
 	  	���� ������ @@@�� ���� @@�� @@@������ �Ծ���.
 	  }
 2) ����
 	- ����
 	- ����
*/
package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Restaurant;

public class A12_GenericXml_rs_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp12_autowire.xml");
		Restaurant rs = aactx.getBean("rs", Restaurant.class);
		rs.show();
	}

}

/*
 # @Qualifier
 	1) @Autowired�� ������ ��ü�� �ΰ��� �̻� type�� �Ҵ� �� ��� ���� �߻�
 		- �Ҵ��� �� �ִ� ��ü�� �����ؾ��� �ʿ䰡 ���� ��, id���� @Qulifier("bean id��")���� ó���Ѵ�.
 		
 	2) @Autowired���� �ش� ��ü�� �޸𸮷� �Ҵ��� �ȵ� ���� ���� ��, �ݵ�� �Ҵ��ؾ� �Ǵ� ���� ��쿡�� �����߻�.
 	     �̸� �����ϱ� ���� �ʼ��� �ƴ϶�� �ɼ� �������� ��������
 	    - @Autowired(required=false) 
*/

/*
 Qualifier Ȯ�ο���
 Robot.java
 Weapon.java
 interface Weapon
 void attack();
 Rocket attack()
 Laser attack()
 
 Robot
 private weapon wp;
 private String kind;
*/