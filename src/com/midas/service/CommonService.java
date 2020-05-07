package com.midas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD:src/com/midas/service/CommonService.java
=======
import com.midas.db.Employee;

>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7:MIDAS-HCM/src/com/midas/service/CommonService.java
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface CommonService {
	public void WindowClose(ActionEvent event);
	public Parent showWindow(Stage s, String formPath);
	public Parent showWindow(Stage s, String formPath, Parent parent);
	public Parent AddScene(String formPath);
<<<<<<< HEAD:src/com/midas/service/CommonService.java
	public BorderPane AddScene2(String formPath);
	
	public void AddComboBox(Parent form, List<String> Items, String comboFxid);
	public boolean isComboBox(Parent membershipForm, String comboFxid);
	public String getComboBoxString(Parent membershipForm, String comboFxid);
=======
	public Parent AddScene2(String formPath, Parent parent);
	
	public Map<String, TextField> getTextFieldInfo(Parent membershipForm, String [] txtFldIdArr);
	public void AddComboBox(Parent form, List<String> Items, String comboFxid);
	public String getComboBoxString(Parent membershipForm, String comboFxid);
	public Map<String, ComboBox<String>> getComboBoxInfo(Parent membershipForm, String[] comboFldIdArr);
	public boolean isComboBox(Parent membershipForm, String comboFxid);
	public boolean isEmptyTxt(Map<String, TextField> txtFldMap, String[] txtFldIdArr);
	public boolean isEmptyCombo(Map<String, ComboBox<String>> comboFldMap, String[] comboFldIdArr);

	public boolean isEmpty(Map<String, TextField> txtFldMap, String [] txtFldIdArr);
	
	public List<Employee> getEmployeeList(int i);
	public List<Employee> getEmployeeSearch(String attribute, String txt, int i);
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7:MIDAS-HCM/src/com/midas/service/CommonService.java
	
	public void ErrorMsg(String title, String headerStr, String ContentTxt);
	public void ErrorMsg(String headerStr, String ContentTxt);
	public void ErrorMsg(String ContentTxt);
	
<<<<<<< HEAD:src/com/midas/service/CommonService.java
	public Map<String, TextField> getTextFieldInfo(Parent membershipForm, String [] txtFldIdArr);
	public boolean isEmpty(Map<String, TextField> txtFldMap, String [] txtFldIdArr);
	
	public void ExportExcel();
	public void ShowTableViewByList(Scene scene, String id, List list);
	public void ShowLineChart(Parent root, LineChart lineChart);
	
	public int CalculateRequestedHoliday(LocalDate d1, LocalDate d2);
	
	public String CheckClassType(Object o);
=======
	
	public void ExportExcel();
	public void ShowTableViewByList(Scene scene, String id, List list);
	public void ShowLineChartByList(Scene scene, String _id, List _list);
	
	public int CalculateRequestedHoliday(LocalDate d1, LocalDate d2);
	
	public String CheckClassType(List o);
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7:MIDAS-HCM/src/com/midas/service/CommonService.java
}
