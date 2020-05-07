package com.midas.db;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class EmployeeHoliday2 {
	private SimpleStringProperty id;
	private SimpleStringProperty year;
	private SimpleStringProperty occurrenceDay;
	private SimpleStringProperty useDay;
	private SimpleStringProperty remainDay;
	
	public EmployeeHoliday2() {
		this.id = new SimpleStringProperty();
		this.year = new SimpleStringProperty();
		this.occurrenceDay = new SimpleStringProperty();
		this.useDay = new SimpleStringProperty();
		this.remainDay = new SimpleStringProperty();
		
	}

	public EmployeeHoliday2(String id, String year, String occurrenceDay, String useDay, String remainDay) {
		this.id = new SimpleStringProperty(id);
		this.year = new SimpleStringProperty(year);
		this.occurrenceDay = new SimpleStringProperty(occurrenceDay);
		this.useDay = new SimpleStringProperty(useDay);
		this.remainDay = new SimpleStringProperty(remainDay);
	}
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public StringProperty id() {
		return id;
	}
	
	public String getYear() {
		return year.get();
	}
	public void setYear(String year) {
		this.year.set(year);
	}
	public StringProperty year() {
		return year;
	}
	
	public String getOccurrenceDay() {
		return occurrenceDay.get();
	}
	public void setOccurrenceDay(String occurrenceDay) {
		this.occurrenceDay.set(occurrenceDay);
	}
	public StringProperty OccurrenceDay() {
		return occurrenceDay;
	}
	
	public String getUseDay() {
		return useDay.get();
	}
	public void setUseDay(String useDay) {
		this.useDay.set(useDay);
	}
	public StringProperty useDay() {
		return useDay;
	}
	
	public String getRemainDay() {
		return remainDay.get();
	}
	public void setRemainDay(String remainDay) {
		this.remainDay.set(remainDay);
	}
	public StringProperty remainDay() {
		return remainDay;
	}
}
