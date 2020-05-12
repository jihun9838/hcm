package com.midas.taa;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class HolidayApprovalStmtController extends Controller implements Initializable {
	private Parent root;
	@FXML TextArea TAAReportTA;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TAAReportTA.clear();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	
	public void HolidayStmtExportToExcel(ActionEvent e) {
		
	}

}
