package com.midas.db.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.midas.db.Commute;
import com.midas.db.Employee;
import com.midas.db.HolidayRequest;
import com.midas.db.SalaryResult;
import com.midas.db.TAA;
import com.midas.db.TAAResult;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.scene.Parent;

public class DBServiceImpl implements DBService{
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:src/MIDAS_Project.db";
	static Connection conn;

	List<Employee> employeeList = new ArrayList<Employee>();
	CommonService comServ = new CommonServiceImpl();

	public DBServiceImpl() {
		comServ = new CommonServiceImpl();

		try {
			//Connection conn;
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

	//
	//	@Override
	//	public boolean MembershipProc(Employee emp) {
	//
	//		return true;
	//	}
	//
	//	@Override
	//	public int LoginProc(String id, String pw) {
	//		String sql = "SELECT count(*) " +
	//				"FROM Employees "+
	//				"where id=? "+
	//				"AND pw=?";
	//
	//		int result = 0;
	//		try {
	//
	//			PreparedStatement pStmt = conn.prepareStatement(sql);
	//			pStmt.setString(1, id);
	//			pStmt.setString(2, pw);
	//
	//			ResultSet rs = pStmt.executeQuery();
	//
	//			if(rs.next()) 
	//				result = rs.getInt("count(*)");
	//
	//
	//
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//
	//
	//		return result;
	//	}



	@Override
	public List<Employee> getEmployeeList() {
		// SELECT

		List<Employee> employeeList = new ArrayList<Employee>();

		String sql = "SELECT * " + 
				"FROM Employee";

		try {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Employee emp = new Employee();

				emp.setNum(rs.getString("�����ȣ"));
				emp.setId(rs.getString("id"));
				emp.setPw(rs.getString("pw"));
				emp.setName(rs.getString("�̸�"));
				emp.setBirth(rs.getString("�������"));
				emp.setSocialNum(rs.getString("�ֹι�ȣ���ڸ�"));
				emp.setCategory(rs.getString("�������"));
				emp.setSalary(rs.getString("����"));
				emp.setDepartment(rs.getString("�μ�"));
				emp.setPosition(rs.getString("����"));
				emp.setPlace(rs.getString("�ٹ���"));
				emp.setPhone(rs.getString("��ȭ��ȣ"));
				emp.setJoin(rs.getString("�Ի�����"));
				emp.setEmail(rs.getString("�̸���"));
				emp.setEducation(rs.getString("�����з�"));
				emp.setAddress(rs.getString("�ּ�"));
				emp.setImage(rs.getString("����url"));
				emp.setAvailableHoliday(rs.getString("�ѿ���"));
				emp.setUsedHoliday(rs.getString("��뿬��"));
				emp.setRemainHoliday(rs.getString("�ܿ�����"));

				employeeList.add(emp);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			return null;
		}

		this.employeeList = employeeList;
		return employeeList;
	}


	@Override
	public Employee getEmployeeById(String id) {
		List<Employee> employeeList = getEmployeeList();

		for(Employee emp : employeeList)
			if(id.equals(emp.getId()))
				return emp;

		return null;
	}

	@Override
	public List getDataFromListById(List list, String id, String option) {
		List newList = new ArrayList<>();

		if(comServ.CheckClassType(list).equals("Employee")) {
			List<Employee> _list = list;
			for(Employee o : _list) 
				if(id.equals(o.getId())) 
					newList.add(o);
		}
		if(comServ.CheckClassType(list).equals("HolidayRequest")) {
			List<HolidayRequest> _list = list;
			for(HolidayRequest o : _list) 
				if(id.equals(o.getId())) 
					newList.add(o);
		}
		if(comServ.CheckClassType(list).equals("SalaryResult")) {
			List<SalaryResult> _list = list;
			for(SalaryResult o : _list) 
				if(id.equals(o.getId())) 
					newList.add(o);
		}
		if(comServ.CheckClassType(list).equals("TAA")) {
			List<TAA> _list = list;
			for(TAA o : _list) 
				if(id.equals(o.getId())) 
					newList.add(o);
		}
		if(comServ.CheckClassType(list).equals("TAAResult")) {
			List<TAAResult> _list = list;
			for(TAAResult o : _list) 
				if(id.equals(o.getId())) 
					newList.add(o);
		}
		return newList;
	}


	@Override
	public void addEmployee(Employee emp) {
		// UPDATE

	}


	@Override
	public void deleteEmployee(String id) {
		// UPDATE

	}


	@Override
	public void editEmployee(String id) {
		// UPDATE

	}


	@Override
	public void CreateTable(String table) {
		// TODO Auto-generated method stub

	}


	@Override
	public void UpdateTable(String table) {
		// UPDATE
	}

	@Override
	public void InsertTable(String table) {
		// INSERT

		String sql = "INSERT INTO " + table +
				"(name, id, pw, gender, age, hobby) "+
				"VALUES (?,?,?,?,?,?);";

		//			try {
		//				PreparedStatement pStmt = conn.prepareStatement(sql);
		//				pStmt.setString(1, member.getName());
		//				pStmt.setString(2, member.getId());
		//				pStmt.setString(3, member.getPw());
		//				pStmt.setInt(4, member.getGender());
		//				pStmt.setString(5, member.getAge());
		//				pStmt.setInt(6, member.getHobby());
		//
		//				pStmt.executeUpdate();
		//
		//				pStmt.close();
		//				conn.close();			


	}

	@Override
	public List SelectTable(String table, String whereOption) {
		// SELECT

		String sql = "SELECT * " + 
				"FROM " + table;

		if(!whereOption.isEmpty()) 
			sql += "\n" + whereOption;


		List list = new ArrayList<>();

		try {
//			Class.forName(DRIVER);
//			conn = DriverManager.getConnection(DB);
			
			//			Statement stmt = conn.createStatement();
			//			ResultSet rs = stmt.executeQuery(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();


			if(table.equals("Employee")) {
				while(rs.next()) {
					Employee emp = new Employee();

					emp.setNum(rs.getString("num"));
					emp.setId(rs.getString("id"));
					emp.setPw(rs.getString("pw"));
					emp.setName(rs.getString("name"));
					// ...

					list.add(emp);
				}
			}


			if(table.equals("SalaryResult")) {
				while(rs.next()) {
					SalaryResult salaryResult = new SalaryResult();

					salaryResult.setNum(rs.getString("num"));
					salaryResult.setId(rs.getString("id"));
					salaryResult.setYear(rs.getString("year"));
					salaryResult.setMonth(rs.getString("month"));
					salaryResult.setSalary(rs.getString("salary"));

					list.add(salaryResult);
				}
			}



			if(table.equals("HolidayRequest")) {
				while(rs.next()) {
					HolidayRequest holidayRequest = new HolidayRequest();


					holidayRequest.setId(rs.getString("�����ȣ"));
					holidayRequest.setName(rs.getString("�̸�"));
					holidayRequest.setDepartment(rs.getString("�μ�"));
					holidayRequest.setAvailableDay(rs.getString("�ܿ�����"));
					holidayRequest.setRequestDay(rs.getString("��û��"));
					holidayRequest.setStartDay(rs.getString("������"));
					holidayRequest.setEndDay(rs.getString("������"));
					holidayRequest.setPeriodDay(rs.getString("�Ⱓ"));
					holidayRequest.setReason(rs.getString("����"));
					holidayRequest.setApproval(rs.getString("���ο���"));

					list.add(holidayRequest);
				}
			}



			if(table.equals("TAAResult")) {
				while(rs.next()) {
					TAAResult empTAAResult = new TAAResult();

					empTAAResult.setNum(rs.getString("�����ȣ"));
					empTAAResult.setId(rs.getString("id"));
					//				empTAAResult.setPw(rs.getString("pw"));
					//				empTAAResult.setName(rs.getString("�̸�"));
					//				empTAAResult.setBirth(rs.getString("�������"));
					//				empTAAResult.setGender(rs.getString("�ֹι�ȣ���ڸ�"));
					//				empTAAResult.setCategory(rs.getString("�������"));
					//				empTAAResult.setSalary(rs.getString("����"));
					//				empTAAResult.setDepartment(rs.getString("�μ�"));
					//				empTAAResult.setPosition(rs.getString("����"));
					//				empTAAResult.setPlace(rs.getString("�ٹ���"));
					//				empTAAResult.setPhone(rs.getString("��ȭ��ȣ"));
					//				empTAAResult.setJoin(rs.getString("�Ի�����"));
					//				empTAAResult.setEmail(rs.getString("�̸���"));
					//				empTAAResult.setEducation(rs.getString("�����з�"));
					//				empTAAResult.setAddress(rs.getString("�ּ�"));
					//				empTAAResult.setImage(rs.getString("����url"));
					empTAAResult.setYear(rs.getString("year"));
					empTAAResult.setMonth(rs.getString("month"));
					empTAAResult.setTAA(rs.getString("taa"));

					list.add(empTAAResult);
				}
			}

			if(table.equals("TAA")) {
				while(rs.next()) {
					TAA empTAA = new TAA();

					empTAA.setNum(rs.getString("�����ȣ"));
					empTAA.setId(rs.getString("id"));
					//				empTAA.setPw(rs.getString("pw"));
					//				empTAA.setName(rs.getString("�̸�"));
					//				empTAA.setBirth(rs.getString("�������"));
					//				empTAA.setGender(rs.getString("�ֹι�ȣ���ڸ�"));
					//				empTAA.setCategory(rs.getString("�������"));
					//				empTAA.setSalary(rs.getString("����"));
					//				empTAA.setDepartment(rs.getString("�μ�"));
					//				empTAA.setPosition(rs.getString("����"));
					//				empTAA.setPlace(rs.getString("�ٹ���"));
					//				empTAA.setPhone(rs.getString("��ȭ��ȣ"));
					//				empTAA.setJoin(rs.getString("�Ի�����"));
					//				empTAA.setEmail(rs.getString("�̸���"));
					//				empTAA.setEducation(rs.getString("�����з�"));
					//				empTAA.setAddress(rs.getString("�ּ�"));
					//				empTAA.setImage(rs.getString("����url"));
					empTAA.setDate(rs.getString("date"));
					empTAA.setTime(rs.getString("time"));
					empTAA.setState(rs.getString("state"));

					list.add(empTAA);
				}
			}

			//stmt.close();
			pStmt.close();
			rs.close();
			conn.close();

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR : SelectTable");
		return null;
	}









	@Override
	public Employee getEmployee(String num) {
		String sql = "SELECT * " + 
				"FROM Employee " +
				"WHERE �����ȣ like '%" + num + "%'";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
				Employee employee = new Employee();

				employee.setNum(rs.getString("�����ȣ"));
				employee.setId(rs.getString("id"));
				employee.setPw(rs.getString("pw"));
				employee.setName(rs.getString("�̸�"));
				employee.setBirth(rs.getString("�������"));
				employee.setSocialNum(rs.getString("�ֹι�ȣ���ڸ�"));
				employee.setCategory(rs.getString("�������"));
				employee.setSalary(rs.getString("����"));
				employee.setDepartment(rs.getString("�μ�"));
				employee.setPosition(rs.getString("����"));
				employee.setPlace(rs.getString("�ٹ���"));
				employee.setPhone(rs.getString("��ȭ��ȣ"));
				employee.setJoin(rs.getString("�Ի�����"));
				employee.setEmail(rs.getString("�̸���"));
				employee.setEducation(rs.getString("�����з�"));
				employee.setAddress(rs.getString("�ּ�"));
				employee.setImage(rs.getString("����url"));

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
			employee.setNum(rs.getString("�����ȣ"));
			employee.setId(rs.getString("id"));
			employee.setPw(rs.getString("pw"));
			employee.setName(rs.getString("�̸�"));
			employee.setBirth(rs.getString("�������"));
			employee.setSocialNum(rs.getString("�ֹι�ȣ���ڸ�"));
			employee.setCategory(rs.getString("�������"));
			employee.setSalary(rs.getString("����"));
			employee.setDepartment(rs.getString("�μ�"));
			employee.setPosition(rs.getString("����"));
			employee.setPlace(rs.getString("�ٹ���"));
			employee.setPhone(rs.getString("��ȭ��ȣ"));
			employee.setJoin(rs.getString("�Ի�����"));
			employee.setEmail(rs.getString("�̸���"));
			employee.setEducation(rs.getString("�����з�"));
			employee.setAddress(rs.getString("�ּ�"));
			employee.setImage(rs.getString("����url"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}
	private Employee biglst(ResultSet rs, Employee employee) {
		try {
			employee.setNum(rs.getString("�����ȣ"));
			employee.setName(rs.getString("�̸�"));
			employee.setCategory(rs.getString("�������"));
			employee.setDepartment(rs.getString("�μ�"));
			employee.setPosition(rs.getString("����"));
			employee.setPlace(rs.getString("�ٹ���"));
			employee.setPhone(rs.getString("��ȭ��ȣ"));
			employee.setJoin(rs.getString("�Ի�����"));
			employee.setEmail(rs.getString("�̸���"));
			employee.setEducation(rs.getString("�����з�"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}
	private Employee smalllst(ResultSet rs, Employee employee) {
		try {
			employee.setNum(rs.getString("�����ȣ"));
			employee.setName(rs.getString("�̸�"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}
	@Override
	public boolean SaveInfo(Employee employee) {
		String sql = "INSERT INTO Employee (�����ȣ,id,pw,�̸�,�������,�ֹι�ȣ���ڸ�,�μ�,��ȭ��ȣ,�Ի�����,�̸���,�����з�,�ּ�,�������,����,����,�ٹ���,����url,�ѿ���,��뿬��,�ܿ�����) " + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, employee.getNum());
			pStmt.setString(2, employee.getId());
			pStmt.setString(3, employee.getPw());
			pStmt.setString(4, employee.getName());
			pStmt.setString(5, employee.getBirth());
			pStmt.setString(6, employee.getSocialNum());
			pStmt.setString(7, employee.getDepartment());
			pStmt.setString(8, employee.getPhone());
			pStmt.setString(9, employee.getJoin());
			pStmt.setString(10, employee.getEmail());
			pStmt.setString(11, employee.getEducation());
			pStmt.setString(12, employee.getAddress());
			pStmt.setString(13, employee.getCategory());
			pStmt.setString(14, employee.getSalary());
			pStmt.setString(15, employee.getPosition());
			pStmt.setString(16, employee.getPlace());
			pStmt.setString(17, employee.getImage());
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
				"SET �����ȣ = ?,id = ?,�̸� = ?,������� = ?,�μ� = ?,��ȭ��ȣ = ?,�Ի����� = ?,�̸��� = ?,�����з� = ?,�ּ� = ?,������� = ?,���� = ?,���� = ?,�ٹ��� = ?,����url = ? " + 
				"WHERE �����ȣ = " + num;

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, employee.getNum());
			pStmt.setString(2, employee.getId());
			pStmt.setString(3, employee.getName());
			pStmt.setString(4, employee.getBirth());
			pStmt.setString(5, employee.getDepartment());
			pStmt.setString(6, employee.getPhone());
			pStmt.setString(7, employee.getJoin());
			pStmt.setString(8, employee.getEmail());
			pStmt.setString(9, employee.getEducation());
			pStmt.setString(10, employee.getAddress());
			pStmt.setString(11, employee.getCategory());
			pStmt.setString(12, employee.getSalary());
			pStmt.setString(13, employee.getPosition());
			pStmt.setString(14, employee.getPlace());
			pStmt.setString(15, employee.getImage());


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
				"WHERE �����ȣ = " + num;
	
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








	@Override
	public boolean MembershipProc(Employee employee) {
		String sql = "INSERT INTO Employee (�����ȣ,id,pw,�̸�,�������,�ֹι�ȣ���ڸ�,�μ�,��ȭ��ȣ,�Ի�����,�̸���,�����з�,�ּ�,�ѿ���,��뿬��,�ܿ�����,�������,����,�ٹ���)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,26,0,26,'���','���','����')";
		// ȸ������

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, employee.getNum());
			pStmt.setString(2, employee.getId());
			pStmt.setString(3, employee.getPw());
			pStmt.setString(4, employee.getName());
			pStmt.setString(5, employee.getBirth());
			pStmt.setString(6, employee.getSocialNum());
			pStmt.setString(7, employee.getDepartment());
			pStmt.setString(8, employee.getPhone());
			pStmt.setString(9, employee.getJoin());
			pStmt.setString(10, employee.getEmail());
			pStmt.setString(11, employee.getEducation());
			pStmt.setString(12, employee.getAddress());


			pStmt.executeUpdate();

			pStmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	// ���� �Է� �ߵǸ� ȸ������ ����
	}

	@Override
	public boolean LoginProc(String id, String pw) {
		String sql = "SELECT count(*) FROM Employee WHERE id=? AND pw=?";
		// �α���
		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);
			pStmt.setString(2, pw);

			rs = pStmt.executeQuery();

			while(rs.next()) {	//���� ���� ������ �� �ݺ����� �̾��
				int i = rs.getInt("count(*)");
				if(i==1) {
					pStmt.close();
					conn.close();
					return true;
				}
				else {
					pStmt.close();
					conn.close();
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
	public List<Employee> getMember() {
		String sql = "SELECT * FROM Employee";
		List<Employee> lstEmp = new ArrayList<Employee>();

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setNum(rs.getString("�����ȣ"));
				emp.setId(rs.getString("id"));
				emp.setPw(rs.getString("pw"));
				emp.setName(rs.getString("�̸�"));
				emp.setBirth(rs.getString("�������"));
				emp.setSocialNum(rs.getString("�ֹι�ȣ���ڸ�"));
				emp.setDepartment(rs.getString("�μ�"));
				emp.setPhone(rs.getString("��ȭ��ȣ"));
				emp.setJoin(rs.getString("�Ի�����"));
				emp.setEmail(rs.getString("�̸���"));
				emp.setEducation(rs.getString("�����з�"));
				emp.setAddress(rs.getString("�ּ�"));

				lstEmp.add(emp);
			}
			pStmt.close();
			conn.close();
		} catch (SQLException e) {

			return null;
		}
		return lstEmp;
	}
	@Override
	public boolean idcheck(String id) {
		Parent root = null;
		String sql = "SELECT count(*) FROM Employee WHERE id = ?";
		CommonService comServ = new CommonServiceImpl();

		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);

			rs = pStmt.executeQuery();

			while(rs.next()) {
				int i = rs.getInt("count(*)");
				if(i==0) {
					pStmt.close();
					conn.close();
					return true;
				}
				else {
					pStmt.close();
					conn.close();
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
	public boolean numcheck(String num) {
		Parent root = null;
		String sql = "SELECT count(*) FROM Employee WHERE �����ȣ = ?";
		CommonService comServ = new CommonServiceImpl();

		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, num);

			rs = pStmt.executeQuery();

			while(rs.next()) {
				int i = rs.getInt("count(*)");
				if(i==0) {
					pStmt.close();
					conn.close();
					return true;
				}
				else {
					pStmt.close();
					conn.close();
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
		String sql = "SELECT  count(*),id FROM Employee WHERE �̸�=? AND ��ȭ��ȣ = ?";
		CommonService comServ = new CommonServiceImpl();

		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2, PhoneNum);

			rs = pStmt.executeQuery();

			Employee member = new Employee();
			member.setId(rs.getString("id"));

			while(rs.next()) {

				String i = rs.getString("id");
				if(i!=null) {
					comServ.ErrorMsg("���̵� ã��","�Է��Ͻ� ������ ���̵� �ֽ��ϴ�.","���̵�� "+i+" �Դϴ�.");
					pStmt.close();
					conn.close();
					return false;
				}
				else {
					comServ.ErrorMsg("���̵� ã��", "�Է��� ������ Ȯ�����ּ���.","���̵� �����ϴ�.");		
					pStmt.close();
					conn.close();
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
		String sql = "SELECT  count(*), pw FROM Employee WHERE �̸�=? AND id = ? AND ��ȭ��ȣ = ? ";
		CommonService comServ = new CommonServiceImpl();

		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2, id);
			pStmt.setString(3, PhoneNum);

			rs = pStmt.executeQuery();

			Employee member = new Employee();
			member.setPw(rs.getString("pw"));
			while(rs.next()) {
				String i = rs.getString("pw");
				if(i!=null) {
					comServ.ErrorMsg("��й�ȣ ã��","�Է��Ͻ� ������ ��й�ȣ�� �ֽ��ϴ�.","��й�ȣ�� "+i+" �Դϴ�.");
					pStmt.close();
					conn.close();
					return false;
				}
				else {
					comServ.ErrorMsg("��й�ȣ ã��", "�Է��� ������ Ȯ�����ּ���.","��й�ȣ�� ã�� �� �����ϴ�.");
					pStmt.close();
					conn.close();
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
	public Employee getMember(String num) {
		String sql = "SELECT * " + 
				"FROM Employee " +
				"WHERE �����ȣ like '" + num + "'";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
				Employee member = new Employee();

				member.setNum(rs.getString("�����ȣ"));
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
				member.setPhone(rs.getString("��ȭ��ȣ"));
				member.setJoin(rs.getString("�Ի�����"));
				member.setEmail(rs.getString("�̸���"));
				member.setEducation(rs.getString("�����з�"));
				member.setAddress(rs.getString("�ּ�"));
				member.setImage(rs.getString("����url"));

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
		String sql = "SELECT �����ȣ, �̸�, �������  FROM Employee WHERE id=?";
		CommonService comServ = new CommonServiceImpl();
		String [] idName = new String[3];			

		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);

			rs = pStmt.executeQuery();

			while(rs.next()) {
				idName[0] = rs.getString("�����ȣ");
				idName[1] = rs.getString("�̸�");
				idName[2] = rs.getString("�������");
			}

			pStmt.close();
			conn.close();
			//return idName;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return idName;
	}

	@Override
	public boolean infopwCheck(String id, String pw) {
		System.out.println("infopwCheck(" + id + ") ");
		String sql = "SELECT count(*) FROM Employee WHERE �����ȣ=? AND pw=?";
		CommonService comServ = new CommonServiceImpl();	

		boolean rtn = false; 
		ResultSet rs;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);
			pStmt.setString(2, pw);

			rs = pStmt.executeQuery();

			while(rs.next()) {
				int i = rs.getInt("count(*)");
				if(i==1) {
					rtn = true;
				}
				else {
					comServ.ErrorMsg("�� ���� Ȯ��", "��й�ȣ�� Ʋ�Ƚ��ϴ�.","��й�ȣ�� Ȯ�����ּ���");
					rtn = false;
				}
			}

			pStmt.close();
			rs.close();
			conn.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rtn;	
	}
	

	@Override
	public boolean mypage(String num, Employee employee, boolean n) {
		String sql;
	      if(n) {
	         sql = "UPDATE Employee " +
	               "SET �̸� = ?,��ȭ��ȣ = ?,�̸��� = ?,�ּ� = ? " + 
	               "WHERE �����ȣ = '" + num +"'";
	      }
	      else {
	         sql = "UPDATE Employee " +
	               "SET �̸� = ?,��ȭ��ȣ = ?,�̸��� = ?,�ּ� = ?, pw = ? " + 
	               "WHERE �����ȣ = '" + num +"'";
	      }
	      System.out.println();
	      try {
	         PreparedStatement pStmt = conn.prepareStatement(sql);

	      
	         pStmt.setString(1, employee.getName());            
	         pStmt.setString(2, employee.getPhone());            
	         pStmt.setString(3, employee.getEmail());            
	         pStmt.setString(4, employee.getAddress());
	         if(!n) {
	            pStmt.setString(5, employee.getPw());
	         }
	         
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

	
	
	
	
	
	

	//TAA
	@Override
	public boolean SaveHolidayRequest(HolidayRequest holidayRequest) {
		System.out.println("SaveHolidayRequest : " + holidayRequest.getId());
		String sql = "INSERT INTO HolidayRequest "+
				"(\"�����ȣ\", \"�̸�\", \"�μ�\", \"�ܿ�����\", \"��û��\", \"������\" , \"������\", \"�Ⱓ\", \"����\", \"���ο���\")" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);


			pStmt.setString(1, holidayRequest.getId());
			pStmt.setString(2, holidayRequest.getName());
			pStmt.setString(3, holidayRequest.getDepartment());
			pStmt.setString(4, holidayRequest.getAvailableDay());
			pStmt.setString(5, holidayRequest.getRequestDay());
			pStmt.setString(6, holidayRequest.getStartDay());
			pStmt.setString(7, holidayRequest.getEndDay());
			pStmt.setString(8, holidayRequest.getPeriodDay());
			pStmt.setString(9, holidayRequest.getReason());
			pStmt.setString(10, holidayRequest.getApproval());

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("SaveHolidayRequest : DONE");
		return false;
	}

	@Override
	public List<Employee> SelectTableHoliday(String attribute, String txt, int i){
		List<Employee> lstEmployee = new ArrayList<Employee>();

		String sql = "SELECT " +
				"\"�����ȣ\", \"�̸�\", \"�μ�\", \"�Ի�����\", \"�ѿ���\", \"��뿬��\", \"�ܿ�����\" "+
				"FROM Employee " +
				"WHERE " + attribute + " like '%" + txt + "%'";

		//SELECT "�����ȣ", "�̸�", "�μ�", "�Ի�����", "�ѿ���", "��뿬��", "�ܿ�����" FROM Employee;

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Employee emp = new Employee();

				if(i==1)
					AllTAAlst(rs, emp);
				//				if(i==2)
				//					BigTAAlst(rs, emp);

				lstEmployee.add(emp);
			}


			//stmt.close();
			pStmt.close();
			rs.close();
			conn.close();

			return lstEmployee;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR : SelectTableHoliday");
		return null;
	}
	private Employee AllTAAlst(ResultSet rs, Employee emp) {
		try {
			emp.setNum(rs.getString("�����ȣ"));
			emp.setName(rs.getString("�̸�"));
			emp.setDepartment(rs.getString("�μ�"));
			emp.setJoin(rs.getString("�Ի�����"));
			emp.setAvailableHoliday(rs.getString("�ѿ���"));
			emp.setUsedHoliday(rs.getString("��뿬��"));
			emp.setRemainHoliday(rs.getString("�ܿ�����"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}


	@Override
	public List<Employee> SelectTableHoliday(String whereOption){

		String sql = "SELECT " +
				"\"�����ȣ\", \"�̸�\", \"�μ�\", \"�Ի�����\", \"�ѿ���\", \"��뿬��\", \"�ܿ�����\" "+
				"FROM Employee";

		//SELECT "�����ȣ", "�̸�", "�μ�", "�Ի�����", "�ѿ���", "��뿬��", "�ܿ�����" FROM Employee;

		if(!whereOption.isEmpty()) {
			sql +="\n" + whereOption;
		}
		List<Employee> list = new ArrayList<>();

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Employee emp = new Employee();

				emp.setNum(rs.getString("�����ȣ"));
				emp.setName(rs.getString("�̸�"));
				emp.setDepartment(rs.getString("�μ�"));
				emp.setJoin(rs.getString("�Ի�����"));
				emp.setAvailableHoliday(rs.getString("�ѿ���"));
				emp.setUsedHoliday(rs.getString("��뿬��"));
				emp.setRemainHoliday(rs.getString("�ܿ�����"));

				list.add(emp);
			}


			//stmt.close();
			pStmt.close();
			rs.close();
			conn.close();

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR : SelectTableHoliday");
		return null;
	}
	@Override
	public List<HolidayRequest> SelectHolidayApprovalSearch(String attribute, String txt) {
		List<HolidayRequest> requestList = new ArrayList<HolidayRequest>();
		String sql = "SELECT * " + 
				"FROM HolidayRequest " +
				"WHERE " + attribute + " like '%" + txt + "%'";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				HolidayRequest holidayRequest = new HolidayRequest();


				holidayRequest.setId(rs.getString("�����ȣ"));
				holidayRequest.setName(rs.getString("�̸�"));
				holidayRequest.setDepartment(rs.getString("�μ�"));
				holidayRequest.setAvailableDay(rs.getString("�ܿ�����"));
				holidayRequest.setRequestDay(rs.getString("��û��"));
				holidayRequest.setStartDay(rs.getString("������"));
				holidayRequest.setEndDay(rs.getString("������"));
				holidayRequest.setPeriodDay(rs.getString("�Ⱓ"));
				holidayRequest.setReason(rs.getString("����"));
				holidayRequest.setApproval(rs.getString("���ο���"));

				requestList.add(holidayRequest);
			}

			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestList;
	}
	@Override
	public boolean updateApprovalHoliday(String whereOption) {
		String UPDATESQL = "UPDATE HolidayRequest "+
				"SET "+
				"���ο���="+
				"\"����\"";
		if(!whereOption.isEmpty()) {
			UPDATESQL +="\n" + whereOption;
		}
		//UPDATE HolidayRequest SET approval="����" WHERE ROWID=1;
		try {
			PreparedStatement pStmt = conn.prepareStatement(UPDATESQL);

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			System.out.println("\n���οϷ�");
			return true;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n����");
		return false;
	}
	@Override
	public boolean updateEmployeeHoliday(String whereOption, String periodDay) {
		String UPDATESQL = "UPDATE Employee "+
				"SET "+
				"\"��뿬��\""+ "=" +
				" \"��뿬��\"" + "+" + periodDay +"\n" + whereOption;
		try {
			PreparedStatement pStmt = conn.prepareStatement(UPDATESQL);

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			System.out.println("\n���οϷ�");
			return true;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n����");
		return false;
	}
	@Override
	public boolean updateEmployeeHoliday2(String whereOption, String periodDay) {
		String UPDATESQL = 	"UPDATE Employee "+
				"SET "+
				"\"�ܿ�����\""+ "=" +
				" \"�ܿ�����\"" + "-" + periodDay +"\n" + whereOption +";";
		try {
			PreparedStatement pStmt = conn.prepareStatement(UPDATESQL);

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			System.out.println("\n���οϷ�");
			return true;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n����");
		return false;
	}
	@Override
	public boolean updateDeclineHoliday(String whereOption) {
		String UPDATESQL = "UPDATE HolidayRequest "+
				"SET "+
				"���ο���="+
				"\"�ݷ�\"";
		if(!whereOption.isEmpty()) {
			UPDATESQL +="\n" + whereOption;
		}
		//UPDATE HolidayRequest SET approval="����" WHERE ROWID=1;
		try {
			PreparedStatement pStmt = conn.prepareStatement(UPDATESQL);

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			System.out.println("\n�ݷ��Ϸ�");
			return true;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n����");
		return false;
	}
	@Override
	public boolean updateEmployeeHolidayDe(String whereOption, String periodDay) {
		String UPDATESQL = "UPDATE Employee "+
				"SET "+
				"\"��뿬��\""+ "=" +
				" \"��뿬��\"" + "-" + periodDay +"\n" + whereOption;
		try {
			PreparedStatement pStmt = conn.prepareStatement(UPDATESQL);

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			System.out.println("\n���οϷ�");
			return true;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n����");
		return false;
	}
	@Override
	public boolean updateEmployeeHolidayDe2(String whereOption, String periodDay) {
		String UPDATESQL = 	"UPDATE Employee "+
				"SET "+
				"\"�ܿ�����\""+ "=" +
				" \"�ܿ�����\"" + "+" + periodDay +"\n" + whereOption +";";
		try {
			PreparedStatement pStmt = conn.prepareStatement(UPDATESQL);

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
			System.out.println("\n���οϷ�");
			return true;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n����");
		return false;
	}
	
	@Override
	public boolean SaveCommute(Commute commute) {
		String sql = "INSERT INTO commute (�����ȣ,����,��¥,�ð�) " + 
				"VALUES (?,?,?,?)";

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, commute.getNum());
			pStmt.setString(2, commute.getSortation());
			pStmt.setString(3, commute.getDate());
			pStmt.setString(4, commute.getTime());
			
			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public void SaveCommute(Commute commute, String loginNum, String Sortation, String timeStr) {
		commute.setNum(loginNum); //�α��� �� ��� �����ȣ
		commute.setSortation(Sortation); //��� ��ư�� �������Ƿ� ���
		commute.setDate(LocalDate.now().toString()); //������� : ����
		commute.setTime(timeStr); //���� �ð�
		SaveCommute(commute);
	}
	
}
