package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;

public class MonthTAAController extends Controller implements Initializable{

	@FXML private DatePicker MonthDatePicker;
	private Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		MonthDatePicker.setValue(LocalDate.now());
		
	}
}
