package spring.b01_di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import spring.dto.Weather;

public class A02_DI_Weather_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r = new ClassPathResource("spring/b01_di/diexp01.xml");
		BeanFactory bean = new XmlBeanFactory(r);
		Weather w = (Weather)bean.getBean("w");
		System.out.println(w.getDate());
		System.out.println(w.getLoc());
		System.out.println(w.getInfo());
	}

}

