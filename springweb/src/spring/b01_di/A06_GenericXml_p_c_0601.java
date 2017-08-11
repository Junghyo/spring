package spring.b01_di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import spring.dto.Person;
import spring.dto.Product;

public class A06_GenericXml_p_c_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r = new ClassPathResource("spring/b01_di/diexp_p_c.xml");
		BeanFactory bean1 = new XmlBeanFactory(r);
		Person p01 = (Person)bean1.getBean("p01");
		System.out.println("이름: "+p01.getName());
		System.out.println("나이: "+p01.getAge());
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp_p_c.xml");
		Product prod1 = aactx.getBean("prod1", Product.class);
		System.out.println(prod1.getName()+" : "+prod1.getPrice());
		
		BeanFactory bean2 = new XmlBeanFactory(r);
		Product prod2 = (Product)bean2.getBean("prod1");
		System.out.println(prod2.getName());
		
		Person p02 = aactx.getBean("p01", Person.class);
		System.out.println(p02.getName());
	}

}
