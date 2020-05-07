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
//	private final static String DB = "jdbc:sqlite:C:/������ �ڹ������/������ƮMIDAS/MIDAS_Project.db";
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
//				"WHERE �����ȣ like '%" + num + "%'";
//
//		try {
//			Statement stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			if(rs.next()) {
//				Employee employee = new Employee();
//
//				employee.setNum(rs.getString("�����ȣ"));
//				employee.setId(rs.getString("id"));
//				employee.setPw(rs.getString("pw"));
//				employee.setName(rs.getString("�̸�"));
//				employee.setBirth(rs.getString("�������"));
//				employee.setGender(rs.getString("�ֹι�ȣ���ڸ�"));
//				employee.setCategory(rs.getString("�������"));
//				employee.setSalary(rs.getString("����"));
//				employee.setDepartment(rs.getString("�μ�"));
//				employee.setPosition(rs.getString("����"));
//				employee.setPlace(rs.getString("�ٹ���"));
//				employee.setPhone(rs.getString("��ȭ��ȣ"));
//				employee.setJoin(rs.getString("�Ի�����"));
//				employee.setEmail(rs.getString("�̸���"));
//				employee.setEducation(rs.getString("�����з�"));
//				employee.setAddress(rs.getString("�ּ�"));
//				employee.setImage(rs.getString("����url"));
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
//			employee.setNum(rs.getString("�����ȣ"));
//			employee.setId(rs.getString("id"));
//			employee.setPw(rs.getString("pw"));
//			employee.setName(rs.getString("�̸�"));
//			employee.setBirth(rs.getString("�������"));
//			employee.setGender(rs.getString("�ֹι�ȣ���ڸ�"));
//			employee.setCategory(rs.getString("�������"));
//			employee.setSalary(rs.getString("����"));
//			employee.setDepartment(rs.getString("�μ�"));
//			employee.setPosition(rs.getString("����"));
//			employee.setPlace(rs.getString("�ٹ���"));
//			employee.setPhone(rs.getString("��ȭ��ȣ"));
//			employee.setJoin(rs.getString("�Ի�����"));
//			employee.setEmail(rs.getString("�̸���"));
//			employee.setEducation(rs.getString("�����з�"));
//			employee.setAddress(rs.getString("�ּ�"));
//			employee.setImage(rs.getString("����url"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return employee;
//	}
//	private Employee biglst(ResultSet rs, Employee employee) {
//		try {
//			employee.setNum(rs.getString("�����ȣ"));
//			employee.setName(rs.getString("�̸�"));
//			employee.setCategory(rs.getString("�������"));
//			employee.setDepartment(rs.getString("�μ�"));
//			employee.setPosition(rs.getString("����"));
//			employee.setPlace(rs.getString("�ٹ���"));
//			employee.setPhone(rs.getString("��ȭ��ȣ"));
//			employee.setJoin(rs.getString("�Ի�����"));
//			employee.setEmail(rs.getString("�̸���"));
//			employee.setEducation(rs.getString("�����з�"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return employee;
//	}
//	private Employee smalllst(ResultSet rs, Employee employee) {
//		try {
//			employee.setNum(rs.getString("�����ȣ"));
//			employee.setName(rs.getString("�̸�"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return employee;
//	}
//	@Override
//	public boolean SaveInfo(Employee employee) {
//		String sql = "INSERT INTO Member (�����ȣ,id,pw,�̸�,�������,�ֹι�ȣ���ڸ�,�μ�,��ȭ��ȣ,�Ի�����,�̸���,�����з�,�ּ�,�������,����,����,�ٹ���,����url) " + 
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
//				"SET �����ȣ = ?,id = ?,�̸� = ?,������� = ?,�μ� = ?,��ȭ��ȣ = ?,�Ի����� = ?,�̸��� = ?,�����з� = ?,�ּ� = ?,������� = ?,���� = ?,���� = ?,�ٹ��� = ?,����url = ? " + 
//				"WHERE �����ȣ = " + num;
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
