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
		System.out.println("���� ������ "+storeName+"�� ����");
		System.out.println(f.getMenu()+"�� "+f.getPrice()+"������ �Ծ�߰ڴ�.");
	}
	
}
