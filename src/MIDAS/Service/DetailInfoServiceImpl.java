package MIDAS.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import MIDAS.Employee;
import MIDAS.Data.DataManage;
import MIDAS.Data.DataManageImpl;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
		
		Employee_num.setText(employee.getnum());
		Employee_name.setText(employee.getname());
		Employee_id.setText(employee.getid());
		Employee_birthday.setText(employee.getbirth());
		Employee_birth.setText(employee.getbirth());
		Employee_gender.setText(employee.getgender().substring(0, 1));
		Employee_department.setText(employee.getdepartment());
		Employee_place.setText(employee.getplace());
		Employee_salary.setText(employee.getsalary());
		Employee_phone.setText(employee.getphone());
		Employee_email.setText(employee.getemail());
		Employee_address.setText(employee.getaddress());
		if(employee.getimage() == null || employee.getimage().length() == 0) {
			employee_picture.setImage(new Image("/MIDAS/image/기본사진.png"));
		}
		else {
			employee_picture.setImage(new Image("/MIDAS/image/" + employee.getimage()));
		}
		Employee_join.setValue(LOCAL_DATE(employee.getjoin()));
		Employee_category.setValue(employee.getcategory());
		Employee_position.setValue(employee.getposition());
		Employee_education.setValue(employee.geteducation());
		edit_img.setText(employee.getimage());
		
	}
	
	public LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}

	@Override
	public Employee getEmployee(String num) {
		DataManage dataManage = new DataManageImpl();
		return dataManage.getEmployee(num);
	}

	@Override
	public boolean EditInfo(String num, Employee employee) {
		DataManage dataManage = new DataManageImpl();
		return dataManage.EditInfo(num, employee);
	}

	
}
