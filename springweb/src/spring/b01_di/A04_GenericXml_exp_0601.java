/*
 # �����ڿ� ��ü�Ҵ� ����
 1) Product
 	- ���Ǹ� ���� : �����ڷ� �Ҵ�
 
 2) Mart
 	- ��Ʈ�̸�
 	- Product
 	- selling()
 		������� @@@��Ʈ�Դϴ�.
 		���� ��õ����
 		@@@, @@@@������ ��ʴϴ�.

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
		m1.setMartName("ȣ����¯¯��");
		m1.show();
		p1.setName("¥���");
		p1.setPrice(4000);
		m1.show();
		m2.show();
		m1.show();
	}

}

/*
 # 1:M �� ���� ������ ó��
 1) DTO
 	- class Mart
 		- private ArrayList<Product> prodlist;
 		  public void setProdlist(ArrayList<Product>li){
 		  			this.prodlist = li;
 		  }
 		
 		- main
 			ArrayList<Product> buyList = new XXX();
 			buyList.add(new Product("���", 3000));
 			buyList.add(new Product("����", 2000));
 			mart.setProductlist(buuList);
 			
 2) �����⿡�� ó��
 	- <bean id="prod01" class="">
 		<property name="name" value="���"/>
 	  <bean id="prod02" class="">
 	  	<property name="name" value="�ٳ���"/>
 	  ...
 	  <bean id="mart01" class="">
 	  	<property name="prodlist">
 	  		<list>
 	  			<ref bean="prod01"/>
 	  			<ref bean="prod02"/>
*/

/* Ȯ�ο���
 1) Schedule
 	- �ð�, ����
 2) DailySchedule
 	- ��¥(���ڿ�)
 	- ArrayList<Schedule> schList;
 	- showSchedule()
 		
*/