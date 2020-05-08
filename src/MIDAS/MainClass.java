package MIDAS;

import MIDAS.Service.CommonService;
import MIDAS.Service.CommonServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		CommonService comServ = new CommonServiceImpl();
		Stage HRForm = new Stage();
		comServ.showWindow(HRForm, "../HRMpage.fxml", "HRpage");
		
		/*
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HRMpage.fxml"));
		Parent root = (Parent)loader.load();
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("HRMpage");
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
	}
	public static void main(String[] args) {
		launch(args);
	}
}
