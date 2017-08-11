package spring.c01_database.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import spring.dto.Emp;
import spring.dto.EmpJobMulti;
import spring.dto.EmpMulti;

@Repository
public interface A01_EmpRep {
//	xml에 있는 id값과 다음 같은 규칙으로 mapping
//	id="패키지명.인터페이스명.메서드명
//	id="spring.c01_database.repository.A01_EmpRep.emplist"
//	전달하는 data있는 VO : Emp sch
//	parameterType="emp"
//	데이터 결과 처리 ArrayList<VO>
	public ArrayList<Emp> emplist(Emp sch);

//	return : Emp 	입력: empno(int)
	public Emp empInfo(int empno);
//	id : emInfo resultType="emp" parameterType="int"	
	

//  return : void 	입력 : Emp
	public void empUpdate(Emp upt);
//	id : empUpdate 	parameterType : emp
	
//	ename, job이 있을 때에 정확한 값을 비교하여 데이터 로딩처리
	public ArrayList<Emp> empList02(Emp sch);
	
//	ArrayList 동적데이터 처리
	public ArrayList<Emp> empMultiList(EmpMulti sch);
	
//	job, deptno 멀티
	public ArrayList<Emp> empMultiList2(EmpJobMulti sch);
}
