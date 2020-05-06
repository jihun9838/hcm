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
		String sql = "INSERT INTO Member (사원번호,id,pw,이름,생년월일,주민번호뒷자리,부서,전화번호,입사일자,이메일,최종학력,주소)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		// 회원가입

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
		return true;	// 정보 입력 잘되면 회원가입 성공
		}

		@Override
		public boolean LoginProc(String id, String pw) {
			String sql = "SELECT count(*) FROM Member WHERE id=? AND pw=?";
					// 로그인
			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);
				pStmt.setString(2, pw);

				rs = pStmt.executeQuery();

				while(rs.next()) {	//다음 행이 있으면 이 반복문을 이어가렴
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
					
					member.setEmployeeNum(rs.getString("사원번호"));
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setName(rs.getString("이름"));
					member.setBirth(rs.getString("생년월일"));
					member.setSocialNum(rs.getString("주민번호뒷자리"));
					member.setDepartment(rs.getString("부서"));
					member.setPhoneNum(rs.getString("전화번호"));
					member.setSignJoindate(rs.getString("입사일자"));
					member.setEmail(rs.getString("이메일"));
					member.setFinalEdu(rs.getString("최종학력"));
					member.setAddress(rs.getString("주소"));

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
						comServ.ErrorMsg("아이디 확인","중복된 아이디가 없습니다.","중복된 아이디가 없습니다. 사용가능 합니다.");
						return true;
					}
					else {
						comServ.ErrorMsg("아이디 확인", "중복된 아이디가 있습니다.","중복된 아이디입니다. 다시 입력해주세요.");
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
			String sql = "SELECT  count(*),id FROM Member WHERE 이름=? AND 전화번호 = ?";
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
						comServ.ErrorMsg("아이디 찾기","입력하신 정보의 아이디가 있습니다.","아이디는 "+i+" 입니다.");
						return false;
					}
					else {
						comServ.ErrorMsg("아이디 찾기", "입력한 정보를 확인해주세요.","아이디가 없습니다.");		
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
			String sql = "SELECT  count(*), pw FROM Member WHERE 이름=? AND id = ? AND 전화번호 = ? ";
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
						comServ.ErrorMsg("비밀번호 찾기","입력하신 정보의 비밀번호가 있습니다.","비밀번호는 "+i+" 입니다.");
						return false;
					}
					else {
						comServ.ErrorMsg("비밀번호 찾기", "입력한 정보를 확인해주세요.","비밀번호를 찾을 수 없습니다.");
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
			            "WHERE 사원번호 like '%" + num + "%'";
			   
			      try {
			         Statement stmt = conn.createStatement();
			         
			         ResultSet rs = stmt.executeQuery(sql);
			         
			         if(rs.next()) {
			        	 Member member = new Member();
			            
			            member.setEmployeeNum(rs.getString("사원번호"));
			            member.setId(rs.getString("id"));
			            member.setPw(rs.getString("pw"));
			            member.setName(rs.getString("이름"));
			            member.setBirth(rs.getString("생년월일"));
			            member.setSocialNum(rs.getString("주민번호뒷자리"));
			            //member.setCategory(rs.getString("사원구분"));
			            //member.setSalary(rs.getString("연봉"));
			            member.setDepartment(rs.getString("부서"));
			            member.setPosition(rs.getString("직급"));
			            member.setPlace(rs.getString("근무지"));
			            member.setPhoneNum(rs.getString("전화번호"));
			            member.setSignJoindate(rs.getString("입사일자"));
			            member.setEmail(rs.getString("이메일"));
			            member.setFinalEdu(rs.getString("최종학력"));
			            member.setAddress(rs.getString("주소"));
			            //member.setImage(rs.getString("사진url"));
			            
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
			String sql = "SELECT id, 이름  FROM Member WHERE id=?";
			CommonService comServ = new CommonServiceImpl();
			String [] idName = new String[2];			

			ResultSet rs;
			try {
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);

				rs = pStmt.executeQuery();
				
				while(rs.next()) {
					idName[0] = rs.getString("id");
					idName[1] = rs.getString("이름");
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
						comServ.ErrorMsg("내 정보 확인", "비밀번호가 틀렸습니다.","비밀번호를 확인해주세요");
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










