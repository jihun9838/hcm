package com.midas.mypage;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mypageController extends Controller implements Initializable{

	Parent root;
	@FXML private TextField nameTxt;
	@FXML private TextField phoneNumTxt;
	@FXML private TextField addressTxt;
	@FXML private TextField emailTxt;
	@FXML private Label departmemtLbl;
	@FXML private Label finalEduLbl;
	@FXML private Label positionLbl;
	@FXML private Label joinDateLbl;
	@FXML private Label birthLbl;
	@FXML private Label employeeLbl;
	@FXML private Button modifyBtn;		// 수정버튼
	
	@FXML private TextField newPwTxt;
	@FXML private TextField newPwOKTxt;

	private DBService dbServ;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		dbServ = new DBServiceImpl();

	}

	public void modifyBtnProc() {

	}
	
	public void setInfo(String num) {
		Employee emp = dbServ.getEmployee(num);

		phoneNumTxt.setText(emp.getPhone());
		nameTxt.setText(emp.getName());
		birthLbl.setText(emp.getBirth());
		departmemtLbl.setText(emp.getDepartment());
		emailTxt.setText(emp.getEmail());
		addressTxt.setText(emp.getAddress());
		positionLbl.setText(emp.getPosition());
		finalEduLbl.setText(emp.getEducation());
		employeeLbl.setText(emp.getNum());
		joinDateLbl.setText(emp.getJoin());

		/*
		 * if(member.getimage() == null || member.getimage().length() == 0) {
		 * employee_picture.setImage(new Image("/MIDAS/image/기본사진.png")); } else {
		 * employee_picture.setImage(new
		 * Image(getClass().getResource(member.getimage()).toString())); }
		 */
		//if 등록한 사진이 없을 땐 기본사진  else 등록한 사진이 있을 때는 등록된 사진 출력
	}


}
