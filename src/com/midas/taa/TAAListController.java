package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.collections4.map.HashedMap;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TAAListController extends Controller implements Initializable {

	@FXML private DatePicker TAADatePicker;
	@FXML private ComboBox<String> cmbSort;
	@FXML private TextField searchTf;
	@FXML private TableView<Employee> HolidayTable;
	@FXML private TableColumn<Employee, String> numColumn, nameColumn, departmentColumn, joinColumn, availableDayColumn, usedDayColumn, remainDayColumn;
	private final static String[] ATTRIBUTE = {"사원번호", "이름", "부서", "입사일자", "총연차", "사용연차", "잔여연차"};
	private Parent root;
	private DBService dbServ;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TAADatePicker.setValue(LocalDate.now());
		dbServ = new DBServiceImpl();
		
		List<Employee> employeelst = dbServ.SelectTableHoliday("");
		TableShow(employeelst);
		cmbSort.getItems().addAll(ATTRIBUTE);
		cmbSort.setValue("사원번호");
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void PickerClicked(ActionEvent e) {
		cmbSort.requestFocus();
	}
	public void SortClicked(ActionEvent e) {
		searchTf.requestFocus();
	}
	
	public void HolidaySearch(ActionEvent e) {
		
		String attribute = cmbSort.getValue();
		String txt = searchTf.getText();
		List<Employee> employeelst;
		employeelst = dbServ.SelectTableHoliday(attribute, txt, 1);
		TableShow(employeelst);
		
//		List<Employee> TAAList = dbServ.SelectTableHoliday("");
//		for(int i=0; i<TAAList.size(); i++) System.out.println("");
//		TableShow(TAAList);
	}
	
	private void TableShow(List<Employee> employeelst) {
		ObservableList tableList = FXCollections.observableArrayList();

		for(Employee e : employeelst) {
			tableList.add(new Employee(e.getNum(), e.getName(), e.getDepartment(), e.getJoin(), e.getAvailableHoliday(), e.getUsedHoliday(), e.getRemainHoliday()));
		}



		numColumn.setCellValueFactory(cellData -> cellData.getValue().num());
		numColumn.setStyle("-fx-alignment: CENTER;");

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name());
		nameColumn.setStyle("-fx-alignment: CENTER;");


		departmentColumn.setCellValueFactory(cellData -> cellData.getValue().department());
		departmentColumn.setStyle("-fx-alignment: CENTER;");


		joinColumn.setCellValueFactory(cellData -> cellData.getValue().join());
		joinColumn.setStyle("-fx-alignment: CENTER;");


		availableDayColumn.setCellValueFactory(cellData -> cellData.getValue().availableHoliday());  //인티저 타입은 asObject
		availableDayColumn.setStyle("-fx-alignment: CENTER;");


		usedDayColumn.setCellValueFactory(cellData -> cellData.getValue().usedHoliday());
		usedDayColumn.setStyle("-fx-alignment: CENTER;");


		remainDayColumn.setCellValueFactory(cellData -> cellData.getValue().remainHoliday());
		remainDayColumn.setStyle("-fx-alignment: CENTER;");

		HolidayTable.setItems(tableList);

	}
}
