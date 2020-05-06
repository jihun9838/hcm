package MIDAS.Service;

import java.util.List;
import java.util.Map;

import MIDAS.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface CommonService {
	public Parent showWindow(Stage s, String formPath, String title);
	public Parent showWindow(Stage s, String formPath);
	public void WindowClose(ActionEvent event);
	
	public List<Employee> getEmployeeList(int i);
	public List<Employee> getEmployeeSearch(String attribute, String txt, int i);
	
	public Map<String, TextField> getTextFieldInfo(Parent membershipForm, String[] txtFldIdArr);
	public Map<String, ComboBox<String>> getComboBoxInfo(Parent membershipForm, String[] comboFldIdArr);
	public boolean isEmptyTxt(Map<String, TextField> txtFldMap, String[] txtFldIdArr);
	public boolean isEmptyCombo(Map<String, ComboBox<String>> comboFldMap, String[] comboFldIdArr);
	
	public void ErrorMsg(String title, String headerStr, String ContentTxt);
	public void ErrorMsg(String headerStr, String ContentTxt);
	public void ErrorMsg(String ContentTxt);
}
