package com.midas.taa._02;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TAAReportController extends Controller implements Initializable {
	@SuppressWarnings("unused")
	private Parent root;
	private TAAService TAAServ;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TAAServ = new TAAServiceImpl();
	}
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void ReportProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String option = "WHERE " +
						"\"½ÂÀÎ¿©ºÎ\"" +"=" +"\"½ÂÀÎ\"";
		@SuppressWarnings("unchecked")
		List<HolidayRequest> holiResultList = new DBServiceImpl().SelectTable("HolidayRequest", option);
		System.out.println(holiResultList.size());
		TAAServ.ShowLineChartByList(scene, "#TAAReportLineChart", holiResultList);
	}
}
