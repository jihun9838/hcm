package com.midas.db.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.midas.db.Employee;
import com.midas.db.EmployeeHoliday;
import com.midas.db.EmployeeHoliday2;
import com.midas.db.HolidayRequest;
import com.midas.db.SalaryResult;
import com.midas.db.TAA;
import com.midas.db.TAAResult;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.beans.property.SimpleStringProperty;

public class DBServiceImpl implements DBService{
	final String DRIVER = "org.sqlite.JDBC";
	final String DB = "jdbc:sqlite:C:/�ڹ������/������Ʈ/DB/MIDAS_Project.db";

	List<Employee> employeeList = new ArrayList<Employee>();
	Connection conn;
	CommonService comServ;


	public DBServiceImpl() {
		comServ = new CommonServiceImpl();
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
	public boolean MembershipProc(Employee emp) {

		return true;
	}

	@Override
	public int LoginProc(String id, String pw) {
		String sql = "SELECT count(*) " +
				"FROM Employees "+
				"where id=? "+
				"AND pw=?";

		int result = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, pw);

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) 
				result = rs.getInt("count(*)");



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return result;
	}



	@Override
	public List<Employee> getEmployeeList() {
		// SELECT

		List<Employee> employeeList = new ArrayList<Employee>();

		String sql = "SELECT * " + 
				"FROM Member";

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
				emp.setGender(rs.getString("�ֹι�ȣ���ڸ�"));
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
				emp.setHoliday(rs.getString("�ް�"));

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
	public Employee getEmployee(String id) {
		List<Employee> employeeList = getEmployeeList();

		for(Employee emp : employeeList)
			if(id.equals(emp.getId()))
				return emp;

		return null;
	}

	@Override
	public List getDataFromListById(List list, String id) {
		List newList = new ArrayList<>();

		if(comServ.CheckClassType(list).equals("Employee")) {
			List<Employee> _list = list;
			for(Employee o : _list) 
				if(id.equals(o.getId())) 
					newList.add(o);
		}
		if(comServ.CheckClassType(list).equals("EmployeeHoliday")) {
			List<EmployeeHoliday> _list = list;
			for(EmployeeHoliday o : _list) 
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
		//	INSERT INTO commute VALUES("200401", 0, "2020-04-28", "08:54:00");
		//	INSERT INTO commute VALUES("200401", 0, "2020-04-28", "18:25:25");
		//
		//	INSERT INTO commute VALUES("200402", 0, "2020-04-28",  "08:58:20"); 
		//	INSERT INTO commute VALUES("200402", 0, "2020-04-28",  "18:08:17"); 
		//
		//	INSERT INTO commute VALUES("200403", 0, "2020-04-28", "08:25:10");
		//	INSERT INTO commute VALUES("200403", 0, "2020-04-28" , "18:00:10");
		//
		//	INSERT INTO commute VALUES("200404", 1,"2020-04-28" , "09:25:10");
		//	INSERT INTO commute VALUES("200404", 1,"2020-04-28" , "18:00:10");
		//
		//	INSERT INTO commute VALUES( "200404", 1,"2020-04-28" , "08:25:10");
		//	INSERT INTO commute VALUES("200404", 1,"2020-04-28" , "18:00:10");


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

		if(!whereOption.isEmpty()) {
			sql +="\n" + whereOption;
		}

		List list = new ArrayList<>();

		try {
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

			if(table.equals("EmployeeHoliday")) {

				while(rs.next()) {
					EmployeeHoliday2 empHoli = new EmployeeHoliday2();
					empHoli.setId(rs.getString("id"));
					empHoli.setYear(rs.getString("year"));
					empHoli.setOccurrenceDay(rs.getString("occurrenceDay"));
					empHoli.setUseDay(rs.getString("useDay"));
					empHoli.setRemainDay(rs.getString("remainDay"));
					// ...

					System.out.println(empHoli.getId());
					System.out.println(empHoli.getYear());
					System.out.println(empHoli.getRemainDay());
					list.add(empHoli);
				}
			}

			if(table.equals("SalaryResult")) {
				//List<SalaryResult> salaryResultList = new ArrayList<SalaryResult>();
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


					holidayRequest.setId(rs.getString("id"));
					holidayRequest.setName(rs.getString("name"));
					holidayRequest.setDepartment(rs.getString("department"));
					holidayRequest.setAvailableDay(rs.getString("availableDay"));
					holidayRequest.setRequestDay(rs.getString("requestDay"));
					holidayRequest.setStartDay(rs.getString("startDay"));
					holidayRequest.setEndDay(rs.getString("endDay"));
					holidayRequest.setPeriodDay(rs.getString("periodDay"));
					holidayRequest.setReason(rs.getString("reason"));
					holidayRequest.setApproval(rs.getString("approval"));

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
	public boolean SaveHolidayRequest(HolidayRequest holidayRequest) {
		String sql = "INSERT INTO HolidayRequest (id,name,department,availableDay,requestDay,startDay,endDay,periodDay,reason,approval)" + 
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

		return false;
	}




}
