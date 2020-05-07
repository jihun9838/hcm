package com.midas;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.db.EmployeeHoliday2;
<<<<<<< HEAD
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;


=======
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.mainpage.service.HompageService;
import com.midas.mainpage.service.HompageServiceImp;
import com.midas.mainpage.service.Loginservice;
import com.midas.mainpage.service.LoginserviceImp;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController extends Controller implements Initializable{

	private CommonService comServ;;
	private DBService dbServ;
	private Parent root;
	@FXML Pane calendarPane;
=======
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainController extends Controller implements Initializable{

	private Parent root;
	private CommonService comServ;
	private DBService dbServ;

	private Loginservice loginServ;
	private HompageService homeServ;


//	@FXML private Button loginBtn;
//	@FXML private TextField loginIdTxt;
//	@FXML private TextField loginPwTxt;


	// HomePage.fxml
	@FXML private Label IDLbl;
	@FXML private Label helloLbl;
	@FXML private Button logoutBtn;
	@FXML private Button commuteBtn;


	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}

	private Parent getScene(Event e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
<<<<<<< HEAD
	}

	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}

	private Parent getScene(Event e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}

	public void HomepageView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/Homepage.fxml");
		borderPane.setCenter(root);
=======
		loginServ = new LoginserviceImp();
		homeServ = new HompageServiceImp();






		//		
		//		loginBtn.setOnAction(e->{			
		//			loginBtnProc();
		//		});
		//
		//		loginBtn.setDisable(true);
		//
		//		loginIdTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
		//			disableButton();
		//
		//		});
		//		loginPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
		//			disableButton();
		//		});
		//
		//		loginIdTxt.setOnAction(e->loginPwTxt.requestFocus());
		//		loginPwTxt.setOnAction(e->loginBtn.requestFocus());
		//		
		
		

	}



	public void HomepageView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent scene = comServ.AddScene("/com/midas/Homepage.fxml");
		borderPane.setCenter(scene);
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
	}

	public void EmployeeMenuView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
<<<<<<< HEAD
		root = comServ.AddScene("/com/midas/Employee.fxml");
		borderPane.setLeft(root);
=======
		Parent scene = comServ.AddScene("/com/midas/Employee.fxml");
		borderPane.setLeft(scene);
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
	}

	public void ManagerMenuView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
<<<<<<< HEAD
		root = comServ.AddScene("/com/midas/Manager.fxml");
		borderPane.setLeft(root);
	}


	//Salary
	public void SalaryMgmtView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/SalaryMgmt.fxml");
		borderPane.setCenter(root);
	}

	public void SalaryReportView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene2("/com/midas/SalaryReport.fxml");
		borderPane.setCenter(root);
	}

	public void SalaryStmtView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/SalaryStmt.fxml");
		borderPane.setCenter(root);
	}

	//	public void ViewTableProc(ActionEvent e) {
	//		SalaryController sc = new SalaryController();
	//		sc.ViewTableProc(e);
	//	}
=======
		Parent scene = comServ.AddScene("/com/midas/Manager.fxml");
		borderPane.setLeft(scene);
	}



	
	
	public void logoutBtnProc(ActionEvent e) {
		comServ.ErrorMsg("로그아웃", "로그아웃 됩니다.", "로그아웃이 실행됩니다.");
		comServ.WindowClose(e);
	}

	public void commuteBtnProc(ActionEvent e) {
		System.out.println("출근");
	}

	public void Lbl(Parent root, String id) {
		homeServ.Lbl(root, id);
	}
	
	
	
	
	public void MyPageView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent scene = comServ.AddScene("/com/midas/mypage/infoPwCheck.fxml");
		borderPane.setCenter(scene);
	}
	
	








	// Salary
	public void SalaryMgmtView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent scene = comServ.AddScene("/com/midas/salary/SalaryMgmt.fxml");
		borderPane.setCenter(scene);
	}

	public void SalaryReportView(Event e) {

		BorderPane borderPane = (BorderPane)getScene(e);
		Parent scene = comServ.AddScene("/com/midas/salary/SalaryReport.fxml");
		borderPane.setCenter(scene);
	}

	public void SalaryStmtView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent scene = comServ.AddScene("/com/midas/salary/SalaryStmt.fxml");
		borderPane.setCenter(scene);
	}





>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7

	//TAA Manager
	public void SetCalendarView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent root = comServ.AddScene("/com/midas/taa/SetCalendar.fxml");
		borderPane.setCenter(root);
	}

	public void TAAReportView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent root = comServ.AddScene("/com/midas/taa/TAAReport.fxml");
		borderPane.setCenter(root);
	}

	public void MonthTAAView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/MonthTAA.fxml");

		Parent form = root;
<<<<<<< HEAD
		String [] departItems= {"�μ�1", "�μ�2", "�μ�3", "�μ�4", "�μ�5"};
		String [] sortItems= {"�����ȣ", "�̸�"};
