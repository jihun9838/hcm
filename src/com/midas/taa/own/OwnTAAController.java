package com.midas.taa.own;

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

public class OwnTAAController extends Controller implements Initializable {
	private Parent root;
	private CalendarService calServ;
	@FXML private DatePicker TAADatePicker;
	@FXML private BorderPane OwnBP;
	@FXML private Pane CalPane;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
		TAADatePicker.setValue(LocalDate.now());
	}


}
