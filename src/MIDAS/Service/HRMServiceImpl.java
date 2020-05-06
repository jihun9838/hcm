package MIDAS.Service;

import java.util.List;

import MIDAS.Employee;
import MIDAS.Data.DataManage;
import MIDAS.Data.DataManageImpl;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class HRMServiceImpl implements HRMService {

	@Override
	public Parent OpenDetailForm() {
		CommonService comServ = new CommonServiceImpl();
		Stage membershipForm = new Stage();
		return comServ.showWindow(membershipForm, "../HRMDetailInfo.fxml", "사원 상세정보");
	}

	@Override
	public Parent OpenAddForm() {
		CommonService comServ = new CommonServiceImpl();
		Stage membershipForm = new Stage();
		return comServ.showWindow(membershipForm, "../HRMAddInfo.fxml", "사원 추가");
	}

}
