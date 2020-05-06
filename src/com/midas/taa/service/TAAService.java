package com.midas.taa.service;


import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public interface TAAService {


	
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP, DatePicker endDP);
	public boolean isEmptyCont(ComboBox<String> cb, DatePicker startDP);
	public boolean isFullAndHalf(ComboBox<String> cb);


}
