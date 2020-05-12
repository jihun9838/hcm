package com.midas.mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.mainpage.service.Loginservice;
import com.midas.mainpage.service.LoginserviceImp;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController extends Controller implements Initializable{

	private Parent root;
	private Loginservice loginServ;
	private CommonService comServ;
	private DBService dbServ;

	@FXML private Button loginBtn;
	@FXML private TextField loginIdTxt;
	@FXML private TextField loginPwTxt;

	// HomePage.fxml
	@FXML private Label IDLbl;
	@FXML private Label helloLbl;
	@FXML private Button logoutBtn;
	@FXML private Button commuteBtn;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}

	private Parent getScene(Event e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		loginServ = new LoginserviceImp();



		loginIdTxt.setOnAction(e->loginPwTxt.requestFocus());
		loginPwTxt.setOnAction(e->loginBtn.requestFocus());
		
		//loginBtn.setDisable(true);

			loginIdTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
				disableButton();

			});
			loginPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
				disableButton();
			});
		
	}

	private void disableButton() {
		String id = loginIdTxt.getText();
		String pw = loginPwTxt.getText();

		if(id.length()>0 && pw.length()>0)
			loginBtn.setDisable(false);		

		else loginBtn.setDisable(true);		
	}

	public Parent loginBtnProc(ActionEvent e) {
		String id = loginIdTxt.getText();
		String pw = loginPwTxt.getText();
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		
		
		if(loginServ.loginProc(root)) {
			comServ.setUserLabel(getScene(e), id);
			Button logoutBtn = (Button)getScene(e).lookup("#logoutBtn");
			Button commuteBtn = (Button)getScene(e).lookup("#commuteBtn");
			logoutBtn.setVisible(true);
			commuteBtn.setVisible(true);
			
			BorderPane borderPane = (BorderPane)getScene(e);
			
//			Parent scene = comServ.AddScene("/com/midas/Employee.fxml");
			Parent scene = comServ.AddSceneWithControllerOnRoot("/com/midas/Manager.fxml", root);
			borderPane.setLeft(scene);
			
			comServ.getUserLabel(root);
		}
		else{
			comServ.ErrorMsg("로그인", "로그인  실패", "아이디와 비밀번호를 확인해주세요.");
			loginIdTxt.requestFocus();
		}
		return loginBtn;
	}

	public void searchIdBtnProc() {
		Stage s = new Stage();
		comServ.showWindow(s, "/com/midas/mainpage/searchid.fxml");
	}

	public void searchPwBtnProc() {
		Stage s = new Stage();
		comServ.showWindow(s, "/com/midas/mainpage/searchpw.fxml");	
	}

	public void SignBtnProc() {	
		Stage s = new Stage();
		comServ.showWindow(s, "/com/midas/mainpage/signin.fxml");		
	}


}
