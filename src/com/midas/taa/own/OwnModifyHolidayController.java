package com.midas.taa.own;

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
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class OwnModifyHolidayController extends Controller implements Initializable {
	private Parent root;
	private CommonService comServ;
	private TAAService TAAServ;
	private DBService dbServ;
	@FXML private Label dayLbl;
	@FXML private DatePicker AskDatePicker;
	private int year, month;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		dbServ = new DBServiceImpl();
		AskDatePicker.setPromptText(LocalDate.now().getYear()+"."+LocalDate.now().getMonthValue());
		dayLbl.setText("날짜를 선택하세요.");
		year = LocalDate.now().getYear();
		month = LocalDate.now().getMonthValue();
	}
	
	public void checkAskDate(ActionEvent e) {
		year = AskDatePicker.getValue().getYear();
		month = AskDatePicker.getValue().getMonthValue();
	}
	
	public void SearchMyHolidayTable(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String requestYearMonth = Integer.toString(year)+"-0"+Integer.toString(month);
		List<HolidayRequest> OwnHolidayAskList = dbServ.SelectTable("HolidayRequest", "WHERE " +"\"사원번호\"" + "=" + "\"200401\""+
		"AND "+ "\"요청일\""+" like '%" + requestYearMonth + "%'");
		//로그인 된 사람 id
		comServ.ShowTableViewByList(scene, "#OwnAskTable", OwnHolidayAskList);
	}
	
	


}
