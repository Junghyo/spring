/*
 # AOP ����
 	1. Advice Ŭ���� ����
 		1) �ش� Ư�� ������ ó���� ������ ����
 		2) ProceedingJoinPoint
 		 	- �����ϴ� ��⿡ ���� ������ ������ ��
 		 	- getSignature() : ��ü ����
 		 	- proceed() : ���� ó���Ǵ� ����
 		 		 * ó���� ���α׷��� ���븣 �ҽ� ���̳� �ڿ� ����
 		 		 * ex) ���� �ð��� ���� �ð��� �ش� �޼��带 �����ϴ� �� �ڿ� ó��
 	
 	2. pointcut ����(��������� ��, dispatcher-servlet.xml)
 		- ���� �ش� ������ �����ϴ���?
 		- <aop:config>
 			<aop:aspect ref="advice Ŭ���� ��������">
 				<aop:pointcut 
 					* ���� ����� ��
 					* expression="excution(pulic * springqwb...repository..*(..)"
 						repository �������̽��� ���� ��ü�� �Ҵ��Ͽ� ������ ��
 				<aop:around : �����ϰ� �ִ� �߿� ó��
 					* method : Ư���� advice �޼��� ����
 
  # ������(pointcut) : targetŬ������ advice�� ���յ� �� �� ������ ���ձ�Ģ�� �����ϴ� ��
*/
package spring.g01_aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class A01_Profiler {
//	������ ���� ó��. advice Ŭ���� �޼���
//	Ư�� ���α׷��� ó���� ��, log ����
	public Object trace(ProceedingJoinPoint jointPoint) throws Throwable{
		
//		�ش� ����� �����ϴ� ���۰� �ش� ����� ���� ���
		String signatureString = jointPoint.getSignature().toShortString();
		System.out.println(signatureString+"����!!");

//		���� �ý��� ���� �ð��� ��Ÿ���� ��ɸ޼���(@@@ ###)
		long start = System.currentTimeMillis();
		
		try{
			Object result = jointPoint.proceed();
			return result;
		}finally{
//			������ ������ ó���Ͽ� ����ð��� Ȯ���ϴ� advice�����
			long end = System.currentTimeMillis();
			System.out.println(signatureString+" ����!");
			System.out.println(signatureString+" �� ����ð� : "+(end-start)+"ms");
		}
	}
}

/*
 # spring ajax ó��
 	1) @ResponseBody Ȱ��
 		- json ���ڿ��� return �޾Ƽ� ó��
 		- �ѱۿ� ���õ� encoding�� decoding ó��
 		- ArrayList<Ŭ����> ==> json ���� ���ڿ� ��ȯó��
 		- ���ڿ� ���̿� "" ==> + ==> �������� ��ȯó��
 		
 	2) json viewer�� Ȱ��
 		- �����⿡ �ش� viewer�� ���
 		- MappingJacksonJsonView�� ����ϰ�
 			property : contentType
 				text/html:charset=UTF-8
*/

/*
 # ResponseBody Ȱ��
 1) view(.jsp)
 	- $("form").serialize();
 		* form�� ���� �ִ� ������ �Ӽ��� ajax��ſ� ����ó���ϴ� ������ jquery string(id=@@@&pass=@@@)���� ��ȯ���ش�.
 	- dataType:"json"
 	- success
 		�ѱ��� decodingó��
 
 2) Controller
 	- @RequestMapping : ��û������ ������ ������ "+" ==>""
 	- @ResponseBody : ȣ���ϴ� �κ��� ���ڿ��� json�� ���� ó��
 	- return "[{id:".pass"}]"
 
 3) Service
  	- DB ArrayList ==> json
  		JSONArray.JSONObject
*/