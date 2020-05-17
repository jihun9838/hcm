package com.midas.taa._01;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;
import com.midas.taa.service.TAAService;
import com.midas.taa.service.TAAServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalendarHolidayController extends Controller implements Initializable{
	@SuppressWarnings("unused")
	private Parent root;
	private CommonService comServ;
	private TAAService TAAServ;
	@FXML Label setCalendarHolidayLbl;
	@FXML ComboBox<String> cmbSort;
	@FXML TextField contentTf;
	@FXML Button saveBtn;

	private String [] items = {"∞¯»ﬁ¿œ","±‚≈∏"};

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		TAAServ = new TAAServiceImpl();
		TAAServ.addComboBoxInController(cmbSort, items);
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
