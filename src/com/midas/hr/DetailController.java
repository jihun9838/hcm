package com.midas.hr;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.hr.service.DetailInfoService;
import com.midas.hr.service.DetailInfoServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetailController extends Controller implements Initializable{
	@FXML private TableView<Employee> employee_simple_table;
	@FXML private TableColumn<Employee, String> numColumn;
	@FXML private TableColumn<Employee, String> nameColumn;
	@FXML private TextField Employee_num;
	@FXML private TextField Employee_name;
	@FXML private TextField Employee_id;
	@FXML private TextField Employee_birthday;
	@FXML private TextField Employee_birth;
	@FXML private TextField Employee_gender;
	@FXML private TextField Employee_department;
	@FXML private TextField Employee_place;
	@FXML private TextField Employee_salary;
	@FXML private TextField Employee_phone;
	@FXML private TextField Employee_email;
	@FXML private TextField Employee_address;
	@FXML private TextField edit_img;
	@FXML private ImageView employee_picture;
	@FXML private DatePicker Employee_join;
	@FXML private ComboBox<String> Employee_category;
	@FXML private ComboBox<String> Employee_position;
	@FXML private ComboBox<String> Employee_education;
	@FXML private Button employee_editbtn;
	@FXML private Button edit_cancel;
	//private final static int ALLLIST = 1;
	//private final static int BIGLIST = 2;
	private final static int SMALLLIST = 3;
	private final static String[] CATEGORY = {"���", "������"};
	private final static String[] POSITION = {"���", "����", "�븮", "����", "����", "����"};
	private final static String[] EDUCATION = {"���п�", "���б�", "������", "����б�", "���б�", "�ʵ��б�", "����"};
	private final static String[] TXTFLDLST = {"#Employee_num", "#Employee_name", "#Employee_id", "#Employee_birthday", "#Employee_department", "#Employee_place", "#Employee_phone", "#Employee_address"};
	private final static String[] COMBOFLDLST = {"#Employee_category", "#Employee_position", "#Employee_education"};
	TableViewSelectionModel<Employee> defaultSelectionModel;
	private Parent root;
	DetailInfoService detail;
	CommonService comServ;
	final private int BIRTH = 6;
	private String selectedEmployee;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		detail = new DetailInfoServiceImpl();
		comServ = new CommonServiceImpl();
		defaultSelectionModel = employee_simple_table.getSelectionModel();

		setTableView();

		Employee_category.getItems().addAll(CATEGORY);
		Employee_category.setStyle("-fx-opacity: 1;");
		Employee_position.getItems().addAll(POSITION);
		Employee_position.setStyle("-fx-opacity: 1;");
		Employee_education.getItems().addAll(EDUCATION);
		Employee_education.setStyle("-fx-opacity: 1;");
		Employee_join.setStyle("-fx-opacity: 1;");

		Employee_birthday.textProperty().addListener((obs, oldTxt, newTxt)->{
			txtLimit(Employee_birthday);
			checkEscapeText(Employee_birthday);
			Employee_birth.setText(newTxt);
			txtLimit(Employee_birth);
		});

	}

	private void setTableView() {
		List<Employee> employeelst = comServ.getEmployeeList(SMALLLIST);
		ObservableList tableList = FXCollections.observableArrayList();

		for(Employee e : employeelst) {
			tableList.add(new Employee(e.getNum(), e.getName()));
		}

		numColumn.setCellValueFactory(cellData -> cellData.getValue().num());
		numColumn.setStyle("-fx-alignment: CENTER;");

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name());
		nameColumn.setStyle("-fx-alignment: CENTER;");

		employee_simple_table.setItems(tableList);

		employee_simple_table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>() {
			@Override
			public void changed(ObservableValue<? extends Employee> observable, Employee oldValue, Employee newValue) {
				if(newValue!=null) {
					setInfo(employee_simple_table.getSelectionModel().getSelectedItem().getNum());
					selectedEmployee = employee_simple_table.getSelectionModel().getSelectedItem().getNum();
				}
			}
		});
	}

	public void setInfo(String num) {
		Employee employee = detail.getEmployee(num);

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
		Employee_category.setValue(employee.getCategory());
		Employee_position.setValue(employee.getPosition());
		Employee_education.setValue(employee.getEducation());
		Employee_join.setValue(detail.LOCAL_DATE(employee.getJoin()));
		if(employee.getImage() == null || employee.getImage().length() == 0)	{
			employee_picture.setImage(new Image("/com/midas/image/�⺻����.png"));
		}
		else {
			employee_picture.setImage(new Image("/com/midas/image/" + employee.getImage()));
		}
		edit_img.setText(employee.getImage());
	}

	public void EmployeeEdit() {
		if(employee_editbtn.getText().contentEquals("��������")) {
			for(int i = 0; !numColumn.getCellData(i).isEmpty(); i++) {
				if(numColumn.getCellData(i).contentEquals(Employee_num.getText())) {
					employee_simple_table.getSelectionModel().select(i);
					break;
				}
			}

			Editable(true);
			employee_editbtn.setText("����");
		}
		else if(employee_editbtn.getText().contentEquals("����")) {
			String []txtFldIdArr = TXTFLDLST;
			String []comboFldIdArr = COMBOFLDLST;
			Map<String, TextField> txtFldMap = comServ.getTextFieldInfo(root, txtFldIdArr);
			Map<String, ComboBox<String>> comboFldMap = comServ.getComboBoxInfo(root, comboFldIdArr);

			if(comServ.isEmptyTxt(txtFldMap, txtFldIdArr) || comServ.isEmptyCombo(comboFldMap, comboFldIdArr)) {
				comServ.ErrorMsg("������ �˶�", "�������� ����", "�ʼ� �Է� ĭ�� ����ֽ��ϴ�.");
				return ;
			}

			Editable(false);
			employee_editbtn.setText("��������");
			EditProc();
			setTableView();
			setInfo(selectedEmployee);
		}
	}

	public void Editable(boolean set) {
		Employee_num.setEditable(set);
		Employee_name.setEditable(set);
		Employee_id.setEditable(set);
		Employee_birthday.setEditable(set);
		Employee_birth.setDisable(set);
		Employee_gender.setDisable(set);;
		Employee_department.setEditable(set);
		Employee_place.setEditable(set);
		Employee_salary.setEditable(set);
		Employee_phone.setEditable(set);
		Employee_email.setEditable(set);
		Employee_address.setEditable(set);
		if(set) {
			employee_simple_table.setSelectionModel(null);
		}
		else {
			employee_simple_table.setSelectionModel(defaultSelectionModel);
		}
		Employee_category.setDisable(!set);
		Employee_position.setDisable(!set);
		Employee_education.setDisable(!set);
		Employee_join.setDisable(!set);
		edit_cancel.setVisible(set);
		edit_img.setVisible(set);
		edit_img.setEditable(set);
	}

	public void EditProc() {
		Employee employee = new Employee();

		employee.setNum(Employee_num.getText());
		employee.setName(Employee_name.getText());
		employee.setId(Employee_id.getText());
		employee.setBirth(Employee_birthday.getText());
		employee.setDepartment(Employee_department.getText());
		employee.setPlace(Employee_place.getText());
		if(Employee_salary.getText() == null || Employee_salary.getText().isEmpty() || Employee_salary.getText().length() == 0) {
			employee.setSalary(null);
		}
		else {
			employee.setSalary(Employee_salary.getText());
		}
		employee.setPhone(Employee_phone.getText());
		if(Employee_email.getText() == null || Employee_email.getText().isEmpty() || Employee_email.getText().length() == 0) {
			employee.setEmail(null);
		}
		else {
			employee.setEmail(Employee_email.getText());
		}
		employee.setAddress(Employee_address.getText());
		if(edit_img.getText() == null || edit_img.getText().isEmpty() || edit_img.getText().length() == 0) {
			employee.setImage(null);
		}
		else {
			try {
				Image img = new Image("/com/midas/image/" + edit_img.getText());
				employee.setImage(edit_img.getText());
			} catch(Exception e) {
				comServ.ErrorMsg("������ �˶�", "�������� ����", "�ش� ���� ������ �������� �ʽ��ϴ�.\n�⺻�������� �����˴ϴ�.");
				employee.setImage(null);
			}
		}
		employee.setJoin(Employee_join.getValue().toString());
		employee.setCategory(Employee_category.getValue());
		employee.setPosition(Employee_position.getValue());
		employee.setEducation(Employee_education.getValue());

		detail.EditInfo(selectedEmployee, employee);
	}

	public void EditCancel() {
		Editable(false);
		employee_editbtn.setText("��������");
		setInfo(selectedEmployee);
	}
	
	public void DeleteProc(ActionEvent event) {
		if(detail.DeleteProc(root)) {
	         CloseProc(event);
	      }
	}

	public void CloseProc(ActionEvent event) {
		comServ = new CommonServiceImpl();
		comServ.WindowClose(event);
	}

	private void txtLimit(TextField txt) {
		if(txt.getLength() >= BIRTH) {
			txt.setText(txt.getText().substring(0, BIRTH));
		}
	}

	private void checkEscapeText(TextField txt) {			//�Է±��� ����
		txt.setText(txt.getText().replaceAll("[^0-9_]", ""));
	}

}
