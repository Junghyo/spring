package spring.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class Marine {
	private String type;
//	�ش� �������� Attack�� ������ type�� �ε��Ǿ� ������ �ڵ����� �Ҵ� ó��	
	@Autowired
	private Attack upA;
	
	public Marine() {
		type="4��Ÿ��";
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void show(){
		System.out.print(type+" ������ ");
		if(upA!=null){
			upA.improve();
		}
	}
	
}
