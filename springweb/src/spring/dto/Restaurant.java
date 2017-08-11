package spring.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class Restaurant {
	private String storeName;
	@Autowired
	private Food f;
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public void show(){
		System.out.println("오늘 점심은 "+storeName+"에 가서");
		System.out.println(f.getMenu()+"를 "+f.getPrice()+"원으로 먹어야겠다.");
	}
	
}
