package com.midas.taa.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import com.midas.db.Commute;
import com.midas.db.Employee;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class TAAServiceImpl implements TAAService {

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
		//new CommonServiceImpl().ShowLineChartByListTAA(scene, id, list);
	}

	@Override
	public void addComboBoxInController(ComboBox<String> cmbox, String [] items) {
		cmbox.getItems().addAll(items);
		cmbox.setValue(items[0]);
	}

	@Override
	public String getYearMonth(DatePicker datePicker) {
		return datePicker.getValue().toString().substring(0, 7);  //0000-00월까지
	}

	@Override
	public void showTableCommuteSearchNum(ActionEvent e, DatePicker datePicker, String num, String tableId) {
		Scene scene = ((Parent)e.getSource()).getScene();
		CommonService comServ = new CommonServiceImpl();
		String option = "WHERE " + "\"날짜\""  + "like '%" + getYearMonth(datePicker) + "%'"
				+" AND "+"\"사원번호\""+"=";
		List<Commute> commuteLst = new DBServiceImpl().CommuteCountAllList(option+num);
		comServ.ShowTableViewByList(scene, tableId, commuteLst);
	}

	@Override
	public void showOwnCalendar(String num, Pane pane, DatePicker datePicker){
		String option = "WHERE 사원번호=" + num; 
		@SuppressWarnings("unchecked")
		List<Commute> comLst = new DBServiceImpl().SelectTable("commute", option);
		pane.getChildren().clear();
		CharSequence txt = getYearMonth(datePicker);
		CalendarService calServ = new CalendarServiceImpl(YearMonth.parse(txt.toString()), num, comLst);
		pane.getChildren().add(calServ.getView());
	}

	@Override
	public void showTableEmployeeHolidatList(Parent root, List<Employee> employeelst) {
		Scene scene = (Scene)root.getScene();
		CommonService comServ = new CommonServiceImpl();
		comServ.ShowTableViewByList(scene, "#HolidayTable", employeelst);
	}

	@Override
	public void showTableEmployeeHolidatList(ActionEvent e, String attribute, String txt) {
		Scene scene = ((Parent)e.getSource()).getScene();
		CommonService comServ = new CommonServiceImpl();
		List<Employee> employeelst = new DBServiceImpl().SelectTableHoliday(attribute, txt, 1);
		comServ.ShowTableViewByList(scene, "#HolidayTable", employeelst);
	}

	@Override
	public void ApprovalHoliday(List<HolidayRequest> requestList, TableView<String> tableView) {
		CommonService comServ = new CommonServiceImpl();
		int row = tableView.getSelectionModel().getSelectedIndex()+1; 
		String num = requestList.get(row-1).getId();						
		String periodDay = requestList.get(row-1).getPeriodDay();	

		if("미승인".contentEquals(requestList.get(row-1).getApproval())) {
			ApprovalHolidayRequest(row, num, periodDay);
			comServ.ErrorMsg("휴가가 승인되었습니다.");
		}
		else if("승인".contentEquals(requestList.get(row-1).getApproval())) {
			comServ.ErrorMsg("이미 승인되었습니다.");
		}
		else { //반려
			ApprovalHolidayRequest(row, num, periodDay);
			comServ.ErrorMsg("반려 휴가가 재승인되었습니다.");
		}
	}

	@Override
	public void DeclineHoliday(List<HolidayRequest> requestList, TableView<String> tableView) {
		CommonService comServ = new CommonServiceImpl();
		int row = tableView.getSelectionModel().getSelectedIndex()+1;
		String num = requestList.get(row-1).getId();
		String periodDay = requestList.get(row-1).getPeriodDay();
		System.out.println(row+" "+num+" "+periodDay);

		if("미승인".contentEquals(requestList.get(row-1).getApproval())) {
			DeclineHolidayRequestOnlyRowControl(row);
			comServ.ErrorMsg("반려되었습니다.");
		}
		else if("승인".contentEquals(requestList.get(row-1).getApproval())){
			DeclineHolidayRequest(row, num, periodDay);
			comServ.ErrorMsg("승인이 반려되었습니다.");
		}
		else { //반려
			comServ.ErrorMsg("이미 반려되었습니다.");
		}
	}
	
	@Override
	public void showTableEmployeeOwn(ActionEvent e, int year, int month, String num) {
		DBService dbServ = new DBServiceImpl();
		CommonService comServ = new CommonServiceImpl();
		Scene scene = ((Parent)e.getSource()).getScene();
		String requestYearMonth = Integer.toString(year)+"-0"+Integer.toString(month);
		List<HolidayRequest> OwnHolidayAskList = dbServ.SelectTable("HolidayRequest", "WHERE " +"\"사원번호\"" + "=" + num+
		"AND "+ "\"요청일\""+" like '%" + requestYearMonth + "%'");
		comServ.ShowTableViewByList(scene, "#OwnAskTable", OwnHolidayAskList);
	}
	
	@Override
	public double FullAndHalfCheck(ComboBox<String> cmbFullHalf, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf) {
		if(cmbFullHalf.getValue().contentEquals("반일")) {
			StartDatePicker.setDisable(false); StartDatePicker.setValue(null);
			EndDatePicker.setDisable(true); EndDatePicker.setValue(null);
			
			reasonTf.setDisable(false);
			StartDatePicker.requestFocus();
			return 0.5;
		}
		else{   //if(cmbFullHalf.getValue().contentEquals("전일"))
			StartDatePicker.setDisable(false); StartDatePicker.setValue(null);
			EndDatePicker.setDisable(false); EndDatePicker.setValue(null);
			
			reasonTf.setDisable(false);
			StartDatePicker.requestFocus();
			return 1.0;
		}
	}
	
	@Override
	public double StartRequestHoliday(ComboBox<String> cmbFullHalf, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf) {
		CommonService comServ = new CommonServiceImpl();
		if("반일".contentEquals(cmbFullHalf.getValue())) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			reasonTf.requestFocus();
			return 0.5;
		}
		else{//if("전일".contentEquals(cmbFullHalf.getValue())) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			EndDatePicker.requestFocus();
			return comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
		}
	}
	
	@Override
	public double EndRequestHoliday(ComboBox<String> cmbFullHalf, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf, Label Holidays) {
		CommonService comServ = new CommonServiceImpl();
		Double CalcHoliday;
		if(StartDatePicker.getValue() == null) {
			StartDatePicker.requestFocus();
		}
		CalcHoliday = (double) comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
		
		if(CalcHoliday<=0) {
			EndDatePicker.setValue(StartDatePicker.getValue());
			CalcHoliday = 1.0;
			Holidays.setText("1");
			EndDatePicker.requestFocus();
		}
		else {
			Holidays.setText(String.valueOf(CalcHoliday));
			reasonTf.requestFocus();
		}
		
		return CalcHoliday;
	}
	
	@Override
	public boolean isCheck(ComboBox<String> cb, DatePicker startDP, DatePicker endDP) {
		{	
			if(cb.getValue() == null) {
				cb.requestFocus();
				System.out.println("비어 있어요");
				return false;
			}
			if(cb.getValue().toString().contentEquals("반일")&&isEmptyCont(cb, startDP)) {
				System.out.println("비어 있어요");
				return false;
			}
			if(cb.getValue().toString().contentEquals("전일")&&isEmptyCont(cb, startDP, endDP)){
				System.out.println("비어 있어요");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public double successHolidayRequest(ComboBox<String> cmbFullHalf, Double calHoliday, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf, String num) {
		CommonService comServ = new CommonServiceImpl();
		double CalcHoliday = calHoliday;
		if(!isFullAndHalf(cmbFullHalf)) {  //반일
			CalcHoliday = 0.5;
		}
		else {
			int output = comServ.CalculateRequestedHoliday(StartDatePicker.getValue(), EndDatePicker.getValue());
			CalcHoliday = (int)Integer.parseInt(String.valueOf(Math.round(output))); //소수점제거
		}
		if(reasonTf.getText().isEmpty()) {
			reasonTf.setText("");
		}
		HolidayRequest hr = holyMem(num, StartDatePicker, EndDatePicker, CalcHoliday, reasonTf.getText());
		if(new DBServiceImpl().SaveHolidayRequest(hr)) {
			comServ.ErrorMsg(
					"데이터 확인 Success!!!",
					"휴가신청 완료!!"
					);
		}
		else {
			comServ.ErrorMsg("신청", "실패", "관리자에게 문의하세요.");
		}
		return CalcHoliday;
	}
	
	@Override
	public HolidayRequest holyMem(String num, DatePicker StartDatePicker, DatePicker EndDatePicker, Double CalcHoliday, String reason) {
		Employee emp = new DBServiceImpl().getEmployee(num);
		HolidayRequest hr = new HolidayRequest();
		hr.setId(num);  //로그인 했을때 아이디
		hr.setName(emp.getName()); //이름
		hr.setDepartment(emp.getDepartment()); //부서
		hr.setAvailableDay(emp.getAvailableHoliday()); //인 사람의 남은 연가
		hr.setRequestDay(String.valueOf(LocalDate.now()));
		hr.setStartDay(StartDatePicker.getValue().toString());
		hr.setEndDay(EndDatePicker.getValue().toString());
		hr.setPeriodDay(String.valueOf(CalcHoliday));
		hr.setReason(reason);
		hr.setApproval("미승인");
		return hr;
	}
	
	


	private void ApprovalHolidayRequest(int row, String num, String periodDay) {
		String [] UPDATESQL = {
				"UPDATE HolidayRequest " + "SET " + "승인여부=" + "\"승인\"" + " WHERE ROWID=" + row,
				"UPDATE HolidayRequest " + "SET " + "잔여연차=" + "\"잔여연차\"" + "-" + periodDay + " WHERE 사원번호=" + num,
				"UPDATE Employee " + "SET " + "\"사용연차\""+ "=" + " \"사용연차\"" + "+" + periodDay + " WHERE 사원번호=" + num,
				"UPDATE Employee " + "SET "+ "\"잔여연차\""+ "=" + " \"잔여연차\"" + "-" + periodDay + " WHERE 사원번호=" + num
		};
		for(int i=0; i<UPDATESQL.length; i++) new DBServiceImpl().UpdateTableWitnSQL(UPDATESQL[i]);
	}

	private void DeclineHolidayRequestOnlyRowControl(int row){
		String UPDATESQL = "UPDATE HolidayRequest "+	"SET "+	"승인여부="+"\"반려\"" + "WHERE ROWID=" + row;
		new DBServiceImpl().UpdateTableWitnSQL(UPDATESQL);
	}

	private void DeclineHolidayRequest(int row, String num, String periodDay){
		String [] UPDATESQL = {
				"UPDATE HolidayRequest "+ "SET "+ "승인여부=" + "\"반려\"" + " WHERE ROWID=" + row,
				"UPDATE HolidayRequest " + "SET " +	"잔여연차=" + "\"잔여연차\"" + "+" + periodDay + " WHERE 사원번호=" +num,
				"UPDATE Employee " + "SET " + "\"사용연차\"" + "=" + " \"사용연차\"" + "-" + periodDay  + " WHERE "+"\"사원번호\""+" = "+num,
				"UPDATE Employee "+	"SET "+	"\"잔여연차\""+ "=" +	" \"잔여연차\"" + "+" + periodDay +"\n" + " WHERE "+"\"사원번호\""+" = "+num
		};
		for(int i=0; i<UPDATESQL.length; i++) new DBServiceImpl().UpdateTableWitnSQL(UPDATESQL[i]);
	}

}
