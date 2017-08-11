/*
 # �����ڸ� ���� �Ҵ�
 1) DTO : �����ڸ� ���Ͽ� ������ �Ҵ��� �� �ֵ��� ����
 		- Person(String name, int age)
 		  Person p = new Person("ȫ�浿", 25);
 			 
 2) xml bean ����
 		- <bean>
 			<constructor-arg value="ȣ����"/>
 			<constructor-arg value="25"/>
 		  </bean>

 		  
 # ��ü�� ��ü �Ҵ� ó��
 1) Ŭ���� ����
 		- class Woman{}
 		  class Man{
 		  	 Woman w;
 		  	 public void setWoman(Woman w){
 		  		 this.w=w;
 		  	 }
 		  }

 2) ������(Container) ó��
 		- <bean id="woman" class=""/>
 		  <bean id="man" class=""/>
 		  	<property name="woman" ref="woman"/>


 # type casting ���� bean Ȱ��
 1) main()
 		- GenericXmlApplicationContext ctx
 		  Person p = ctx.getBean("p", Person.class);
*/
package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Man;

public class A03_GenericXml_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp01.xml");
		Man m01=aactx.getBean("man", Man.class);
		m01.show();
	}
}

