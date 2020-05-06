package mypage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;
import mypage.Service.CommonService;
import mypage.Service.CommonServiceImpl;

public class infoPWCheckController implements Initializable{

	@FXML private TextField infoPwTxt;
	@FXML private Button pwCheckBtn;
	private CommonService commomServ;
	private IMembershipManage memManage;
	private mypageController mypageC;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		commomServ = new CommonServiceImpl();
		memManage = new IMembershipManageImpl();
		
		pwCheckBtn.setOnAction(e->{			
			pwCheckBtnProc();
		});
		pwCheckBtn.setDisable(true);
		
		infoPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			disableButton();
		});
	}

	public void pwCheckBtnProc() {
		String pw = infoPwTxt.getText();
		String id = mypageC.;	// 콘솔창에 입력된 아이디를 받아오고싶어요.......
		Stage s = new Stage();
		
		if(memManage.infopwCheck(pw)) {
			commomServ.showWindow(s, "/mypage/mypage");
		}
		else {
			commomServ.ErrorMsg("내정보 확인", "비밀번호가 다릅니다.", "비밀번호를 확인해주세요");
			infoPwTxt.clear();
		}
		
		
		
		
	}

	public void disableButton() {
		String pw = infoPwTxt.getText();		
		if(pw.length()>0)
			pwCheckBtn.setDisable(false);	
		else pwCheckBtn.setDisable(true);	
	}

}
