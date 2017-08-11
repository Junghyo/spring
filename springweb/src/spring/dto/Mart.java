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
		System.out.println("어서오세요! "+martName+"마트 입니다.");
		System.out.println("오늘의 추천상품은 ");
		System.out.println(prod.getName()+"이며 가격은 "+prod.getPrice()+"원으로 모십니다.");
		
		for(Product prod : prodList){
			System.out.println(prod.getName()+" : "+prod.getPrice()+"원");
		}
	}
	
}
