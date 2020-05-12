package com.midas.taa;

import java.net.URL;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SetCalendarHolidayController extends Controller implements Initializable{
	private Parent root;
	private CommonService comServ;
	@FXML Label setCalendarHolidayLbl;
	@FXML ComboBox<String> cmbSort;
	@FXML TextField contentTf;
	@FXML Button saveBtn;
	
	private String [] items = {"∞¯»ﬁ¿œ","±‚≈∏"};
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		cmbSort.getItems().addAll(items);
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void SaveHolidayProc(ActionEvent e) {
		
		comServ.ErrorMsg(cmbSort.getValue() + " " + setCalendarHolidayLbl.getText() + " " + contentTf.getText() + " ");
	}
	
	public void getCalendarLbl() {
		
	}

}
