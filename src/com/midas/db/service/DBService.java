package com.midas.db.service;

import java.util.List;

import com.midas.db.Employee;
import com.midas.db.EmployeeHoliday;
import com.midas.db.HolidayRequest;
import com.midas.db.SalaryResult;
import com.midas.db.TAA;
import com.midas.db.TAAResult;

public interface DBService {
	//회원 가입 시 개인 정보를 DB에 저장
	public boolean MembershipProc(Employee emp);
	//ID와 PW로 개인 인증
	public int LoginProc(String id, String pw);


	// db controller
	public List<Employee> getEmployeeList();
	public Employee getEmployee(String id);
	public void addEmployee(Employee emp);
	public void deleteEmployee(String id);
	public void editEmployee(String id);
	//public boolean hasId(String id);

	public List getDataFromListById(List list, String id, String whereOption);
	
	public void CreateTable(String table);
	public void InsertTable(String table);
	public void UpdateTable(String table);
	public List SelectTable(String table, String option);
	/*
	 * public List<EmployeeHoliday> getEmployeeHolidayList();
	public List<SalaryResult> getSalaryResultList();
	public List<TAA> getTAA();
	public List<TAAResult> getTAAResult();
	public List<HolidayRequest> getHolidayRequest();
	 */


}
