package spring.i01_calendar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.i01_calendar.repository.CalendarDAO;
import spring.i01_calendar.vo.Calendar;

@Service
public class CalendarService {
	@Autowired(required=false)
	private CalendarDAO dao;
	
	public ArrayList<Calendar> calendarList(){
		return dao.calendarList();
	}
}
