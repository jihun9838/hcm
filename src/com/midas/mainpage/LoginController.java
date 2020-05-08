package com.midas.mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.mainpage.service.HompageService;
import com.midas.mainpage.service.HompageServiceImp;
import com.midas.mainpage.service.Loginservice;
import com.midas.mainpage.service.LoginserviceImp;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	private HompageService homeServ;

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
		root = this.root;
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
		homeServ = new HompageServiceImp();



		//loginBtn.setDisable(true);

		loginIdTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			disableButton();

		});
		loginPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			disableButton();
		});

		loginIdTxt.setOnAction(e->loginPwTxt.requestFocus());
		loginPwTxt.setOnAction(e->loginBtn.requestFocus());
		loginBtn.setOnAction(e->loginBtnProc(e));
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
		System.out.println("asdasdasdasdasdas");
		System.out.println(id);
		System.out.println(pw);
		
		
		if(dbServ.LoginProc(id, pw)) {
			// Parent form = comServ.showWindow(signinForm, "/mainpage/Homepagevisible.fxml");
			Label lb = (Label)getScene(e).lookup("#IDLbl");
			lb.setText("hg");
			System.out.println(lb.getText());
			
//			try {
//			    parent = (Parent)fxmlLoader.load(getFxmlStream("tasklist.fxml"));
			BorderPane borderPane = (BorderPane)getScene(e);
//			Parent scene = comServ.AddScene("/com/midas/Employee.fxml");
			Parent scene = comServ.AddScene("/com/midas/Manager.fxml");
			borderPane.setLeft(scene);
			
			//homeServ.Lbl(form, id);
		}
		else
		{
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
