package board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.repository.A01_BoardDAO;
import board.vo.Board;
import board.vo.Board_Search;

@Service
public class A01_BoardService {
	@Autowired(required=false)
	private A01_BoardDAO dao;
	public void insertBoard(Board ins) {
		dao.insertBoard(ins);
	}
	public ArrayList<Board> listBoard(Board_Search sch){
//		�� ������ �Ǽ�
		sch.setCount(dao.countBoard(sch));

//		�� ���������� ��Ÿ�� ������ �Ǽ�. �ʱ� 0 ==> 5
		if(sch.getPageSize() == 0) sch.setPageSize(5);

//		�� ������ �� : [1] [2] [3] [4] [5] �� ������ �Ǽ�/ �������� ��Ÿ�� ������ �Ǽ�
//		20 --> 4page 23---> 5page�� ó���� ���� �ø� ó��
		sch.setPageCount((int) Math.ceil(sch.getCount()/(double)sch.getPageSize()));
		
//		���� Ŭ���� page ��ȣ. �ʱ� 0 ==> 1
		if(sch.getCurPage() == 0) sch.setCurPage(1);
		
//		���۹�ȣ
		sch.setStart((sch.getCurPage()-1)*(sch.getPageSize())+1);
		
//		��������ȣ
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		return dao.listBoard(sch);
	}
	public Board getBoard(int no){
		return dao.getBoard(no);
	}
//	��ȭ�� ȣ���, ��ȸ���� update, �ϳ��� �����͸� �������� ó��.	
	public Board detailBoard(int no){
//		readCount�� update ó��
		dao.updateCount(no);
//		�ϳ��� �����͸� ������ �κ�
		return dao.getBoard(no);
	}
	public Board getReBoard(int no){
		Board reboard = null;
		if(no==0){
			reboard = new Board();
		}else{
			reboard = dao.getBoard(no);
//		��ۿ� refno������ �������� no���� �Ҵ��Ͽ�
//		����� ��Ͻ�, refno�� ���� �ֵ��� ó��
			reboard.setRefno(no);
			reboard.setSubject("RE: "+reboard.getSubject());
			reboard.setContent("\n\n\n\n====��������===\n"+reboard.getContent());
		}
		return reboard;
	}
	
}
