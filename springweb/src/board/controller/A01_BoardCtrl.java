/*
 # 주요기능
 1) 초기 글 리스트 화면
 	- 답변형 계층구조
 	- 페이징 처리
 2) 등록화면
 	- 첨부파일
 3) 상세화면
 	- 수정, 삭제
------------------------------------------	
 # 구현 순서
 1) 화면 ui 결정 및 프로세스 결정
 	- 초기화면(HTML, CSS)
 2) DB 설계
 	- ERD, table 생성
 3) 각 화면단에 활용할 sql 구현
 	- 계층형 sql 구현(답변처리)
 4) 위 sql에 매핑되는 VO, DTO 클래스 구현

------------------------------------------- 
 # 초기화면 구현
 1) Controller
 	- 공통 RequestMapping을 클래스명 위에 선언
 	- 각 기능별 메서드에 params="method=list";
 2) View단
 	- 검색항목
 		제목, 작성자, 내용
 	- list 항목
 		번호, 제목, 작성자, 작성일

-------------------------------------------
 # DB 설계
 1) 관리할 데이터 list
 	- num(키), 제목, 내용, 패스워드, 작성자, 조회수, 등록일, 이메일
 	- 첨부파일 테이블 : num(키), 파일명, 생성일
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
 # 게시물 등록
 1) 프로세스
  	- 메인화면에서 등록버튼 클릭
  	- 등록화면 : 제목, 내용, 패스워드, 이메일 ==> 등록처리
  	- 메인화면에서 등록된 list 확인
 
 2) 개발 순서
 	- 초기 웹 화면 구성
 	- DB sql 작성 
 	- DTO 구성 내지 선택
 	- DAO(Repository) 
 	- 화면 구성 : DTO(property)연결되는 name 부분
 	- Controller연결처리 Service, DAO
 
------------------------------------------------------
 # 초기 화면 구성
 1) main에서 연결하는 등록화면 Controller로 연계되어 처리될 수 있도록
 2) sql구현
 	- INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '게시판등록', 'HELLO WORLD', '1111', '호날두', 0, SYSDATE, 'ronaldo@gmail.com');
 3) DTO 구성 내지 선택
 4) DAO(Repository)
 	- 입력 : Board return : void
 	- package 등록 여부 확인
*/

