package com.midas.mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchpwController extends Controller implements Initializable{

	Parent root;
	@FXML private TextField pwSearchNameTxt;
	@FXML private TextField pwSearchIdTxt;
	@FXML private TextField pwSearchNumTxt;
	@FXML private Button pwSerchBtn;

	private DBService dbServ = new DBServiceImpl();
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pwSearchNameTxt.setOnAction(e->pwSearchIdTxt.requestFocus());
		pwSearchIdTxt.setOnAction(e->pwSearchNumTxt.requestFocus());
		pwSearchNumTxt.setOnAction(e->pwSerchBtn.requestFocus());

	}

	public void pwSerchBtnProc() {
		String name = pwSearchNameTxt.getText();
		String PhoneNum = pwSearchNumTxt.getText();
		String id = pwSearchIdTxt.getText();

		dbServ.searchPW(name, id, PhoneNum);
	}
}
