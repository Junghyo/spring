/*
 # AOP 예제
 	1. Advice 클래스 선언
 		1) 해당 특정 시점에 처리할 내용을 선언
 		2) ProceedingJoinPoint
 		 	- 수행하는 모듈에 대한 정보를 가지고 옮
 		 	- getSignature() : 객체 정보
 		 	- proceed() : 실제 처리되는 내용
 		 		 * 처리할 프로그래밍 내용르 소스 앞이나 뒤에 선언
 		 		 * ex) 시작 시간과 종료 시간을 해당 메서드를 선언하는 앞 뒤에 처리
 	
 	2. pointcut 지정(조립기수행 시, dispatcher-servlet.xml)
 		- 언제 해당 내용을 수행하느냐?
 		- <aop:config>
 			<aop:aspect ref="advice 클래스 참조변수">
 				<aop:pointcut 
 					* 언제 수행될 것
 					* expression="excution(pulic * springqwb...repository..*(..)"
 						repository 인터페이스가 실제 객체를 할당하여 수행할 때
 				<aop:around : 수행하고 있는 중에 처리
 					* method : 특정한 advice 메서드 수행
 
  # 교차점(pointcut) : target클래스와 advice가 결합될 때 둘 사이의 결합규칙을 정의하는 것
*/
package spring.g01_aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class A01_Profiler {
//	수행할 내용 처리. advice 클래스 메서드
//	특정 프로그램이 처리될 때, log 내용
	public Object trace(ProceedingJoinPoint jointPoint) throws Throwable{
		
//		해당 모듈이 시작하는 시작과 해당 모듈의 정보 출력
		String signatureString = jointPoint.getSignature().toShortString();
		System.out.println(signatureString+"시작!!");

//		현재 시스템 수행 시간을 나타내는 기능메서드(@@@ ###)
		long start = System.currentTimeMillis();
		
		try{
			Object result = jointPoint.proceed();
			return result;
		}finally{
//			끝나는 시작을 처리하여 수행시간을 확인하는 advice만들기
			long end = System.currentTimeMillis();
			System.out.println(signatureString+" 종료!");
			System.out.println(signatureString+" 의 수행시간 : "+(end-start)+"ms");
		}
	}
}

/*
 # spring ajax 처리
 	1) @ResponseBody 활용
 		- json 문자열을 return 받아서 처리
 		- 한글에 관련된 encoding과 decoding 처리
 		- ArrayList<클래스> ==> json 형태 문자열 변환처리
 		- 문자열 사이에 "" ==> + ==> 공백으로 변환처리
 		
 	2) json viewer를 활용
 		- 조립기에 해당 viewer를 등록
 		- MappingJacksonJsonView를 등록하고
 			property : contentType
 				text/html:charset=UTF-8
*/

/*
 # ResponseBody 활용
 1) view(.jsp)
 	- $("form").serialize();
 		* form에 속해 있는 내용의 속성을 ajax통신에 전달처리하는 형식인 jquery string(id=@@@&pass=@@@)으로 변환해준다.
 	- dataType:"json"
 	- success
 		한글은 decoding처리
 
 2) Controller
 	- @RequestMapping : 요청값으로 공백이 들어오면 "+" ==>""
 	- @ResponseBody : 호출하는 부분이 문자열인 json을 전달 처리
 	- return "[{id:".pass"}]"
 
 3) Service
  	- DB ArrayList ==> json
  		JSONArray.JSONObject
*/