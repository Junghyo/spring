package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Marine2;

public class A13_GenericXml_Qualifier_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp13_qualifier.xml");
		Marine2 m2 = aactx.getBean("m2", Marine2.class);
		m2.show();
	}

}
