package com.midas.hr.service;

import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class HRServiceImpl implements HRService{
	@Override
	public Parent OpenDetailForm() {
		CommonService comServ = new CommonServiceImpl();
		Stage membershipForm = new Stage();
		return comServ.showWindow(membershipForm, "/com/midas/hr/HRMDetailInfo.fxml");
	}

	@Override
	public Parent OpenAddForm() {
		CommonService comServ = new CommonServiceImpl();
		Stage membershipForm = new Stage();
		return comServ.showWindow(membershipForm, "/com/midas/hr/HRMAddInfo.fxml");
	}

}
