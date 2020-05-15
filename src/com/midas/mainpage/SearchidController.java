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

public class SearchidController extends Controller implements Initializable{

	Parent root;
	@FXML private TextField idSearchNameTxt;
	@FXML private TextField idSearchNumTxt;
	@FXML private Button idSerchBtn;

	private DBService dbServ = new DBServiceImpl();

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		idSearchNameTxt.setOnAction(e->idSearchNumTxt.requestFocus());
		idSearchNumTxt.setOnAction(e->idSerchBtn.requestFocus());
	}


	public void idSerchBtnProc() {
		String name = idSearchNameTxt.getText();
		String PhoneNum = idSearchNumTxt.getText();

		dbServ.searchID(name, PhoneNum);
		idSearchNameTxt.requestFocus();
	}
}











