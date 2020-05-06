package mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class searchpwController implements Initializable{

	@FXML private TextField pwSearchNameTxt;
	@FXML private TextField pwSearchIdTxt;
	@FXML private TextField pwSearchNumTxt;
	@FXML private Button pwSerchBtn;

	private IMembershipManage imemManage = new IMembershipManageImpl();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pwSearchNameTxt.setOnAction(e->pwSearchIdTxt.requestFocus());
		pwSearchIdTxt.setOnAction(e->pwSearchNumTxt.requestFocus());
		pwSearchNumTxt.setOnAction(e->pwSerchBtn.requestFocus());

	}

	public void pwSerchBtnProc() {
		String name = pwSearchNameTxt.getText();
		String PhoneNum = pwSearchNumTxt.getText();
		String id = pwSearchIdTxt.getText();

		imemManage.searchPW(name, id, PhoneNum);
	}
}
