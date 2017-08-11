package spring.dto;

public class Man {
	private Woman woman;
	private String name;
	private String loc;
	public Woman getWoman() {
		return woman;
	}
	public void setWoman(Woman woman) {
		this.woman = woman;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void show(){
		System.out.println("Name: "+name);
		System.out.println("Nationality: "+loc);
		if(woman!=null){
			System.out.println("Who is she?");
			System.out.println("Name: "+woman.getName());
			System.out.println("Age: "+woman.getAge());
		}
	}
}
