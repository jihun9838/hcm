package com.midas.db.service;

import java.util.List;

import com.midas.db.Employee;
import com.midas.db.HolidayRequest;

public interface DBService {

	// db controller
	public List<Employee> getEmployeeList();
	public Employee getEmployeeById(String id);
	public void addEmployee(Employee emp);
	public void deleteEmployee(String id);
	public void editEmployee(String id);
	//public boolean hasId(String id);

	public List getDataFromListById(List list, String id, String whereOption);

	public void CreateTable(String table);
	public void InsertTable(String table);
	public void UpdateTable(String table);
	public List SelectTable(String table, String option);



	// YOU
	public Employee getEmployee(String num);
	public List<Employee> getEmployeelst(int i);
	public List<Employee> getEmployeeSearch(String attribute, String txt, int i);
	public boolean SaveInfo(Employee employee);
	public boolean EditInfo(String num, Employee employee);




	// Eunji
	public boolean MembershipProc(Employee employee);	// 회원가입시 개인정보를 DB에 저장
	public boolean LoginProc(String id, String pw);	// ID와 PW로 개인인증
	public List<Employee> getMember();
	public boolean idcheck(String id);

	public boolean searchID(String name, String PhoneNum);
	public boolean searchPW(String name, String id, String PhoneNum);
	public String [] homepage(String id);
	public boolean infopwCheck(String id);
	public Employee getMember(String num);
	
	//JeongSoo
	public boolean SaveHolidayRequest(HolidayRequest holidayRequest);
	public List<Employee> SelectTableHoliday(String whereOption);
	
	
	
	/*
	 * public List<EmployeeHoliday> getEmployeeHolidayList();
	public List<SalaryResult> getSalaryResultList();
	public List<TAA> getTAA();
	public List<TAAResult> getTAAResult();
	public List<HolidayRequest> getHolidayRequest();
	 */


}
