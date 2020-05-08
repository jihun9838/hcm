package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TAAListController extends Controller implements Initializable {

	@FXML private DatePicker TAADatePicker;
	@FXML private ComboBox<String> cmbDepart, cmbSort;
	@FXML private TextField searchTf;
	
	@FXML private TableView<Employee> HolidayTable;
	@FXML private TableColumn<Employee, String> numColumn, nameColumn, departmentColumn, joinColumn, availableDayColumn, usedDayColumn, remainDayColumn;
	
	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private String department, sort;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TAADatePicker.setValue(LocalDate.now());
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		department = cmbDepart.getPromptText();
		sort = cmbSort.getPromptText();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	public void PickerClicked(ActionEvent e) {
		cmbDepart.requestFocus();
	}
	public void DepartClicked(ActionEvent e) {
		department = cmbDepart.getValue();
		cmbSort.requestFocus();
	}
	public void SortClicked(ActionEvent e) {
		sort = cmbSort.getValue();
		searchTf.requestFocus();
	}
	
	public void HolidaySearch(ActionEvent e) {
		System.out.println(department);
		System.out.println(sort);
		Scene scene = ((Parent)e.getSource()).getScene();
		
		
		String whereQuerry = "";
		//"부서"="회계;
		if(!"부서 전체".contentEquals(department)) {
			whereQuerry = " WHERE"+
							" \"부서\""+
							"="+
							department;
		}
		
		List<Employee> TAAList = dbServ.SelectTableHoliday(whereQuerry);
		setTableView(TAAList);
		
	}
	
	private void setTableView(List<Employee> employeelst) {
	      ObservableList tableList = FXCollections.observableArrayList();
	      
	      for(Employee e : employeelst) {
	         tableList.add(new Employee(e.getNum(), e.getName(), e.getDepartment(), e.getJoin(), e.getAvailableHoliday(), e.getUsedHoliday(), e.getRemainHoliday()));
	      }
	      
	      numColumn.setCellValueFactory(cellData -> cellData.getValue().num());
	      numColumn.setStyle("-fx-alignment: CENTER;");
	      
	      nameColumn.setCellValueFactory(cellData -> cellData.getValue().name());
	      nameColumn.setStyle("-fx-alignment: CENTER;");
	
	      
	      departmentColumn.setCellValueFactory(cellData -> cellData.getValue().department());
	      departmentColumn.setStyle("-fx-alignment: CENTER;");
	      
	    
	      joinColumn.setCellValueFactory(cellData -> cellData.getValue().join());
	      joinColumn.setStyle("-fx-alignment: CENTER;");
	      
	      
	      availableDayColumn.setCellValueFactory(cellData -> cellData.getValue().usedHoliday());  //인티저 타입은 asObject
	      availableDayColumn.setStyle("-fx-alignment: CENTER;");
	      
	      
	      usedDayColumn.setCellValueFactory(cellData -> cellData.getValue().usedHoliday());
	      usedDayColumn.setStyle("-fx-alignment: CENTER;");
	      
	      
	      remainDayColumn.setCellValueFactory(cellData -> cellData.getValue().remainHoliday());
	      remainDayColumn.setStyle("-fx-alignment: CENTER;");
	      
	      
	      
	      
	      
//	      btnColumn.setCellFactory(item -> new TableCell<Employee, String>() {
//	         private final Button detailBtn = new Button("상세정보");
//	         
//	         @Override
//	         protected void updateItem(String item, boolean empty) {
//	            super.updateItem(item, empty);
//	            setText(null);
//	            
//	            detailBtn.setOnAction(e->{
//	               String employeeNum = getTableView().getItems().get(getIndex()).getnum();
//	               hrmserv = new HRMServiceImpl();
//	               DetailInfoService detail = new DetailInfoServiceImpl();
//	               Parent form = hrmserv.OpenDetailForm();
//	               
//	               detail.setInfo(form, employeeNum);
//	               edit_cancel = (Button)form.lookup("#edit_cancel");
//	               edit_cancel.visibleProperty().addListener((obs, oldValue, newValue)->{
//	                  if(oldValue) {
//	                     List<Employee> employeelst = comServ.getEmployeeList(BIGLIST);
//	                     
//	                     setTableView(employeelst);
//	                  }
//	               });
//	            });
//	            if(empty) {
//	               setGraphic(null);
//	            }
//	            else {
//	               setGraphic(this.detailBtn);
//	            }
//	         }
//	      });
//	      btnColumn.setStyle("-fx-alignment: CENTER;");
	       
	      HolidayTable.setItems(tableList);
	   }
}
