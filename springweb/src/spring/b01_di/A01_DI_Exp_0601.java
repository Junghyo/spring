/*
 # DI(Dependency Injection)
 1) ��������
 2) �����⸦ ����Ͽ� ����Ŭ������ ������ ���� ���� ���� type�� Ȯ���Ͽ� �ش� ��ü�� �����ϴ� codeó�� ����� ���Ѵ�.
 
 				Flyway									
  			  (interface)					
  			  	fly();
  			  	
  	CountryFly			   WorldFly
  	fly(){					fly(){
  		���׸� ����				���踦 ����.
  	}						}


 # spring ������
 1) dispatcher-servlet.xml���� ���ǵ� ũ������ WAS �ε� ��, ����� ���� Ŭ������ FRAMEWORK ����� Ŭ������ ���� ��ü�� �޸𸮿� �ε��Ǵ� ó��
 
 2) �����⿡ ����ü �������� �Ҵ��ϱ⿡ ���� Ŭ�����ڵ忡���� new XXX�ڵ尡 ������� �ȴ�.
 
 
 # �����⿡�� ��ü ���� ������ �Ҵ�
 1) main��ü ����
 		- Person p = new Person();
 		- p.setName("ȣ����");
 		- p.setAge(25);
 	
 2) ������
 		- <bean id="p" class="��Ű����...Person">
 			<property name="name" value="ȣ����"/>
 			<property name="age" value="25"/>
 		  </bean>	
 		  
 # �����̳� ���� Ȯ��
 1) xml �ε�
 		- Resource rs = new ClassPathResource("���/diexp01.xml");
 
 2) xml�� �ִ� bean�� ȣ��
 		- BeanFactory : bean��ü ȣ��
 		- XmlBeanFactory : Resource�� �ִ� xml bean��ü ȣ��
 				.getBean("xml�� ����� id")
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

//		*xml �ε�
		Resource r = new ClassPathResource("spring/b01_di/diexp01.xml");

//		BeanFactory : bean��ü ȣ��
//		XmlBeanFactory : xml�� �ִ� bean ȣ��
		BeanFactory bean = new XmlBeanFactory(r);

//		�ش� bean id������ �ε�. xml id="p"
		Person p = (Person)bean.getBean("p");
		System.out.println("�̸�: "+p.getName());
		System.out.println("����: "+p.getAge());
	}

}
