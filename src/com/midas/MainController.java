package com.midas;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.db.EmployeeHoliday2;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController extends Controller implements Initializable{

	private CommonService comServ;;
	private DBService dbServ;
	private Parent root;
	@FXML Pane calendarPane;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
	}

	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}

	private Parent getScene(Event e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}

	public void HomepageView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/Homepage.fxml");
		borderPane.setCenter(root);
	}

	public void EmployeeMenuView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/Employee.fxml");
		borderPane.setLeft(root);
	}

	public void ManagerMenuView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/Manager.fxml");
		borderPane.setLeft(root);
	}


	//Salary
	public void SalaryMgmtView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/SalaryMgmt.fxml");
		borderPane.setCenter(root);
	}

	public void SalaryReportView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene2("/com/midas/SalaryReport.fxml");
		borderPane.setCenter(root);
	}

	public void SalaryStmtView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/SalaryStmt.fxml");
		borderPane.setCenter(root);
	}

	//	public void ViewTableProc(ActionEvent e) {
	//		SalaryController sc = new SalaryController();
	//		sc.ViewTableProc(e);
	//	}

	//TAA Manager
	public void SetCalendarView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent root = comServ.AddScene("/com/midas/taa/SetCalendar.fxml");
		borderPane.setCenter(root);
	}

	public void TAAReportView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent root = comServ.AddScene("/com/midas/taa/TAAReport.fxml");
		borderPane.setCenter(root);
	}

	public void MonthTAAView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/MonthTAA.fxml");

		Parent form = root;
		String [] departItems= {"부서1", "부서2", "부서3", "부서4", "부서5"};
		String [] sortItems= {"사원번호", "이름"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");

		borderPane.setCenter(root);
	}

	public void PersonalTAAView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/PersonalTAA.fxml");
		
		Parent form = root;
		String [] departItems= {"부서1", "부서2", "부서3", "부서4", "부서5"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		
		borderPane.setCenter(root);
	}

	public void TAAListView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/TAAList.fxml");

		Parent form = root;
		String [] departItems= {"부서1", "부서2", "부서3", "부서4", "부서5"};
		String [] sortItems= {"사원번호", "이름"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");

		borderPane.setCenter(root);
	}

	public void HolidayApprovalView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/HolidayApproval.fxml");
		
		Parent form = root;
		String [] departItems= {"부서1", "부서2", "부서3", "부서4", "부서5"};
		String [] sortItems= {"사원번호", "이름"};
		String [] approvalItems = {"승인", "미승인", "반려"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");
		comServ.AddComboBox(form, Arrays.asList(approvalItems), "#cmbApproval");
		
		borderPane.setCenter(root);
	}

	public void HolidayModifyView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/HolidayModify.fxml");
		borderPane.setCenter(root);
	}
	
	//TAA Employee
	public void OwnTAAView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnTAA.fxml");
		borderPane.setCenter(root);
	}
	
	public void OwnAskHolidayView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnAskHoliday.fxml");
		
		Parent form = root;
		String [] FullHalfItems= {"전일", "반일"};
		comServ.AddComboBox(form, Arrays.asList(FullHalfItems), "#cmbFullHalf");
		
		borderPane.setCenter(root);
		
		Scene scene = ((Parent)e.getSource()).getScene();
		List<EmployeeHoliday2> OwnHolidayList = dbServ.SelectTable("EmployeeHoliday", "WHERE id = \"200401\""); //로그인 한 사람의 아이디
		comServ.ShowTableViewByList(scene, "#OwnRemainTable", OwnHolidayList);
	}
	
	public void OwnModifyHolidayView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnModifyHoliday.fxml");
		
		String [] TypeItems= {"연차", "출장", "조퇴", "결근", "지각", "출근"};
		
		borderPane.setCenter(root);
		
	}
	
	
	
	


}
