package spring.c01_database.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.c01_database.repository.A01_EmpRep;
import spring.dto.Emp;
import spring.dto.EmpJobMulti;
import spring.dto.EmpMulti;

@Service
public class A01_EmpService {
	@Autowired(required=false)
	private A01_EmpRep dao;
	
	public ArrayList<Emp> empList(Emp sch){
		if(sch.getEname()==null){
			sch.setEname("");
		}
		return dao.emplist(sch);
	}
	
	public Emp empInfo(int empno){
		return dao.empInfo(empno);
	}
	
	public void empUpdate(Emp upt){
		dao.empUpdate(upt);
	}
	
	public ArrayList<Emp> empList02(Emp sch){
		return dao.empList02(sch);
	}
	public ArrayList<Emp> empMultiList(EmpMulti sch){
		return dao.empMultiList(sch);		
	}
	
	public ArrayList<Emp> empMultiList2(EmpJobMulti sch){
		return dao.empMultiList2(sch);
	}
}
