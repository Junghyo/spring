package spring.c01_database.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import spring.dto.Dept;
@Repository
public interface A02_DeptRep {
	public ArrayList<Dept> deptList();
	public Dept deptInfo(int deptno);
	public void deptUpdate(Dept upt);
}
