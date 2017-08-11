package spring.c01_database.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.c01_database.repository.A02_DeptRep;
import spring.dto.Dept;

@Service
public class A02_DeptService {
	@Autowired(required=false)
	private A02_DeptRep dao;
	public ArrayList<Dept> deptList(){
		return dao.deptList();
	}
	public Dept deptInfo(int deptno){
		return dao.deptInfo(deptno);
	}
	public void deptUpdate(Dept upt){
		dao.deptUpdate(upt);
	}
}
