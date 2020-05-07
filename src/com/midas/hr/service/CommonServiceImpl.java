//package MIDAS.Service;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import MIDAS.Controller;
//import MIDAS.Employee;
//import MIDAS.Data.DataManage;
//import MIDAS.Data.DataManageImpl;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
//public class CommonServiceImpl implements CommonService {
//
//	@Override
//	public Parent showWindow(Stage s, String formPath, String title) {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
//		Parent root = null;
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Scene scene = new Scene(root);
//		
//		Controller ctrler = loader.getController();
//		ctrler.setRoot(root);
//		
//		s.setTitle(title);
//		s.setScene(scene);
//		s.show();
//		
//		return root;
//	}
//
//	@Override
//	public Parent showWindow(Stage s, String formPath) {
//		return showWindow(s, formPath, "Windows");
//	}
//	
//	@Override
//	public void WindowClose(ActionEvent event) {
//		Parent root = (Parent)event.getSource();
//		Stage stage = (Stage) root.getScene().getWindow();
//		stage.close();
//	}
//	
//	@Override
//	public List<Employee> getEmployeeList(int i) {
//		DataManage dataManage = new DataManageImpl();
//		return dataManage.getEmployeelst(i);
//	}
//	
//	@Override
//	public List<Employee> getEmployeeSearch(String attribute, String txt, int i) {
//		DataManage dataManage = new DataManageImpl();
//		return dataManage.getEmployeeSearch(attribute, txt, i);
//	}
//	
//	@Override
//	public Map<String, TextField> getTextFieldInfo(Parent membershipForm, String[] txtFldIdArr) {
//		Map<String, TextField> txtFldMap = new HashMap<String, TextField>();
//		
//		for(String txtFldId : txtFldIdArr) {
//			TextField txtFld = (TextField)membershipForm.lookup(txtFldId);
//			txtFldMap.put(txtFldId, txtFld);
//		}
//		return txtFldMap;
//	}
//	@Override
//	public Map<String, ComboBox<String>> getComboBoxInfo(Parent membershipForm, String[] comboFldIdArr) {
//		Map<String, ComboBox<String>> comboFldMap = new HashMap<String, ComboBox<String>>();
//		
//		for(String comboFldId : comboFldIdArr) {
//			ComboBox<String> comboFld = (ComboBox<String>)membershipForm.lookup(comboFldId);
//			comboFldMap.put(comboFldId, comboFld);
//		}
//		return comboFldMap;
//	}
//
//	@Override
//	public boolean isEmptyTxt(Map<String, TextField> txtFldMap, String[] txtFldIdArr) {
//		for(String txtFldId : txtFldIdArr) {
//			TextField txtFld = txtFldMap.get(txtFldId);
//			
//			if(txtFld.getText().isEmpty()) {
//				txtFld.requestFocus();
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	@Override
//	public boolean isEmptyCombo(Map<String, ComboBox<String>> comboFldMap, String[] comboFldIdArr) {
//		for(String comboFldId : comboFldIdArr) {
//			ComboBox<String> comboFld = comboFldMap.get(comboFldId);
//			
//			if(comboFld.getValue() == null) {
//				comboFld.requestFocus();
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	@Override
//	public void ErrorMsg(String title, String headerStr, String ContentTxt) {
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle(title);
//		alert.setHeaderText(headerStr);
//		alert.setContentText(ContentTxt);
//		alert.showAndWait();
//	}
//
//	@Override
//	public void ErrorMsg(String headerStr, String ContentTxt) {
//		ErrorMsg("error", headerStr, ContentTxt);
//	}
//
//	@Override
//	public void ErrorMsg(String ContentTxt) {
//		ErrorMsg("error", "error Header", ContentTxt);
//	}
//
//}
