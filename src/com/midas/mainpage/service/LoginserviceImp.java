package com.midas.mainpage.service;

import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginserviceImp implements Loginservice{
	private DBService dbServ = new DBServiceImpl();

	@Override
	public boolean loginProc(Parent root) {
		TextField loginidTxt = (TextField)root.lookup("#loginIdTxt");
		TextField loginpwTxt = (TextField)root.lookup("#loginPwTxt");

		DBService dbServ = new DBServiceImpl();

		if(dbServ.LoginProc(loginidTxt.getText(), loginpwTxt.getText())==true)
			return true;
		return false;
	}


	@Override
	public String[] homeProc(String id) {
		return dbServ.homepage(id);
	}
}

