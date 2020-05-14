package com.midas.taa._01;

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
	@SuppressWarnings("unused")
	private Parent root;
	private CalendarService calServ;
	@FXML private DatePicker setCalendarDatePicker;
	@FXML private Pane calendarPane;
	@FXML private BorderPane calBorderPane;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void DateSearchProc(ActionEvent e) {
		LocalDate data = setCalendarDatePicker.getValue();
		calServ = new CalendarServiceImpl(YearMonth.of(data.getYear(), data.getMonth()));
		calBorderPane.setCenter(calServ.getView());	//달력 생성
	}
}
