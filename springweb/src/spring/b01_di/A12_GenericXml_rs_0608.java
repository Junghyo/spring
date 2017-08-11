/*
 확인예제
 1) 음식점
 	- 가게이름
 	- 음식(autowired)
 	- void eatLunch(){
 	  	오늘 점심은 @@@에 가서 @@를 @@@원으로 먹었다.
 	  }
 2) 음식
 	- 종류
 	- 가격
*/
package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Restaurant;

public class A12_GenericXml_rs_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp12_autowire.xml");
		Restaurant rs = aactx.getBean("rs", Restaurant.class);
		rs.show();
	}

}

/*
 # @Qualifier
 	1) @Autowired로 설정된 객체가 두가지 이상 type이 할당 될 경우 에러 발생
 		- 할당할 수 있는 객체를 선택해야할 필요가 있을 때, id값을 @Qulifier("bean id값")으로 처리한다.
 		
 	2) @Autowired에서 해당 객체가 메모리로 할당이 안될 수도 있을 때, 반드시 할당해야 되는 것인 경우에는 에러발생.
 	     이를 방지하기 위해 필수는 아니라는 옵션 설정으로 에러방지
 	    - @Autowired(required=false) 
*/

/*
 Qualifier 확인예제
 Robot.java
 Weapon.java
 interface Weapon
 void attack();
 Rocket attack()
 Laser attack()
 
 Robot
 private weapon wp;
 private String kind;
*/