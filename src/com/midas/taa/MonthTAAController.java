package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;
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

public class MonthTAAController extends Controller implements Initializable{

	@FXML private DatePicker MonthDatePicker;
	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		MonthDatePicker.setValue(LocalDate.now());
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		
	}
	
	public void monthSearch(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene(); 
		//List<HolidayRequest> MonthTAAList = dbServ.SelectTable("HolidayRequest", "");  //°íÃÄºÁ
		//comServ.ShowTableViewByList(scene, "#MonthTAATable", MonthTAAList);
	}
}
