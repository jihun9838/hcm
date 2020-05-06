package mainpage.Service;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpage.Member;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class LoginserviceImp implements Loginservice{
	private IMembershipManage membershipManager = new IMembershipManageImpl();

	@Override
	public boolean loginProc(Parent root) {
		TextField loginidTxt = (TextField)root.lookup("#loginIdTxt");
		TextField loginpwTxt = (TextField)root.lookup("#loginPwTxt");
		
		IMembershipManage membershipManager = new IMembershipManageImpl();
		
		if(membershipManager.LoginProc(loginidTxt.getText(), loginpwTxt.getText())==true)
			return true;
		return false;
	}


	@Override
	public String[] homeProc(String id) {
		return membershipManager.homepage(id);
	}
}

