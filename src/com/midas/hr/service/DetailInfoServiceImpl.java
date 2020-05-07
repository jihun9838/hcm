package com.midas.hr.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;

import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetailInfoServiceImpl implements DetailInfoService {

	@Override
	public void setInfo(Parent form, String num) {
		TextField Employee_num = (TextField)form.lookup("#Employee_num");
		TextField Employee_name = (TextField)form.lookup("#Employee_name");
		TextField Employee_id = (TextField)form.lookup("#Employee_id");
		TextField Employee_birthday = (TextField)form.lookup("#Employee_birthday");
		TextField Employee_birth = (TextField)form.lookup("#Employee_birth");
		TextField Employee_gender = (TextField)form.lookup("#Employee_gender");
		TextField Employee_department = (TextField)form.lookup("#Employee_department");
		TextField Employee_place = (TextField)form.lookup("#Employee_place");
		TextField Employee_salary = (TextField)form.lookup("#Employee_salary");
		TextField Employee_phone = (TextField)form.lookup("#Employee_phone");
		TextField Employee_email = (TextField)form.lookup("#Employee_email");
		TextField Employee_address = (TextField)form.lookup("#Employee_address");
		TextField edit_img = (TextField)form.lookup("#edit_img");
		ImageView employee_picture = (ImageView)form.lookup("#employee_picture");
		DatePicker Employee_join = (DatePicker)form.lookup("#Employee_join");
		ComboBox<String> Employee_category = (ComboBox)form.lookup("#Employee_category");
		ComboBox<String> Employee_position = (ComboBox)form.lookup("#Employee_position");
		ComboBox<String> Employee_education = (ComboBox)form.lookup("#Employee_education");

		Employee employee = getEmployee(num);

		Employee_num.setText(employee.getNum());
		Employee_name.setText(employee.getName());
		Employee_id.setText(employee.getId());
		Employee_birthday.setText(employee.getBirth());
		Employee_birth.setText(employee.getBirth());
		Employee_gender.setText(employee.getSocialNum().substring(0, 1));
		Employee_department.setText(employee.getDepartment());
		Employee_place.setText(employee.getPlace());
		Employee_salary.setText(employee.getSalary());
		Employee_phone.setText(employee.getPhone());
		Employee_email.setText(employee.getEmail());
		Employee_address.setText(employee.getAddress());
		if(employee.getImage() == null || employee.getImage().length() == 0) {
			employee_picture.setImage(new Image("/com/midas/image/기본사진.png"));
		}
		else {
			employee_picture.setImage(new Image("/com/midas/image/" + employee.getImage()));
		}
		Employee_join.setValue(LOCAL_DATE(employee.getJoin()));
		Employee_category.setValue(employee.getCategory());
		Employee_position.setValue(employee.getPosition());
		Employee_education.setValue(employee.getEducation());
		edit_img.setText(employee.getImage());

	}

	public LocalDate LOCAL_DATE (String dateString){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		return localDate;
	}

	@Override
	public Employee getEmployee(String num) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.getEmployee(num);
	}

	@Override
	public boolean EditInfo(String num, Employee employee) {
		DBService dbServ = new DBServiceImpl();
		return dbServ.EditInfo(num, employee);
	}


}
