package com.midas.mainpage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;



public class MembershipServiceImpl implements MembershipService {
	private DBService dbServ = new DBServiceImpl();

	@Override
	public boolean comparePW(String pw, String pwOk) {

		return pw.contentEquals(pwOk);
	}


	@Override
	public boolean MembershipProc(Employee employee) {
		return dbServ.MembershipProc(employee);
	}

	@Override
	public Map<String, String> getMember() {
		List<Employee> lstEmployee = dbServ.getEmployeeList();
		Map<String, String> mapEmployee= new HashMap<String, String>();

		for(Employee emp: lstEmployee)
			mapEmployee.put(emp.getId(), emp.getName());

		return mapEmployee;
	}

}











