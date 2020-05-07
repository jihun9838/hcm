package com.midas.db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HolidayRequest {
	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty department;
	private SimpleStringProperty availableDay;
	private SimpleStringProperty requestDay;
	private SimpleStringProperty startDay;
	private SimpleStringProperty endDay;
	private SimpleStringProperty periodDay;
	private SimpleStringProperty reason;
	private SimpleStringProperty approval;
	
	
	public HolidayRequest() {
		this.id = new SimpleStringProperty();
		this.name = new SimpleStringProperty();
		this.department = new SimpleStringProperty();
		this.availableDay = new SimpleStringProperty();
		this.requestDay = new SimpleStringProperty();
		this.startDay = new SimpleStringProperty();
		this.endDay = new SimpleStringProperty();
		this.periodDay = new SimpleStringProperty();
		this.reason = new SimpleStringProperty();
		this.approval = new SimpleStringProperty();
	}
	
	public HolidayRequest(String id, String name, String department, String availableDay, String requestDay, String startDay, String endDay, String periodDay, String reason, String approval) {
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.department = new SimpleStringProperty(department);
		this.availableDay = new SimpleStringProperty(availableDay);
		this.requestDay = new SimpleStringProperty(requestDay);
		this.startDay = new SimpleStringProperty(startDay);
		this.endDay = new SimpleStringProperty(endDay);
		this.periodDay = new SimpleStringProperty(periodDay);
		this.reason = new SimpleStringProperty(reason);
		this.approval = new SimpleStringProperty(approval);
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
	
	public String getAvailableDay() {
		return availableDay.get();
	}
	public void setAvailableDay(String availableDay) {
		this.availableDay.set(availableDay);
	}
	public StringProperty availableDay() {
		return availableDay;
	}
	
	public String getRequestDay() {
		return requestDay.get();
	}
	public void setRequestDay(String requestDay) {
		this.requestDay.set(requestDay);
	}
	public StringProperty requestDay() {
		return requestDay;
	}
	
	public String getStartDay() {
		return startDay.get();
	}
	public void setStartDay(String startDay) {
		this.startDay.set(startDay);
	}
	public StringProperty startDay() {
		return startDay;
	}
	
	public String getEndDay() {
		return endDay.get();
	}
	public void setEndDay(String endDay) {
		this.endDay.set(endDay);
	}
	public StringProperty endDay() {
		return endDay;
	}
	
	public String getPeriodDay() {
		return periodDay.get();
	}
	public void setPeriodDay(String periodDay) {
		this.periodDay.set(periodDay);
	}
	public StringProperty periodDay() {
		return periodDay;
	}
	
	public String getReason() {
		return reason.get();
	}
	public void setReason(String reason) {
		this.reason.set(reason);
	}
	public StringProperty reason() {
		return reason;
	}
	
	public String getApproval() {
		return approval.get();
	}
	public void setApproval(String approval) {
		this.approval.set(approval);
	}
	public StringProperty approval() {
		return approval;
	}
}