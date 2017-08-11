package spring.z01_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import spring.dto.Members;

public class MembersDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String sql = null;
	
	private void setCon() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url, "scott", "tiger");
	}
	
	public Members memInfo(Members dto){
		Members mem = null;
		try {
			setCon();
			sql = "SELECT * FROM MEMBERS "+"WHERE ID=? "+"AND PWD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getJid());
			pstmt.setString(2, dto.getJpwd());
			rs = pstmt.executeQuery();
			if( rs.next() ){
				mem = new Members();
				mem.setJid(rs.getString(1));
				mem.setJpwd(rs.getString(2));
				mem.setJname(rs.getString(3));
				mem.setJpoint(rs.getInt(4));
				mem.setJauthor(rs.getString(5));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return mem;
	}
	public ArrayList<Members> memList(){
		ArrayList<Members> list= new ArrayList<Members>();
		try {
			setCon();
			sql = "SELECT * FROM MEMBERS ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Members mem = null;
			while( rs.next() ){
				mem = new Members();
				mem.setJid(rs.getString(1));
				mem.setJpwd(rs.getString(2));
				mem.setJname(rs.getString(3));
				mem.setJpoint(rs.getInt(4));
				mem.setJauthor(rs.getString(5));
				list.add(mem);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MembersDAO dao = new MembersDAO();
		Members dto = new Members();
		System.out.println(dao.memList().size());
	}

}
/*
# session 적용
1. 세션처리
	1) login 사용자 관련 정보를 page마다 표시
		- page마다 필요로 하는 정보를 DB에서 불러온 내용을 객체로 담아 session에 저장 및 호출
		ex) @@@님 로그인 표시, 화면별 권한 check(read, 등록/수정/삭제)
	
	2) 장바구니 담기
		- page마다 구매한 물품정보(물건id, 구매량) 누적 저장
		- 최종 cart에서 구매 처리
		
# 세션예제(로그인)
1. 화면처리(로그인과 page별 인증)
	- ID/password 입력
	- process에서 인증이 되면 DB에서 id/password 외 정보(이름, 권한, 물건구매 history기록)
	- page마다 현재 session 정보에 해당 사용자를 호출해서 session정보가 있을 경우에만 사용가능.(정상적인 login 프로세스를 통해서만 페이지 접근이 가능) 
	
# 세션예제(로그인) 개발
1. DB 구성
	1) member 테이블 구성
		- id, password, name, point, author(권한) 
	
2. VO 클래스 생성

3. DAO
	- sql : select * from member
	- where id = ? and pass = ?
	- public Member getMember(Member sch)
		
4. Login 화면 구성(로그인 넘길 데이터 : id/password, proc)
	- ID []
	- Password []
	- [로그인]

5. loginProc.jsp
	- id, password가 DB에 있는지 여부 확인, 있으면 session 처리(main page 이동) 없으면 다시 login 화면으로 이동
	- 로그아웃 시, session을 invalidate() 처리 후, 로그인 화면 이동

6. main.jsp 
	- 로그인 후, 초기화면
	- session값 check해서session이 있는 경우 @@@님 환영합니다. 현재 point: @@@
	- session이 없는 경우 msg : 로그인이 필요합니다. 로그인 창으로 이동하겠습니다.
	- [로그아웃] 클릭시, 세션 종료 처리(loginProc.jsp)
*/