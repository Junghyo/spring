package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.DailySchedule;

public class A05_GenericXml_schedule_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp_schedule.xml");
		DailySchedule ds = aactx.getBean("dailyschedule", DailySchedule.class);
		ds.show();
	}

}

