package com.midas.mainpage.service;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

public class SearchServiceImp implements SearchService{
	private DBService dbServ = new DBServiceImpl();
	
	@Override
	public boolean MembershipProc(Employee emp) {
		// TODO Auto-generated method stub
		return dbServ.MembershipProc(emp);
	}

	

}