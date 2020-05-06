package com.midas.salary;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.SalaryResult;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.salary.service.SalaryService;
import com.midas.salary.service.SalaryServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class SalaryController extends Controller implements Initializable{

	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private SalaryService salServ;
	
	@FXML private TextField salaryMgmtNameTextField;
	@FXML ComboBox salaryMgmtComboBox;
	@FXML ChoiceBox salaryMgmtChoiceBox;
	@FXML DatePicker salaryMgmtDatePicker;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		salServ = new SalaryServiceImpl();
	}


	public void ShowTableProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		
		String option = "";
		List<SalaryResult> salaryResultList = dbServ.SelectTable("SalaryResult", option);
		
		salServ.ShowTableViewByList(scene, "#salaryMgmtTableView", salaryResultList);
	}

	public void SalaryMgmtExportToExcel(ActionEvent e) {
		
	}
	
	public void ShowReportProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		
		String option = "";
		List<SalaryResult> salaryResultList = dbServ.SelectTable("SalaryResult", option);
		
		salServ.ShowLineChartByList(scene, "#salaryReportLineChart", salaryResultList);
		
		
		//Parent sss = ((Parent)e.getSource()).getParent().getParent().getParent().getParent();
		//TextField tf = (TextField)scene.lookup("#salaryMgmtNameTextField");
//		Parent root = null;
//		TextField tf1 = (TextField)root.lookup("#salaryMgmtNameTextField");
//		
//		tf1.setText("¤»¤»");
//		System.out.println(tf1.getText());
	}

	public void SalaryReportExportToExcel() {
		
	}
	
	public void ShowStmtProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		
		String option = "WHERE id = \"cat\" AND month = 4";
		
//		LocalDate date; // = comServ.getDatePickerInfo(root, "#salaryStmtDatePicker");
//		
//		for(SalaryResult salaryResult : lilililist) {
//			if(date.getMonth().equals(salaryResult.getMonth())) {
//				
//				salServ.ShowSalaryStmt(root, "#salaryStmtTextTf", salaryResult);
//				break;
//			}
//		}
		
		//List<SalaryResult> salaryResult = dbServ.SelectTable("SalaryResult", "WHERE id = " + id);
		List<SalaryResult> salaryResultList = dbServ.SelectTable("SalaryResult", option);
		
		if(salaryResultList.isEmpty())
			System.out.println("sad,.fj kahsdlfkjabdlgknbadflkgjnsbdfkjbsdkljsdlfjknlkjfnv");
		
		SalaryResult salaryResult = salaryResultList.get(0); 
		System.out.println(salaryResultList.size());
		
		salServ.ShowSalaryStmt(scene, "#salaryStmtTa", salaryResult);
	}
	
	public void SalaryStmtExportToExcel() {
		
	}
}