=======
		String [] departItems= {"遺��꽌1", "遺��꽌2", "遺��꽌3", "遺��꽌4", "遺��꽌5"};
		String [] sortItems= {"�궗�썝踰덊샇", "�씠由�"};
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");

		borderPane.setCenter(root);
	}

	public void PersonalTAAView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/PersonalTAA.fxml");
<<<<<<< HEAD
		
		Parent form = root;
		String [] departItems= {"�μ�1", "�μ�2", "�μ�3", "�μ�4", "�μ�5"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		
=======

		Parent form = root;
		String [] departItems= {"遺��꽌1", "遺��꽌2", "遺��꽌3", "遺��꽌4", "遺��꽌5"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");

>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
		borderPane.setCenter(root);
	}

	public void TAAListView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/TAAList.fxml");

		Parent form = root;
<<<<<<< HEAD
		String [] departItems= {"�μ�1", "�μ�2", "�μ�3", "�μ�4", "�μ�5"};
		String [] sortItems= {"�����ȣ", "�̸�"};
=======
		String [] departItems= {"遺��꽌1", "遺��꽌2", "遺��꽌3", "遺��꽌4", "遺��꽌5"};
		String [] sortItems= {"�궗�썝踰덊샇", "�씠由�"};
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");

		borderPane.setCenter(root);
	}

	public void HolidayApprovalView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/HolidayApproval.fxml");
<<<<<<< HEAD
		
		Parent form = root;
		String [] departItems= {"�μ�1", "�μ�2", "�μ�3", "�μ�4", "�μ�5"};
		String [] sortItems= {"�����ȣ", "�̸�"};
		String [] approvalItems = {"����", "�̽���", "�ݷ�"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");
		comServ.AddComboBox(form, Arrays.asList(approvalItems), "#cmbApproval");
		
=======

		Parent form = root;
		String [] departItems= {"遺��꽌1", "遺��꽌2", "遺��꽌3", "遺��꽌4", "遺��꽌5"};
		String [] sortItems= {"�궗�썝踰덊샇", "�씠由�"};
		String [] approvalItems = {"�듅�씤", "誘몄듅�씤", "諛섎젮"};
		comServ.AddComboBox(form, Arrays.asList(departItems), "#cmbDepart");
		comServ.AddComboBox(form, Arrays.asList(sortItems), "#cmbSort");
		comServ.AddComboBox(form, Arrays.asList(approvalItems), "#cmbApproval");

>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
		borderPane.setCenter(root);
	}

	public void HolidayModifyView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/HolidayModify.fxml");
		borderPane.setCenter(root);
	}
<<<<<<< HEAD
	
=======

>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
	//TAA Employee
	public void OwnTAAView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnTAA.fxml");
		borderPane.setCenter(root);
	}
<<<<<<< HEAD
	
	public void OwnAskHolidayView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnAskHoliday.fxml");
		
		Parent form = root;
		String [] FullHalfItems= {"����", "����"};
		comServ.AddComboBox(form, Arrays.asList(FullHalfItems), "#cmbFullHalf");
		
		borderPane.setCenter(root);
		
		Scene scene = ((Parent)e.getSource()).getScene();
		List<EmployeeHoliday2> OwnHolidayList = dbServ.SelectTable("EmployeeHoliday", "WHERE id = \"200401\""); //�α��� �� ����� ���̵�
		comServ.ShowTableViewByList(scene, "#OwnRemainTable", OwnHolidayList);
	}
	
	public void OwnModifyHolidayView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnModifyHoliday.fxml");
		
		String [] TypeItems= {"����", "����", "����", "���", "����", "���"};
		
		borderPane.setCenter(root);
		
	}
	
	
	
=======

	public void OwnAskHolidayView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnAskHoliday.fxml");

		Parent form = root;
		String [] FullHalfItems= {"�쟾�씪", "諛섏씪"};
		comServ.AddComboBox(form, Arrays.asList(FullHalfItems), "#cmbFullHalf");

		borderPane.setCenter(root);

		Scene scene = ((Parent)e.getSource()).getScene();
		List<EmployeeHoliday2> OwnHolidayList = dbServ.SelectTable("EmployeeHoliday", "WHERE id = \"200401\""); //濡쒓렇�씤 �븳 �궗�엺�쓽 �븘�씠�뵒
		comServ.ShowTableViewByList(scene, "#OwnRemainTable", OwnHolidayList);
	}

	public void OwnModifyHolidayView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/taa/own/OwnModifyHoliday.fxml");

		String [] TypeItems= {"�뿰李�", "異쒖옣", "議고눜", "寃곌렐", "吏�媛�", "異쒓렐"};

		borderPane.setCenter(root);

	}








	//HR
	public void HRPageView(Event e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		root = comServ.AddScene("/com/midas/hr/HRMpage.fxml");
		borderPane.setCenter(root);
	}


>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7
	


}
