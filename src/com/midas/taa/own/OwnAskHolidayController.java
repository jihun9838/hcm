package com.midas.taa.own;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OwnAskHolidayController extends Controller implements Initializable{
	private Parent root;
	private CommonService comServ;
	private TAAService TAAServ;
	private DBService dbServ;
	private static double CalcHoliday = 0;
	@FXML private Label todayLbl, Holidays;
	@FXML private DatePicker AskDatePicker, StartDatePicker, EndDatePicker;
	@FXML private ComboBox<String> cmbFullHalf;
	@FXML private TextField reasonTf;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		dbServ = new DBServiceImpl();
		AskDatePicker.setPromptText(LocalDate.now().getYear()+"."+LocalDate.now().getMonthValue());
		todayLbl.setText(LocalDate.now().toString());
	}
	
	
	public void SearchMyHolidayTable(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		List<HolidayRequest> OwnHolidayAskList = dbServ.SelectTable("HolidayRequest", "WHERE id = \"200401\""); //로그인 된 사람 id
		comServ.ShowTableViewByList(scene, "#OwnAskTable", OwnHolidayAskList);
	}

	public void FullAndHalfCheck(ActionEvent e) {
		if(cmbFullHalf.getValue().contentEquals("반일")) {
			StartDatePicker.setDisable(false); StartDatePicker.setValue(null);
			EndDatePicker.setDisable(true); EndDatePicker.setValue(null);
			reasonTf.setDisable(false);

			StartDatePicker.requestFocus();
			CalcHoliday = 0.5;
			Holidays.setText("0.5");
		}
		if(cmbFullHalf.getValue().contentEquals("전일")){
			StartDatePicker.setDisable(false); StartDatePicker.setValue(null);
			EndDatePicker.setDisable(false); EndDatePicker.setValue(null);
			reasonTf.setDisable(false);

			StartDatePicker.requestFocus();
			CalcHoliday = 0;
			Holidays.setText("0");
		}
	}


	public void StartRequestHoliday(ActionEvent e) {
		if("반일".contentEquals(cmbFullHalf.getValue())) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			reasonTf.requestFocus();
			CalcHoliday = 0.5;
			Holidays.setText("0.5");
		}
		if("전일".contentEquals(cmbFullHalf.getValue())) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			CalcHoliday = comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
			Holidays.setText("1");
			EndDatePicker.requestFocus();
		}
	}



	public void EndRequestHoliday(ActionEvent e) {
		if(StartDatePicker.getValue() == null) {
			StartDatePicker.requestFocus();
		}
		CalcHoliday = comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
		if(CalcHoliday<=0) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			CalcHoliday = 1;
			Holidays.setText("1");
			EndDatePicker.requestFocus();
		}
		else {
			Holidays.setText(String.valueOf(CalcHoliday));
			reasonTf.requestFocus();
		}
	}

	private boolean isCheck(ComboBox<String> cb, DatePicker startDP, DatePicker endDP) {
		{	
			if(cb.getValue().isEmpty()) {
				System.out.println("비어 있어요");
				return false;
			}
			if(cb.getValue().toString().contentEquals("반일")&&TAAServ.isEmptyCont(cb, startDP)) {
				System.out.println("비어 있어요");
				return false;
			}
			if(cb.getValue().toString().contentEquals("전일")&&TAAServ.isEmptyCont(cb, startDP, endDP)){
				System.out.println("비어 있어요");
				return false;
			}
		}
		return true;
	}

	public void requestHoliday(ActionEvent e) {
		if(cmbFullHalf.getValue().isEmpty()) {
			cmbFullHalf.requestFocus();
			return;
		}
		if(!isCheck(cmbFullHalf, StartDatePicker, EndDatePicker)) {
			return;
		}

		else {
			if(!TAAServ.isFullAndHalf(cmbFullHalf)) {  //반일
				CalcHoliday = 0.5;
			}
			else {
				int output = comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
				CalcHoliday = (int)Integer.parseInt(String.valueOf(Math.round(output))); //소수점제거
			}
			if(reasonTf.getText().isEmpty()) {
				reasonTf.setText("");
			} 
			

			HolidayRequest hr = new HolidayRequest();
			hr.setId("200401");  //로그인 했을때 아이디
			hr.setName("강아지"); //이름
			hr.setDepartment("회계"); //부서
			hr.setAvailableDay("26"); //인 사람의 남은 연가
			
			hr.setRequestDay(String.valueOf(LocalDate.now()));
			hr.setStartDay(StartDatePicker.getValue().toString());
			hr.setEndDay(EndDatePicker.getValue().toString());
			hr.setPeriodDay(String.valueOf(CalcHoliday));
			hr.setReason(reasonTf.getText());
			hr.setApproval("미승인");

			if(dbServ.SaveHolidayRequest(hr)) {
				comServ.ErrorMsg(
						"데이터 확인 Success!!!", 
						
						"아이디 : "+hr.getId()+
						"이름 : "+hr.getName()+
						"부서 : "+hr.getDepartment()+
						"연가 : "+hr.getAvailableDay() ,
						
						"요청일 : "+hr.getRequestDay()+
						"\n연차시작일 : "+hr.getStartDay()+
						"\n연차 종료일 : "+hr.getEndDay()+
						"\n기간 : "+hr.getPeriodDay()+
						"\n사유 : "+hr.getReason()+
						"\n승인여부 : "+hr.getApproval()
						);
			}
			else {
				comServ.ErrorMsg("신청", "실패", "관리자에게 문의하세요.");
			}
		}
	}

}
