/*
 # DI(Dependency Injection)
 1) 의존주입
 2) 조립기를 사용하여 기존클래스에 영향이 없이 서로 간에 type을 확인하여 해당 객체를 삽입하는 code처리 방식을 말한다.
 
 				Flyway									
  			  (interface)					
  			  	fly();
  			  	
  	CountryFly			   WorldFly
  	fly(){					fly(){
  		동네를 난다				세계를 난다.
  	}						}


 # spring 조립기
 1) dispatcher-servlet.xml에서 정의된 크래스는 WAS 로딩 시, 사용자 정의 클래스나 FRAMEWORK 기반을 클래스가 실제 객체가 메모리에 로딩되는 처리
 
 2) 조립기에 ㄱ개체 생성으로 할당하기에 실제 클래스코드에서는 new XXX코드가 사라지게 된다.
 
 
 # 조립기에서 객체 생성 데이터 할당
 1) main객체 생성
 		- Person p = new Person();
 		- p.setName("호날두");
 		- p.setAge(25);
 	
 2) 조립기
 		- <bean id="p" class="패키지명...Person">
 			<property name="name" value="호날두"/>
 			<property name="age" value="25"/>
 		  </bean>	
 		  
 # 컨테이너 내용 확인
 1) xml 로딩
 		- Resource rs = new ClassPathResource("경로/diexp01.xml");
 
 2) xml에 있는 bean을 호출
 		- BeanFactory : bean객체 호출
 		- XmlBeanFactory : Resource에 있는 xml bean객체 호출
 				.getBean("xml에 선언된 id")
 				Person p = (Person)bean.getBean("p");
*/
package spring.b01_di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import spring.dto.Person;

public class A01_DI_Exp_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		*xml 로딩
		Resource r = new ClassPathResource("spring/b01_di/diexp01.xml");

//		BeanFactory : bean객체 호출
//		XmlBeanFactory : xml에 있는 bean 호출
		BeanFactory bean = new XmlBeanFactory(r);

//		해당 bean id값으로 로딩. xml id="p"
		Person p = (Person)bean.getBean("p");
		System.out.println("이름: "+p.getName());
		System.out.println("나이: "+p.getAge());
	}

}
