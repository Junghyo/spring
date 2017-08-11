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
		System.out.println("��ȭ�� empno: "+empno);
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
			System.out.println("�μ���ȣ �Է±���: "+sch.getDeptnos().length);
			for( int deptno : sch.getDeptnos()){
				System.out.println("�μ���ȣ �Է°�: "+deptno);
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
 # mybatis MVC ����
 	1) Controller
 	2) Service
 	3) Repository(DAO)
 	4) mybatis SQL(*.xml)
 	5) ȭ���(*.jsp)
 
 # dispatch-servlet.xml(������)
 	1) ���� : BasicDataSource : dataSource
 		- ����̹�
 		- DB���� ����(sid, ip, port, ����, ��й�ȣ)
 		
 	2) mybatis ����
 		- ���� ������ �޾Ƽ� mybatis�� ����
 				dataSource ref => dataSource
 		- mybatis ���� ���� config xml���� ����
 				configLocation
 				
 	3) Repository(DAO) ����
 		- MapperScannerConfigurer�� ���ؼ� dao���� ��Ű���� ����
 		
 
 # mybatis ���� ���� config xml
 	1) classpath:resource/mybatis.Spring.xml
 		- classpath:src�� �������� ����.
 		- resource������ mybatis���� ���� ������ mybatis.Spring.xml
 	
 	2) �ַ� �ϴ� ����
 		- ��⺰�� ���� ó���� sql ����(xml)�� ���ó��
 				<mapper resource="EmpMapper.xml"/>
 		- ����VO, DTO ���� alias�� ����, sql���Ͽ��� Ȱ�뼺�� ���̱� ���� ������ �̸����� ����
 		
 
 # XXXMapper.xml
  	1) mybatis ���� config.xml���� ��⺰�� sql�� ����� �� �ְԲ� ó���ϴ� ����
  		- sql ó�� SELECT * FROM
  		- �ν��� �� �ִ� id : dao�ܿ��� ȣ�� �� �ʿ�
  		- id : hello.CallDAO.callList
  		- �Է°��� ������ �� ó�� parameType = "CallDTO"
  		- return���� ���� ó�� : resultMap = VO�� ���� ArrayList����
  		- namespace : hello.CallDAO ����� id�� namespace�κ��� ��������
  		
  	2) DAO�� interface�� ������ ��������
  		- dao�� interface ��Ű����.�������̽���.�޼����
  				package hello;
  				public interface CallDAO{
  					public ArrayList<VO> callList( CallDTO dto );
  				}	
*/

/*
 SELECT * FROM DEPT ������� ó���ϴ� DAO �����
 1) VO : ���� �����͸� ������ ��ü
 	- DEPT
 
 2) DAO��(Repository)
 	- interface DeptDao
 	- �޼���� deptList
 		public ArrayList<Dept> deptList();
 
 3)	mybatis.Spring.xml
  	- Dept�� alias�̸� ����
  	- DeptMapper.xml ���� �� ����
  	
 4) DeptMapper.xml
 	- namespace ����
 	- <resultMap id="deptRsMap" type=""
 	- <select id=""
*/

/*
# ���� process
1) ȭ��� ����(.jsp) - css, img, html
2) sql ó��(raw data Ȯ��)
	- ex) SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%'||'HIMAN'||'%' AND JOB LIKE '%'||'SUPERMAN'||'%'
3) DTO, VO, ArrayList<DTO>
	- class Emp{
	  	private int empno;
	  	private String ename;
	  	private String job;
	  }
	  
4) Repository(DAO)
	- public interface Emp_DAO
	  // return �� �� : ArrayList<Emp>
	  // ����ó���� �� : public ArrayList<Emp> empList(Emp sch);

5) mybatis.Spring.xml
	- �ٽ� DTO, VO Ŭ������ alias�̸����� ���
		<typeAlias alias="emp" type="spring.dto.Emp"/>
	- sql�� ó���� XXXmapper.xml ���
		<mapper resource="resource/EmpMapper.xml"/>
		
6) empMapper.xml ����
	- repository/dao�� ������ id
		namespace�� ���� : dao��Ű����.�������̽���
		id : dao�������̽��� �޼����
	- �Է�ó���� dto/vo�� ó��
		<select parameterType="emp" ----> mybatis.Spring.xml�� alias��
			WHERE ENAME LIKE '%'||#{ename}||'%'	---> emp.getEname()
	- return�� ��ü(dto, ArrayList<VO>)
		reusltMap : VO ---> ArrayList
			<resultMap type="�Ѱ��� VO��ü" id="empMap"/>
			<result column="ename" property="name"/>
				select�� �÷����� ename�� ���� setName()���� �Ҵ� �� getName()���� ȣ��ó���ȴ�.
		resultType : VO
		<select resultMap="empMap"

7) Service�ܿ��� ó��
	- DAO�� Autowired�� ���ؼ� ó��
	- ����, �ݺ��� ó��
	
8) Controller�ܿ��� ó��
	- service ȣ��
	- model ó��
	- view ����
	
9) ȭ��� ������
	- �Ѱܿ� model ������ el/jstl ó��
	- javascript/jquery ó��

*/

