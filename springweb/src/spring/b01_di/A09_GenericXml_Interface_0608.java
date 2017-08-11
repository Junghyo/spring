package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Hydralisk;

public class A09_GenericXml_Interface_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp09_interface.xml");
		Hydralisk h1 = aactx.getBean("h1", Hydralisk.class);
		Hydralisk h2 = aactx.getBean("h2", Hydralisk.class);
		h1.show();
		h2.show();
	}

}

