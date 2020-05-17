package com.midas.db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commute {
	private SimpleStringProperty num;
	private SimpleStringProperty sortation;
	private SimpleStringProperty date;
	private SimpleStringProperty time;
//	private SimpleStringProperty name;
//	private SimpleStringProperty department;
	private SimpleStringProperty yearMonth;
	private SimpleStringProperty goToWork;
	private SimpleStringProperty lateness;
	private SimpleStringProperty businessTrip;
	private SimpleStringProperty leave;
	private SimpleStringProperty earlyLeave;
	private SimpleStringProperty absence;
	private StringProperty[] value;

	public Commute() {
		this.num = new SimpleStringProperty();
		this.sortation = new SimpleStringProperty();
		this.date = new SimpleStringProperty();
		this.time = new SimpleStringProperty();
//		this.name = new SimpleStringProperty();
//		this.department = new SimpleStringProperty();
		this.yearMonth = new SimpleStringProperty();
		this.goToWork = new SimpleStringProperty();
		this.lateness = new SimpleStringProperty();
		this.businessTrip = new SimpleStringProperty();
		this.leave = new SimpleStringProperty();
		this.earlyLeave = new SimpleStringProperty();
		this.absence = new SimpleStringProperty();
		this.value = new StringProperty[3];
	}
	
	public Commute(String num, String sortation, String date, String time) {
		this.num = new SimpleStringProperty(num);
		this.sortation = new SimpleStringProperty(sortation);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
	}

	public Commute(String num, String sortation, String date, String time, String yearMonth, String goToWork, String lateness, 
			String businessTrip, String leave, String earlyLeave, String absence, String [] value) {
		this.num = new SimpleStringProperty(num);
		this.sortation = new SimpleStringProperty(sortation);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
//		this.name = new SimpleStringProperty(name);
//		this.department = new SimpleStringProperty(department);
		this.yearMonth = new SimpleStringProperty(yearMonth);
		this.goToWork = new SimpleStringProperty(goToWork);
		this.lateness = new SimpleStringProperty(lateness);
		this.businessTrip = new SimpleStringProperty(businessTrip);
		this.leave = new SimpleStringProperty(leave);
		this.earlyLeave = new SimpleStringProperty(earlyLeave);
		this.absence = new SimpleStringProperty(absence);
		this.value = new StringProperty[]{
				num(), sortation(), date(), time(), 
				yearMonth(), goToWork(), lateness(), businessTrip(), leave(), earlyLeave(), absence()};
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
//	public String getName() {
//		return name.get();
//	}
//	public void setName(String name) {
//		this.name.set(name);
//	}
//	public StringProperty name() {
//		return name;
//	}
//	public String getDepartment() {
//		return department.get();
//	}
//	public void setDepartment(String department) {
//		this.department.set(department);
//	}
//	public StringProperty department() {
//		return department;
//	}
	public String getYearMonth() {
		return yearMonth.get();
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth.set(yearMonth);
	}
	public StringProperty yearMonth() {
		return yearMonth;
	}
	public String getGoToWork() {
		return goToWork.get();
	}
	public void setGoToWork(String goToWork) {
		this.goToWork.set(goToWork);
	}
	public StringProperty goToWork() {
		return goToWork;
	}
	public String getLateness() {
		return lateness.get();
	}
	public void setLateness(String lateness) {
		this.lateness.set(lateness);
	}
	public StringProperty lateness() {
		return lateness;
	}
	public String getBusinessTrip() {
		return businessTrip.get();
	}
	public void setBusinessTrip(String businessTrip) {
		this.businessTrip.set(businessTrip);
	}
	public StringProperty businessTrip() {
		return businessTrip;
	}
	public String getLeave() {
		return leave.get();
	}
	public void setLeave(String leave) {
		this.leave.set(leave);
	}
	public StringProperty leave() {
		return leave;
	}
	public String getEarlyLeave() {
		return earlyLeave.get();
	}
	public void setEarlyLeave(String earlyLeave) {
		this.earlyLeave.set(earlyLeave);
	}
	public StringProperty earlyLeave() {
		return earlyLeave;
	}
	public String getAbsence() {
		return absence.get();
	}
	public void setAbsence(String absence) {
		this.absence.set(absence);
	}
	public StringProperty absence() {
		return absence;
	}
	
	public StringProperty[] getValue() {
		return value;
	}
	
}