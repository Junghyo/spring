package spring.dto;
/*CREATE TABLE MEMBERS
(
   ID       VARCHAR2 (50),
   PWD      VARCHAR2 (50),
   NAME     VARCHAR2 (50),
   POINT    NUMBER,
   AUTHOR   VARCHAR2 (20)
)*/
public class Member1 {
	private String id;
	private String pwd;
	private String name;
	private int point;
	private String author;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
