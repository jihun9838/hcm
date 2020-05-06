package mainpage.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import mainpage.LoginController;
import mainpage.Member;
import mainpage.Service.CommonService;
import mainpage.Service.CommonServiceImpl;

public class IMembershipManageImpl implements IMembershipManage {
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:c:/java bej/Project/MIDAS_Project.db";
	Connection conn;

	public IMembershipManageImpl() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void membership() {
		
	}
	@Override
	public boolean MembershipProc(Member member) {
		String sql = "INSERT INTO Member (�����ȣ,id,pw,�̸�,�������,�ֹι�ȣ���ڸ�,�μ�,��ȭ��ȣ,�Ի�����,�̸���,�����з�,�ּ�)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		// ȸ������

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, member.getEmployeeNum());
			pStmt.setString(2, member.getId());
			pStmt.setString(3, member.getPw());
			pStmt.setString(4, member.getName());
			pStmt.setString(5, member.getBirth());
			pStmt.setString(6, member.getSocialNum());
			pStmt.setString(7, member.getDepartment());
			pStmt.setString(8, member.getPhoneNum());
			pStmt.setString(9, member.getSignJoindate());
			pStmt.setString(10, member.getEmail());
			pStmt.setString(11, member.getFinalEdu());
			pStmt.setString(12, member.getAddress());
			
			pStmt.executeUpdate();
			
