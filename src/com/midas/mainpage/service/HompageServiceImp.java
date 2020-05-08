package com.midas.mainpage.service; 

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class HompageServiceImp implements HompageService{

	private Loginservice loginServ = new LoginserviceImp();
	@Override
	public void setUserLabel(Parent root, String id) {
	
		Label idlbl = (Label)root.lookup("#IDLbl");
		Label hellolbl = (Label)root.lookup("#helloLbl");
		
		String [] home = loginServ.homeProc(id);
		idlbl.setText(home[0]);
		hellolbl.setText(home[1]+"¥‘ æ»≥Á«œººø‰.");
		
	}
	@Override
	public String getUserLabel(Parent root) {
		//Label idlbl = (Label)root.lookup("#IDLbl");		
		//return idlbl.getText();
		
		return ((Label)root.lookup("#IDLbl")).getText();
	}

	
}
