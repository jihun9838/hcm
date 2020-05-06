package mypage.Service;

import javafx.scene.Parent;

import javafx.scene.control.TextField;


public class pwCheckServiceImp implements pwCheckService{

	private pwCheckService pwCheckServ = new pwCheckServiceImp();

	@Override
	public void pwCheck(Parent root,String id) {
		
		TextField infoPwTxt = (TextField)root.lookup("#infoPwTxt");
		
		 pwCheckServ.pwCheck(root, id);
		 infoPwTxt.getText();	
		
	}

}
