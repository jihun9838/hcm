package com.midas.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.SalaryResult;
import com.midas.db.service.DB2ExcelExporter;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.mainpage.service.Loginservice;
import com.midas.mainpage.service.LoginserviceImp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CommonServiceImpl implements CommonService{
	//@FXML TableView<Employee> tableView;

	@Override
	public Parent getSuperRoot(Parent root) {
		while(root.getParent() != null)	root = root.getParent();
		return root;
	}

	@Override
	public void setPageLabel(Parent root, String text) {
		((Label)getSuperRoot(root).lookup("#homepageLbl")).setText(text);
	}

	@Override
	public String getUserLabel(Parent root) {		
		return ((Label)getSuperRoot(root).lookup("#IDLbl")).getText();
	}

	@Override
	public String setUserLabel(Parent root, String id) {
		Loginservice loginServ = new LoginserviceImp();
		Label idlbl = (Label)root.lookup("#IDLbl");
		Label hellolbl = (Label)root.lookup("#helloLbl");

		String [] home = loginServ.homeProc(id);
		idlbl.setText(home[0]);
		if("���".contentEquals(home[2])) {
			hellolbl.setText(home[1]+"�� �ȳ��ϼ���.");
		}
		else {
			hellolbl.setText("�����ڴ� �ȳ��ϼ���.");
		}

		return home[2];
	}





	@Override
	public void WindowClose(ActionEvent event) {
		Parent root = (Parent)event.getSource();
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
		//tableView.lookup("#id");
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

		// ?
		Controller ctrler = loader.getController();
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
	public Parent AddSceneWithControllerOnRoot(String formPath, Parent parent) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = parent;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Controller ctrler = loader.getController();
		ctrler.setRoot(root);
		return root;
	}

	@Override
	public Parent AddSceneWithController(String formPath) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Controller ctrler = loader.getController();
		ctrler.setRoot(root);
		return root;
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
	public void AddComboBox(Parent form, List<String> items, String comboFxid) {
		ComboBox<String> 	cmbAge = (ComboBox<String>)form.lookup(comboFxid);

		if(cmbAge!=null) {
			for(String item : items)
				cmbAge.getItems().add(item);
		}
	}



	@Override
	public String getComboBoxString(Parent membershipForm, String comboFxid) {
		ComboBox<String> cmbAge = (ComboBox<String>)membershipForm.lookup(comboFxid);
		if(cmbAge==null) return "";
		return cmbAge.getValue().toString();
	}


	@Override
	public Map<String, ComboBox<String>> getComboBoxInfo(Parent membershipForm, String[] comboFldIdArr) {
		Map<String, ComboBox<String>> comboFldMap = new HashMap<String, ComboBox<String>>();

		for(String comboFldId : comboFldIdArr) {
			ComboBox<String> comboFld = (ComboBox<String>)membershipForm.lookup(comboFldId);
			comboFldMap.put(comboFldId, comboFld);
		}
		return comboFldMap;
	}

	@Override
	public boolean isEmptyTxt(Map<String, TextField> txtFldMap, String[] txtFldIdArr) {
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
	public boolean isEmptyCombo(Map<String, ComboBox<String>> comboFldMap, String[] comboFldIdArr) {
		for(String comboFldId : comboFldIdArr) {
			ComboBox<String> comboFld = comboFldMap.get(comboFldId);

			if(comboFld.getValue() == null) {
				comboFld.requestFocus();
				return true;
			}
		}
		return false;
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
	public List<Employee> getEmployeeList(int i) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.getEmployeelst(i);
	}

	@Override
	public List<Employee> getEmployeeSearch(String attribute, String txt, int i) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.getEmployeeSearch(attribute, txt, i);
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
	public boolean ConfirmMsg(String title, String headerStr, String ContentTxt) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerStr);
		alert.setContentText(ContentTxt);

		Optional<ButtonType> result =  alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public void ExportExcel() {
		// DB2ExcelExporter exporter = new DB2ExcelExporter(); 
		new DB2ExcelExporter();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void ShowTableViewByList(Scene scene, String id, List list) {
		TableView<?> tableView = (TableView)scene.lookup(id);

		ObservableList tableList = FXCollections.observableArrayList();

		tableList.addAll(list);

		tableView.setItems(tableList);
	}

	@Override
	public void ShowLineChartByList(Scene scene, String _id, List _list) {
		LineChart<String, Number> lineChart = (LineChart)scene.lookup(_id);
		lineChart.getData().clear();
		Map<String, Integer> name = new HashMap<String, Integer>();

		//		if(comServ.getComboBoxInfo().equals("�ְ�")) {}
		//		if(comServ.getComboBoxInfo().equals("����")) {}
		//		if(comServ.getComboBoxInfo().equals("����")) {}

		CategoryAxis xAxis = new CategoryAxis();	xAxis.setLabel("��¥");
		NumberAxis yAxis = new NumberAxis();		yAxis.setLabel("�޿� (����)");

		XYChart.Series<String, Number>[] series = new XYChart.Series[5];
		if(CheckClassType(_list).equals("SalaryResult")) {
			System.out.println("Checking LineChart by SalaryResult ");
			List<SalaryResult> list = _list;

			Collections.sort(list, new Comparator<SalaryResult>() {
				@Override
				public int compare(SalaryResult o1, SalaryResult o2) {
					return Integer.valueOf(o1.getYear() + o1.getMonth()).compareTo(Integer.valueOf(o2.getYear() + o2.getMonth()));  
				}
			});
			for(SalaryResult o : list) {
				String id = o.getId();
				if(!name.containsKey(id)) {
					name.put(id, name.size());
					series[name.get(id)] = new XYChart.Series<String, Number>();
					series[name.get(id)].setName(id);
				}
				series[name.get(id)].getData().add(new XYChart.Data(
						String.valueOf(o.getYear() + "." + o.getMonth()), Integer.valueOf(o.getSalary())));
			}
		}

		for(int i = 0 ; i < name.size() ; ++i)
			lineChart.getData().add(series[i]);

		//ObservableList chartList = FXCollections.observableArrayList();

		//chartList.addAll(series[0], series[1]);
		//lineChart.getData().addAll(chartList);







		//		
		//		
		//		BorderPane borderPane = (BorderPane)getScene(e);
		//		
		////		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		////		Parent root = null;
		////		try {
		////			root = loader.load();
		////		} catch (IOException e) {
		////			e.printStackTrace();
		////		}
		////		return root;
		////		
		//		Parent roots = new Pane();
		//		Parent sceness = AddScene("/com/midas/salary/SalaryReportLineChart.fxml");
		//		borderPane.setCenter(scenes);
		//		//Scene scene = new Scene(lineChart);
		//		
		//		
		//		
		//		
		//		
		//		
		//		BorderPane borderPane = (BorderPane)root;
		//		borderPane.setCenter(pane);
		////		
		////		public void SalaryStmtView(Event e) {
		////			BorderPane borderPane = (BorderPane)getScene(e);
		////			Parent scene = comServ.AddScene("/com/midas/salary/SalaryStmt.fxml");
		////			borderPane.setCenter(scene);
		////		}
		////
		////		
		////		
		////		// if(dbServ.getEmployee(id).getCategory() == 1)
		////		Parent empMenuScene = comServ.AddScene("/com/midas/Employee.fxml");
		////		// else
		////		Parent manMenuScene = comServ.AddScene("/com/midas/Manager.fxml");
		////		
		////		Parent s = comServ.AddScene("/com/midas/salary/SalaryMgmt.fxml");
		////
		////		
		////		
		////		//borderPane.setLeft(empMenuScene);
		////		borderPane.setLeft(manMenuScene);
		////		borderPane.setCenter(s);		
	}


	@Override
	public int CalculateRequestedHoliday(LocalDate d1, LocalDate d2) {

		//		LocalDate ld = null;
		//		// datePicker data
		//		LocalDate date = ld.now();
		//		int m1 = Integer.valueOf(date.toString().substring(0, 4));
		//		int w1 = Integer.valueOf(date.toString().substring(5, 5 + 2));
		//		int d1 = Integer.valueOf(date.toString().substring(8, 8 + 2));
		//		
		//		System.out.println(m1);
		//		System.out.println(w1);
		//		System.out.println(d1);
		//		
		//		int m1 = Integer.valueOf(date.substring(0, 4));
		//		int w1 = Integer.valueOf(date.substring(5, 5 + 2));
		//		int d1 = Integer.valueOf(date.substring(8, 8 + 2));
		//		
		//		// ��¥ ��¥ ����


		/*
		 * String date = "2019-11-12T 12:30:54";
			LocalDateTime localdatetime = LocalDateTime.parse(date);
		// ��� : parse ����
		 */

		long days = d2.toEpochDay() - d1.toEpochDay() + 1;
		System.out.print("��û�� �� �� : \t\t");
		System.out.println(days);

		int requestHoliday = 0;

		for(LocalDate day = d1 ; day.isBefore(d2.plusDays(1)) ; day = day.plusDays(1)) {
			if(day.getDayOfWeek().name() == "SATURDAY" || day.getDayOfWeek().name() == "SUNDAY") continue;
			requestHoliday++;
		}

		System.out.print("�ް� �� �� �ִ� ���� �� : \t");
		return requestHoliday;
	}



	// var implementation
	@Override
	public String CheckClassType(List o) {

		String className = o.get(0).getClass().getName();

		if(className.contains("TAAResult")) 		return "TAAResult";
		if(className.contains("TAA")) 				return "TAA";
		if(className.contains("SalaryResult")) 		return "SalaryResult";
		if(className.contains("HolidayRequest"))	return "HolidayRequest";
		if(className.contains("EmployeeHoliday")) 	return "EmployeeHoliday";
		if(className.contains("Employee")) 			return "Employee";

		return className;
	}





	@Override
	public boolean idcheck(String id) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.idcheck(id);
	}

	@Override
	public boolean numcheck(String num) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.numcheck(num);
	}

	@Override
	public void OpenEasterEggForm(String url) {
		Stage s = new Stage();
		Pane pane = new Pane(new ImageView(url));
		s.setX(new Random().nextInt(1920) - pane.getScaleX());
		s.setY(new Random().nextInt(1080) - pane.getScaleY());
		s.setScene(new Scene(pane));
		s.setTitle("HAHAHAHAHAHAHAHAHAHA");
		s.show();
	}
}
