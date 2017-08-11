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
 # Mybatis ����
 	1) �����̳�(dispatcher-servlet.xml)�� ���
 		- DB ��������
 		- mybatis ��� ���, ���� ����
 		- dao interface ��ġ ���
 	
 	2) Mybatis ����
 		- ���� vo�� ���, alias �̸�
 		- ������ XXXXmapper.xml�� ���
 		
 	3) Mapper.xml
 		- namespace ����
 		- resultMap ���� : vo
 		- sql ���� : select
 			�Է°� : parameterType
 			return : resultMap(ArrayList), resultTyp(VO)
 			update, insert
 			
 			
 [ BasicDataSource ]			     [ Mybatis ]				
 	  - jdbc				   - ���� ��������xml�� ����    		
 	  - ����̹�			=====>    
 	  - ip/port/����
 	  
 [ DAO(Repository) ]				   [ Mapper.xml ] 
 - ����ϴ� dao inf ���		====>  - ����ϴ� sql�� ���
*/