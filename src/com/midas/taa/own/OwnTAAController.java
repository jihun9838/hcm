package com.midas.taa.own;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Commute;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.CalendarService;
import com.midas.taa.service.CalendarServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class OwnTAAController extends Controller implements Initializable {
	private Parent root;
	private CalendarService calServ;
	private DBService dbServ;
	private CommonService comServ;
	@FXML private DatePicker TAADatePicker;
	@FXML private BorderPane OwnBP;
	@FXML private Pane CalPane;
	@FXML private TableView<String> OwnTAATableView;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		calServ = new CalendarServiceImpl(YearMonth.now());
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		TAADatePicker.setValue(LocalDate.now());
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
	}
	public void OwnTAASearchProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String yearMonth = TAADatePicker.getValue().toString().substring(0, 7);  //0000-00월까지
		
		String num ="";
		num = "200401";
		
		List<Commute> commuteLst = dbServ.CommuteCountAllList(yearMonth, "AND "+"\"사원번호\""+"="+num);
		comServ.ShowTableViewByList(scene, "#OwnTAATableView", commuteLst);
		
		String option = "WHERE 사원번호=" + num; 
		List<Commute> comLst = dbServ.SelectTable("commute", option);
		CalPane.getChildren().clear();
		CharSequence txt = yearMonth;
		calServ = new CalendarServiceImpl(YearMonth.parse(txt.toString()), num, comLst);
		CalPane.getChildren().add(calServ.getView());
	}

}
