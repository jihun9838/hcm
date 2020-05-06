package mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mainpage.Service.CommonService;
import mainpage.Service.CommonServiceImpl;
import mainpage.Service.HompageService;
import mainpage.Service.HompageServiceImp;
import mainpage.Service.Loginservice;
import mainpage.Service.LoginserviceImp;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class HompagevisibleController implements Initializable{

	private CommonService comServ;
	private IMembershipManage imemManage;
	private Loginservice loginServ;
	private HompageService homeServ;
	
	@FXML private Label helloLbl;
	@FXML private Label IDLbl;
	@FXML private Button logoutBtn;
	@FXML private Button commuteBtn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		imemManage = new IMembershipManageImpl();
		loginServ = new LoginserviceImp();
		homeServ = new HompageServiceImp();
		
		logoutBtn.setOnAction(e->{			
			logoutBtnProc(e);
		});
		
		logoutBtn.setVisible(true);
		commuteBtn.setVisible(true);
		helloLbl.setVisible(true);
		IDLbl.setVisible(true);
		
		
	}

	public void logoutBtnProc(ActionEvent e) {
		comServ.ErrorMsg("�α׾ƿ�", "�α׾ƿ� �˴ϴ�.", "�α׾ƿ��� ����˴ϴ�.");
		comServ.WindowClose(e);
	}
	
	public void commuteBtnProc() {
		System.out.println("���");
		
	}

	public void Lbl(Parent root, String id) {
		homeServ.Lbl(root, id);
	}
}









