package com.midas.mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SigninController extends Controller implements Initializable{
	
	Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private Employee employee;

	@FXML private TextField signEmployeeTxt;
	@FXML private TextField signPwTxt;
	@FXML private TextField signPwOKTxt;
	@FXML private TextField signNameTxt;
	@FXML private TextField signIdTxt;
	@FXML private TextField SignBirthTxt;
	@FXML private TextField signSecretTxt;
	@FXML private TextField signPhoneNumTxt;
	@FXML private TextField signAddressTxt;
	@FXML private TextField signEmailTxt;
	@FXML private ComboBox<String> SignDepartmemtCombobox;
	@FXML private ComboBox<String> signFinalEduCombobox;
	@FXML private DatePicker SignJoindate;
	@FXML private Button idCheckBtn;
	@FXML private Button signinBtn;

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		employee = new Employee();

		idCheckBtn.setOnAction(e->{			
			idCheckBtnProc();
		});
		signinBtn.setDisable(true);			// �� �Է��ϸ� Ȱ��ȭ �ǰ�

		signinBtn.setOnAction(e->{
			signinBtnProc();
		});

		signEmployeeTxt.setOnAction(e->signNameTxt.requestFocus());
		signNameTxt.setOnAction(e->signIdTxt.requestFocus());
		signIdTxt.setOnAction(e->idCheckBtn.requestFocus());

		signPwTxt.setOnAction(e->signPwOKTxt.requestFocus());
		signPwOKTxt.setOnAction(e->SignBirthTxt.requestFocus());
		SignBirthTxt.setOnAction(e->signSecretTxt.requestFocus());
		signSecretTxt.setOnAction(e->signPhoneNumTxt.requestFocus());
		signPhoneNumTxt.setOnAction(e->signAddressTxt.requestFocus());
		signAddressTxt.setOnAction(e->SignDepartmemtCombobox.requestFocus());
		SignDepartmemtCombobox.setOnAction(e->signEmailTxt.requestFocus());
		signEmailTxt.setOnAction(e->SignJoindate.requestFocus());
		SignJoindate.setOnAction(e->signFinalEduCombobox.requestFocus());
		signFinalEduCombobox.setOnAction(e->signinBtn.requestFocus());

		signEmployeeTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signPwOKTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();			
		});
		signNameTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signIdTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();			
		});
		SignBirthTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});		
		signSecretTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signPhoneNumTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signAddressTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();			
		});
		signEmailTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});		

		String [] items1= {"ȸ��", "������", "�λ�", "����"};
		SignDepartmemtCombobox.getItems().addAll(items1);

		String [] items2= {"���б� ����", "����б� ����", "�������� ����", "���б� ����", "���п� ����"};
		signFinalEduCombobox.getItems().addAll(items2);

	}

	public void signinBtnProc() {

		if(signPwTxt.getText().equals(signPwOKTxt.getText())) {

			employee.setNum(signEmployeeTxt.getText());
			employee.setName(signNameTxt.getText());
			employee.setId(signIdTxt.getText());
			employee.setPw(signPwTxt.getText());
			employee.setBirth(SignBirthTxt.getText());
			employee.setSocialNum(signSecretTxt.getText());
			employee.setPhone(signPhoneNumTxt.getText());
			employee.setAddress(signAddressTxt.getText());
			employee.setDepartment(SignDepartmemtCombobox.getValue());
			employee.setEmail(signEmailTxt.getText());
			employee.setJoin(SignJoindate.getValue().toString());
			employee.setEducation(signFinalEduCombobox.getValue());

			dbServ.MembershipProc(employee);			
			comServ.ErrorMsg("ȸ������", "ȸ������ ����", "ȸ�������� �Ϸ� �Ǿ����ϴ�!");
		}
		else {
			comServ.ErrorMsg("ȸ������", "ȸ������ ����","��й�ȣ�� �����ʽ��ϴ�. �ٽ� �Է����ּ���!");
			signPwOKTxt.requestFocus();
			signPwOKTxt.clear();
		}
	}

	public void signinBtn() {

		if(signEmployeeTxt.getLength()>0 && signPwOKTxt.getLength()>0
				&&signPwOKTxt.getLength()>0 && signNameTxt.getLength()>0
				&&signIdTxt.getLength()>0 && SignBirthTxt.getLength()>0
				&&signSecretTxt.getLength()>0 && signPhoneNumTxt.getLength()>0
				&&signAddressTxt.getLength()>0 && signEmailTxt.getLength()>0) {		
			signinBtn.setDisable(false);
		}
		else signinBtn.setDisable(true);
	}

	public void idCheckBtnProc() {
		String id = signIdTxt.getText();

		if(dbServ.idcheck(id)==false) {
			signIdTxt.clear();
			signIdTxt.requestFocus();
		}
		else
			signPwTxt.requestFocus();

	}
}





