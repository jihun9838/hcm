package com.midas.taa;

import java.net.URL;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Commute;
import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.CalendarService;
import com.midas.taa.service.CalendarServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


/*1. ���� ���� �� Ȥ�� ���� ���� ������ ���� �� ���� ����ؾ� �Ѵ�
(���� ���� ����) <<��ħ

2. ������ �ش� �������̸� �� �Ⱓ���� ���³������� ���� �ϼ��� �������� �Ѵ�
(���� �� ������ ��� ����)  <<�̰� �׳��� ���ɼ� ���� ����*/

public class PersonalTAAController extends Controller implements Initializable{
	private Parent root;
	private CalendarService calServ;
	private DBService dbServ;
	private CommonService comServ;
	@FXML private DatePicker PersonalDatePicker;
	@FXML private BorderPane PerBP;
	@FXML private Pane CalPane;
	@FXML private TableView<String> PersonalTAATableView;
	@FXML private TextField searchTf;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		PersonalDatePicker.setValue(LocalDate.now());
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void SearchProc(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String yearMonth = PersonalDatePicker.getValue().toString().substring(0, 7);  //0000-00������
		
		String num ="";
		num = "200401";
		
		if(!num.isEmpty()) {
		List<Commute> commuteLst = dbServ.CommuteCountAllList(yearMonth, "AND "+"\"�����ȣ\""+"="+num);
		comServ.ShowTableViewByList(scene, "#PersonalTAATableView", commuteLst);
		
		String option = "WHERE �����ȣ=" + num; 
		List<Commute> comLst = dbServ.SelectTable("commute", option);
		CalPane.getChildren().clear();
		CharSequence txt = yearMonth;
		calServ = new CalendarServiceImpl(YearMonth.parse(txt.toString()), num, comLst);
		CalPane.getChildren().add(calServ.getView());
		}
		else {
			comServ.ErrorMsg("�����ȣ ã�� ����", "", "�ٽ� �˻����ּ���.");
		}
		
//		calServ = new CalendarServiceImpl(YearMonth.now());
	}

}
