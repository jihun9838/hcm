package com.midas.taa.service;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

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



}
