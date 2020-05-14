package com.midas.taa.own._04;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.HolidayRequest;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

// 구현완료.. 화면구성에 추가 직전

public class OwnHolidayApprovalStmtController extends Controller implements Initializable {
	private Parent root;
	private CommonService comServ;
	@FXML TextArea TAAReportTA;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TAAReportTA.clear();
		comServ = new CommonServiceImpl();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	
	public void HolidayStmtExportToExcel(ActionEvent e) {
		String num = comServ.getUserLabel(root);
		Scene scene = ((Parent)e.getSource()).getScene();
		HolidayRequest hr = new HolidayRequest();
		new TAAServiceImpl().ShowHolidayStmt(scene, num, hr);
	}

}
