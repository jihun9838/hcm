package mainpage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mainpage.Service.CommonService;
import mainpage.Service.CommonServiceImpl;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;
import sun.nio.cs.ext.ISCII91;

public class SigninController implements Initializable{

	private CommonService comServ;
	private IMembershipManage imemManage;
	private Member member;
	
	@FXML private TextField signEmployeeTxt;
	@FXML private TextField signPwTxt;
	@FXML private TextField signPwOKTxt;
	@FXML private TextField signNameTxt;
	@FXML private TextField signIdTxt;
	@FXML private TextField SignBirthTxt;
	@FXML private TextField signSecretTxt;
	@FXML private TextField signPhoneNumTxt;
	@FXML private TextField signAddressTxt;
	@FXML private TextField signEmailTxt;
	@FXML private ComboBox<String> SignDepartmemtCombobox;
	@FXML private ComboBox<String> signFinalEduCombobox;
	@FXML private DatePicker SignJoindate;
	@FXML private Button idCheckBtn;
	@FXML private Button signinBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		imemManage = new IMembershipManageImpl();
		member = new Member();

		idCheckBtn.setOnAction(e->{			
			idCheckBtnProc();
		});
		signinBtn.setDisable(true);			// 다 입력하면 활성화 되게

		signinBtn.setOnAction(e->{
			signinBtnProc();
		});

		signEmployeeTxt.setOnAction(e->signNameTxt.requestFocus());
		signNameTxt.setOnAction(e->signIdTxt.requestFocus());
		signIdTxt.setOnAction(e->idCheckBtn.requestFocus());
		
		signPwTxt.setOnAction(e->signPwOKTxt.requestFocus());
		signPwOKTxt.setOnAction(e->SignBirthTxt.requestFocus());
		SignBirthTxt.setOnAction(e->signSecretTxt.requestFocus());
		signSecretTxt.setOnAction(e->signPhoneNumTxt.requestFocus());
		signPhoneNumTxt.setOnAction(e->signAddressTxt.requestFocus());
		signAddressTxt.setOnAction(e->SignDepartmemtCombobox.requestFocus());
		SignDepartmemtCombobox.setOnAction(e->signEmailTxt.requestFocus());
		signEmailTxt.setOnAction(e->SignJoindate.requestFocus());
		SignJoindate.setOnAction(e->signFinalEduCombobox.requestFocus());
		signFinalEduCombobox.setOnAction(e->signinBtn.requestFocus());

		signEmployeeTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signPwTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signPwOKTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();			
		});
		signNameTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signIdTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();			
		});
		SignBirthTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});		
		signSecretTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signPhoneNumTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});
		signAddressTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();			
		});
		signEmailTxt.textProperty().addListener((obs, oldTxt, newTxt)->{
			signinBtn();
		});		
				
		String [] items1= {"회계", "마케팅", "인사", "영업"};
		SignDepartmemtCombobox.getItems().addAll(items1);
		
		String [] items2= {"중학교 졸업", "고등학교 졸업", "전문대학 졸업", "대학교 졸업", "대학원 졸업"};
		signFinalEduCombobox.getItems().addAll(items2);
	
	}

	public void signinBtnProc() {
		
		if(signPwTxt.getText().equals(signPwOKTxt.getText())) {
		
			member.setEmployeeNum(signEmployeeTxt.getText());
			member.setName(signNameTxt.getText());
			member.setId(signIdTxt.getText());
			member.setPw(signPwTxt.getText());
			member.setBirth(SignBirthTxt.getText());
			member.setSocialNum(signSecretTxt.getText());
			member.setPhoneNum(signPhoneNumTxt.getText());
			member.setAddress(signAddressTxt.getText());
			member.setDepartment(SignDepartmemtCombobox.getValue());
			member.setEmail(signEmailTxt.getText());
			member.setSignJoindate(SignJoindate.getValue().toString());
			member.setFinalEdu(signFinalEduCombobox.getValue());
			
			imemManage.MembershipProc(member);			
			comServ.ErrorMsg("회원가입", "회원가입 성공", "회원가입이 완료 되었습니다!");
		}
		else {
			comServ.ErrorMsg("회원가입", "회원가입 실패","비밀번호가 맞지않습니다. 다시 입력해주세요!");
			signPwOKTxt.requestFocus();
			signPwOKTxt.clear();
		}
	}
	
	public void signinBtn() {
		
		if(signEmployeeTxt.getLength()>0 && signPwOKTxt.getLength()>0
				&&signPwOKTxt.getLength()>0 && signNameTxt.getLength()>0
				&&signIdTxt.getLength()>0 && SignBirthTxt.getLength()>0
				&&signSecretTxt.getLength()>0 && signPhoneNumTxt.getLength()>0
				&&signAddressTxt.getLength()>0 && signEmailTxt.getLength()>0) {		
			signinBtn.setDisable(false);
		}
		else signinBtn.setDisable(true);
	}

	public void idCheckBtnProc() {
		String id = signIdTxt.getText();
		
		if(imemManage.idcheck(id)==false) {
			signIdTxt.clear();
			signIdTxt.requestFocus();
		}
		else
		signPwTxt.requestFocus();

	}
}
	
	
	
	
	
	