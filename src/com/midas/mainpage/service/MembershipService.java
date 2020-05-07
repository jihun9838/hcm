package com.midas.mainpage.service;


import java.util.Map;

import com.midas.db.Employee;


public interface MembershipService {
	public boolean comparePW(String pw, String pwOk);

	public boolean MembershipProc(Employee employee);
	public Map<String,String> getMember();
}
