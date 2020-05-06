package MIDAS;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import MIDAS.Service.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HRMController extends Controller implements Initializable{
	@FXML private TableView<Employee> employee_table;
	@FXML private TableColumn<Employee, String> numColumn;
	@FXML private TableColumn<Employee, String> nameColumn;
	@FXML private TableColumn<Employee, String> departmentColumn;
	@FXML private TableColumn<Employee, String> positionColumn;
	@FXML private TableColumn<Employee, String> placeColumn;
	@FXML private TableColumn<Employee, String> categoryColumn;
	@FXML private TableColumn<Employee, String> joinColumn;
	@FXML private TableColumn<Employee, String> phoneColumn;
	@FXML private TableColumn<Employee, String> emailColumn;
	@FXML private TableColumn<Employee, String> educationColumn;
	@FXML private TableColumn<Employee, String> btnColumn;
	@FXML private ComboBox<String> employee_attribute;
	@FXML private TextField employee_search_txt;
	private final static String[] ATTRIBUTE = {"사원번호", "이름", "부서", "직급", "근무지", "사워구분", "입사일자", "전화번호", "이메일", "최종학력"};
	//private final static int ALLLIST = 1;
	private final static int BIGLIST = 2;
	//private final static int SMALLLIST = 3;
	
	private Parent root;
	private HRMService hrmserv;
	CommonService comServ;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		List<Employee> employeelst = comServ.getEmployeeList(BIGLIST);
		
		setTableView(employeelst);
		
		employee_attribute.getItems().addAll(ATTRIBUTE);
		employee_attribute.setValue("사원번호");
		
	}
	
	private void setTableView(List<Employee> employeelst) {
		ObservableList tableList = FXCollections.observableArrayList();
		
		for(Employee e : employeelst) {
			tableList.add(new Employee(e.getnum(), e.getname(), e.getcategory(), e.getdepartment(), e.getposition(), e.getplace(), e.getphone(), e.getjoin(), e.getemail(), e.geteducation()));
		}
		
		numColumn.setCellValueFactory(cellData -> cellData.getValue().num());
		numColumn.setStyle("-fx-alignment: CENTER;");
		
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name());
		nameColumn.setStyle("-fx-alignment: CENTER;");
		
		departmentColumn.setCellValueFactory(cellData -> cellData.getValue().department());
		departmentColumn.setStyle("-fx-alignment: CENTER;");
		
		positionColumn.setCellValueFactory(cellData -> cellData.getValue().position());
		positionColumn.setStyle("-fx-alignment: CENTER;");
		
		placeColumn.setCellValueFactory(cellData -> cellData.getValue().place());
		placeColumn.setStyle("-fx-alignment: CENTER;");
		
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().category());
		categoryColumn.setStyle("-fx-alignment: CENTER;");
		
		joinColumn.setCellValueFactory(cellData -> cellData.getValue().join());
		joinColumn.setStyle("-fx-alignment: CENTER;");
		
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phone());
		phoneColumn.setStyle("-fx-alignment: CENTER;");
		
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().email());
		emailColumn.setStyle("-fx-alignment: CENTER;");
		
		educationColumn.setCellValueFactory(cellData -> cellData.getValue().education());
		educationColumn.setStyle("-fx-alignment: CENTER;");
		
		btnColumn.setCellFactory(item -> new TableCell<Employee, String>() {
			private final Button detailBtn = new Button("상세정보");
			
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(null);
				
				detailBtn.setOnAction(e->{
					String employeeNum = getTableView().getItems().get(getIndex()).getnum();
					hrmserv = new HRMServiceImpl();
					DetailInfoService detail = new DetailInfoServiceImpl();
					Parent form = hrmserv.OpenDetailForm();
					
					detail.setInfo(form, employeeNum);
				});
				if(empty) {
					setGraphic(null);
				}
				else {
					setGraphic(this.detailBtn);
				}
			}
		});
		btnColumn.setStyle("-fx-alignment: CENTER;");
	    
		employee_table.setItems(tableList);
	}
	
	public void employeeSearch() {
		String attribute = employee_attribute.getValue();
		String txt = employee_search_txt.getText();
		comServ = new CommonServiceImpl();
		
		List<Employee> employeelst = comServ.getEmployeeSearch(attribute, txt, BIGLIST);
		
		setTableView(employeelst);
	}
	public void employeeAdd() {
		hrmserv = new HRMServiceImpl();
		hrmserv.OpenAddForm();
		
	}
}
