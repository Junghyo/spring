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
		System.out.println(type+"����� ");
		if(up!=null){
			up.improve();
		}else{
			System.out.println("���׷��̵� ���� ����");
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
		System.out.println("���ݷ� +1 ����");
	}
	
}

class Range implements Upgrade{

	@Override
	public void improve() {
		// TODO Auto-generated method stub
		System.out.println("��Ÿ� +1 ����");
	}
	
}