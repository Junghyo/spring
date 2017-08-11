package spring.dto;

public class EmpJobMulti {
	private String ename;
	private String[] jobs;
	private int[] deptnos;
	public String getEname() {
		return ename;
	}
	public void setEName(String ename) {
		this.ename = ename;
	}
	public String[] getJobs() {
		return jobs;
	}
	public void setJobs(String[] jobs) {
		this.jobs = jobs;
	}
	public int[] getDeptnos() {
		return deptnos;
	}
	public void setDeptnos(int[] deptnos) {
		this.deptnos = deptnos;
	}
	
}
