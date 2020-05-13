package com.midas.taa;

import java.net.URL;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Commute;
import com.midas.db.Employee;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/*1. 연차 이전 월 혹은 다음 월이 걸쳐져 있을 때 따로 계산해야 한다
(추후 개발 예정) <<빡침

2. 오늘이 해당 연차일이면 그 기간동안 근태내역에서 연차 일수가 더해져야 한다
(이전 월 보고서로 충당 예정)  <<이게 그나마 가능성 높은 개발*/

public class PersonalTAAController extends Controller implements Initializable{
	private Parent root;
	private CalendarService calServ;
	private DBService dbServ;
	private CommonService comServ;
	@FXML private DatePicker PersonalDatePicker;
	@FXML private BorderPane PerBP;
	@FXML private Pane CalPane;
	@FXML private TableView<String> PersonalTAATableView;
	@FXML private TextField searchTf;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		PersonalDatePicker.setValue(LocalDate.now());
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void SearchProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String yearMonth = PersonalDatePicker.getValue().toString().substring(0, 7);  //0000-00월까지
		
		String num ="";
		num = "200401";
		
		if(!num.isEmpty()) {
		List<Commute> commuteLst = dbServ.CommuteCountAllList(yearMonth, "AND "+"\"사원번호\""+"="+num);
		comServ.ShowTableViewByList(scene, "#PersonalTAATableView", commuteLst);
		
		String option = "WHERE 사원번호=" + num; 
		List<Commute> comLst = dbServ.SelectTable("commute", option);
		CalPane.getChildren().clear();
		CharSequence txt = yearMonth;
		calServ = new CalendarServiceImpl(YearMonth.parse(txt.toString()), num, comLst);
		CalPane.getChildren().add(calServ.getView());
		}
		else {
			comServ.ErrorMsg("사원번호 찾기 실패", "", "다시 검색해주세요.");
		}
		
//		calServ = new CalendarServiceImpl(YearMonth.now());
	}

}