/*
 # ���� ó��
 1) ����Ʈ �� ������ Ŭ�� ��, ��ȭ������ ��ȯ ó��
	- �ʱ� ȭ�鱸��
 	- SQL �ۼ�
 	- DAO ���� �޼��� �߰�
 	- DB.xml ó��
 	- service��
 	- controller �� ó��
 
 2) ���� ó��
 	- sql �ۼ�
 	- DAO ���� ó�� �޼��� �߰�
 	
*/

/*
# XML���� ���� SQL ó��
1) OGNL(Object Graph Navigation Language)
	- ex) <c:if..., <c:forEach...
	- ������Ƽ�� ���� �������ų� �����ϱ� ���� ���
	- ����ũ, JSTL ��� Ȱ��, mybatis
	
2) mybatis�� �����ϴ� XML ������Ʈ
	- if: ����ó��
	- choose(when, otherwise) : ���� �� �� ó��
	- trim(where, set)
	- foreach : �ݺ���
*/

/*
# if ������Ʈ
1) ��� ���ǿ� ���� ó���ϰ� �����ϴ� ������ ����� ��� �����Ѵ�
	<select id="selData" parameterType="emp">
	SELECT * FROM EMP
	<if test = "ename!=null">
	WHERE ENAME = #{ename}
	</if>

2) ����query : ���� ���� sql������ ���ǿ� ���� ����Ǵ� ���� ���Ѵ�.
*/

/*
# �⺻����
emp ������ ������ �� ename�̳� job �� �ش� �����Ͱ� ���� �� �˻��� �ǰ� �׷��� ������ ��ü �����Ͱ� �˻��� �Ǵ� query�� �ۼ�
SELECT * FROM EMP WHERE 1=1 	
<if test="ename!=null">AND ENAME=#{ename}</if>
<if test="job!=null">AND JOB=#{job}</if>

*/

/*
 # choose(when, otherwise)
 1) ���� ������ �� �ܿ� ���� ó���� ������ sql���� ������ �� Ȱ��ȴ�.
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
 # trim(where) ������Ʈ
 1) if ������Ʈ�� ���� ó������ where ������ ���� ó���� �����ϱ� ���� ����Ѵ�
 	SELECT * FROM EMP WHERE 1=1 : ������ Ȱ������ ������
 	<where>
 	<trim prefix="WHERE" prefixOverrides="AND|OR">
 		<if test="ename!=null">ENAME=#{ename}
 		<if test="job!=null">AND JOB=#{job}
*/

/*
 # foreach ������Ʈ
 1) ���� sql�� loop������ �ݺ�ó�� �ؾ��� ���
 	- ��ȸ���ǿ��� �μ��� ���� �� �˻��������� ó���� ��
 		SELECT * FROM EMP WHERE DEPTNO IN(10, 30, 20);
 		
 2) �Ӽ�
 	- collection : �迭�� ��� ����Ʈ�� ������ ex) jstl items
 	- item : �迭�� ��� ���� ex) jstl�� var
 	- index : �� ��° ������ ��Ÿ���� �ε���, 0
 	- open : ��Ͽ� ���� ������ ���� �� ��, �տ� �ٿ��ִ� ���� ex) deptno in(
 	- close : ��Ͽ� ���� ������ ���� �� ��, �������� �ٿ��ִ� ���� ex) deptno in (.....)
 	- separator : ��Ͽ� ���� ������ ������ �� ���� ���̿� �ٿ��ִ� ���ڿ� ex) deptno in (10,20,30)
*/

/*
 1) ȭ�� 
 	- �˻��� �μ� []10 []20 []30
 		<input type="checkbox" name="deptnos"/>10
 		<input type="checkbox" name="deptnos"/>20
 		<input type="checkbox" name="deptnos"/>30
 2) DTO, VO
 	- private String[] deptnos;
 	- setDeptno(String[]), getDeptno()
 3) forEach�� Ȱ���� ���� sql
 
*/

/*
 # ��Ƽ���� ó��
 	1) forEach�� Ȱ���� ���� sql
 		- SELECT * FROM EMP WHERE 1=1
 		  <if test="deptnos !=null">	==> getDeptnos()�� �־����
 		  	deptno in
 		  	<foreach collection="deptnos" item="ckdeptno" index="idx" open="(" close=")" seperator=",">
 		  		#{ckdeptno}
 
*/

/*
 job�� ��Ƽ�������� �˻� ó��
*/

