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
import com.midas.db.HolidayRequest;
import com.midas.db.SalaryResult;
import com.midas.db.TAA;
import com.midas.db.TAAResult;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

public class DBServiceImpl implements DBService{
	final String DRIVER = "org.sqlite.JDBC";
	final String DB = "jdbc:sqlite:C:/자바취업반/MIDAS_Project.db";
	//Connection conn;

	List<Employee> employeeList = new ArrayList<Employee>();
	CommonService comServ = new CommonServiceImpl();

	//	public DBServiceImpl() {
	//		comServ = new CommonServiceImpl();
	//		
	//		try {
	//			Connection conn;
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
			Connection conn;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, pw);

			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) 
				result = rs.getInt("count(*)");



		} catch (SQLException | ClassNotFoundException e) {
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
			Connection conn;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Employee emp = new Employee();

				emp.setNum(rs.getString("사원번호"));
				emp.setId(rs.getString("id"));
				emp.setPw(rs.getString("pw"));
				emp.setName(rs.getString("이름"));
				emp.setBirth(rs.getString("생년월일"));
				emp.setGender(rs.getString("주민번호뒷자리"));
				emp.setCategory(rs.getString("사원구분"));
				emp.setSalary(rs.getString("연봉"));
				emp.setDepartment(rs.getString("부서"));
				emp.setPosition(rs.getString("직급"));
				emp.setPlace(rs.getString("근무지"));
				emp.setPhone(rs.getString("전화번호"));
				emp.setJoin(rs.getString("입사일자"));
				emp.setEmail(rs.getString("이메일"));
				emp.setEducation(rs.getString("최종학력"));
				emp.setAddress(rs.getString("주소"));
				emp.setImage(rs.getString("사진url"));
				emp.setHoliday(rs.getString("휴가"));

				employeeList.add(emp);
			}
			stmt.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
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
	public List getDataFromListById(List list, String id, String option) {
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
			Connection conn;
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB);
			
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

					holidayRequest.setNum(rs.getString("사원번호"));
					holidayRequest.setId(rs.getString("id"));
					//				holidayRequest.setPw(rs.getString("pw"));
					//				holidayRequest.setName(rs.getString("이름"));
					//				holidayRequest.setBirth(rs.getString("생년월일"));
					//				holidayRequest.setGender(rs.getString("주민번호뒷자리"));
					//				holidayRequest.setCategory(rs.getString("사원구분"));
					//				holidayRequest.setSalary(rs.getString("연봉"));
					//				holidayRequest.setDepartment(rs.getString("부서"));
					//				holidayRequest.setPosition(rs.getString("직급"));
					//				holidayRequest.setPlace(rs.getString("근무지"));
					//				holidayRequest.setPhone(rs.getString("전화번호"));
					//				holidayRequest.setJoin(rs.getString("입사일자"));
					//				holidayRequest.setEmail(rs.getString("이메일"));
					//				holidayRequest.setEducation(rs.getString("최종학력"));
					//				holidayRequest.setAddress(rs.getString("주소"));
					//				holidayRequest.setImage(rs.getString("사진url"));
					holidayRequest.setIdx(rs.getString("idx"));
					holidayRequest.setStart(rs.getString("start"));
					holidayRequest.setEnd(rs.getString("end"));
					holidayRequest.setDays(rs.getString("days"));
					holidayRequest.setText(rs.getString("text"));

					list.add(holidayRequest);
				}
			}


			if(table.equals("TAAResult")) {
				while(rs.next()) {
					TAAResult empTAAResult = new TAAResult();

					empTAAResult.setNum(rs.getString("사원번호"));
					empTAAResult.setId(rs.getString("id"));
					//				empTAAResult.setPw(rs.getString("pw"));
					//				empTAAResult.setName(rs.getString("이름"));
					//				empTAAResult.setBirth(rs.getString("생년월일"));
					//				empTAAResult.setGender(rs.getString("주민번호뒷자리"));
					//				empTAAResult.setCategory(rs.getString("사원구분"));
					//				empTAAResult.setSalary(rs.getString("연봉"));
					//				empTAAResult.setDepartment(rs.getString("부서"));
					//				empTAAResult.setPosition(rs.getString("직급"));
					//				empTAAResult.setPlace(rs.getString("근무지"));
					//				empTAAResult.setPhone(rs.getString("전화번호"));
					//				empTAAResult.setJoin(rs.getString("입사일자"));
					//				empTAAResult.setEmail(rs.getString("이메일"));
					//				empTAAResult.setEducation(rs.getString("최종학력"));
					//				empTAAResult.setAddress(rs.getString("주소"));
					//				empTAAResult.setImage(rs.getString("사진url"));
					empTAAResult.setYear(rs.getString("year"));
					empTAAResult.setMonth(rs.getString("month"));
					empTAAResult.setTAA(rs.getString("taa"));

					list.add(empTAAResult);
				}
			}

			if(table.equals("TAA")) {
				while(rs.next()) {
					TAA empTAA = new TAA();

					empTAA.setNum(rs.getString("사원번호"));
					empTAA.setId(rs.getString("id"));
					//				empTAA.setPw(rs.getString("pw"));
					//				empTAA.setName(rs.getString("이름"));
					//				empTAA.setBirth(rs.getString("생년월일"));
					//				empTAA.setGender(rs.getString("주민번호뒷자리"));
					//				empTAA.setCategory(rs.getString("사원구분"));
					//				empTAA.setSalary(rs.getString("연봉"));
					//				empTAA.setDepartment(rs.getString("부서"));
					//				empTAA.setPosition(rs.getString("직급"));
					//				empTAA.setPlace(rs.getString("근무지"));
					//				empTAA.setPhone(rs.getString("전화번호"));
					//				empTAA.setJoin(rs.getString("입사일자"));
					//				empTAA.setEmail(rs.getString("이메일"));
					//				empTAA.setEducation(rs.getString("최종학력"));
					//				empTAA.setAddress(rs.getString("주소"));
					//				empTAA.setImage(rs.getString("사진url"));
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

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ERROR : SelectTable");
		return null;
	}
}
