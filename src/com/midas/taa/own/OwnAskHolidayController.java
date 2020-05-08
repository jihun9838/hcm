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
		List<HolidayRequest> OwnHolidayAskList = dbServ.SelectTable("HolidayRequest", "WHERE id = \"200401\""); //�α��� �� ��� id
		comServ.ShowTableViewByList(scene, "#OwnAskTable", OwnHolidayAskList);
	}

	public void FullAndHalfCheck(ActionEvent e) {
		if(cmbFullHalf.getValue().contentEquals("����")) {
			StartDatePicker.setDisable(false); StartDatePicker.setValue(null);
			EndDatePicker.setDisable(true); EndDatePicker.setValue(null);
			reasonTf.setDisable(false);

			StartDatePicker.requestFocus();
			CalcHoliday = 0.5;
			Holidays.setText("0.5");
		}
		if(cmbFullHalf.getValue().contentEquals("����")){
			StartDatePicker.setDisable(false); StartDatePicker.setValue(null);
			EndDatePicker.setDisable(false); EndDatePicker.setValue(null);
			reasonTf.setDisable(false);

			StartDatePicker.requestFocus();
			CalcHoliday = 0;
			Holidays.setText("0");
		}
	}


	public void StartRequestHoliday(ActionEvent e) {
		if("����".contentEquals(cmbFullHalf.getValue())) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			reasonTf.requestFocus();
			CalcHoliday = 0.5;
			Holidays.setText("0.5");
		}
		if("����".contentEquals(cmbFullHalf.getValue())) {
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
				System.out.println("��� �־��");
				return false;
			}
			if(cb.getValue().toString().contentEquals("����")&&TAAServ.isEmptyCont(cb, startDP)) {
				System.out.println("��� �־��");
				return false;
			}
			if(cb.getValue().toString().contentEquals("����")&&TAAServ.isEmptyCont(cb, startDP, endDP)){
				System.out.println("��� �־��");
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
			if(!TAAServ.isFullAndHalf(cmbFullHalf)) {  //����
				CalcHoliday = 0.5;
			}
			else {
				int output = comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
				CalcHoliday = (int)Integer.parseInt(String.valueOf(Math.round(output))); //�Ҽ�������
			}
			if(reasonTf.getText().isEmpty()) {
				reasonTf.setText("");
			} 
			

			HolidayRequest hr = new HolidayRequest();
			hr.setId("200401");  //�α��� ������ ���̵�
			hr.setName("������"); //�̸�
			hr.setDepartment("ȸ��"); //�μ�
			hr.setAvailableDay("26"); //�� ����� ���� ����
			
			hr.setRequestDay(String.valueOf(LocalDate.now()));
			hr.setStartDay(StartDatePicker.getValue().toString());
			hr.setEndDay(EndDatePicker.getValue().toString());
			hr.setPeriodDay(String.valueOf(CalcHoliday));
			hr.setReason(reasonTf.getText());
			hr.setApproval("�̽���");

			if(dbServ.SaveHolidayRequest(hr)) {
				comServ.ErrorMsg(
						"������ Ȯ�� Success!!!", 
						
						"���̵� : "+hr.getId()+
						"�̸� : "+hr.getName()+
						"�μ� : "+hr.getDepartment()+
						"���� : "+hr.getAvailableDay() ,
						
						"��û�� : "+hr.getRequestDay()+
						"\n���������� : "+hr.getStartDay()+
						"\n���� ������ : "+hr.getEndDay()+
						"\n�Ⱓ : "+hr.getPeriodDay()+
						"\n���� : "+hr.getReason()+
						"\n���ο��� : "+hr.getApproval()
						);
			}
			else {
				comServ.ErrorMsg("��û", "����", "�����ڿ��� �����ϼ���.");
			}
		}
	}

}
