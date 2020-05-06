package com.midas.salary;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class SalaryController extends Controller implements Initializable{

	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private SalaryService salServ;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	//	private Parent getScene(ActionEvent e) {
	//		Parent btnObj = (Parent)e.getSource();
	//		return btnObj.getScene().getRoot();
	//	}
	//

	//	private Parent getScene(Event e) {
	//		Parent btnObj = (Parent)e.getSource();
	//		return btnObj.getScene().getRoot();
	//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		salServ = new SalaryServiceImpl();
	}


	public void ShowTableProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		
		List<SalaryResult> salaryResultList = dbServ.SelectTable("SalaryResult", "");
		
		comServ.ShowTableViewByList(scene, "#salaryMgmtTableView", salaryResultList);
	}

	
	
	public void ShowReportProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		
		List<SalaryResult> salaryResultList = dbServ.SelectTable("SalaryResult", "");

		//comServ.ShowLineChart(salServ.AddDataToLineChart(empList));
	}

	
	
	public void ShowStmtProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		
		List<SalaryResult> salaryResultList = dbServ.SelectTable("SalaryResult", "");
		
		String id; // comServ.getTextFieldInfo(root, "#mainPageIdTf");

//		List<SalaryResult> lilililist = dbServ.getDataFromListById(salaryResultList, id);
//		
//		LocalDate date; // = comServ.getDatePickerInfo(root, "#salaryStmtDatePicker");
//		
//		for(SalaryResult salaryResult : lilililist) {
//			if(date.getMonth().equals(salaryResult.getMonth())) {
//				
//				salServ.ShowSalaryStmt(root, "#salaryStmtTextTf");
//				
//			}
//		}
				

		 
	}
}
