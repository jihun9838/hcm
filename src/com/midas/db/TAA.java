package com.midas.db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TAA {
	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty department;
	private SimpleStringProperty yearMonth;
	private SimpleStringProperty goToWork;
	private SimpleStringProperty lateness;
	private SimpleStringProperty businessTrip;
	private SimpleStringProperty earlyLeave;
	private SimpleStringProperty absence;
	public TAA() {
		this.id = new SimpleStringProperty();
		this.name = new SimpleStringProperty();
		this.department = new SimpleStringProperty();
		this.yearMonth = new SimpleStringProperty();
		this.goToWork = new SimpleStringProperty();
		this.lateness = new SimpleStringProperty();
		this.businessTrip = new SimpleStringProperty();
		this.earlyLeave = new SimpleStringProperty();
		this.absence = new SimpleStringProperty();
	}
	public TAA(String id, String name, String department, String yearMonth, String goToWork, String lateness, 
			String holiday, String halfHoliday, String businessTrip, String earlyLeave, String absence) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.department = new SimpleStringProperty(department);
		this.yearMonth = new SimpleStringProperty(yearMonth);
		this.goToWork = new SimpleStringProperty(goToWork);
		this.lateness = new SimpleStringProperty(lateness);
		this.businessTrip = new SimpleStringProperty(businessTrip);
		this.earlyLeave = new SimpleStringProperty(earlyLeave);
		this.absence = new SimpleStringProperty(absence);
	}
	
	public TAA(String id, String name, String department, String yearMonth) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.department = new SimpleStringProperty(department);
		this.yearMonth = new SimpleStringProperty(yearMonth);
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
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty name() {
		return name;
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department.set(department);
	}
	public StringProperty department() {
		return department;
	}
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
}