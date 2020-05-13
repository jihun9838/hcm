package com.midas.taa.service;

import java.time.LocalDate;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;


/**
 * Create an anchor pane that can store additional data.
 */
public class CalendarAnchorPaneNode extends AnchorPane {

	// Date associated with this pane
	private LocalDate date;

	/**
	 * Create a anchor pane node. Date is not assigned in the constructor.
	 * @param children children of the anchor pane
	 */
	public CalendarAnchorPaneNode(Node... children) {
		super(children);
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
