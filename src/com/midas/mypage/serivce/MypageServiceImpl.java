package com.midas.mypage.serivce;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MypageServiceImpl implements MypageService{

	@Override
	public Employee getEmployee(String id) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.getMember(id);
	}
	
	@Override
	public void setInfo(Parent form, String num) {
		TextField nameTxt = (TextField)form.lookup("#nameTxt");
		TextField phoneNumTxt = (TextField)form.lookup("#phoneNumTxt");
		TextField addressTxt = (TextField)form.lookup("#addressTxt");
		TextField emailTxt = (TextField)form.lookup("#emailTxt");
		Label departmemtLbl = (Label)form.lookup("#departmemtLbl");
		Label finalEduLbl = (Label)form.lookup("#finalEduLbl");
		Label positionLbl = (Label)form.lookup("#positionLbl");
		Label joinDateLbl = (Label)form.lookup("#joinDateLbl");
		Label birthLbl = (Label)form.lookup("#birthLbl");
		Label employeeLbl = (Label)form.lookup("#employeeLbl");
		
		Employee emp = getEmployee(num);

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
