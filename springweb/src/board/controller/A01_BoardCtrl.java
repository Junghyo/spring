/*
 # �ֿ���
 1) �ʱ� �� ����Ʈ ȭ��
 	- �亯�� ��������
 	- ����¡ ó��
 2) ���ȭ��
 	- ÷������
 3) ��ȭ��
 	- ����, ����
------------------------------------------	
 # ���� ����
 1) ȭ�� ui ���� �� ���μ��� ����
 	- �ʱ�ȭ��(HTML, CSS)
 2) DB ����
 	- ERD, table ����
 3) �� ȭ��ܿ� Ȱ���� sql ����
 	- ������ sql ����(�亯ó��)
 4) �� sql�� ���εǴ� VO, DTO Ŭ���� ����

------------------------------------------- 
 # �ʱ�ȭ�� ����
 1) Controller
 	- ���� RequestMapping�� Ŭ������ ���� ����
 	- �� ��ɺ� �޼��忡 params="method=list";
 2) View��
 	- �˻��׸�
 		����, �ۼ���, ����
 	- list �׸�
 		��ȣ, ����, �ۼ���, �ۼ���

-------------------------------------------
 # DB ����
 1) ������ ������ list
 	- num(Ű), ����, ����, �н�����, �ۼ���, ��ȸ��, �����, �̸���
 	- ÷������ ���̺� : num(Ű), ���ϸ�, ������
 2) sequence : board_seq
 CREATE TABLE BOARD(
	NO NUMBER PRIMARY KEY,
	REFNO NUMBER,
	SUBJECT VARCHAR2(100),
	CONTENT VARCHAR2(1000),
	PWD VARCHAR2(30),
	WRITER VARCHAR2(50),
	READCOUNT NUMBER,
	REGDATE DATE,
	EMAIL VARCHAR2(100)
);
CREATE SEQUENCE BOARD_SEQ
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 9999999
	MINVALUE 1
	NOCYCLE
	CACHE 20;

*/
/*
 # �Խù� ���
 1) ���μ���
  	- ����ȭ�鿡�� ��Ϲ�ư Ŭ��
  	- ���ȭ�� : ����, ����, �н�����, �̸��� ==> ���ó��
  	- ����ȭ�鿡�� ��ϵ� list Ȯ��
 
 2) ���� ����
 	- �ʱ� �� ȭ�� ����
 	- DB sql �ۼ� 
 	- DTO ���� ���� ����
 	- DAO(Repository) 
 	- ȭ�� ���� : DTO(property)����Ǵ� name �κ�
 	- Controller����ó�� Service, DAO
 
------------------------------------------------------
 # �ʱ� ȭ�� ����
 1) main���� �����ϴ� ���ȭ�� Controller�� ����Ǿ� ó���� �� �ֵ���
 2) sql����
 	- INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '�Խ��ǵ��', 'HELLO WORLD', '1111', 'ȣ����', 0, SYSDATE, 'ronaldo@gmail.com');
 3) DTO ���� ���� ����
 4) DAO(Repository)
 	- �Է� : Board return : void
 	- package ��� ���� Ȯ��
*/