			pStmt.close();
			conn.close();
			
		} catch (SQLException e) {
			return false;
		}
		return true;	// ���� �Է� �ߵǸ� ȸ������ ����
		}

		@Override
		public boolean LoginProc(String id, String pw) {
			String sql = "SELECT count(*) FROM Member WHERE id=? AND pw=?";
					// �α���
			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);
				pStmt.setString(2, pw);

				rs = pStmt.executeQuery();

				while(rs.next()) {	//���� ���� ������ �� �ݺ����� �̾��
					int i = rs.getInt("count(*)");
					if(i==1)
						return true;
					else return false;
				}
				pStmt.close();
				conn.close();

			} catch (SQLException e) {

			}	
			return false;

		}
		@Override
		public List<Member> getMember() {
			String sql = "SELECT * FROM Member";
			List<Member> lstmember = new ArrayList<Member>();

			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Member member = new Member();
					
					member.setEmployeeNum(rs.getString("�����ȣ"));
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("�̸�"));
					member.setBirth(rs.getString("�������"));
					member.setSocialNum(rs.getString("�ֹι�ȣ���ڸ�"));
					member.setDepartment(rs.getString("�μ�"));
					member.setPhoneNum(rs.getString("��ȭ��ȣ"));
					member.setSignJoindate(rs.getString("�Ի�����"));
					member.setEmail(rs.getString("�̸���"));
					member.setFinalEdu(rs.getString("�����з�"));
					member.setAddress(rs.getString("�ּ�"));

					lstmember.add(member);
				}
			} catch (SQLException e) {

				return null;
			}
			return lstmember;
		}
		@Override
		public boolean idcheck(String id) {
			Parent root = null;
			String sql = "SELECT count(*) FROM Member WHERE id = ?";
			CommonService comServ = new CommonServiceImpl();

			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);

				rs = pStmt.executeQuery();

				while(rs.next()) {
					int i = rs.getInt("count(*)");
					if(i==0) {
						comServ.ErrorMsg("���̵� Ȯ��","�ߺ��� ���̵� �����ϴ�.","�ߺ��� ���̵� �����ϴ�. ��밡�� �մϴ�.");
						return true;
					}
					else {
						comServ.ErrorMsg("���̵� Ȯ��", "�ߺ��� ���̵� �ֽ��ϴ�.","�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
						return false;
					}
				}
				pStmt.close();
				conn.close();

			} catch (SQLException e) {

			}
			return false;	

		}
		
		@Override
		public boolean searchID(String name, String PhoneNum) {
			String sql = "SELECT  count(*),id FROM Member WHERE �̸�=? AND ��ȭ��ȣ = ?";
			CommonService comServ = new CommonServiceImpl();
			
			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, name);
				pStmt.setString(2, PhoneNum);

				rs = pStmt.executeQuery();

				Member member = new Member();
				member.setId(rs.getString("id"));
				
				while(rs.next()) {
					
					String i = rs.getString("id");
					if(i!=null) {
						comServ.ErrorMsg("���̵� ã��","�Է��Ͻ� ������ ���̵� �ֽ��ϴ�.","���̵�� "+i+" �Դϴ�.");
						return false;
					}
					else {
						comServ.ErrorMsg("���̵� ã��", "�Է��� ������ Ȯ�����ּ���.","���̵� �����ϴ�.");		
						return true;
					}
				}
				pStmt.close();
				conn.close();

			} catch (SQLException e) {

			}
			return false;	
		}

		
		@Override
		public boolean searchPW(String name,String id, String PhoneNum) {
			String sql = "SELECT  count(*), pw FROM Member WHERE �̸�=? AND id = ? AND ��ȭ��ȣ = ? ";
			CommonService comServ = new CommonServiceImpl();

			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, name);
				pStmt.setString(2, id);
				pStmt.setString(3, PhoneNum);

				rs = pStmt.executeQuery();
				
				Member member = new Member();
				member.setPw(rs.getString("pw"));
				while(rs.next()) {
					String i = rs.getString("pw");
					if(i!=null) {
						comServ.ErrorMsg("��й�ȣ ã��","�Է��Ͻ� ������ ��й�ȣ�� �ֽ��ϴ�.","��й�ȣ�� "+i+" �Դϴ�.");
						return false;
					}
					else {
						comServ.ErrorMsg("��й�ȣ ã��", "�Է��� ������ Ȯ�����ּ���.","��й�ȣ�� ã�� �� �����ϴ�.");
						return true;
					}
				}
				pStmt.close();
				conn.close();

			} catch (SQLException e) {

			}
			return false;	
		}
		@Override
		public Member getMember(String num) {
			  String sql = "SELECT * " + 
			            "FROM Member " +
			            "WHERE �����ȣ like '%" + num + "%'";
			   
			      try {
			         Statement stmt = conn.createStatement();
			         
			         ResultSet rs = stmt.executeQuery(sql);
			         
			         if(rs.next()) {
			        	 Member member = new Member();
			            
			            member.setEmployeeNum(rs.getString("�����ȣ"));
			            member.setId(rs.getString("id"));
			            member.setPw(rs.getString("pw"));
			            member.setName(rs.getString("�̸�"));
			            member.setBirth(rs.getString("�������"));
			            member.setSocialNum(rs.getString("�ֹι�ȣ���ڸ�"));
			            //member.setCategory(rs.getString("�������"));
			            //member.setSalary(rs.getString("����"));
			            member.setDepartment(rs.getString("�μ�"));
			            member.setPosition(rs.getString("����"));
			            member.setPlace(rs.getString("�ٹ���"));
			            member.setPhoneNum(rs.getString("��ȭ��ȣ"));
			            member.setSignJoindate(rs.getString("�Ի�����"));
			            member.setEmail(rs.getString("�̸���"));
			            member.setFinalEdu(rs.getString("�����з�"));
			            member.setAddress(rs.getString("�ּ�"));
			            //member.setImage(rs.getString("����url"));
			            
			            stmt.close();
			            rs.close();
			            conn.close();
			            
			            return member;
			         }
			         
			         stmt.close();
			         rs.close();
			         conn.close();
			         
			      } catch (SQLException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			      }

			      return null;
		}
		@Override
		public String [] homepage(String id) {
			String sql = "SELECT id, �̸�  FROM Member WHERE id=?";
			CommonService comServ = new CommonServiceImpl();
			String [] idName = new String[2];			

			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);

				rs = pStmt.executeQuery();
				
				while(rs.next()) {
					idName[0] = rs.getString("id");
					idName[1] = rs.getString("�̸�");
				}
				
				pStmt.close();
				conn.close();
				return idName;

			} catch (SQLException e) {

			}
			return null;	
		}

		@Override
		public boolean infopwCheck(String id) {
			String sql = "SELECT count(*) FROM Member WHERE id=? AND pw=?";
			CommonService comServ = new CommonServiceImpl();	

			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);

				rs = pStmt.executeQuery();
				
				while(rs.next()) {
					int i = rs.getInt("pw");
					if(i==1) {
						System.out.println("sss");
						return false;
					}
					else {
						comServ.ErrorMsg("�� ���� Ȯ��", "��й�ȣ�� Ʋ�Ƚ��ϴ�.","��й�ȣ�� Ȯ�����ּ���");
						return true;
					}
				}
				
				pStmt.close();
				conn.close();
				

			} catch (SQLException e) {

			}
			return false;	
		}
}










