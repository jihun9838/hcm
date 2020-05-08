package MIDAS.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MIDAS.Employee;

public class DataManageImpl implements DataManage {
	private final static String DRIVER = "org.sqlite.JDBC";
	private final static String DB = "jdbc:sqlite:src/MIDAS_Project.db";
	Connection conn;
	public DataManageImpl() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Employee getEmployee(String num) {
		String sql = "SELECT * " + 
				"FROM Employee " +
				"WHERE 사원번호 like '%" + num + "%'";
	
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				Employee employee = new Employee();
				
				employee.setnum(rs.getString("사원번호"));
				employee.setid(rs.getString("id"));
				employee.setpw(rs.getString("pw"));
				employee.setname(rs.getString("이름"));
				employee.setbirth(rs.getString("생년월일"));
				employee.setgender(rs.getString("주민번호뒷자리"));
				employee.setcategory(rs.getString("사원구분"));
				employee.setsalary(rs.getString("연봉"));
				employee.setdepartment(rs.getString("부서"));
				employee.setposition(rs.getString("직급"));
				employee.setplace(rs.getString("근무지"));
				employee.setphone(rs.getString("전화번호"));
				employee.setjoin(rs.getString("입사일자"));
				employee.setemail(rs.getString("이메일"));
				employee.seteducation(rs.getString("최종학력"));
				employee.setaddress(rs.getString("주소"));
				employee.setimage(rs.getString("사진url"));
				
				stmt.close();
				rs.close();
				conn.close();
				
				return employee;
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
	public List<Employee> getEmployeelst(int i) {
		List<Employee> lstEmployee = new ArrayList<Employee>();
		String sql = "SELECT * " + 
					"FROM Employee";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Employee employee = new Employee();
				
				if(i==1)
					alllst(rs, employee);
				if(i==2)
					biglst(rs, employee);
				if(i==3)
					smalllst(rs, employee);
				
				lstEmployee.add(employee);
			}
			
			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return lstEmployee;
	}
	@Override
	public List<Employee> getEmployeeSearch(String attribute, String txt, int i) {
		List<Employee> lstEmployee = new ArrayList<Employee>();
		String sql = "SELECT * " + 
					"FROM Employee " +
					"WHERE " + attribute + " like '%" + txt + "%'";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Employee employee = new Employee();
				
				if(i==1)
					alllst(rs, employee);
				if(i==2)
					biglst(rs, employee);
				
				lstEmployee.add(employee);
			}
			
			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lstEmployee;
	}
	private Employee alllst(ResultSet rs, Employee employee) {
		try {
			employee.setnum(rs.getString("사원번호"));
			employee.setid(rs.getString("id"));
			employee.setpw(rs.getString("pw"));
			employee.setname(rs.getString("이름"));
			employee.setbirth(rs.getString("생년월일"));
			employee.setgender(rs.getString("주민번호뒷자리"));
			employee.setcategory(rs.getString("사원구분"));
			employee.setsalary(rs.getString("연봉"));
			employee.setdepartment(rs.getString("부서"));
			employee.setposition(rs.getString("직급"));
			employee.setplace(rs.getString("근무지"));
			employee.setphone(rs.getString("전화번호"));
			employee.setjoin(rs.getString("입사일자"));
			employee.setemail(rs.getString("이메일"));
			employee.seteducation(rs.getString("최종학력"));
			employee.setaddress(rs.getString("주소"));
			employee.setimage(rs.getString("사진url"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	private Employee biglst(ResultSet rs, Employee employee) {
		try {
			employee.setnum(rs.getString("사원번호"));
			employee.setname(rs.getString("이름"));
			employee.setcategory(rs.getString("사원구분"));
			employee.setdepartment(rs.getString("부서"));
			employee.setposition(rs.getString("직급"));
			employee.setplace(rs.getString("근무지"));
			employee.setphone(rs.getString("전화번호"));
			employee.setjoin(rs.getString("입사일자"));
			employee.setemail(rs.getString("이메일"));
			employee.seteducation(rs.getString("최종학력"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	private Employee smalllst(ResultSet rs, Employee employee) {
		try {
			employee.setnum(rs.getString("사원번호"));
			employee.setname(rs.getString("이름"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	@Override
	public boolean SaveInfo(Employee employee) {
		String sql = "INSERT INTO Employee (사원번호,id,pw,이름,생년월일,주민번호뒷자리,부서,전화번호,입사일자,이메일,최종학력,주소,사원구분,연봉,직급,근무지,사진url,총연차,사용연차,잔여연차) " + 
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, employee.getnum());
	        pStmt.setString(2, employee.getid());
	        pStmt.setString(3, employee.getpw());
	        pStmt.setString(4, employee.getname());
	        pStmt.setString(5, employee.getbirth());
	        pStmt.setString(6, employee.getgender());
	        pStmt.setString(7, employee.getdepartment());
	        pStmt.setString(8, employee.getphone());
	        pStmt.setString(9, employee.getjoin());
	        pStmt.setString(10, employee.getemail());
	        pStmt.setString(11, employee.geteducation());
	        pStmt.setString(12, employee.getaddress());
	        pStmt.setString(13, employee.getcategory());
	        pStmt.setString(14, employee.getsalary());
	        pStmt.setString(15, employee.getposition());
	        pStmt.setString(16, employee.getplace());
	        pStmt.setString(17, employee.getimage());
	        pStmt.setInt(18, 26);
	        pStmt.setInt(19, 0);
	        pStmt.setInt(20, 26);
	        
			
			pStmt.executeUpdate();
			
			pStmt.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean EditInfo(String num, Employee employee) {
		String sql = "UPDATE Employee " +
					"SET 사원번호 = ?,id = ?,이름 = ?,생년월일 = ?,부서 = ?,전화번호 = ?,입사일자 = ?,이메일 = ?,최종학력 = ?,주소 = ?,사원구분 = ?,연봉 = ?,직급 = ?,근무지 = ?,사진url = ? " + 
					"WHERE 사원번호 = " + num;

	try {
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		pStmt.setString(1, employee.getnum());
        pStmt.setString(2, employee.getid());
        pStmt.setString(3, employee.getname());
        pStmt.setString(4, employee.getbirth());
        pStmt.setString(5, employee.getdepartment());
        pStmt.setString(6, employee.getphone());
        pStmt.setString(7, employee.getjoin());
        pStmt.setString(8, employee.getemail());
        pStmt.setString(9, employee.geteducation());
        pStmt.setString(10, employee.getaddress());
        pStmt.setString(11, employee.getcategory());
        pStmt.setString(12, employee.getsalary());
        pStmt.setString(13, employee.getposition());
        pStmt.setString(14, employee.getplace());
        pStmt.setString(15, employee.getimage());
        
		
		pStmt.executeUpdate();
		
		pStmt.close();
		conn.close();
		
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	}
	
	@Override
	public boolean DeleteInfo(String num) {
		String sql = "DELETE FROM Employee " + 
				"WHERE 사원번호 = " + num;
	
		try {
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

}
