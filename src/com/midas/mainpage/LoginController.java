package mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpage.Service.CommonService;
import mainpage.Service.CommonServiceImpl;
import mainpage.Service.HompageService;
import mainpage.Service.HompageServiceImp;
import mainpage.Service.Loginservice;
import mainpage.Service.LoginserviceImp;
import mainpage.Service.MembershipService;
import mainpage.Service.MembershipServiceImpl;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class LoginController implements Initializable{

	private Parent root;
	private Loginservice loginServ;
	private CommonService comServ;
	private IMembershipManage imemManage;
	private HompageService homeServ;
	
	@FXML private Button loginBtn;
	@FXML private TextField loginIdTxt;
	@FXML private TextField loginPwTxt;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comServ = new CommonServiceImpl();
		imemManage = new IMembershipManageImpl();
		loginServ = new LoginserviceImp();
		homeServ = new HompageServiceImp();
		
		loginBtn.setOnAction(e->{			
			loginBtnProc();
		});

		loginBtn.setDisable(true);

		loginIdTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			disableButton();

		});
		loginPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			disableButton();
		});

		loginIdTxt.setOnAction(e->loginPwTxt.requestFocus());
		loginPwTxt.setOnAction(e->loginBtn.requestFocus());
	}

	private void disableButton() {
		String id = loginIdTxt.getText();
		String pw = loginPwTxt.getText();

		if(id.length()>0 && pw.length()>0)
			loginBtn.setDisable(false);		

		else loginBtn.setDisable(true);		
	}

	public Parent loginBtnProc() {
		String id = loginIdTxt.getText();
		String pw = loginPwTxt.getText();

		if(imemManage.LoginProc(id, pw)) {
			CommonService comServ = new CommonServiceImpl();
			Stage signinForm = new Stage();
			Parent form = comServ.showWindow(signinForm, "/mainpage/Homepagevisible.fxml");
			
			homeServ.Lbl(form, id);
			
			
		
		}
		else
		{
			comServ.ErrorMsg("로그인", "로그인  실패", "아이디와 비밀번호를 확인해주세요.");
			loginIdTxt.requestFocus();
		}
		return loginBtn;
	}

	public void searchIdBtnProc() {
		CommonService comServ = new CommonServiceImpl();
		Stage signinForm = new Stage();
		comServ.showWindow(signinForm, "/mainpage/searchid.fxml");
	}

	public void searchPwBtnProc() {
		CommonService comServ = new CommonServiceImpl();
		Stage signinForm = new Stage();
		comServ.showWindow(signinForm, "/mainpage/searchpw.fxml");	
	}

	public void SignBtnProc() {	
		CommonService comServ = new CommonServiceImpl();
		Stage signinForm = new Stage();
		comServ.showWindow(signinForm, "/mainpage/signin.fxml");		

	}
	public void setRoot(Parent root) {
		root = this.root;
	}

}
