//package com.midas.mainpage;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import com.midas.db.service.DBService;
//import com.midas.db.service.DBServiceImpl;
//import com.midas.mainpage.service.HompageService;
//import com.midas.mainpage.service.HompageServiceImp;
//import com.midas.mainpage.service.Loginservice;
//import com.midas.mainpage.service.LoginserviceImp;
//import com.midas.service.CommonService;
//import com.midas.service.CommonServiceImpl;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//
//public class HompagevisibleController implements Initializable{
//
//	private CommonService comServ;
//	private DBService dbServ;
//	private Loginservice loginServ;
//	private HompageService homeServ;
//
//	@FXML private Label helloLbl;
//	@FXML private Label IDLbl;
//	@FXML private Button logoutBtn;
//	@FXML private Button commuteBtn;
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		comServ = new CommonServiceImpl();
//		dbServ = new DBServiceImpl();
//		loginServ = new LoginserviceImp();
//		homeServ = new HompageServiceImp();
//
//		logoutBtn.setOnAction(e->{			
//			logoutBtnProc(e);
//		});
//
//		logoutBtn.setVisible(true);
//		commuteBtn.setVisible(true);
//		helloLbl.setVisible(true);
//		IDLbl.setVisible(true);
//
//
//	}
//
//	public void logoutBtnProc(ActionEvent e) {
//		comServ.ErrorMsg("�α׾ƿ�", "�α׾ƿ� �˴ϴ�.", "�α׾ƿ��� ����˴ϴ�.");
//		comServ.WindowClose(e);
//	}
//
//	public void commuteBtnProc() {
//		System.out.println("���");
//
//	}
//
//	public void Lbl(Parent root, String id) {
//		homeServ.Lbl(root, id);
//	}
//}
//
//
//
//
//
//
//
//
//
