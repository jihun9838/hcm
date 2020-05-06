package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;

public class HolidayModifyController extends Controller implements Initializable {
	private Parent root;
	@FXML DatePicker ModifyDatePicker;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ModifyDatePicker.setValue(LocalDate.now());
		
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}

}
