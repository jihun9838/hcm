package com.midas.taa;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.midas.Controller;
import com.midas.db.HolidayRequest;
import com.midas.db.service.DBService;
import com.midas.db.service.DBServiceImpl;
import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HolidayApprovalController extends Controller implements Initializable{
	private Parent root;
	//private DBService dbServ;
	private CommonService comServ;
	@FXML Label todayLbl;
	@FXML ComboBox<String> cmbSort;
	@FXML TextField searchTf;
	private final static String[] ATTRIBUTE = {"�����ȣ", "�̸�", "�μ�", "�ܿ� ����", "��û��", "������", "������", "�Ⱓ", "����", "���ο���"};
	@FXML TableView<String> HoliAppTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		todayLbl.setText(LocalDate.now().toString().substring(0, 7));
		comServ = new CommonServiceImpl();
		cmbSort.getItems().addAll(ATTRIBUTE);
		cmbSort.setValue("�����ȣ");
	}
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void HoliAppTableShow(ActionEvent e) {
		Scene scene = ((Parent)e.getSource()).getScene();
		String attribute = cmbSort.getValue();
		String txt = searchTf.getText();
		List<HolidayRequest> requestList = new DBServiceImpl().SelectHolidayApprovalSearch(attribute, txt);
		comServ.ShowTableViewByList(scene, "#HoliAppTableView", requestList);
	}
	
	public void approvalBtn(ActionEvent e) {
		String attribute = cmbSort.getValue();
		String txt = searchTf.getText();
		List<HolidayRequest> requestList = new DBServiceImpl().SelectHolidayApprovalSearch(attribute, txt);
		
		int row = HoliAppTableView.getSelectionModel().getSelectedIndex()+1;
		String num = requestList.get(row-1).getId();
		String periodDay = requestList.get(row-1).getPeriodDay();
		System.out.println(row+" "+num+" "+periodDay);
		System.out.println(requestList.get(row-1).getApproval());
		if("�̽���".contentEquals(requestList.get(row-1).getApproval())) {
			new DBServiceImpl().updateApprovalHoliday("WHERE ROWID="+row);
			new DBServiceImpl().updateRemainHoliday("WHERE �����ȣ=" +num, periodDay); //holi �ӽ� ��������
			new DBServiceImpl().updateEmployeeHoliday("WHERE "+"\"�����ȣ\""+" = "+num, periodDay);
			new DBServiceImpl().updateEmployeeHoliday2("WHERE "+"\"�����ȣ\""+" = "+num, periodDay);
			comServ.ErrorMsg("�ް��� ���εǾ����ϴ�.");
		}
		else if("����".contentEquals(requestList.get(row-1).getApproval())) {
			comServ.ErrorMsg("�̹� ���εǾ����ϴ�.");
		}
		else { //�ݷ�
			new DBServiceImpl().updateApprovalHoliday("WHERE ROWID="+row);
			new DBServiceImpl().updateRemainHoliday("WHERE �����ȣ=" +num, periodDay); //holi �ӽ� ��������
			new DBServiceImpl().updateEmployeeHoliday("WHERE "+"\"�����ȣ\""+" = "+num, periodDay);
			new DBServiceImpl().updateEmployeeHoliday2("WHERE "+"\"�����ȣ\""+" = "+num, periodDay);
			comServ.ErrorMsg("�ݷ� �ް��� ����εǾ����ϴ�.");
		}
	}
	
	public void declineBtn(ActionEvent e) {
		String attribute = cmbSort.getValue();
		String txt = searchTf.getText();
		List<HolidayRequest> requestList = new DBServiceImpl().SelectHolidayApprovalSearch(attribute, txt);
		
		int row = HoliAppTableView.getSelectionModel().getSelectedIndex()+1;
		String num = requestList.get(row-1).getId();
		String periodDay = requestList.get(row-1).getPeriodDay();
		System.out.println(row+" "+num+" "+periodDay);
		if("�̽���".contentEquals(requestList.get(row-1).getApproval())) {			
			new DBServiceImpl().updateDeclineHoliday("WHERE ROWID="+row);
			comServ.ErrorMsg("�ݷ��Ǿ����ϴ�.");
		}
		else if("����".contentEquals(requestList.get(row-1).getApproval())){
			new DBServiceImpl().updateDeclineHoliday("WHERE ROWID="+row);
			new DBServiceImpl().updateRemainHolidayDe("WHERE �����ȣ=" +num, periodDay); //holi �ӽ� ��������
			new DBServiceImpl().updateEmployeeHolidayDe("WHERE "+"\"�����ȣ\""+" = "+num, periodDay);
			new DBServiceImpl().updateEmployeeHolidayDe2("WHERE "+"\"�����ȣ\""+" = "+num, periodDay);
			comServ.ErrorMsg("������ �ݷ��Ǿ����ϴ�.");
		}
		else { //�ݷ�
			comServ.ErrorMsg("�̹� �ݷ��Ǿ����ϴ�.");
		}
	}
}
