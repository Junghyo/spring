package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Man;

public class A07_GenericXml_Autowire_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp07_auto.xml");
		Man m01=aactx.getBean("m", Man.class);
		m01.show();
	}

}