/*
 # 답글 처리 프로세서
 	1) 메인 화면
 	2) 해당 글을 더블 클릭 시, 상세화면 이동
 	3) 상세화면
 		- Controller-view(jsp) : 화면 구성
 		- 모델데이터 : 단일 데이터 로딩(DAO, mybatis xml,)
 		- 답글 달기, 수정처리, 삭제
 		- 답글 메뉴버튼 클릭시 처리해야할 화면 DB
 			submit로 key값, no전달
 			DB : 단일 데이터로딩(service) : 제목 => RE: 첨부, 내용 : 이전 내용
 	4) 답글화면
 		- RE : 메인 글 제목
 		- 내용 : 기존 글 내용
 		- 답글등록 버튼 클릭시 답글이 등록처리. 메인화면에 처리
 		
---------------------------------------------------------------------------
 # 답글 등록시, 기존글의 no가 refno로 신규 답글에 등록 처리
 	1) 화면단
 		- <input name="refno" value="${board.refno}"
 		- 답 글 데이터를 가져올 때, Service getNo() ===> setRefno()로 할당
 	2) BoardMapper.xml
 		- insertBoard에서 insert into board values(board_seq.nextval, #{refno}, ...
---------------------------------------------------------------------------
 # main 조회 list 화면 계층형 sql 만들기
 	1) BoardMapper.xml
 		- START WITH REFNO=0
 			CONNECT BY PRIOR NO=REFNO
 	2) 계층형 sql에서 계층형도 지키면서 순위를 정하는 처리(정렬처리)
 		ORDER BY SILBLINGS BY NO DESC
--------------------------------------------------------------------------
 # 메인화면 numbering 처리
 	1) 글을 조회시, count되게 처리
 		- 상세화면에서만 글 고유 번호 확인
 	2) 조회된 글수  : @@@
 	3) 처리 : sql에서 조회된 만큼 numbering 처리
--------------------------------------------------------------------------
 # 첨부파일 등록
 	1) 사용자 처리 프로세스
 		- 게시판 등록 화면에서 여러 첨부파일 등록
 	2) 프로그램 처리 프로세스
 		- DB 설계		
 	3) 게시판 등록 화면 처리
 		- <form 속성 enctype="multipart/form-data">
 			<input type="name"
 			<input type="file"
-------------------------------------------------------------------------
 # spring 첨부 파일 필요 부분
 	1) 파일을 업로드/다운로드 하는 viewResolve setting이 필요
 		- dispatcher-servlet.xml에 파일 다운로드, 업로드 모듈 설정
 		- 파일 업로드 모듈
 			<bean id="" class="org.springframework.web.multipart.commons.CommonMultipartResolver"/>
 		- 파일 다운로드 모듈
 			사용자 정의로 클래스 선언
 			<bean class="springweb.z01_util.A03.DownloadViewResolver"
 			json이나 파일처리시 필요로 하는 viewResolver 선언
 			<bean id="bnViewResolver" class="org.springframework.web.servlet.BeanNameViewResolver"
 				<property name="order" value="0"/> 최우선
 			<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<property name="prefix" value=""/>
				<property name="suffix" value=".jsp"/> 
				<property name="order" value="1"/>
	2) 첨부파일 처리시 Ctrl/server
		- Controller에서 Param
			view단
				<input name="id"/>
				<input type="file" name="report"/>
			controller
				list( @RequestParam("id") String id
				list( @RequestPARAM("report") MultipartFile report
		- MultipartFile를 물리적 저장, DB저장
			getOriginalFilename() : 업로드 파일명
			transferTo("저장할 경로 파일객체")
			FileInputStream, FileOutStream을 통해서 네트웤을 통해서 전달받은 파일을 서버에 특정한 위치로 저장
			DB에 getOrigianlFilename()로 DB insert
--------------------------------------------------------------------------------------
*/
/*
 # 답글 화면단 계층형 표시
 	1) sql
 		- 계층형 sql에 level : 계층형 sql의 단계를 처리할 수 있다.
 	
 	2) vo/dto
 		- level과 mapping되는 property표시
 	
 	3) 화면(jsp)
 		- 해당하는 level만큼 공백처리
 		- 답글이라는 표시
----------------------------------------------------------------------
 
 # Paging
 	1. DB SQL
 		- rownum : sql을 통해서 데이터를 numbering하는 oracle 키워드
 		- 시작번호와 마지막번호를 통해서 해당페이지가 처리 되게 한다.
 		- where rownum between #{start} and #{end}
 		- sub query를 통해서 해당 rownum의 범위를 처리할 수 있다.
 		- 총건수에 대한 sql 처리 : select count(*) cnt from board
 	
 	2. DAO단(Repository)
 		1) 총건수를 가져오는 메서드 추가
 		2) page 처리를 위해서 필요로 하는 property들(Board_sch에 추가할 내용)
 			- 총건수 : count <DB>
 			- 한 화면에 보여 줄 데이터 건수 : pageSize <화면>
 			- 총 페이지수 : pageCount <service>
 			- 클릭한 현재 page 번호 : curPage <화면>
 			- 해당 페이지의 시작 번호 : start <service>
 			- 해당 페이지의 마지막 번호 : end <service>
---------------------------------------------------------------------------

 # Paging 처리(화면)
 	1) pageSize : <select name = "pageSize">
 	2) curPage
 		- <a href="">[1][2][3]
 		- <input type="hidden" name="curPage"
 
---------------------------------------------------------------------------
 # Paging 처리(Service단)
 	1) 총 데이터 건수
 		- cnt.setCount(dao.countBoard(cnt));
 	
 	2) 한 페이지에 나타날 데이터 건수
 		- 초기화면을 위하여 default 값 setting
 			if(cnt.getPageSize()==0){
 				cnt.setPageSize(5)
 			}
 			
 		- 총 페이지수 : [1][2][3][4]...
 			총데이터건수/한페이지에 나타날 데이터 건수
 				Math.ceil((double)...)
 				
 		- 현재 클릭한 page번호
 			초기값
 			if(cnt.getCurPage==0){
 				cnt.setCurpage(1)
 			}
 			
 		- 시작번호, 마지막번호
 			시작번호 : (현재페이지번호-1)*한번에 보여줄 페이지+1
 			마지막번호 : 현재 클릭한 페이지 번호 * 한번에 보여줄 페이지의 크기
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
//	게시판 list
//	http://localhost:7080/spring_web/boardList.do?method=list
	@RequestMapping(params="method=list")
	public String listBoard(@ModelAttribute("boardSch") Board_Search sch, Model m){
		m.addAttribute("boardList", service.listBoard(sch));
		return "d01_board/a01_boardList";
	}
	// 등록화면 호출. boardList.do?method=insert
	@RequestMapping(params="method=insert")
	public String insert(@RequestParam(value="no", defaultValue="0") int no, Model m){
		System.out.println("no:"+no);
		m.addAttribute("board", service.getReBoard(no));
		return "d01_board/a02_insertBoard";
	}
	
	@RequestMapping(params="method=insProc")
	public String insertProc(Board ins){
		service.insertBoard(ins);
//		등록 후, 메인 조회화면으로 처리		
		return "redirect:/boardex.do?method=list";
	}
	
	@RequestMapping(params="method=detail")
	public String detail(@RequestParam("no") int no, Model m){
		System.out.println("no: "+no);
		m.addAttribute("board", service.detailBoard(no));
		return "d01_board/a03_detailBoard";
	}
}

