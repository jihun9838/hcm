package com.midas.taa;

import java.net.URL;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.taa.service.CalendarService;
import com.midas.taa.service.CalendarServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/*1. 연차 이전 월 혹은 다음 월이 걸쳐져 있을 때 따로 계산해야 한다
(추후 개발 예정) <<빡침

2. 오늘이 해당 연차일이면 그 기간동안 근태내역에서 연차 일수가 더해져야 한다
(이전 월 보고서로 충당 예정)  <<이게 그나마 가능성 높은 개발*/

public class PersonalTAAController extends Controller implements Initializable{
	private Parent root;
	private CalendarService calServ;
	@FXML private DatePicker PersonalDatePicker;
	@FXML private BorderPane PerBP;
	@FXML private Pane CalPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		PersonalDatePicker.setValue(LocalDate.now());
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

}
