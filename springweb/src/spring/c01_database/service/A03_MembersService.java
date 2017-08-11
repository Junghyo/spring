package spring.c01_database.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.c01_database.repository.A03_MembersRep;
import spring.dto.Member1;

@Service
public class A03_MembersService {
	@Autowired(required=false)
	private A03_MembersRep dao;
	public ArrayList<Member1> memList(Member1 sch){
		if(sch.getId()==null){
			sch.setId("");
		}
		return dao.memList(sch);
	}
	
	public Member1 memInfo(String id){
		return dao.memInfo(id);
	}
	
	public void MemUpdate(Member1 upt){
		dao.memUpdate(upt);
	}
}
