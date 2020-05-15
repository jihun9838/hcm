package com.midas.mypage;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.mypage.serivce.MypageService;
import com.midas.mypage.serivce.MypageServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class infoPWCheckController extends Controller implements Initializable{

	Parent root;
	@FXML private TextField infoPwTxt;
	@FXML private Button pwCheckBtn;
	private CommonService comServ;
	private DBService dbServ;
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		dbServ = new DBServiceImpl();
		
//		pwCheckBtn.setOnAction(e->{			
//			pwCheckBtnProc();
//		});
		pwCheckBtn.setDisable(true);
		
		infoPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			disableButton();
		});
		infoPwTxt.setOnAction(e->pwCheckBtn.requestFocus());
	}

	public void pwCheckBtnProc(ActionEvent e) {
		DBService dbServ = new DBServiceImpl();
		MypageService myServ = new MypageServiceImpl();
		String pw = infoPwTxt.getText();
		String id = comServ.getUserLabel(getScene(e));
		
		//if(dbServ.infopwCheck(pw)) {
		if(dbServ.infopwCheck(id, pw)) {
			//commomServ.showWindow(s, "/mypage/mypage");
			
			BorderPane borderPane = (BorderPane)getScene(e);
			Parent scene = comServ.AddSceneWithController("/com/midas/mypage/mypage.fxml");
			borderPane.setCenter(scene);
			
			myServ.setInfo(scene, ((Label)borderPane.lookup("#IDLbl")).getText());
			
		}
		else {
			//comServ.ErrorMsg("내정보 확인", "비밀번호가 다릅니다.", "비밀번호를 확인해주세요");
			infoPwTxt.clear();
			infoPwTxt.requestFocus();
		}	
		
	}

	public void disableButton() {
		String pw = infoPwTxt.getText();		
		if(pw.length()>0)
			pwCheckBtn.setDisable(false);	
		else pwCheckBtn.setDisable(true);	
	}

}
