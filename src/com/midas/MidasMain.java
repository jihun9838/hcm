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
		//Parent empMenuScene = comServ.AddScene("/com/midas/Employee.fxml");
		// else
		//Parent manMenuScene = comServ.AddScene("/com/midas/Manager.fxml");
		
		//Parent s = comServ.AddScene("/com/midas/salary/SalaryMgmt.fxml");

		Parent ss = comServ.AddScene("/com/midas/mainpage/login.fxml");
		
		

		// modifiy and merge test
		// second test

		
		//borderPane.setLeft(empMenuScene);
		//borderPane.setLeft(manMenuScene);
//		borderPane.setCenter(s);
		borderPane.setCenter(ss);
		primaryStage.setScene(new Scene(borderPane));
		primaryStage.setTitle("MIDAS-HCM");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
