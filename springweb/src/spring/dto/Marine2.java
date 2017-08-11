package spring.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Marine2 {
	private String type;
	@Autowired
	@Qualifier("upR")
	private Upgrade up;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void show(){
		System.out.print(type+" ¸¶¸°ÀÇ ");
		if(up!=null){
			up.improve();
		}		
	}
}
