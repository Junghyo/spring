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
		System.out.print(kind+" �Ҽ������� ");
		if(sk!=null){
			sk.cast();
		}else{
			System.out.print("��ų�� ���� ����� ����");
		}
	}
}
