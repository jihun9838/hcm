package com.midas.taa.service;

import javafx.scene.Parent;
import javafx.scene.control.DatePicker;

public class TAAServiceImpl implements TAAService {

	@Override
	public String DateSearch(Parent root) {
		DatePicker InputDate = new DatePicker();
		InputDate = (DatePicker)root.lookup("#DateSelectPicker");
		
		return "a";
	}
	



}
