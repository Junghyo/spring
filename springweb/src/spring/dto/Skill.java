package spring.dto;

public interface Skill {
	void cast();
}

class Blizzard implements Skill{

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		System.out.println("���ڵ� ��ų ����");
	}
	
}

class Meteor implements Skill{

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		System.out.println("���׿� ��ų ����");
	}
	
}