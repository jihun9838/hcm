package com.midas.hr.service;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

public class AddInfoServiceImpl implements AddInfoService {

	@Override
	public boolean SaveInfo(Employee employee) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.SaveInfo(employee);
	}

}
