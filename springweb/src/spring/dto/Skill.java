package spring.dto;

public interface Skill {
	void cast();
}

class Blizzard implements Skill{

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		System.out.println("블리자드 스킬 시전");
	}
	
}

class Meteor implements Skill{

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		System.out.println("메테오 스킬 시전");
	}
	
}