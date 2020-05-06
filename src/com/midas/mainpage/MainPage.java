package mainpage;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import mainpage.Service.CommonService;
import mainpage.Service.CommonServiceImpl;

public class MainPage extends Application{
	@Override
	public void start(Stage primaryStage) throws IOException {	
		CommonService comServ = new CommonServiceImpl();
		comServ.showWindow(primaryStage, "../login.fxml");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}