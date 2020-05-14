package com.midas.taa._04;

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
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/*1. ���� ���� �� Ȥ�� ���� ���� ������ ���� �� ���� ����ؾ� �Ѵ�
(���� ���� ����) <<��ħ

2. ������ �ش� �������̸� �� �Ⱓ���� ���³������� ���� �ϼ��� �������� �Ѵ�
(���� �� ������ ��� ����)  <<�̰� �׳��� ���ɼ� ���� ����*/

public class PersonalTAAController extends Controller implements Initializable{
	@SuppressWarnings("unused")
	private Parent root;
	private CalendarService calServ;
	private CommonService comServ;
	private TAAService TAAServ;
	@FXML private DatePicker PersonalDatePicker;
	@FXML private BorderPane PerBP;
	@FXML private Pane CalPane;
	@FXML private TableView<String> PersonalTAATableView;
	@FXML private TextField searchTf;


	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		PersonalDatePicker.setValue(LocalDate.now());
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void SearchProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String num = searchTf.getText();

		if(!num.isEmpty()) {
			TAAServ.showTableCommuteSearchNum(e, PersonalDatePicker, num, "#PersonalTAATableView");
			TAAServ.showOwnCalendar(num, CalPane, PersonalDatePicker);
		}
		else {
			comServ.ErrorMsg("�����ȣ ã�� ����", "", "�ٽ� �˻����ּ���.");
		}
	}

}
