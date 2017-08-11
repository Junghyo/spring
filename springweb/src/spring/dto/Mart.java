package spring.dto;

import java.util.ArrayList;

public class Mart {
	private String martName;
	private Product prod;
	private ArrayList<Product> prodList;
	
	public ArrayList<Product> getProdList() {
		return prodList;
	}
	public void setProdList(ArrayList<Product> prodList) {
		this.prodList = prodList;
	}
	public String getMartName() {
		return martName;
	}
	public void setMartName(String martName) {
		this.martName = martName;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	
	public void show(){
		System.out.println("�������! "+martName+"��Ʈ �Դϴ�.");
		System.out.println("������ ��õ��ǰ�� ");
		System.out.println(prod.getName()+"�̸� ������ "+prod.getPrice()+"������ ��ʴϴ�.");
		
		for(Product prod : prodList){
			System.out.println(prod.getName()+" : "+prod.getPrice()+"��");
		}
	}
	
}
