package spring.c01_database.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import spring.dto.Member1;

@Repository
public interface A03_MembersRep {
	public ArrayList<Member1> memList(Member1 sch);
	public Member1 memInfo(String id);
	public void memUpdate(Member1 upt);
}
