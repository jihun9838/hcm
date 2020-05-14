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


/*1. 연차 이전 월 혹은 다음 월이 걸쳐져 있을 때 따로 계산해야 한다
(추후 개발 예정) <<빡침

2. 오늘이 해당 연차일이면 그 기간동안 근태내역에서 연차 일수가 더해져야 한다
(이전 월 보고서로 충당 예정)  <<이게 그나마 가능성 높은 개발*/

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
			comServ.ErrorMsg("사원번호 찾기 실패", "", "다시 검색해주세요.");
		}
	}

}
