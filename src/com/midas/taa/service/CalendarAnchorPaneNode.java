package com.midas.taa.service;

import java.time.LocalDate;

import com.midas.service.CommonService;
import com.midas.service.CommonServiceImpl;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * Create an anchor pane that can store additional data.
 */
public class CalendarAnchorPaneNode extends AnchorPane {

	// Date associated with this pane
	private LocalDate date;
	private CommonService comServ;

	/**
	 * Create a anchor pane node. Date is not assigned in the constructor.
	 * @param children children of the anchor pane
	 */
	public CalendarAnchorPaneNode(Node... children) {
		super(children);
		comServ = new CommonServiceImpl();
		Stage s = new Stage();
		// Add action handler for mouse clicked
		this.setOnMouseClicked(e ->{
			System.out.println("This pane's date is: " + date);
			//comServ.showWindow(s, "../SetCalendarHoliday.fxml", /*부모없는놈임여기*/);
		});
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
