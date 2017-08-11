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
# session ����
1. ����ó��
	1) login ����� ���� ������ page���� ǥ��
		- page���� �ʿ�� �ϴ� ������ DB���� �ҷ��� ������ ��ü�� ��� session�� ���� �� ȣ��
		ex) @@@�� �α��� ǥ��, ȭ�麰 ���� check(read, ���/����/����)
	
	2) ��ٱ��� ���
		- page���� ������ ��ǰ����(����id, ���ŷ�) ���� ����
		- ���� cart���� ���� ó��
		
# ���ǿ���(�α���)
1. ȭ��ó��(�α��ΰ� page�� ����)
	- ID/password �Է�
	- process���� ������ �Ǹ� DB���� id/password �� ����(�̸�, ����, ���Ǳ��� history���)
	- page���� ���� session ������ �ش� ����ڸ� ȣ���ؼ� session������ ���� ��쿡�� ��밡��.(�������� login ���μ����� ���ؼ��� ������ ������ ����) 
	
# ���ǿ���(�α���) ����
1. DB ����
	1) member ���̺� ����
		- id, password, name, point, author(����) 
	
2. VO Ŭ���� ����

3. DAO
	- sql : select * from member
	- where id = ? and pass = ?
	- public Member getMember(Member sch)
		
4. Login ȭ�� ����(�α��� �ѱ� ������ : id/password, proc)
	- ID []
	- Password []
	- [�α���]

5. loginProc.jsp
	- id, password�� DB�� �ִ��� ���� Ȯ��, ������ session ó��(main page �̵�) ������ �ٽ� login ȭ������ �̵�
	- �α׾ƿ� ��, session�� invalidate() ó�� ��, �α��� ȭ�� �̵�

6. main.jsp 
	- �α��� ��, �ʱ�ȭ��
	- session�� check�ؼ�session�� �ִ� ��� @@@�� ȯ���մϴ�. ���� point: @@@
	- session�� ���� ��� msg : �α����� �ʿ��մϴ�. �α��� â���� �̵��ϰڽ��ϴ�.
	- [�α׾ƿ�] Ŭ����, ���� ���� ó��(loginProc.jsp)
*/