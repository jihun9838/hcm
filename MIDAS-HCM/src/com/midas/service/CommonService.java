package com.midas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.midas.db.SalaryResult;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public interface CommonService {
	public void WindowClose(ActionEvent event);
	public Parent showWindow(Stage s, String formPath);
	public Parent showWindow(Stage s, String formPath, Parent parent);
	public Parent AddScene(String formPath);
	public Parent AddScene(String formPath, Parent parent);
	
	public void ErrorMsg(String title, String headerStr, String ContentTxt);
	public void ErrorMsg(String headerStr, String ContentTxt);
	public void ErrorMsg(String ContentTxt);
	
	public Map<String, TextField> getTextFieldInfo(Parent membershipForm, String [] txtFldIdArr);
	public boolean isEmpty(Map<String, TextField> txtFldMap, String [] txtFldIdArr);

	public void ShowTableViewByList(Scene scene, String id, List list);
	public void ShowLineChartByList(Scene scene, String id, List list);

	public int CalculateRequestedHoliday(LocalDate d1, LocalDate d2);
	
	public void ExportExcel();
	public String CheckClassType(List o);
}
