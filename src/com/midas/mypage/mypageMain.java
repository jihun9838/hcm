//package com.midas.mypage;
//
//import java.util.Scanner;
//
//import com.midas.service.CommonService;
//import com.midas.service.CommonServiceImpl;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//
//public class mypageMain extends Application{
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		
//		Scanner in = new Scanner(System.in);
//		String id;
//		
//		id = in.next();
//		System.out.println(id);
//		
//		CommonService comServ = new CommonServiceImpl();
//		comServ.showWindow(primaryStage, "../infoPwCheck.fxml");
//		
//	}
//
//}
