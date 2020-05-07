package com.midas.taa.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CalendarServiceImpl implements CalendarService{
	private ArrayList<CalendarAnchorPaneNode> allCalendarDays = new ArrayList<>(35);
	private VBox view;
	private Text calendarTitle;
	private YearMonth currentYearMonth;
	
	public CalendarServiceImpl() {
	}


	public CalendarServiceImpl(YearMonth yearMonth) {
		currentYearMonth = yearMonth;
		// Create the calendar grid pane
		GridPane calendar = new GridPane();
		calendar.setPrefSize(1000, 400);
		calendar.setGridLinesVisible(true);
		// Create rows and columns with anchor panes for the calendar
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				CalendarAnchorPaneNode ap = new CalendarAnchorPaneNode();
				ap.setPrefSize(200,200);
				calendar.add(ap,j,i);
				allCalendarDays.add(ap);
			}
		}
		// Days of the week labels
		Text[] dayNames = new Text[]{ new Text("Sunday"), new Text("Monday"), new Text("Tuesday"),
				new Text("Wednesday"), new Text("Thursday"), new Text("Friday"),
				new Text("Saturday") };
		GridPane dayLabels = new GridPane();
		dayLabels.setPrefWidth(600);
		Integer col = 0;
		for (Text txt : dayNames) {
			AnchorPane ap = new AnchorPane();
			
			ap.setPrefSize(200, 10);
			ap.setBottomAnchor(txt, 5.0);
			ap.getChildren().add(txt);
			dayLabels.add(ap, col++, 0);
		}
		// Create calendarTitle and buttons to change current month
		calendarTitle = new Text();
		// Populate calendar with the appropriate day numbers
		populateCalendar(yearMonth);
		// Create the calendar view
		view = new VBox(dayLabels, calendar);
	}


	/**
	 * Set the days of the calendar to correspond to the appropriate date
	 * @param yearMonth year and month of month to render
	 */
	public void populateCalendar(YearMonth yearMonth) {
		// Get the date we want to start with on the calendar
		LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
		// Dial back the day until it is SUNDAY (unless the month starts on a sunday)
		while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
			calendarDate = calendarDate.minusDays(1);
		}
		
		// Populate the calendar with day numbers
		for (CalendarAnchorPaneNode ap : allCalendarDays) {
			if (ap.getChildren().size() != 0) {
				ap.getChildren().remove(0);
			}
			
			if(calendarDate.equals(LocalDate.now())&&calendarDate.getMonth().equals(LocalDate.now().getMonth())) {
	        	ap.setStyle("-fx-background-color:#A6A6A6;");
	        }
			
			Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
			if(calendarDate.getDayOfWeek().toString().equals("SUNDAY")) {
				txt.setFill(Color.RED);
			}
			if(calendarDate.getDayOfWeek().toString().equals("SATURDAY")) {
				txt.setFill(Color.BLUE);
			}
			ap.setDate(calendarDate);
			ap.setTopAnchor(txt, 5.0);
			ap.setLeftAnchor(txt, 5.0);
			ap.getChildren().add(txt);
			calendarDate = calendarDate.plusDays(1);
		}
		// Change the title of the calendar
		calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));

	}

	public ArrayList<CalendarAnchorPaneNode> getAllCalendarDays() {
		return allCalendarDays;
	}

	public void setAllCalendarDays(ArrayList<CalendarAnchorPaneNode> allCalendarDays) {
		this.allCalendarDays = allCalendarDays;
	}


	@Override
	public VBox getView() {
		return view;
	}
	

}
