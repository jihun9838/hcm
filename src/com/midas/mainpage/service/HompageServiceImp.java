package com.midas.mainpage.service; 

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class HompageServiceImp implements HompageService{

	private Loginservice loginServ = new LoginserviceImp();

	@Override
	public void Lbl(Parent root, String id) {
	
		Label idlbl = (Label)root.lookup("#IDLbl");
		Label hellolbl = (Label)root.lookup("#helloLbl");
		
		String [] home = loginServ.homeProc(id);
		idlbl.setText(home[0]);
		hellolbl.setText(home[1]+"¥‘ æ»≥Á«œººø‰.");
		
	}

}
