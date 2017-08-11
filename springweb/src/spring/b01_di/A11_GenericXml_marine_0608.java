/*
 # �� java���� autowire ����
 	1) ������ ����
 		-<context:annotation-config/>
 	2) �� Ŭ�������� autowire �� annotation�� ���� ó��
*/
package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Marine;

public class A11_GenericXml_marine_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp11_autowire.xml");
		Marine m1 = aactx.getBean("m1", Marine.class);
		m1.show();
	}

}

