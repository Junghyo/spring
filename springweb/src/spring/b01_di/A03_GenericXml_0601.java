/*
 # 생성자를 통한 할당
 1) DTO : 생성자를 통하여 데이터 할당할 수 있도록 선언
 		- Person(String name, int age)
 		  Person p = new Person("홍길동", 25);
 			 
 2) xml bean 선언
 		- <bean>
 			<constructor-arg value="호날두"/>
 			<constructor-arg value="25"/>
 		  </bean>

 		  
 # 객체에 객체 할당 처리
 1) 클래스 선언
 		- class Woman{}
 		  class Man{
 		  	 Woman w;
 		  	 public void setWoman(Woman w){
 		  		 this.w=w;
 		  	 }
 		  }

 2) 조립기(Container) 처리
 		- <bean id="woman" class=""/>
 		  <bean id="man" class=""/>
 		  	<property name="woman" ref="woman"/>


 # type casting 없이 bean 활용
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

