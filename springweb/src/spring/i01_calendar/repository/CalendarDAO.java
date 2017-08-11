/*CREATE TABLE CALENDAR
(
   ID      NUMBER,
   TITLE   VARCHAR2 (100),
   BEGIN   VARCHAR2 (100),
   END     VARCHAR2 (100),
   URL     VARCHAR2 (100)
)
NOCACHE
LOGGING;*/
package spring.i01_calendar.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import spring.i01_calendar.vo.Calendar;

@Repository
public interface CalendarDAO {
	public ArrayList<Calendar> calendarList();
}
