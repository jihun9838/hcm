package com.midas;

import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MidasMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		CommonService comServ = new CommonServiceImpl();
		
		BorderPane borderPane = (BorderPane)comServ.AddScene("/com/midas/Homepage.fxml");
		// if(dbServ.getEmployee(id).getCategory() == 1)
<<<<<<< HEAD:src/com/midas/MidasMain.java
		Parent empMenuScene = comServ.AddScene("/com/midas/Employee.fxml");
		//else
		Parent manMenuScene = comServ.AddScene("/com/midas/Manager.fxml");
		//Parent s = comServ.AddScene("/com/midas/taa/own/OwnAskHoliday.fxml");
=======
		//Parent empMenuScene = comServ.AddScene("/com/midas/Employee.fxml");
		// else
		//Parent manMenuScene = comServ.AddScene("/com/midas/Manager.fxml");
		
		//Parent s = comServ.AddScene("/com/midas/salary/SalaryMgmt.fxml");
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7:MIDAS-HCM/src/com/midas/MidasMain.java

		Parent ss = comServ.AddScene("/com/midas/mainpage/login.fxml");
		
		
<<<<<<< HEAD:src/com/midas/MidasMain.java
		borderPane.setLeft(empMenuScene);
		//borderPane.setCenter(s);
=======


		
		//borderPane.setLeft(empMenuScene);
		//borderPane.setLeft(manMenuScene);
//		borderPane.setCenter(s);
		borderPane.setCenter(ss);
>>>>>>> 3029ffae3305dedca3f7b741d8ef0663cecb91b7:MIDAS-HCM/src/com/midas/MidasMain.java
		primaryStage.setScene(new Scene(borderPane));
		primaryStage.setTitle("MIDAS-HCM");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
