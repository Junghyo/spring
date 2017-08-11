package spring.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class Marine {
	private String type;
//	해당 조립내에 Attack과 동일한 type이 로딩되어 있으면 자동으로 할당 처리	
	@Autowired
	private Attack upA;
	
	public Marine() {
		type="4번타자";
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void show(){
		System.out.print(type+" 마린의 ");
		if(upA!=null){
			upA.improve();
		}
	}
	
}
