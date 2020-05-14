package com.midas.taa.service;


import java.util.List;

import com.midas.db.Employee;
import com.midas.db.HolidayRequest;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public interface TAAService {


	
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP, DatePicker endDP);
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP);
	public boolean isFullAndHalf(ComboBox<String> cb);
	public void ShowHolidayStmt(Scene scene, String id, HolidayRequest holidayRequest);
	public void ShowLineChartByList(Scene scene, String id, List<HolidayRequest> list);
	public void addComboBoxInController(ComboBox<String> cmbSort, String [] items);
	public String getYearMonth(DatePicker datePicker);
	public void showTableCommuteSearchNum(ActionEvent e, DatePicker datePicker, String num, String tableId);
	public void showOwnCalendar(String num, Pane pane, DatePicker datePicker);
	public void showTableEmployeeHolidatList(Parent root, List<Employee> employeelst);
	public void showTableEmployeeHolidatList(ActionEvent e, String attribute, String txt);
	public void ApprovalHoliday(List<HolidayRequest> requestList, TableView<String> tableView);
	public void DeclineHoliday(List<HolidayRequest> requestList, TableView<String> tableView);
	public void showTableEmployeeOwn(ActionEvent e, int year, int month, String num);
	public double FullAndHalfCheck(ComboBox<String> cmbFullHalf, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf);
	public double StartRequestHoliday(ComboBox<String> cmbFullHalf, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf);
	public double EndRequestHoliday(ComboBox<String> cmbFullHalf, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf, Label Holidays);
	public boolean isCheck(ComboBox<String> cb, DatePicker startDP, DatePicker endDP);
	public HolidayRequest holyMem(String num, DatePicker StartDatePicker, DatePicker EndDatePicker, Double CalcHoliday, String reason);
	public double successHolidayRequest(ComboBox<String> cmbFullHalf, Double calHoliday, DatePicker StartDatePicker, DatePicker EndDatePicker, TextField reasonTf, String num);


}
