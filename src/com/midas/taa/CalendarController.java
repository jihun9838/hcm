package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.CalendarService;
import com.midas.taa.service.CalendarServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CalendarController extends Controller implements Initializable{
	private Parent root;
	private CommonService comServ;
	private TAAService taaServ;
	private CalendarService calServ;
	@FXML private DatePicker setCalendarDatePicker;
	@FXML private Pane calendarPane;
	@FXML private Pane fullCalendarPane;
	@FXML private VBox calendarVBox;
	@FXML private BorderPane calBorderPane;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl(); 
		taaServ = new TAAServiceImpl();
		
//		setCalendarDatePicker.setValue(LocalDate.now());
//		calServ = new CalendarServiceImpl(YearMonth.now());
//		calendarPane.getChildren().add(calServ.getView());
//		comServ.AddSceneWithController("/com/midas/taa/fullCalendar.fxml");
//		fullCalendarPane.getChildren().add(new CalendarServiceImpl(YearMonth.now()).getView());

	}
	public void DateSearchProc(ActionEvent e) {
		LocalDate data = setCalendarDatePicker.getValue();
//		CalendarService calServChange = new CalendarServiceImpl(YearMonth.of(data.getYear(), data.getMonth()));
//		calendarPane.getChildren().add(calServChange.getView());
		
		
		calBorderPane.setCenter(new CalendarServiceImpl(YearMonth.of(data.getYear(), data.getMonth())).getView());		//.clear();
		System.out.println(setCalendarDatePicker.getValue());
	}
}
