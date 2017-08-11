package spring.c01_database.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import spring.dto.Emp;
import spring.dto.EmpJobMulti;
import spring.dto.EmpMulti;

@Repository
public interface A01_EmpRep {
//	xml�� �ִ� id���� ���� ���� ��Ģ���� mapping
//	id="��Ű����.�������̽���.�޼����
//	id="spring.c01_database.repository.A01_EmpRep.emplist"
//	�����ϴ� data�ִ� VO : Emp sch
//	parameterType="emp"
//	������ ��� ó�� ArrayList<VO>
	public ArrayList<Emp> emplist(Emp sch);

//	return : Emp 	�Է�: empno(int)
	public Emp empInfo(int empno);
//	id : emInfo resultType="emp" parameterType="int"	
	

//  return : void 	�Է� : Emp
	public void empUpdate(Emp upt);
//	id : empUpdate 	parameterType : emp
	
//	ename, job�� ���� ���� ��Ȯ�� ���� ���Ͽ� ������ �ε�ó��
	public ArrayList<Emp> empList02(Emp sch);
	
//	ArrayList ���������� ó��
	public ArrayList<Emp> empMultiList(EmpMulti sch);
	
//	job, deptno ��Ƽ
	public ArrayList<Emp> empMultiList2(EmpJobMulti sch);
}