/*
 # ��� ó�� ���μ���
 	1) ���� ȭ��
 	2) �ش� ���� ���� Ŭ�� ��, ��ȭ�� �̵�
 	3) ��ȭ��
 		- Controller-view(jsp) : ȭ�� ����
 		- �𵨵����� : ���� ������ �ε�(DAO, mybatis xml,)
 		- ��� �ޱ�, ����ó��, ����
 		- ��� �޴���ư Ŭ���� ó���ؾ��� ȭ�� DB
 			submit�� key��, no����
 			DB : ���� �����ͷε�(service) : ���� => RE: ÷��, ���� : ���� ����
 	4) ���ȭ��
 		- RE : ���� �� ����
 		- ���� : ���� �� ����
 		- ��۵�� ��ư Ŭ���� ����� ���ó��. ����ȭ�鿡 ó��
 		
---------------------------------------------------------------------------
 # ��� ��Ͻ�, �������� no�� refno�� �ű� ��ۿ� ��� ó��
 	1) ȭ���
 		- <input name="refno" value="${board.refno}"
 		- �� �� �����͸� ������ ��, Service getNo() ===> setRefno()�� �Ҵ�
 	2) BoardMapper.xml
 		- insertBoard���� insert into board values(board_seq.nextval, #{refno}, ...
---------------------------------------------------------------------------
 # main ��ȸ list ȭ�� ������ sql �����
 	1) BoardMapper.xml
 		- START WITH REFNO=0
 			CONNECT BY PRIOR NO=REFNO
 	2) ������ sql���� �������� ��Ű�鼭 ������ ���ϴ� ó��(����ó��)
 		ORDER BY SILBLINGS BY NO DESC
--------------------------------------------------------------------------
 # ����ȭ�� numbering ó��
 	1) ���� ��ȸ��, count�ǰ� ó��
 		- ��ȭ�鿡���� �� ���� ��ȣ Ȯ��
 	2) ��ȸ�� �ۼ�  : @@@
 	3) ó�� : sql���� ��ȸ�� ��ŭ numbering ó��
--------------------------------------------------------------------------
 # ÷������ ���
 	1) ����� ó�� ���μ���
 		- �Խ��� ��� ȭ�鿡�� ���� ÷������ ���
 	2) ���α׷� ó�� ���μ���
 		- DB ����		
 	3) �Խ��� ��� ȭ�� ó��
 		- <form �Ӽ� enctype="multipart/form-data">
 			<input type="name"
 			<input type="file"
-------------------------------------------------------------------------
 # spring ÷�� ���� �ʿ� �κ�
 	1) ������ ���ε�/�ٿ�ε� �ϴ� viewResolve setting�� �ʿ�
 		- dispatcher-servlet.xml�� ���� �ٿ�ε�, ���ε� ��� ����
 		- ���� ���ε� ���
 			<bean id="" class="org.springframework.web.multipart.commons.CommonMultipartResolver"/>
 		- ���� �ٿ�ε� ���
 			����� ���Ƿ� Ŭ���� ����
 			<bean class="springweb.z01_util.A03.DownloadViewResolver"
 			json�̳� ����ó���� �ʿ�� �ϴ� viewResolver ����
 			<bean id="bnViewResolver" class="org.springframework.web.servlet.BeanNameViewResolver"
 				<property name="order" value="0"/> �ֿ켱
 			<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value=""/>
				<property name="suffix" value=".jsp"/> 
				<property name="order" value="1"/>
	2) ÷������ ó���� Ctrl/server
		- Controller���� Param
			view��
				<input name="id"/>
				<input type="file" name="report"/>
			controller
				list( @RequestParam("id") String id
				list( @RequestPARAM("report") MultipartFile report
		- MultipartFile�� ������ ����, DB����
			getOriginalFilename() : ���ε� ���ϸ�
			transferTo("������ ��� ���ϰ�ü")
			FileInputStream, FileOutStream�� ���ؼ� ��Ʈ�p�� ���ؼ� ���޹��� ������ ������ Ư���� ��ġ�� ����
			DB�� getOrigianlFilename()�� DB insert
--------------------------------------------------------------------------------------
*/
/*
 # ��� ȭ��� ������ ǥ��
 	1) sql
 		- ������ sql�� level : ������ sql�� �ܰ踦 ó���� �� �ִ�.
 	
 	2) vo/dto
 		- level�� mapping�Ǵ� propertyǥ��
 	
 	3) ȭ��(jsp)
 		- �ش��ϴ� level��ŭ ����ó��
 		- ����̶�� ǥ��
----------------------------------------------------------------------
 
 # Paging
 	1. DB SQL
 		- rownum : sql�� ���ؼ� �����͸� numbering�ϴ� oracle Ű����
 		- ���۹�ȣ�� ��������ȣ�� ���ؼ� �ش��������� ó�� �ǰ� �Ѵ�.
 		- where rownum between #{start} and #{end}
 		- sub query�� ���ؼ� �ش� rownum�� ������ ó���� �� �ִ�.
 		- �ѰǼ��� ���� sql ó�� : select count(*) cnt from board
 	
 	2. DAO��(Repository)
 		1) �ѰǼ��� �������� �޼��� �߰�
 		2) page ó���� ���ؼ� �ʿ�� �ϴ� property��(Board_sch�� �߰��� ����)
 			- �ѰǼ� : count <DB>
 			- �� ȭ�鿡 ���� �� ������ �Ǽ� : pageSize <ȭ��>
 			- �� �������� : pageCount <service>
 			- Ŭ���� ���� page ��ȣ : curPage <ȭ��>
 			- �ش� �������� ���� ��ȣ : start <service>
 			- �ش� �������� ������ ��ȣ : end <service>
---------------------------------------------------------------------------

 # Paging ó��(ȭ��)
 	1) pageSize : <select name = "pageSize">
 	2) curPage
 		- <a href="">[1][2][3]
 		- <input type="hidden" name="curPage"
 
---------------------------------------------------------------------------
 # Paging ó��(Service��)
 	1) �� ������ �Ǽ�
 		- cnt.setCount(dao.countBoard(cnt));
 	
 	2) �� �������� ��Ÿ�� ������ �Ǽ�
 		- �ʱ�ȭ���� ���Ͽ� default �� setting
 			if(cnt.getPageSize()==0){
 				cnt.setPageSize(5)
 			}
 			
 		- �� �������� : [1][2][3][4]...
 			�ѵ����ͰǼ�/���������� ��Ÿ�� ������ �Ǽ�
 				Math.ceil((double)...)
 				
 		- ���� Ŭ���� page��ȣ
 			�ʱⰪ
 			if(cnt.getCurPage==0){
 				cnt.setCurpage(1)
 			}
 			
 		- ���۹�ȣ, ��������ȣ
 			���۹�ȣ : (������������ȣ-1)*�ѹ��� ������ ������+1
 			��������ȣ : ���� Ŭ���� ������ ��ȣ * �ѹ��� ������ �������� ũ��
*/

