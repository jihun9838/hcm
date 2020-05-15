package com.midas.taa._03;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MonthTAAController extends Controller implements Initializable{

	@SuppressWarnings("unused")
	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private TAAService TAAServ;
	@FXML private DatePicker MonthDatePicker;
	@FXML private ComboBox<String> cmbSort;
	@FXML private TableView<String> MonthTAATable;
	@FXML private TextField searchTf;
	@FXML private Label hideLbl;
	private final String[] items = {"사원번호"};


	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MonthDatePicker.setValue(LocalDate.now());
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		TAAServ = new TAAServiceImpl();
		TAAServ.addComboBoxInController(cmbSort, items);
	}

	public void monthSearchProc(ActionEvent e) {
		String num = searchTf.getText();
		if(!num.isEmpty()) {
			TAAServ.showTableCommuteSearchNum(e, MonthDatePicker, num, "#MonthTAATable");
		}
		else {
			comServ.ErrorMsg("사원번호 미기재", cmbSort.getValue()+"를 다시 입력해주세요.");
		}
	}
}
