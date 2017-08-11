package spring.b01_di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dto.Sorceress;

public class A14_GenericXml_Sorcer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aactx = new GenericXmlApplicationContext("spring/b01_di/diexp14_sorcer.xml");
		Sorceress s1 = aactx.getBean("s1", Sorceress.class);
		s1.Attack();
	}

}
/*
 # Mybatis 연결
 	1) 컨테이너(dispatcher-servlet.xml)에 모듈
 		- DB 연결정보
 		- mybatis 모듈 등록, 설정 파일
 		- dao interface 위치 등록
 	
 	2) Mybatis 설정
 		- 공통 vo를 등록, alias 이름
 		- 업무별 XXXXmapper.xml을 등록
 		
 	3) Mapper.xml
 		- namespace 설정
 		- resultMap 선언 : vo
 		- sql 선언 : select
 			입력값 : parameterType
 			return : resultMap(ArrayList), resultTyp(VO)
 			update, insert
 			
 			
 [ BasicDataSource ]			     [ Mybatis ]				
 	  - jdbc				   - 공통 설정파일xml로 연결    		
 	  - 드라이버			=====>    
 	  - ip/port/계정
 	  
 [ DAO(Repository) ]				   [ Mapper.xml ] 
 - 사용하는 dao inf 등록		====>  - 사용하는 sql을 등록
*/