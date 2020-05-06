package mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class searchidController implements Initializable{

	@FXML private TextField idSearchNameTxt;
	@FXML private TextField idSearchNumTxt;
	@FXML private Button idSerchBtn;
	
	private IMembershipManage imemManage = new IMembershipManageImpl();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		idSearchNameTxt.setOnAction(e->idSearchNumTxt.requestFocus());
		idSearchNumTxt.setOnAction(e->idSerchBtn.requestFocus());
	}
	

	public void idSerchBtnProc() {
		String name = idSearchNameTxt.getText();
		String PhoneNum = idSearchNumTxt.getText();
		
		imemManage.searchID(name, PhoneNum);
	}
}











