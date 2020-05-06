package com.midas.taa;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class TAAController extends Controller implements Initializable {
	private Parent root;
	private CommonService comServ;
	private TAAService taaServ;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl(); 
		taaServ = new TAAServiceImpl();
		
	}

	public void DateSearchProc(ActionEvent e) {
		System.out.println("´­¸²");

	}

}
