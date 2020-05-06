package com.midas.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.midas.Controller;
import com.midas.MainController;
import com.midas.db.Employee;
import com.midas.db.service.DB2ExcelExporter;
import com.midas.taa.CalendarController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService{

	private CalendarController calCon;
	@FXML TableView<Employee> tableView;

	@Override
	public void WindowClose(ActionEvent event) {
		Parent root = (Parent)event.getSource();
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
		tableView.lookup("#id");
	}

	@Override
	public Parent showWindow(Stage s, String formPath) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		try {
			root = loader.load();
			s.setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
		}

		MainController ctrler = loader.getController();
		ctrler.setRoot(root);

		s.show();

		return root;
	}

	//Stage s = new Stage();
	//comServ.showWindow(s, "/com/midas/salary/SalaryMgmt.fxml", root);
	@Override
	public Parent showWindow(Stage s, String formPath, Parent parent) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = parent;
		try {
			root = loader.load();
			s.setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ?
		Controller ctrler = loader.getController();
		ctrler.setRoot(root);

		s.show();

		return root;
	}

	@Override
	public Parent AddScene(String formPath) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}

	@Override
	public BorderPane AddScene2(String formPath) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		BorderPane root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}
	
	@Override
	public void AddComboBox(Parent form, List<String> items, String comboFxid) {
		ComboBox<String> 	cmbAge = (ComboBox<String>)form.lookup(comboFxid);

		if(cmbAge!=null) {
			for(String item : items)
				cmbAge.getItems().add(item);
		}
	}

	@Override
	public boolean isComboBox(Parent membershipForm, String comboFxid) {
		ComboBox<String> 	cmbAge = (ComboBox<String>)membershipForm.lookup(comboFxid);

		if(cmbAge==null) return false;
		else if(cmbAge.getValue()==null) {
			cmbAge.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public String getComboBoxString(Parent membershipForm, String comboFxid) {
		ComboBox<String> cmbAge = (ComboBox<String>)membershipForm.lookup(comboFxid);
		if(cmbAge==null) return "";
		return cmbAge.getValue().toString();
	}



	@Override
	public Map<String, TextField> getTextFieldInfo(Parent membershipForm, String[] txtFldIdArr) {
		Map<String, TextField> txtFldMap = new HashMap<String, TextField>();

		for(String txtFldId : txtFldIdArr) {
			TextField txtFld = (TextField)membershipForm.lookup(txtFldId);
			txtFldMap.put(txtFldId, txtFld);
		}
		return txtFldMap;
	}

	@Override
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldIdArr) {
		for(String txtFldId : txtFldIdArr) {
			TextField txtFld = txtFldMap.get(txtFldId);

			if(txtFld.getText().isEmpty()) {
				txtFld.requestFocus();
				return true;
			}
		}
		return false;
	}

	@Override
	public void ErrorMsg(String title, String headerStr, String ContentTxt) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerStr);
		alert.setContentText(ContentTxt);
		alert.showAndWait();
	}

	@Override
	public void ErrorMsg(String headerStr, String ContentTxt) {
		// TODO Auto-generated method stub
		ErrorMsg("error", headerStr, ContentTxt);
	}

	@Override
	public void ErrorMsg(String ContentTxt) {
		// TODO Auto-generated method stub
		ErrorMsg("error", "error Header", ContentTxt);
	}



	@Override
	public void ExportExcel() {
		// TODO Auto-generated method stub
		new DB2ExcelExporter();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void ShowTableViewByList(Scene scene, String id, List list) {

		ObservableList tableList = FXCollections.observableArrayList();

		tableList.addAll(list);
		TableView<?> tableView = ((TableView)scene.lookup(id));
		tableView.setItems(tableList);
		tableView.requestFocus();
		tableView.getSelectionModel().select(0);
		tableView.getFocusModel().focus(0);
	}

	@Override
	public void ShowLineChart(Parent root, LineChart lineChart) {
		// TODO Auto-generated method stub

	}


	@Override
	public int CalculateRequestedHoliday(LocalDate d1, LocalDate d2) {

		//      LocalDate ld = null;
		//      // datePicker data
		//      LocalDate date = ld.now();
		//      int m1 = Integer.valueOf(date.toString().substring(0, 4));
		//      int w1 = Integer.valueOf(date.toString().substring(5, 5 + 2));
		//      int d1 = Integer.valueOf(date.toString().substring(8, 8 + 2));
		//      
		//      System.out.println(m1);
		//      System.out.println(w1);
		//      System.out.println(d1);
		//      
		//      int m1 = Integer.valueOf(date.substring(0, 4));
		//      int w1 = Integer.valueOf(date.substring(5, 5 + 2));
		//      int d1 = Integer.valueOf(date.substring(8, 8 + 2));
		//      
		//      // 날짜 날짜 사이


		/*
		 * String date = "2019-11-12T 12:30:54";
	         LocalDateTime localdatetime = LocalDateTime.parse(date);
	      // 결과 : parse 성공
		 */

		long days = d2.toEpochDay() - d1.toEpochDay() + 1;
		System.out.print("요청한 일 수 : \t\t");
		System.out.println(days);

		int requestHoliday = 0;

		for(LocalDate day = d1 ; day.isBefore(d2.plusDays(1)) ; day = day.plusDays(1)) {
			if(day.getDayOfWeek().name() == "SATURDAY" || day.getDayOfWeek().name() == "SUNDAY") continue;
			requestHoliday++;
		}

		System.out.print("휴가 쓸 수 있는 평일 날 : \t");
		return requestHoliday;
	}

	// var implementation
	@Override
	public String CheckClassType(Object o) {

		String className = o.getClass().getName();

		if(className.contains("TAAResult")) 		return "TAAResult";
		if(className.contains("TAA")) 				return "TAA";
		if(className.contains("SalaryResult")) 		return "SalaryResult";
		if(className.contains("HolidayRequest"))	return "HolidayRequest";
		if(className.contains("EmployeeHoliday")) 	return "EmployeeHoliday";
		if(className.contains("Employee")) 			return "Employee";

		return className;
	}

}
