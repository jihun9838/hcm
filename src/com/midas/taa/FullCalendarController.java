package com.midas.taa;

import com.midas.Controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class FullCalendarController extends Controller {
	@FXML Pane fullCalendarPane;
	private Parent root;

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
}
