package com.midas.hr;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.hr.service.AddInfoService;
import com.midas.hr.service.AddInfoServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddController extends Controller implements Initializable{
	@FXML private TextField add_num;
	@FXML private TextField add_name;
	@FXML private TextField add_id;
	@FXML private TextField add_pw;
	@FXML private TextField add_birth;	
	@FXML private TextField add_gender;
	@FXML private TextField add_department;
	@FXML private TextField add_place;
	@FXML private TextField add_salary;
	@FXML private TextField add_phone;
	@FXML private TextField add_email;
	@FXML private TextField add_address;
	@FXML private TextField add_img;
	@FXML private DatePicker add_join;
	@FXML private ComboBox<String> add_category;
	@FXML private ComboBox<String> add_position;
	@FXML private ComboBox<String> add_education;
	private final static String[] CATEGORY = {"사원", "관리자"};
	private final static String[] POSITION = {"사원", "주임", "대리", "과장", "차장", "부장"};
	private final static String[] EDUCATION = {"대학원", "대학교", "전문대", "고등학교", "중학교", "초등학교", "없음"};
	private final static String[] TXTFLDLST = {"#add_num", "#add_name", "#add_id", "#add_pw", "#add_birth", "#add_gender", "#add_department", "#add_place", "#add_phone", "#add_address"};
	private final static String[] COMBOFLDLST = {"#add_category", "#add_position", "#add_education"};
	CommonService comServ;
	final private int BIRTH = 6;
	final private int GENDER = 7;
	private Parent root;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		comServ = new CommonServiceImpl();

		add_category.getItems().addAll(CATEGORY);
		add_position.getItems().addAll(POSITION);
		add_education.getItems().addAll(EDUCATION);

		add_birth.textProperty().addListener((obs, oldTxt, newTxt)->{
			txtLimit(add_birth, BIRTH);
			checkEscapeText(add_birth);
		});

		add_gender.textProperty().addListener((obs, oldTxt, newTxt)->{
			txtLimit(add_gender, GENDER);
			checkEscapeText(add_gender);
		});

		add_num.textProperty().addListener((obs, oldTxt, newTxt)->{
			checkEscapeText(add_num);
		});
		
		add_phone.textProperty().addListener((obs, oldTxt, newTxt)->{
			checkEscapeText(add_phone);
		});
	}

	public void InfoSave(ActionEvent event) {
		AddInfoService add = new AddInfoServiceImpl();
		Employee employee = new Employee();
		String []txtFldIdArr = TXTFLDLST;
		String []comboFldIdArr = COMBOFLDLST;
		Map<String, TextField> txtFldMap = comServ.getTextFieldInfo(root, txtFldIdArr);
		Map<String, ComboBox<String>> comboFldMap = comServ.getComboBoxInfo(root, comboFldIdArr);

		if(comServ.isEmptyTxt(txtFldMap, txtFldIdArr) || comServ.isEmptyCombo(comboFldMap, comboFldIdArr)) {
			comServ.ErrorMsg("사원추가 알람", "사원추가 실패", "필수 입력 칸이 비어있습니다.");
			return ;
		}
		if(comServ.idcheck(add_id.getText()) && comServ.numcheck(add_num.getText())) {
			employee.setNum(add_num.getText());
			employee.setName(add_name.getText());
			employee.setId(add_id.getText());
			employee.setPw(add_pw.getText());
			employee.setBirth(add_birth.getText());
			employee.setSocialNum(add_gender.getText());
			employee.setDepartment(add_department.getText());
			employee.setPlace(add_place.getText());
			employee.setSalary(add_salary.getText());
			employee.setPhone(add_phone.getText());
			employee.setEmail(add_email.getText());
			employee.setAddress(add_address.getText());
			if(!add_img.getText().isEmpty()) {
				employee.setImage("/com/midas/image/" + add_img.getText());
			}
			if(add_join.getValue() == null || add_join.getValue().toString().length() == 0)	{
				add_join.setValue(LocalDate.now());
			}
			employee.setJoin(add_join.getValue().toString());
			employee.setCategory(add_category.getValue());
			employee.setPosition(add_position.getValue());
			employee.setEducation(add_education.getValue());
	
			if(add.SaveInfo(employee)) {
				CloseProc(event);
			}
		}
		else {
			comServ.ErrorMsg("사원추가 알람", "사원추가 실패", "사원번호 또는 아이디가 이미 존재합니다.");
		}
	}

	public void CloseProc(ActionEvent event) {
		comServ.WindowClose(event);
	}

	private void txtLimit(TextField txt, int limit) {
		if(txt.getLength() >= limit) {
			txt.setText(txt.getText().substring(0, limit));
		}
	}

	private void checkEscapeText(TextField txt) {			//입력글자 제한
		txt.setText(txt.getText().replaceAll("[^0-9_]", ""));
	}

}
