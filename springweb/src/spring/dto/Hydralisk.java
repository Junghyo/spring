package spring.dto;

public class Hydralisk {
	private String type;
	private Upgrade up;
	
	public Hydralisk() {
	}
	public Hydralisk(Range up) {
		this.up = up;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Upgrade getUp() {
		return up;
	}
	public void setUp(Attack up) {
		this.up = up;
	}
	public void show(){
		System.out.println(type+"히드라 ");
		if(up!=null){
			up.improve();
		}else{
			System.out.println("업그레이드 되지 않음");
		}
	}
	
}
interface Upgrade{
	void improve();
}
class Attack implements Upgrade{

	@Override
	public void improve() {
		// TODO Auto-generated method stub
		System.out.println("공격력 +1 증가");
	}
	
}

class Range implements Upgrade{

	@Override
	public void improve() {
		// TODO Auto-generated method stub
		System.out.println("사거리 +1 증가");
	}
	
}