package spring.c01_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.c01_database.service.A01_EmpService;
import spring.dto.Emp;
import spring.dto.EmpJobMulti;
import spring.dto.EmpMulti;

@Controller
public class A01_EmpCtrl {
//	
	@Autowired(required=false)
	private A01_EmpService service;	
	@RequestMapping("/emplist_mybatis.do")
	public String empList(Emp sch, Model d){

		d.addAttribute("emplist", service.empList(sch));
		
		return "c01_database/a01_empList_0608";
	}
	
	@RequestMapping("/empdetail_mybatis.do")
	public String empDetail(@RequestParam(value="empno", defaultValue="0") int empno, Model m){
		System.out.println("상세화면 empno: "+empno);
		m.addAttribute("emp", service.empInfo(empno));
		return "c01_database/a01_empDetail_0612";	
	}
	
	@RequestMapping("/emp_upt.do")
	public String empUpdate(Emp upt){
		service.empUpdate(upt);
		return "forward:/empdetail_mybatis.do";
	}
	
	@RequestMapping("/emplist_if.do")
	public String empList02(@ModelAttribute("emp") Emp sch, Model m){
		m.addAttribute("emplist", service.empList02(sch));
		return "c01_database/a04_empList_if_0613";
	}
	@RequestMapping("/empmulti_list.do")
	public String multiList(@ModelAttribute("emp") EmpMulti sch, Model m){
/*		if(sch.getDeptnos()!=null){
			System.out.println("부서번호 입력길이: "+sch.getDeptnos().length);
			for( int deptno : sch.getDeptnos()){
				System.out.println("부서번호 입력값: "+deptno);
			}
		}*/
		m.addAttribute("emplist", service.empMultiList(sch));
		return "c01_database/a05_empMultiList_0613";
		
	}
	
	@RequestMapping("/empmulti_list2.do")
	public String multiList2(@ModelAttribute("emp") EmpJobMulti sch, Model m){
		m.addAttribute("emplist", service.empMultiList2(sch));
		return "c01_database/a06_empMultiList2_0613";
	}
}

/*
 # mybatis MVC 패턴
 	1) Controller
 	2) Service
 	3) Repository(DAO)
 	4) mybatis SQL(*.xml)
 	5) 화면단(*.jsp)
 
 # dispatch-servlet.xml(조립기)
 	1) 연결 : BasicDataSource : dataSource
 		- 드라이버
 		- DB서버 정보(sid, ip, port, 계정, 비밀번호)
 		
 	2) mybatis 설정
 		- 연결 정보를 받아서 mybatis와 설정
 				dataSource ref => dataSource
 		- mybatis 공통 설정 config xml파일 선언
 				configLocation
 				
 	3) Repository(DAO) 설정
 		- MapperScannerConfigurer를 통해서 dao단의 패키지를 선언
 		
 
 # mybatis 공통 설정 config xml
 	1) classpath:resource/mybatis.Spring.xml
 		- classpath:src를 기준으로 잡힘.
 		- resource폴더에 mybatis공통 설정 파일인 mybatis.Spring.xml
 	
 	2) 주로 하는 역할
 		- 모듈별로 실제 처리할 sql 파일(xml)을 등록처리
 				<mapper resource="EmpMapper.xml"/>
 		- 공통VO, DTO 등을 alias로 지정, sql파일에서 활용성을 높이기 위해 간단한 이름으로 설정
 		
 
 # XXXMapper.xml
  	1) mybatis 설정 config.xml에서 모듈별로 sql을 사용할 수 있게끔 처리하는 파일
  		- sql 처리 SELECT * FROM
  		- 인식할 수 있는 id : dao단에서 호출 시 필요
  		- id : hello.CallDAO.callList
  		- 입력관련 데이터 값 처리 parameType = "CallDTO"
  		- return값에 대한 처리 : resultMap = VO가 모인 ArrayList형태
  		- namespace : hello.CallDAO 선언시 id에 namespace부분은 생략가능
  		
  	2) DAO단 interface와 밀접한 연관관계
  		- dao단 interface 패키지명.인터페이스명.메서드명
  				package hello;
  				public interface CallDAO{
  					public ArrayList<VO> callList( CallDTO dto );
  				}	
*/

/*
 SELECT * FROM DEPT 결과물을 처리하는 DAO 만들기
 1) VO : 단위 데이터를 저장할 객체
 	- DEPT
 
 2) DAO단(Repository)
 	- interface DeptDao
 	- 메서드명 deptList
 		public ArrayList<Dept> deptList();
 
 3)	mybatis.Spring.xml
  	- Dept의 alias이름 설정
  	- DeptMapper.xml 생성 및 선언
  	
 4) DeptMapper.xml
 	- namespace 선언
 	- <resultMap id="deptRsMap" type=""
 	- <select id=""
*/

