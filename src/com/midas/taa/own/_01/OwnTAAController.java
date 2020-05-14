package com.midas.taa.own._01;

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
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class OwnTAAController extends Controller implements Initializable {
	private Parent root;
	private CalendarService calServ;
	private TAAService TAAServ;
	private CommonService comServ;
	@FXML private DatePicker TAADatePicker;
	@FXML private BorderPane OwnBP;
	@FXML private Pane CalPane;
	@FXML private TableView<String> OwnTAATableView;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		TAADatePicker.setValue(LocalDate.now());
		calServ = new CalendarServiceImpl(YearMonth.now());
		CalPane.getChildren().add(calServ.getView());
	}
	
	public void OwnTAASearchProc(ActionEvent e) {
		String num = comServ.getUserLabel(root);
		TAAServ.showTableCommuteSearchNum(e, TAADatePicker, num, "#OwnTAATableView");
		TAAServ.showOwnCalendar(num, CalPane, TAADatePicker);
	}

}
