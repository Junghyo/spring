package spring.dto;

import java.util.ArrayList;

public class DailySchedule {
	private String date;
	private Schedule schedule;
	private ArrayList<Schedule> scheduleList;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public ArrayList<Schedule> getScheduleList() {
		return scheduleList;
	}
	public void setScheduleList(ArrayList<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	public void show(){
		if(date!=null){
			System.out.println(date);
			for(Schedule s : scheduleList){
				System.out.println(s.getTime()+" : "+s.getContent());
			}
		}
	}
	
}
