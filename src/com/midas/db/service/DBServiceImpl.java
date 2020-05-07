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

				emp.setNum(rs.getString("사원번호"));
				emp.setId(rs.getString("id"));
				emp.setPw(rs.getString("pw"));
				emp.setName(rs.getString("이름"));
				emp.setBirth(rs.getString("생년월일"));
				emp.setSocialNum(rs.getString("주민번호뒷자리"));
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
				emp.setAvailableHoliday(rs.getString("총연차"));
				emp.setUsedHoliday(rs.getString("사용연차"));
				emp.setRemainHoliday(rs.getString("잔여연차"));

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
			rs.close();
			//conn.close();

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
				"WHERE 사원번호 like '%" + num + "%'";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
				Employee employee = new Employee();

				employee.setNum(rs.getString("사원번호"));
				employee.setId(rs.getString("id"));
				employee.setPw(rs.getString("pw"));
				employee.setName(rs.getString("이름"));
				employee.setBirth(rs.getString("생년월일"));
				employee.setSocialNum(rs.getString("주민번호뒷자리"));
				employee.setCategory(rs.getString("사원구분"));
				employee.setSalary(rs.getString("연봉"));
				employee.setDepartment(rs.getString("부서"));
				employee.setPosition(rs.getString("직급"));
				employee.setPlace(rs.getString("근무지"));
				employee.setPhone(rs.getString("전화번호"));
				employee.setJoin(rs.getString("입사일자"));
				employee.setEmail(rs.getString("이메일"));
				employee.setEducation(rs.getString("최종학력"));
				employee.setAddress(rs.getString("주소"));
				employee.setImage(rs.getString("사진url"));

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
			employee.setNum(rs.getString("사원번호"));
			employee.setId(rs.getString("id"));
			employee.setPw(rs.getString("pw"));
			employee.setName(rs.getString("이름"));
			employee.setBirth(rs.getString("생년월일"));
			employee.setSocialNum(rs.getString("주민번호뒷자리"));
			employee.setCategory(rs.getString("사원구분"));
			employee.setSalary(rs.getString("연봉"));
			employee.setDepartment(rs.getString("부서"));
			employee.setPosition(rs.getString("직급"));
			employee.setPlace(rs.getString("근무지"));
			employee.setPhone(rs.getString("전화번호"));
			employee.setJoin(rs.getString("입사일자"));
			employee.setEmail(rs.getString("이메일"));
			employee.setEducation(rs.getString("최종학력"));
			employee.setAddress(rs.getString("주소"));
			employee.setImage(rs.getString("사진url"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}
	private Employee biglst(ResultSet rs, Employee employee) {
		try {
			employee.setNum(rs.getString("사원번호"));
			employee.setName(rs.getString("이름"));
			employee.setCategory(rs.getString("사원구분"));
			employee.setDepartment(rs.getString("부서"));
			employee.setPosition(rs.getString("직급"));
			employee.setPlace(rs.getString("근무지"));
			employee.setPhone(rs.getString("전화번호"));
			employee.setJoin(rs.getString("입사일자"));
			employee.setEmail(rs.getString("이메일"));
			employee.setEducation(rs.getString("최종학력"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}
	private Employee smalllst(ResultSet rs, Employee employee) {
		try {
			employee.setNum(rs.getString("사원번호"));
			employee.setName(rs.getString("이름"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}
	@Override
	public boolean SaveInfo(Employee employee) {
		String sql = "INSERT INTO Employee (사원번호,id,pw,이름,생년월일,주민번호뒷자리,부서,전화번호,입사일자,이메일,최종학력,주소,사원구분,연봉,직급,근무지,사진url) " + 
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
	public boolean MembershipProc(Employee employee) {
		String sql = "INSERT INTO Employee (사원번호,id,pw,이름,생년월일,주민번호뒷자리,부서,전화번호,입사일자,이메일,최종학력,주소)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		// 회원가입

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
			return false;
		}
		return true;	// 정보 입력 잘되면 회원가입 성공
	}

	@Override
	public boolean LoginProc(String id, String pw) {
		String sql = "SELECT count(*) FROM Employee WHERE id=? AND pw=?";
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
	public List<Employee> getMember() {
		String sql = "SELECT * FROM Employee";
		List<Employee> lstEmp = new ArrayList<Employee>();

		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();

				emp.setNum(rs.getString("사원번호"));
				emp.setId(rs.getString("id"));
				emp.setPw(rs.getString("pw"));
				emp.setName(rs.getString("이름"));
				emp.setBirth(rs.getString("생년월일"));
				emp.setSocialNum(rs.getString("주민번호뒷자리"));
				emp.setDepartment(rs.getString("부서"));
				emp.setPhone(rs.getString("전화번호"));
				emp.setJoin(rs.getString("입사일자"));
				emp.setEmail(rs.getString("이메일"));
				emp.setEducation(rs.getString("최종학력"));
				emp.setAddress(rs.getString("주소"));

				lstEmp.add(emp);
			}
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
		String sql = "SELECT  count(*),id FROM Employee WHERE 이름=? AND 전화번호 = ?";
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
		String sql = "SELECT  count(*), pw FROM Employee WHERE 이름=? AND id = ? AND 전화번호 = ? ";
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
	public Employee getMember(String num) {
		String sql = "SELECT * " + 
				"FROM Employee " +
				"WHERE 사원번호 like '%" + num + "%'";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
				Employee member = new Employee();

				member.setNum(rs.getString("사원번호"));
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
				member.setPhone(rs.getString("전화번호"));
				member.setJoin(rs.getString("입사일자"));
				member.setEmail(rs.getString("이메일"));
				member.setEducation(rs.getString("최종학력"));
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
		String sql = "SELECT id, 이름  FROM Employee WHERE id=?";
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
		System.out.println("infopwCheck(" + id + ") ");
		String sql = "SELECT count(*) FROM Employee WHERE id=? AND pw=?";
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
