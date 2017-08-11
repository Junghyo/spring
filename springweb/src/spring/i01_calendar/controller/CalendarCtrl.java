package spring.i01_calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.i01_calendar.service.CalendarService;

@Controller
@RequestMapping("/calendar.do")
public class CalendarCtrl {
	@Autowired(required=false)
	private CalendarService service;
	
	@RequestMapping(params="method=start")
	public String start(){
		return "/i01_calendar/a01_calendar";
	}
	
	@RequestMapping(params="method=list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pageJsonReport");
		System.out.println(service.calendarList().size());
		mav.addObject("calendarList", service.calendarList());
		return mav;
	}
}
