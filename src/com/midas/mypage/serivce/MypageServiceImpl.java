package com.midas.mypage.serivce;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

public class MypageServiceImpl implements MypageService{

	@Override
	public Employee getEmployee(String id) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.getMember(id);
	}

}
