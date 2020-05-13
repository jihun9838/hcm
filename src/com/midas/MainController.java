package com.midas;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.db.Commute;
import com.midas.db.Employee;
import com.midas.db.HolidayRequest;
import com.midas.db.TAA;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.mainpage.service.Loginservice;
import com.midas.mainpage.service.LoginserviceImp;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.CalendarService;
import com.midas.taa.service.CalendarServiceImpl;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MainController extends Controller implements Initializable {

	private Parent root;
	private CommonService comServ;
	private DBService dbServ;
	private Loginservice loginServ;
	private CalendarService calServ;

	// Homepage.fxml
	@FXML
	private Label IDLbl;
	@FXML
	private Label helloLbl;
	@FXML
	private Button logoutBtn;
	@FXML
	private Button commuteBtn;

	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent) e.getSource();
		return btnObj.getScene().getRoot();
	}

	private Parent getScene(Event e) {
		Parent btnObj = (Parent) e.getSource();
		return btnObj.getScene().getRoot();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		loginServ = new LoginserviceImp();
		calServ = new CalendarServiceImpl();

	}

	
	
	
	// Homepage
	public void HomepageView(ActionEvent e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent scene = comServ.AddScene("/com/midas/Homepage.fxml");
		borderPane.setCenter(scene);
	}

	public void EmployeeMenuView(ActionEvent e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent scene = comServ.AddScene("/com/midas/Employee.fxml");
		borderPane.setLeft(scene);
	}

	public void ManagerMenuView(ActionEvent e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent scene = comServ.AddScene("/com/midas/Manager.fxml");
		borderPane.setLeft(scene);
	}

	public void logoutBtnProc(ActionEvent e) {
		comServ.ErrorMsg("로그아웃", "로그아웃 됩니다.", "로그아웃이 실행됩니다.");
		
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent loginPage = comServ.AddSceneWithController("/com/midas/mainpage/login.fxml");
		
		borderPane.setLeft(null);
		borderPane.setCenter(loginPage);
		
		//comServ.WindowClose(e);
	}

	public void commuteBtnProc(ActionEvent e) {
		DBService dbServ = new DBServiceImpl();
		String num = IDLbl.getText();
		Commute commute = new Commute();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String timeStr = sdf.format(cal.getTime());

		if (commuteBtn.getText().contentEquals("출근")) {
			dbServ.SaveCommute(commute, num, "출근", timeStr);
			// dbServ.SaveCommute(commute);
			System.out.println(timeStr);
			comServ.ErrorMsg("출/퇴근", "출근입니다.", "출근하였습니다.\n오늘하루도 화이팅입니다!");
			commuteBtn.setText("퇴근");
		}

		else if (commuteBtn.getText().contentEquals("퇴근")) {
			if (comServ.ConfirmMsg("출/퇴근", "퇴근입니다.", "퇴근하시겠습니까?")) {
				dbServ.SaveCommute(commute, num, "퇴근", timeStr);
				comServ.ErrorMsg("출/퇴근", "퇴근입니다.", "퇴근하였습니다.\n오늘하루도 고생하셨습니다!");
				commuteBtn.setText("출근");
			} else {
			}
		}
	}

	public void Lbl(Parent root, String id) {
		comServ.setUserLabel(root, id);
	}

	public void MyPageView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithController("/com/midas/mypage/infoPwCheck.fxml");
		borderPane.setCenter(root);
	}

	
	
	
	
	
	// Salary
	public void SalaryMgmtView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent scene = comServ.AddScene("/com/midas/salary/SalaryMgmt.fxml");
		borderPane.setCenter(scene);
		
		comServ.setPageLabel(scene, "급여 관리");
	}

	public void SalaryReportView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent scene = comServ.AddScene("/com/midas/salary/SalaryReport.fxml");
		borderPane.setCenter(scene);
		
		comServ.setPageLabel(scene, "급여 리포트");
	}

	public void SalaryStmtView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent scene = comServ.AddScene("/com/midas/salary/SalaryStmt.fxml");
		borderPane.setCenter(scene);
		
		comServ.setPageLabel(scene, "급여 명세서");
	}

	
	
	
	
	
	// TAA Manager
	public void SetCalendarView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithController("/com/midas/taa/SetCalendar.fxml");
		borderPane.setCenter(root);
		BorderPane pane = (BorderPane) borderPane.getCenter();

		pane.setCenter(new CalendarServiceImpl(YearMonth.now()).getView());
		DatePicker dp = (DatePicker) root.lookup("#setCalendarDatePicker");
		dp.setValue(LocalDate.now());
	}

	public void TAAReportView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithControllerOnRoot("/com/midas/taa/TAAReport.fxml", comServ.getSuperRoot(root));
		borderPane.setCenter(root);
	}

	public void MonthTAAView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithControllerOnRoot("/com/midas/taa/MonthTAA.fxml", comServ.getSuperRoot(root));
		borderPane.setCenter(root);
	}

	public void PersonalTAAView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithControllerOnRoot("/com/midas/taa/PersonalTAA.fxml", comServ.getSuperRoot(root));
		borderPane.setCenter(root);
	}

	public void TAAListView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithControllerOnRoot("/com/midas/taa/TAAList.fxml", comServ.getSuperRoot(root));
		borderPane.setCenter(root);
	}

	public void HolidayApprovalView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithControllerOnRoot("/com/midas/taa/HolidayApproval.fxml", comServ.getSuperRoot(root));
		borderPane.setCenter(root);

		Scene scene = ((Parent) e.getSource()).getScene();

		List<HolidayRequest> requestList = dbServ.SelectTable("HolidayRequest",
				"WHERE " + "\"요청일\"" + " like " + "'%" + LocalDate.now().toString().substring(0, 7) + "%'");
		comServ.ShowTableViewByList(scene, "#HoliAppTableView", requestList);
	}

	public void HolidayModifyView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithControllerOnRoot("/com/midas/taa/HolidayModify.fxml", comServ.getSuperRoot(root));
		borderPane.setCenter(root);
	}

	
	
	
	// TAA Employee
	public void OwnTAAView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithController("/com/midas/taa/own/OwnTAA.fxml");
		borderPane.setCenter(root);
	}

	public void OwnAskHolidayView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		Parent root = comServ.AddSceneWithController("/com/midas/taa/own/OwnAskHoliday.fxml");

		String[] FullHalfItems = { "전일", "반일" };
		comServ.AddComboBox(root, Arrays.asList(FullHalfItems), "#cmbFullHalf");

		borderPane.setCenter(root);
		String num = comServ.getUserLabel(root);

		Scene scene = ((Parent) e.getSource()).getScene();
		List<Employee> OwnHolidayList = dbServ.SelectTableHoliday("WHERE 사원번호 = \""+ num + "\""); // 로그인 한 사람의 아이디
		comServ.ShowTableViewByList(scene, "#OwnRemainTable", OwnHolidayList);
	}

	public void OwnModifyHolidayView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithController("/com/midas/taa/own/OwnModifyHoliday.fxml");

		borderPane.setCenter(root);

		Scene scene = ((Parent) e.getSource()).getScene();
		List<Employee> OwnHolidayList = dbServ.SelectTableHoliday("WHERE 사원번호 = \"200401\""); // 로그인 한 사람의 아이디
		comServ.ShowTableViewByList(scene, "#OwnRemainTable", OwnHolidayList);
	}

	
	
	
	
	
	
	// HR
	public void HRPageView(Event e) {
		BorderPane borderPane = (BorderPane) getScene(e);
		root = comServ.AddSceneWithController("/com/midas/hr/HRMpage.fxml");
		borderPane.setCenter(root);
	}

}
