package com.midas.taa.own._02;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OwnAskHolidayController extends Controller implements Initializable{
	private Parent root;
	private CommonService comServ;
	private TAAService TAAServ;
	private static double CalcHoliday = 0;
	@FXML private Label todayLbl, Holidays;
	@FXML private DatePicker AskDatePicker, StartDatePicker, EndDatePicker;
	@FXML private ComboBox<String> cmbFullHalf;
	@FXML private TextField reasonTf;
	private String [] items = {"전일", "반일"};
	private int year, month;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		AskDatePicker.setPromptText(LocalDate.now().getYear()+"."+LocalDate.now().getMonthValue());
		todayLbl.setText(LocalDate.now().toString());
		year = LocalDate.now().getYear();
		month = LocalDate.now().getMonthValue();
		TAAServ.addComboBoxInController(cmbFullHalf, items);
	}
	
	public void checkAskDate(ActionEvent e) {
		year = AskDatePicker.getValue().getYear();
		month = AskDatePicker.getValue().getMonthValue();
	}
	
	
	public void SearchMyHolidayTable(ActionEvent e) {
		String num = comServ.getUserLabel(root);
		TAAServ.showTableEmployeeOwn(e, year, month, num);
	}

	public void FullAndHalfCheck(ActionEvent e) {
		CalcHoliday = TAAServ.FullAndHalfCheck(cmbFullHalf, StartDatePicker, EndDatePicker, reasonTf);
		Holidays.setText(String.valueOf(CalcHoliday));
	}


	public void StartRequestHoliday(ActionEvent e) {
		CalcHoliday = TAAServ.StartRequestHoliday(cmbFullHalf, StartDatePicker, EndDatePicker, reasonTf);
		if(CalcHoliday ==1) Holidays.setText("1");
	}

	public void EndRequestHoliday(ActionEvent e) {
		CalcHoliday = TAAServ.EndRequestHoliday(cmbFullHalf, StartDatePicker, EndDatePicker, reasonTf, Holidays);
	}

	public void requestHoliday(ActionEvent e) {
		System.out.println("RequestHoliday Function");
		String num = comServ.getUserLabel(root);
		if(!TAAServ.isCheck(cmbFullHalf, StartDatePicker, EndDatePicker)) {
			return;
		}

		else {
			TAAServ.successHolidayRequest(cmbFullHalf, CalcHoliday, StartDatePicker, EndDatePicker, reasonTf, num);
		}
	}

}
