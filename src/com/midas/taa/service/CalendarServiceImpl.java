package com.midas.taa.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.midas.db.Commute;
import com.midas.service.CommonServiceImpl;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalendarServiceImpl implements CalendarService{
	private ArrayList<CalendarAnchorPaneNode> allCalendarDays = new ArrayList<>(35);
	private VBox view;
	private Text calendarTitle;
	private YearMonth currentYearMonth;
	//private DBService dbServ;

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
				LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
				while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
					calendarDate = calendarDate.minusDays(1);
				}
//				ap.setDate(calendarDate);
				LocalDate actionDate = calendarDate;
				ap.setOnMouseClicked(e->{
					Stage s = new Stage();
//					DatePicker dp = (DatePicker)s.getScene().getRoot().lookup("#setViewHolidayLbl");
//					dp.setValue(actionDate);
//					Label lbl = (Label)s.getScene().getRoot().lookup("#setCalendarHolidayLbl");
//					lbl.setText(actionDate.toString());
					new CommonServiceImpl().showWindow(s, "/com/midas/taa/SetCalendarHoliday.fxml");
				});
				calendarDate = calendarDate.plusDays(1);
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
		//		System.out.println(calendarDate);
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

	public CalendarServiceImpl(YearMonth yearMonth, String num, List<Commute> comLst) {
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
				//				ap.setOnMouseClicked(e->{
				//					Stage s = new Stage();
				//					new CommonServiceImpl().showWindow(s, "/com/midas/taa/SetCalendarHoliday.fxml");
				//					
				//					DatePicker dp = (DatePicker) s.getScene().getRoot().lookup("#setCalendarDatePicker");
				//					Label lbl = ((Label)((Parent)e.getSource()).getScene().getRoot().lookup("#setCalendarHolidayLbl"));
				//					
				//					//System.out.println(dp.getValue());
				//					//System.out.println(lbl.getText());
				//					lbl.setText(dp.getValue().toString());
				//				});
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
		populateCalendar(yearMonth, num, comLst);
		// Create the calendar view
		view = new VBox(dayLabels, calendar);
	}
	
	public long diffOfTime(String first, String second) throws Exception
	  {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date beginDate = formatter.parse(first);
	    Date endDate = formatter.parse(second);
	    
	    return (endDate.getTime() - beginDate.getTime()) / (60 * 1000) ;
	    
	  }

	//DB조회 칼렌더
	public void populateCalendar(YearMonth yearMonth, String num, List<Commute> comLst) {
		// Get the date we want to start with on the calendar
		LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
		System.out.println(calendarDate);
		//		System.out.println(calendarDate);
		// Dial back the day until it is SUNDAY (unless the month starts on a sunday)
		while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
			calendarDate = calendarDate.minusDays(1);
		}

		// Populate the calendar with day numbers
		for (CalendarAnchorPaneNode ap : allCalendarDays) {
			

			//DB Circle 색 변경
			Circle circle= getCircle(Color.CORAL, 20, 8, 10);
			Circle circle2 = getCircle(Color.DARKCYAN, 60, 8 ,10);
			Circle circle3 = getCircle(Color.AQUA, 100, 8, 10);
			Circle circle4 = getCircle(Color.RED, 20, 8, 10);

			int sort = 0;
			for(Commute com : comLst) {
				if(calendarDate.toString().contentEquals(com.getDate())){
					if("출근".contentEquals(com.getSortation())) {
						circle.setFill(Color.GREEN);
						try {
							if(diffOfTime(LocalDate.now().toString()+" "+com.getTime(),LocalDate.now().toString()+" "+"09:00:00")<0) { //9시 - 출근시각 음수면 지각
								circle.setFill(Color.YELLOW); //지각
							}
//							else circle.setFill(Color.GREEN); //출근
						} catch (Exception er) {
							// TODO Auto-generated catch block
							er.printStackTrace();
						}
					}
					if("퇴근".contentEquals(com.getSortation())) {
						try {
							if(diffOfTime(LocalDate.now().toString()+" "+com.getTime(),LocalDate.now().toString()+" "+"18:00:00")>0) { //18시 - 퇴근시각 양수면 조퇴
								sort = 1;
							}
						} catch (Exception er) {
							// TODO Auto-generated catch block
							er.printStackTrace();
						}
					}
					if("출장".contentEquals(com.getSortation())) {
						sort = 2;  //출장
					}
				}
				else{
					 
				}
			}
			if (ap.getChildren().size() != 0) {
				ap.getChildren().remove(0);
			}
			
			if(sort==1) {
				ap.getChildren().add(circle2);
			}
			if (sort==2) {
				ap.getChildren().add(circle3);
			}
			
			if(calendarDate.equals(LocalDate.now())&&calendarDate.getMonth().equals(LocalDate.now().getMonth())) {
				ap.setStyle("-fx-background-color:#A6A6A6;");
			}
			if(circle.getFill().equals(Color.CORAL)){
				circle.setVisible(false);
			}

			Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
			if(calendarDate.getDayOfWeek().toString().equals("SUNDAY")) {
				txt.setFill(Color.RED);
				if(circle.getFill().equals(Color.CORAL))
				circle.setVisible(false);
			}
			if(calendarDate.getDayOfWeek().toString().equals("SATURDAY")) {
				txt.setFill(Color.BLUE);
				if(circle.getFill().equals(Color.CORAL))
					circle.setVisible(false);
			}

			ap.getChildren().add(circle);
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

	public Circle getCircle(Color color, double x, double y, double r) {
		Circle c = new Circle(r, color);
		c.relocate(x, y);
		return c;
	}


}
