package spring.dto;

public class EmpMulti {
	private String ename;
	private String job;
	private int[] deptnos;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int[] getDeptnos() {
		return deptnos;
	}
	public void setDeptnos(int[] deptnos) {
		this.deptnos = deptnos;
	}
	
}