/*
# 개발 process
1) 화면단 구성(.jsp) - css, img, html
2) sql 처리(raw data 확인)
	- ex) SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%'||'HIMAN'||'%' AND JOB LIKE '%'||'SUPERMAN'||'%'
3) DTO, VO, ArrayList<DTO>
	- class Emp{
	  	private int empno;
	  	private String ename;
	  	private String job;
	  }
	  
4) Repository(DAO)
	- public interface Emp_DAO
	  // return 될 값 : ArrayList<Emp>
	  // 조건처리할 값 : public ArrayList<Emp> empList(Emp sch);

5) mybatis.Spring.xml
	- 핵심 DTO, VO 클래스를 alias이름으로 등록
		<typeAlias alias="emp" type="spring.dto.Emp"/>
	- sql을 처리할 XXXmapper.xml 등록
		<mapper resource="resource/EmpMapper.xml"/>
		
6) empMapper.xml 설정
	- repository/dao를 연결할 id
		namespace로 선언 : dao패키지명.인터페이스명
		id : dao인터페이스의 메서드명
	- 입력처리할 dto/vo단 처리
		<select parameterType="emp" ----> mybatis.Spring.xml의 alias값
			WHERE ENAME LIKE '%'||#{ename}||'%'	---> emp.getEname()
	- return할 객체(dto, ArrayList<VO>)
		reusltMap : VO ---> ArrayList
			<resultMap type="한개의 VO객체" id="empMap"/>
			<result column="ename" property="name"/>
				select된 컬럼명은 ename인 것을 setName()으로 할당 및 getName()으로 호출처리된다.
		resultType : VO
		<select resultMap="empMap"

7) Service단에서 처리
	- DAO단 Autowired를 통해서 처리
	- 조건, 반복문 처리
	
8) Controller단에서 처리
	- service 호출
	- model 처리
	- view 선택
	
9) 화면단 마무리
	- 넘겨온 model 데이터 el/jstl 처리
	- javascript/jquery 처리

*/

/*
 # 수정 처리
 1) 리스트 된 데이터 클릭 시, 상세화면으로 전환 처리
	- 초기 화면구성
 	- SQL 작성
 	- DAO 수정 메서드 추가
 	- DB.xml 처리
 	- service단
 	- controller 모델 처리
 
 2) 수정 처리
 	- sql 작성
 	- DAO 수정 처리 메서드 추가
 	
*/

/*
# XML에서 동적 SQL 처리
1) OGNL(Object Graph Navigation Language)
	- ex) <c:if..., <c:forEach...
	- 프로퍼티의 값을 가져오거나 설정하기 위한 언어
	- 웹워크, JSTL 등에서 활용, mybatis
	
2) mybatis가 제공하는 XML 엘리먼트
	- if: 조건처리
	- choose(when, otherwise) : 조건 그 외 처리
	- trim(where, set)
	- foreach : 반복문
*/

/*
# if 엘리먼트
1) 모든 조건에 대해 처리하고 만족하는 조건의 결과를 모두 적용한다
	<select id="selData" parameterType="emp">
	SELECT * FROM EMP
	<if test = "ename!=null">
	WHERE ENAME = #{ename}
	</if>

2) 동적query : 위와 같이 sql구문이 조건에 따라서 변경되는 것을 말한다.
*/

/*
# 기본예제
emp 리스터 데이터 중 ename이나 job 등 해당 데이터가 있을 때 검색이 되고 그렇지 않으면 전체 데이터가 검색이 되는 query문 작성
SELECT * FROM EMP WHERE 1=1 	
<if test="ename!=null">AND ENAME=#{ename}</if>
<if test="job!=null">AND JOB=#{job}</if>

*/

/*
 # choose(when, otherwise)
 1) 조건 지정과 그 외에 대한 처리를 동적인 sql에서 진행할 때 활용된다.
 <select parameterType="emp">
 	SELECT * FROM EMP WHERE
 	<choose>
 		<when test="sal>5000">AND DEPTNO=10</when>
 		<when test="sal>4000">AND DEPTNO=20</when>
 		<when test="sal>1000">AND DEPTNO=30</when>
 		<otherwise>AND DEPTNO=40</otherwise>
 	</choose>
*/

/*
 # trim(where) 엘리먼트
 1) if 엘리먼트가 조건 처리에서 where 구문에 대한 처리를 보완하기 위해 사용한다
 	SELECT * FROM EMP WHERE 1=1 : 구분의 활용하지 않으면
 	<where>
 	<trim prefix="WHERE" prefixOverrides="AND|OR">
 		<if test="ename!=null">ENAME=#{ename}
 		<if test="job!=null">AND JOB=#{job}
*/

/*
 # foreach 엘리먼트
 1) 동적 sql을 loop문으로 반복처리 해야할 경우
 	- 조회조건에서 부서를 여러 개 검색조건으로 처리할 때
 		SELECT * FROM EMP WHERE DEPTNO IN(10, 30, 20);
 		
 2) 속성
 	- collection : 배열의 목록 리스트를 가져옮 ex) jstl items
 	- item : 배열의 목록 단위 ex) jstl의 var
 	- index : 몇 번째 값인지 나타내는 인덱스, 0
 	- open : 목록에 값을 가져와 설정 할 때, 앞에 붙여주는 문자 ex) deptno in(
 	- close : 목록에 값을 가져와 설정 한 후, 마지막에 붙여주는 문자 ex) deptno in (.....)
 	- separator : 목록에 값을 가져와 설정할 때 값들 사이에 붙여주는 문자열 ex) deptno in (10,20,30)
*/

/*
 1) 화면 
 	- 검색할 부서 []10 []20 []30
 		<input type="checkbox" name="deptnos"/>10
 		<input type="checkbox" name="deptnos"/>20
 		<input type="checkbox" name="deptnos"/>30
 2) DTO, VO
 	- private String[] deptnos;
 	- setDeptno(String[]), getDeptno()
 3) forEach를 활용한 동적 sql
 
*/

/*
 # 멀티선택 처리
 	1) forEach를 활용한 동적 sql
 		- SELECT * FROM EMP WHERE 1=1
 		  <if test="deptnos !=null">	==> getDeptnos()가 있어야함
 		  	deptno in
 		  	<foreach collection="deptnos" item="ckdeptno" index="idx" open="(" close=")" seperator=",">
 		  		#{ckdeptno}
 
*/

/*
 job을 멀티선택으로 검색 처리
*/

