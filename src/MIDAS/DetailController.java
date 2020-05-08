package MIDAS;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import MIDAS.Data.DataManage;
import MIDAS.Data.DataManageImpl;
import MIDAS.Service.CommonService;
import MIDAS.Service.CommonServiceImpl;
import MIDAS.Service.DetailInfoService;
import MIDAS.Service.DetailInfoServiceImpl;
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
import javafx.stage.Stage;

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
	private final static String[] CATEGORY = {"사원", "관리자"};
	private final static String[] POSITION = {"사원", "주임", "대리", "과장", "차장", "부장"};
	private final static String[] EDUCATION = {"대학원", "대학교", "전문대", "고등학교", "중학교", "초등학교", "없음"};
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
		});
		
	}
	
	private void setTableView() {
		List<Employee> employeelst = comServ.getEmployeeList(SMALLLIST);
		ObservableList tableList = FXCollections.observableArrayList();
		
		for(Employee e : employeelst) {
			tableList.add(new Employee(e.getnum(), e.getname()));
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
					setInfo(employee_simple_table.getSelectionModel().getSelectedItem().getnum());
					selectedEmployee = employee_simple_table.getSelectionModel().getSelectedItem().getnum();
				}
			}
		});
	}
	
	public void setInfo(String num) {
		Employee employee = detail.getEmployee(num);
		
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
		Employee_category.setValue(employee.getcategory());
		Employee_position.setValue(employee.getposition());
		Employee_education.setValue(employee.geteducation());
		Employee_join.setValue(detail.LOCAL_DATE(employee.getjoin()));
		if(employee.getimage() == null || employee.getimage().length() == 0)	{
			employee_picture.setImage(new Image("/MIDAS/image/기본사진.png"));
		}
		else {
			employee_picture.setImage(new Image("/MIDAS/image/" + employee.getimage()));
		}
		edit_img.setText(employee.getimage());
	}
	
	public void EmployeeEdit() {
		if(employee_editbtn.getText().contentEquals("정보수정")) {
			for(int i = 0; !numColumn.getCellData(i).isEmpty(); i++) {
				if(numColumn.getCellData(i).contentEquals(Employee_num.getText())) {
					employee_simple_table.getSelectionModel().select(i);
					break;
				}
			}
			
			Editable(true);
			employee_editbtn.setText("저장");
		}
		else if(employee_editbtn.getText().contentEquals("저장")) {
			String []txtFldIdArr = TXTFLDLST;
			String []comboFldIdArr = COMBOFLDLST;
			Map<String, TextField> txtFldMap = comServ.getTextFieldInfo(root, txtFldIdArr);
			Map<String, ComboBox<String>> comboFldMap = comServ.getComboBoxInfo(root, comboFldIdArr);
			
			if(comServ.isEmptyTxt(txtFldMap, txtFldIdArr) || comServ.isEmptyCombo(comboFldMap, comboFldIdArr)) {
				comServ.ErrorMsg("상세정보 알람", "정보수정 실패", "필수 입력 칸이 비어있습니다.");
				return ;
			}
			
			Editable(false);
			employee_editbtn.setText("정보수정");
			EditProc();
			setTableView();
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
		
		employee.setnum(Employee_num.getText());
		employee.setname(Employee_name.getText());
		employee.setid(Employee_id.getText());
		employee.setbirth(Employee_birthday.getText());
		employee.setdepartment(Employee_department.getText());
		employee.setplace(Employee_place.getText());
		if(Employee_salary.getText() == null || Employee_salary.getText().isEmpty() || Employee_salary.getText().length() == 0) {
			employee.setsalary(null);
		}
		else {
			employee.setsalary(Employee_salary.getText());
		}
		employee.setphone(Employee_phone.getText());
		if(Employee_email.getText() == null || Employee_email.getText().isEmpty() || Employee_email.getText().length() == 0) {
			employee.setemail(null);
		}
		else {
			employee.setemail(Employee_email.getText());
		}
		employee.setaddress(Employee_address.getText());
		if(edit_img.getText() == null || edit_img.getText().isEmpty() || edit_img.getText().length() == 0) {
			employee.setimage(null);
		}
		else {
			employee.setimage(edit_img.getText());
		}
		employee.setjoin(Employee_join.getValue().toString());
		employee.setcategory(Employee_category.getValue());
		employee.setposition(Employee_position.getValue());
		employee.seteducation(Employee_education.getValue());
		
		detail.EditInfo(selectedEmployee, employee);
	}
	
	public void EditCancel() {
		Editable(false);
		employee_editbtn.setText("정보수정");
		setInfo(selectedEmployee);
	}
	
	public void DeleteProc() {
		detail = new DetailInfoServiceImpl();
		detail.DeleteProc(root);
	}
	
	private void txtLimit(TextField txt) {
		if(txt.getLength() >= BIRTH) {
			txt.setText(txt.getText().substring(0, BIRTH));
		}
	}
	
	private void checkEscapeText(TextField txt) {			//입력글자 제한
		txt.setText(txt.getText().replaceAll("[^0-9_]", ""));
	}

}
