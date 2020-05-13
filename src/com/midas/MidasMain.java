package com.midas;

import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MidasMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		CommonService comServ = new CommonServiceImpl();

		BorderPane borderPane = (BorderPane)comServ.AddSceneWithController("/com/midas/Homepage.fxml");
		Parent loginPage = comServ.AddSceneWithController("/com/midas/mainpage/login.fxml");

		borderPane.setCenter(loginPage);
		primaryStage.setScene(new Scene(borderPane));
		primaryStage.setTitle("MIDAS-HCM");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
