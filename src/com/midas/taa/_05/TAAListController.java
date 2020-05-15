package com.midas.taa._05;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class TAAListController extends Controller implements Initializable {
	private Parent root;
	private CommonService comServ;
	private TAAService TAAServ;
	@FXML private DatePicker TAADatePicker;
	@FXML private ComboBox<String> cmbSort;
	@FXML private TextField searchTf;
	@FXML private TableColumn<Employee, String> numColumn, nameColumn, departmentColumn, joinColumn, availableDayColumn, usedDayColumn, remainDayColumn;
	private final static String[] items = {"사원번호", "이름", "부서", "입사일자", "총연차", "사용연차", "잔여연차"};
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		TAADatePicker.setValue(LocalDate.now());
		TAAServ.addComboBoxInController(cmbSort, items);
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
		DBService dbServ = new DBServiceImpl();
		String attribute = cmbSort.getValue();
		String txt = searchTf.getText();
		TAAServ.showTableEmployeeHolidatList(e, attribute, txt);
	}

}
