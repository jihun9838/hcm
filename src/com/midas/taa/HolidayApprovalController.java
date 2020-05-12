package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;

public class HolidayApprovalController extends Controller implements Initializable{
	private Parent root;
	private DBService dbServ;
	private CommonService comServ;
	@FXML DatePicker ApprovalDatePicker;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ApprovalDatePicker.setValue(LocalDate.now());
		dbServ = new DBServiceImpl();
		comServ = new CommonServiceImpl();

	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;

	}

	public void HoliAppTableShow(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		List<HolidayRequest> HoliAppList = dbServ.SelectTable("HolidayRequest", "");
		comServ.ShowTableViewByList(scene, "#HoliAppTable", HoliAppList);

	}

}
