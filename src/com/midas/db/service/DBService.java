package com.midas.db.service;

import java.util.List;

import com.midas.db.Commute;
import com.midas.db.Employee;
import com.midas.db.HolidayRequest;
import com.midas.db.TAA;

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
	public boolean DeleteInfo(String num);




	// Eunji
	public boolean MembershipProc(Employee employee);	// ȸ�����Խ� ���������� DB�� ����
	public boolean LoginProc(String id, String pw);	// ID�� PW�� ��������
	public List<Employee> getMember();
	public boolean idcheck(String id);
	public boolean numcheck(String num);

	public boolean searchID(String name, String PhoneNum);
	public boolean searchPW(String name, String id, String PhoneNum);
	public String [] homepage(String id);
	public Employee getMember(String num);
	public boolean infopwCheck(String id, String pw);
	public boolean mypage(String id, Employee employee, boolean n);
	
	
	//jspark
	public boolean SaveHolidayRequest(HolidayRequest holidayRequest);
	public List<Employee> SelectTableHoliday(String attribute, String txt, int i);
	public List<Employee> SelectTableHoliday(String whereOption);
	public List<HolidayRequest> SelectHolidayApprovalSearch(String attribute, String txt);
	public boolean UpdateTableWitnSQL(String UPDATESQL);
	public boolean SaveCommute(Commute commute);
	public void SaveCommute(Commute commute, String loginNum, String Sortation, String timeStr);
	public boolean SaveTAA(TAA TAA);
	public boolean UpdateTAA(TAA TAA, String num);
	public List<Commute> CommuteCountAllList(String whereOption);
	public Commute getCommute(String whereOption);


}
