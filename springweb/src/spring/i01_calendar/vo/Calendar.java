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
package spring.i01_calendar.vo;

public class Calendar {
	private int id;
	private String title;
	private String start;
	private String end;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
