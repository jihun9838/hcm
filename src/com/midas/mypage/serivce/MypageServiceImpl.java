package com.midas.mypage.serivce;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
		ImageView employeeImg = (ImageView)form.lookup("#employeeImg");

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

		if(emp.getImage() == null || emp.getImage().length() == 0)	{
			System.out.println("111");
			employeeImg.setImage(new Image("/com/midas/image/기본사진.png"));
		}
		else {
			System.out.println("222");
			employeeImg.setImage(new Image("/com/midas/image/" + emp.getImage()));
		}

		//if 등록한 사진이 없을 땐 기본사진  else 등록한 사진이 있을 때는 등록된 사진 출력


	}

}
