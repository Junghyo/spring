package board.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import board.vo.Board;
import board.vo.Board_Search;

@Repository
public interface A01_BoardDAO {
	public void insertBoard(Board ins);
	public ArrayList<Board> listBoard(Board_Search sch);
	public Board getBoard(int no);
//	��ȭ�� ��ȸ�� ������Ʈ +1
	public void updateCount(int no);
//	�� �Ǽ�
	public int countBoard(Board_Search sch);	
}