package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import board.service.A01_BoardService;
import board.vo.Board;
import board.vo.Board_Search;

@Controller
@RequestMapping("/boardex.do")
@SessionAttributes("boardSch")
public class A01_BoardCtrl {
	@Autowired(required=false)
	private A01_BoardService service;
	@ModelAttribute("boardSch")
	public Board_Search Board_Search(){
		return new Board_Search();
	}
//	�Խ��� list
//	http://localhost:7080/spring_web/boardList.do?method=list
	@RequestMapping(params="method=list")
	public String listBoard(@ModelAttribute("boardSch") Board_Search sch, Model m){
		m.addAttribute("boardList", service.listBoard(sch));
		return "d01_board/a01_boardList";
	}
	// ���ȭ�� ȣ��. boardList.do?method=insert
	@RequestMapping(params="method=insert")
	public String insert(@RequestParam(value="no", defaultValue="0") int no, Model m){
		System.out.println("no:"+no);
		m.addAttribute("board", service.getReBoard(no));
		return "d01_board/a02_insertBoard";
	}
	
	@RequestMapping(params="method=insProc")
	public String insertProc(Board ins){
		service.insertBoard(ins);
//		��� ��, ���� ��ȸȭ������ ó��		
		return "redirect:/boardex.do?method=list";
	}
	
	@RequestMapping(params="method=detail")
	public String detail(@RequestParam("no") int no, Model m){
		System.out.println("no: "+no);
		m.addAttribute("board", service.detailBoard(no));
		return "d01_board/a03_detailBoard";
	}
}

