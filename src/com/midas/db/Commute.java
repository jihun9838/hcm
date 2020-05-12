package com.midas.db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commute {
	private SimpleStringProperty num;
	private SimpleStringProperty sortation;
	private SimpleStringProperty date;
	private SimpleStringProperty time;
	private StringProperty[] value;

	public Commute() {
		this.num = new SimpleStringProperty();
		this.sortation = new SimpleStringProperty();
		this.date = new SimpleStringProperty();
		this.time = new SimpleStringProperty();
		this.value = new StringProperty[3];
	}

	public Commute(String num, String sortation, String date, String time, String [] value) {
		this.num = new SimpleStringProperty(num);
		this.sortation = new SimpleStringProperty(sortation);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
		this.value = new StringProperty[]{
				num(), sortation(), date(), time()};
	}

	public String getNum() {
		return num.get();
	}
	public void setNum(String num) {
		this.num.set(num);
	}
	public StringProperty num() {
		return num;
	}
	public String getSortation() {
		return sortation.get();
	}
	public void setSortation(String sortation) {
		this.sortation.set(sortation);
	}
	public StringProperty sortation() {
		return sortation;
	}
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.date.set(date);
	}
	public StringProperty date() {
		return date;
	}
	public String getTime() {
		return time.get();
	}
	public void setTime(String time) {
		this.time.set(time);
	}
	public StringProperty time() {
		return time;
	}
	
	
	
	public StringProperty[] getValue() {
		return value;
	}
	
}