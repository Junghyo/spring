package spring.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Sorceress {
	private String kind;
	@Autowired(required=false)
	@Qualifier("skM")
	private Skill sk;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void Attack(){
		System.out.print(kind+" 소서리스가 ");
		if(sk!=null){
			sk.cast();
		}else{
			System.out.print("스킬을 아직 배우지 못함");
		}
	}
}
