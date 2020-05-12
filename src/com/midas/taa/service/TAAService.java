package com.midas.taa.service;


import java.util.List;

import com.midas.db.HolidayRequest;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public interface TAAService {


	
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP, DatePicker endDP);
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP);
	public boolean isFullAndHalf(ComboBox<String> cb);
	public void ShowHolidayStmt(Scene scene, String id, HolidayRequest holidayRequest);
	public void ShowLineChartByList(Scene scene, String id, List<HolidayRequest> list);


}
