/*
 # 생성자와 객체할당 예제
 1) Product
 	- 물건명 가격 : 생성자로 할당
 
 2) Mart
 	- 마트이름
 	- Product
 	- selling()
 		어서오세요 @@@마트입니다.
 		오늘 추천물건
 		@@@, @@@@원으로 모십니다.

*/
package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Mart;
import spring.dto.Product;

public class A04_GenericXml_exp_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp01.xml");
		Mart m1 = aactx.getBean("mart", Mart.class);
		Mart m2 = aactx.getBean("mart", Mart.class);
		Product p1 = aactx.getBean("prod", Product.class);
		m1.show();
		m1.setMartName("호날두짱짱맨");
		m1.show();
		p1.setName("짜장면");
		p1.setPrice(4000);
		m1.show();
		m2.show();
		m1.show();
	}

}

/*
 # 1:M 에 대한 조립기 처리
 1) DTO
 	- class Mart
 		- private ArrayList<Product> prodlist;
 		  public void setProdlist(ArrayList<Product>li){
 		  			this.prodlist = li;
 		  }
 		
 		- main
 			ArrayList<Product> buyList = new XXX();
 			buyList.add(new Product("사과", 3000));
 			buyList.add(new Product("딸기", 2000));
 			mart.setProductlist(buuList);
 			
 2) 조립기에서 처리
 	- <bean id="prod01" class="">
 		<property name="name" value="사과"/>
 	  <bean id="prod02" class="">
 	  	<property name="name" value="바나나"/>
 	  ...
 	  <bean id="mart01" class="">
 	  	<property name="prodlist">
 	  		<list>
 	  			<ref bean="prod01"/>
 	  			<ref bean="prod02"/>
*/

/* 확인예제
 1) Schedule
 	- 시간, 내용
 2) DailySchedule
 	- 날짜(문자열)
 	- ArrayList<Schedule> schList;
 	- showSchedule()
 		
*/