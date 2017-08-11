package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Mart;

public class A08_GenericXmlAutoExp_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp08_auto.xml");
		Mart m1 = aactx.getBean("m", Mart.class);
		System.out.println(m1.getMartName());
		System.out.println(m1.getProd().getName());
		m1.show();
	}

}
