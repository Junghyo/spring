/*
 확인예제
 BookStore
 	- 서점이름
 	- 생성자(Book display)
 	
 	- void displayBook(){
 	  		@@@ 서점에서 전시하는 도서는 @@@, @@@입니다.
 	  }
 Book
 	- 도서명
 	- 가격
 	
*/
package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.BookStore;

public class A10_GenericXml_autowireExp_0608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp10_book.xml");
		BookStore store01 = aactx.getBean("store", BookStore.class);
		BookStore store02 = aactx.getBean("store1", BookStore.class);
		store01.displayBook();
		store02.displayBook();
	}

}
