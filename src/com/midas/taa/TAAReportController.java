package com.midas.taa;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.HolidayRequest;
import com.midas.db.SalaryResult;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TAAReportController extends Controller implements Initializable {
	private Parent root;
	private CommonService comServ;
	private TAAService TAAServ;
	private DBService dbServ;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl(); 
		TAAServ = new TAAServiceImpl();
		dbServ = new DBServiceImpl();
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void ReportProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String option = "WHERE " +
						"\"½ÂÀÎ¿©ºÎ\"" +"=" +"\"½ÂÀÎ\"";
		List<HolidayRequest> holiResultList = dbServ.SelectTable("HolidayRequest", option);
		System.out.println(holiResultList.size());
		TAAServ.ShowLineChartByList(scene, "#TAAReportLineChart", holiResultList);
	}
	
	
}
