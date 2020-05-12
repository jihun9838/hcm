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


/*1. ���� ���� �� Ȥ�� ���� ���� ������ ���� �� ���� ����ؾ� �Ѵ�
(���� ���� ����) <<��ħ

2. ������ �ش� �������̸� �� �Ⱓ���� ���³������� ���� �ϼ��� �������� �Ѵ�
(���� �� ������ ��� ����)  <<�̰� �׳��� ���ɼ� ���� ����*/

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
