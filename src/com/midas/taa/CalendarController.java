package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.CalendarAnchorPaneNode;
import com.midas.taa.service.CalendarService;
import com.midas.taa.service.CalendarServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;

public class CalendarController extends Controller implements Initializable{
	private Parent root;
	private CommonService comServ;
	private TAAService taaServ;
	private CalendarService calServ;
	@FXML private DatePicker DatePicker;
	@FXML private Pane calendarPane;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl(); 
		taaServ = new TAAServiceImpl();
		
		DatePicker.setValue(LocalDate.now());
		calServ = new CalendarServiceImpl(YearMonth.now());
		calendarPane.getChildren().add(calServ.getView());
	}
	public void DateSearchProc(ActionEvent e) {
		calendarPane.getChildren().clear();
		System.out.println(DatePicker.getValue());
		LocalDate data = DatePicker.getValue();
		CalendarService calServChange = new CalendarServiceImpl(YearMonth.of(data.getYear(), data.getMonth()));
		calendarPane.getChildren().add(calServChange.getView());	
	}
}
