package com.midas.taa.service;

import java.util.List;

import com.midas.db.HolidayRequest;
import com.midas.db.SalaryResult;
import com.midas.service.CommonServiceImpl;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class TAAServiceImpl implements TAAService {

//	private DBService dbServ;
//	public TAAServiceImpl() {
//		dbServ = new DBServiceImpl(); 
//	}
	

	@Override
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP, DatePicker endDP) {
		{
			ComboBox<String> cbox = cb;
			DatePicker dp1 = startDP;
			DatePicker dp2 = endDP;

			if(cbox.getValue().isEmpty()) {
				cbox.requestFocus();
				return true;
			}
			if(dp1.getValue() == null) {
				dp1.requestFocus();
				return true;
			}
			if(dp2.getValue() == null) {
				dp2.requestFocus();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP) {
		{
			ComboBox<String> cbox = cb;
			DatePicker dp1 = startDP;

			if(cbox.getValue().isEmpty()) {
				cbox.requestFocus();
				return true;
			}
			if(dp1.getValue() == null) {
				dp1.requestFocus();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isFullAndHalf(ComboBox<String> cb) {
		ComboBox<String> cbox = cb;
		if("반일".contentEquals(cbox.getValue())) {
			return false;
		}
		if("전일".contentEquals(cbox.getValue())) {
			return true;
		}
		else {
			return true;
		}
	}
	@Override
	public void ShowHolidayStmt(Scene scene, String id, HolidayRequest holidayRequest) {
		TextArea ta = (TextArea)scene.lookup(id);
		ta.clear();
		String result = "";
		result += "\n\n";
		result += "\t\t\t\t\t휴가승인서";
		result += "\n\n\n";
		result += "\n\t\t\t사원번호\t\t:\t" + holidayRequest.getId();
		result += "\n\t\t\t이름\t\t\t:\t" + holidayRequest.getName();
		result += "\n\t\t\t부서\t\t\t:\t" + holidayRequest.getDepartment();
		result += "\n\n";
		result += "\n\t\t\t기간\t\t\t:\t" + holidayRequest.getPeriodDay() + "일";
		result += "\n\n";
		result += "\n\t\t\t요청일\t\t:\t" + holidayRequest.getRequestDay();
		result += "\n\t\t\t시작일\t\t:\t" + holidayRequest.getStartDay();
		result += "\n\t\t\t종료일\t\t:\t" + holidayRequest.getEndDay();
		result += "\n\t\t\t사유\t\t\t:\t" + holidayRequest.getReason();
		result += "\n\t\t\t승인여부\t\t:\t" + holidayRequest.getApproval();
		result += "\n\t\t\t\t\t" + "상기 휴가를 승인합니다.";
		result += "\n\t\t\t\t\t\t\t\t" + "(주)미다스";

		ta.setText(result);
	}
	@Override
	public void ShowLineChartByList(Scene scene, String id, List<HolidayRequest> list) {
		//Chart(new Stage());
//		new CommonServiceImpl().ShowLineChartByListTAA(scene, id, list);
	}
	
	



}
