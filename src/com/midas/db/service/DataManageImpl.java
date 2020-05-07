//package com.midas.db.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.midas.db.Employee;
//
//public class DataManageImpl implements DataManage {
//	private final static String DRIVER = "org.sqlite.JDBC";
//	private final static String DB = "jdbc:sqlite:C:/유동관 자바취업반/프로젝트MIDAS/MIDAS_Project.db";
//	Connection conn;
//
//	public DataManageImpl() {
//		try {
//			Class.forName(DRIVER);
//			conn = DriverManager.getConnection(DB);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public Employee getEmployee(String num) {
//		String sql = "SELECT * " + 
//				"FROM Member " +
//				"WHERE 사원번호 like '%" + num + "%'";
//
//		try {
//			Statement stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			if(rs.next()) {
//				Employee employee = new Employee();
//
//				employee.setNum(rs.getString("사원번호"));
//				employee.setId(rs.getString("id"));
//				employee.setPw(rs.getString("pw"));
//				employee.setName(rs.getString("이름"));
//				employee.setBirth(rs.getString("생년월일"));
//				employee.setGender(rs.getString("주민번호뒷자리"));
//				employee.setCategory(rs.getString("사원구분"));
//				employee.setSalary(rs.getString("연봉"));
//				employee.setDepartment(rs.getString("부서"));
//				employee.setPosition(rs.getString("직급"));
//				employee.setPlace(rs.getString("근무지"));
//				employee.setPhone(rs.getString("전화번호"));
//				employee.setJoin(rs.getString("입사일자"));
//				employee.setEmail(rs.getString("이메일"));
//				employee.setEducation(rs.getString("최종학력"));
//				employee.setAddress(rs.getString("주소"));
//				employee.setImage(rs.getString("사진url"));
//
//				stmt.close();
//				rs.close();
//				conn.close();
//
//				return employee;
//			}
//
//			stmt.close();
//			rs.close();
//			conn.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	@Override
//	public List<Employee> getEmployeelst(int i) {
//		List<Employee> lstEmployee = new ArrayList<Employee>();
//		String sql = "SELECT * " + 
//				"FROM Member";
//
//		try {
//			Statement stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			while(rs.next()) {
//				Employee employee = new Employee();
//
//				if(i==1)
//					alllst(rs, employee);
//				if(i==2)
//					biglst(rs, employee);
//				if(i==3)
//					smalllst(rs, employee);
//
//				lstEmployee.add(employee);
//			}
//
//			stmt.close();
//			rs.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			return null;
//		}
//		return lstEmployee;
//	}
//	@Override
//	public List<Employee> getEmployeeSearch(String attribute, String txt, int i) {
//		List<Employee> lstEmployee = new ArrayList<Employee>();
//		String sql = "SELECT * " + 
//				"FROM Member " +
//				"WHERE " + attribute + " like '%" + txt + "%'";
//
//		try {
//			Statement stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			while(rs.next()) {
//				Employee employee = new Employee();
//
//				if(i==1)
//					alllst(rs, employee);
//				if(i==2)
//					biglst(rs, employee);
//
//				lstEmployee.add(employee);
//			}
//
//			stmt.close();
//			rs.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return lstEmployee;
//	}
//	private Employee alllst(ResultSet rs, Employee employee) {
//		try {
//			employee.setNum(rs.getString("사원번호"));
//			employee.setId(rs.getString("id"));
//			employee.setPw(rs.getString("pw"));
//			employee.setName(rs.getString("이름"));
//			employee.setBirth(rs.getString("생년월일"));
//			employee.setGender(rs.getString("주민번호뒷자리"));
//			employee.setCategory(rs.getString("사원구분"));
//			employee.setSalary(rs.getString("연봉"));
//			employee.setDepartment(rs.getString("부서"));
//			employee.setPosition(rs.getString("직급"));
//			employee.setPlace(rs.getString("근무지"));
//			employee.setPhone(rs.getString("전화번호"));
//			employee.setJoin(rs.getString("입사일자"));
//			employee.setEmail(rs.getString("이메일"));
//			employee.setEducation(rs.getString("최종학력"));
//			employee.setAddress(rs.getString("주소"));
//			employee.setImage(rs.getString("사진url"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return employee;
//	}
//	private Employee biglst(ResultSet rs, Employee employee) {
//		try {
//			employee.setNum(rs.getString("사원번호"));
//			employee.setName(rs.getString("이름"));
//			employee.setCategory(rs.getString("사원구분"));
//			employee.setDepartment(rs.getString("부서"));
//			employee.setPosition(rs.getString("직급"));
//			employee.setPlace(rs.getString("근무지"));
//			employee.setPhone(rs.getString("전화번호"));
//			employee.setJoin(rs.getString("입사일자"));
//			employee.setEmail(rs.getString("이메일"));
//			employee.setEducation(rs.getString("최종학력"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return employee;
//	}
//	private Employee smalllst(ResultSet rs, Employee employee) {
//		try {
//			employee.setNum(rs.getString("사원번호"));
//			employee.setName(rs.getString("이름"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return employee;
//	}
//	@Override
//	public boolean SaveInfo(Employee employee) {
//		String sql = "INSERT INTO Member (사원번호,id,pw,이름,생년월일,주민번호뒷자리,부서,전화번호,입사일자,이메일,최종학력,주소,사원구분,연봉,직급,근무지,사진url) " + 
//				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//		try {
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			pStmt.setString(1, employee.getNum());
//			pStmt.setString(2, employee.getId());
//			pStmt.setString(3, employee.getPw());
//			pStmt.setString(4, employee.getName());
//			pStmt.setString(5, employee.getBirth());
//			pStmt.setString(6, employee.getGender());
//			pStmt.setString(7, employee.getDepartment());
//			pStmt.setString(8, employee.getPhone());
//			pStmt.setString(9, employee.getJoin());
//			pStmt.setString(10, employee.getEmail());
//			pStmt.setString(11, employee.getEducation());
//			pStmt.setString(12, employee.getAddress());
//			pStmt.setString(13, employee.getCategory());
//			pStmt.setString(14, employee.getSalary());
//			pStmt.setString(15, employee.getPosition());
//			pStmt.setString(16, employee.getPlace());
//			pStmt.setString(17, employee.getImage());
//
//
//			pStmt.executeUpdate();
//
//			pStmt.close();
//			conn.close();
//
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//	@Override
//	public boolean EditInfo(String num, Employee employee) {
//		String sql = "UPDATE Member " +
//				"SET 사원번호 = ?,id = ?,이름 = ?,생년월일 = ?,부서 = ?,전화번호 = ?,입사일자 = ?,이메일 = ?,최종학력 = ?,주소 = ?,사원구분 = ?,연봉 = ?,직급 = ?,근무지 = ?,사진url = ? " + 
//				"WHERE 사원번호 = " + num;
//
//		try {
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			pStmt.setString(1, employee.getNum());
//			pStmt.setString(2, employee.getId());
//			pStmt.setString(3, employee.getName());
//			pStmt.setString(4, employee.getBirth());
//			pStmt.setString(5, employee.getDepartment());
//			pStmt.setString(6, employee.getPhone());
//			pStmt.setString(7, employee.getJoin());
//			pStmt.setString(8, employee.getEmail());
//			pStmt.setString(9, employee.getEducation());
//			pStmt.setString(10, employee.getAddress());
//			pStmt.setString(11, employee.getCategory());
//			pStmt.setString(12, employee.getSalary());
//			pStmt.setString(13, employee.getPosition());
//			pStmt.setString(14, employee.getPlace());
//			pStmt.setString(15, employee.getImage());
//
//
//			pStmt.executeUpdate();
//
//			pStmt.close();
//			conn.close();
//
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//
//
//
//}
