package com.midas.taa._06;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HolidayApprovalController extends Controller implements Initializable{
	private Parent root;
	//private DBService dbServ;
	private CommonService comServ;
	private TAAService TAAServ;
	@FXML Label todayLbl;
	@FXML ComboBox<String> cmbSort;
	@FXML TextField searchTf;
	@FXML TableView<String> HoliAppTableView;
	private final String[] items = {"사원번호", "이름", "부서", "잔여연차", "요청일", "시작일", "종료일", "기간", "사유", "승인여부"};

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		todayLbl.setText(LocalDate.now().toString().substring(0, 7));
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		TAAServ.addComboBoxInController(cmbSort, items);
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void HoliAppTableShow(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		List<HolidayRequest> requestList = new DBServiceImpl().SelectHolidayApprovalSearch(cmbSort.getValue(), searchTf.getText());
		comServ.ShowTableViewByList(scene, "#HoliAppTableView", requestList);
	}
	
	public void approvalBtn(ActionEvent e) {
		List<HolidayRequest> requestList = new DBServiceImpl().SelectHolidayApprovalSearch(cmbSort.getValue(), searchTf.getText());
		TAAServ.ApprovalHoliday(requestList, HoliAppTableView);
	}
	
	public void declineBtn(ActionEvent e) {
		List<HolidayRequest> requestList = new DBServiceImpl().SelectHolidayApprovalSearch(cmbSort.getValue(), searchTf.getText());
		TAAServ.DeclineHoliday(requestList, HoliAppTableView);
	}
}
