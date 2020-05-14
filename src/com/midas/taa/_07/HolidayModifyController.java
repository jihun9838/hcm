package com.midas.taa._07;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
//근태 수정 신청에 대한 페이지
//기능 구현하거나 삭제 예정
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
