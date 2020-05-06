package com.midas.hr;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.Employee;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class HRController extends Controller implements Initializable{

	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		comServ = new CommonServiceImpl();
//		dbServ = new DBServiceImpl();
//		
//		List<Employee> employeelst = dbServ.getEmployeeList();
//		ObservableList tableList = FXCollections.observableArrayList();
//
//		for(Employee e : employeelst) {
//			tableList.add(new Employee(e.getnum(), e.getid(), e.getpw(), e.getname(), e.getbirth(), e.getgender(), e.getcategory(), e.getsalay(), e.getdepartment(), e.getposition(), e.getplace(), e.getphone(), e.getjoin(), e.getemail(), e.geteducation(), e.getaddress(), e.getimage()));
//
//			//System.out.println(e.getnum() + e.getid() + e.getpw() + e.getname() + e.getbirth() + e.getgender() + e.getcategory() + e.getsalay() + e.getdepartment() + e.getposition() + e.getplace() + e.getphone() + e.getjoin() + e.getemail() + e.geteducation() + e.getadrress() + e.getimage());
//		}
////
//		numColumn.setCellValueFactory(cellData -> cellData.getValue().num());
//		numColumn.setStyle("-fx-alignment: CENTER;");
//
//		nameColumn.setCellValueFactory(cellData -> cellData.getValue().name());
//		nameColumn.setStyle("-fx-alignment: CENTER;");
//
//		departmentColumn.setCellValueFactory(cellData -> cellData.getValue().department());
//		departmentColumn.setStyle("-fx-alignment: CENTER;");
//
//		positionColumn.setCellValueFactory(cellData -> cellData.getValue().position());
//		positionColumn.setStyle("-fx-alignment: CENTER;");
//
//		placeColumn.setCellValueFactory(cellData -> cellData.getValue().place());
//		placeColumn.setStyle("-fx-alignment: CENTER;");
//
//		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().category());
//		categoryColumn.setStyle("-fx-alignment: CENTER;");
//
//		joinColumn.setCellValueFactory(cellData -> cellData.getValue().join());
//		joinColumn.setStyle("-fx-alignment: CENTER;");
//
//		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phone());
//		phoneColumn.setStyle("-fx-alignment: CENTER;");
//
//		emailColumn.setCellValueFactory(cellData -> cellData.getValue().email());
//		emailColumn.setStyle("-fx-alignment: CENTER;");
//
//		educationColumn.setCellValueFactory(cellData -> cellData.getValue().education());
//		educationColumn.setStyle("-fx-alignment: CENTER;");
//
//		employee_table.setItems(tableList);

	}


}
