package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Commute;
import com.midas.db.HolidayRequest;
import com.midas.db.TAA;
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
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MonthTAAController extends Controller implements Initializable{

	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private TAAService TAAServ;
	@FXML private DatePicker MonthDatePicker;
	@FXML private ComboBox<String> cmbSort;
	@FXML private TableView<String> MonthTAATable;
	@FXML private TextField searchTf;
	@FXML private Label hideLbl;
	private final static String[] ATTRIBUTE = {"�����ȣ", "�̸�", "�μ�"};
	private final int size = 987654321;


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
		cmbSort.getItems().addAll(ATTRIBUTE);
		cmbSort.setValue("�����ȣ");

	}

	public void monthSearchProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String attribute = cmbSort.getValue();
		String txt = searchTf.getText();
		String yearMonth = MonthDatePicker.getValue().toString().substring(0, 7);  //0000-00������
		
		String num = "";
		num = "200401";
		//num = searchTf.getText();
		
		List<Commute> commuteLst = dbServ.CommuteCountAllList(yearMonth, "AND "+"\"�����ȣ\""+"="+num);
		comServ.ShowTableViewByList(scene, "#MonthTAATable", commuteLst);



	}
}
