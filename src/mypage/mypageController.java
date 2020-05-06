package mypage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainpage.Member;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class mypageController implements Initializable{

	@FXML private TextField nameTxt;
	@FXML private TextField phoneNumTxt;
	@FXML private TextField addressTxt;
	@FXML private TextField emailTxt;
	@FXML private Label departmemtLbl;
	@FXML private Label finalEduLbl;
	@FXML private Label positionLbl;
	@FXML private Label joinDateLbl;
	@FXML private Label birthLbl;
	@FXML private Label employeeLbl;
	@FXML private Button modifyBtn;		// 수정버튼
	
	@FXML private TextField newPwTxt;
	@FXML private TextField newPwOKTxt;

	private IMembershipManage memManage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void modifyBtnProc() {

	}
	public void setInfo(String num) {
		memManage = new IMembershipManageImpl();
		Member member = memManage.getMember(num);

		phoneNumTxt.setText(member.getPhoneNum());
		nameTxt.setText(member.getName());
		birthLbl.setText(member.getBirth());
		departmemtLbl.setText(member.getDepartment());
		emailTxt.setText(member.getEmail());
		addressTxt.setText(member.getAddress());
		positionLbl.setText(member.getPosition());
		finalEduLbl.setText(member.getFinalEdu());
		employeeLbl.setText(member.getEmployeeNum());
		joinDateLbl.setText(member.getSignJoindate());

		/*
		 * if(member.getimage() == null || member.getimage().length() == 0) {
		 * employee_picture.setImage(new Image("/MIDAS/image/기본사진.png")); } else {
		 * employee_picture.setImage(new
		 * Image(getClass().getResource(member.getimage()).toString())); }
		 */
		//if 등록한 사진이 없을 땐 기본사진  else 등록한 사진이 있을 때는 등록된 사진 출력
	}
}
