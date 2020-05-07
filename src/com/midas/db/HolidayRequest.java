package com.midas.db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HolidayRequest {
	private SimpleStringProperty num;
	private SimpleStringProperty id;
//	private SimpleStringProperty pw;
//	private SimpleStringProperty name;
//	private SimpleStringProperty birth;
//	private SimpleStringProperty gender;
//	private SimpleStringProperty category;
//	private SimpleStringProperty salary;
//	private SimpleStringProperty department;
//	private SimpleStringProperty position;
//	private SimpleStringProperty place;
//	private SimpleStringProperty phone;
//	private SimpleStringProperty join;
//	private SimpleStringProperty email;
//	private SimpleStringProperty education;
//	private SimpleStringProperty address;
//	private SimpleStringProperty image;
	//
	private SimpleStringProperty idx;
	private SimpleStringProperty start;
	private SimpleStringProperty end;
	private SimpleStringProperty days;
	private SimpleStringProperty text;
	
	
	
	public HolidayRequest() {
		this.num = new SimpleStringProperty();
		this.id = new SimpleStringProperty();
//		this.pw = new SimpleStringProperty();
//		this.name = new SimpleStringProperty();
//		this.birth = new SimpleStringProperty();
//		this.gender = new SimpleStringProperty();
//		this.category = new SimpleStringProperty();
//		this.salary = new SimpleStringProperty();
//		this.department = new SimpleStringProperty();
//		this.position = new SimpleStringProperty();
//		this.place = new SimpleStringProperty();
//		this.phone = new SimpleStringProperty();
//		this.join = new SimpleStringProperty();
//		this.email = new SimpleStringProperty();
//		this.education = new SimpleStringProperty();
//		this.address = new SimpleStringProperty();
//		this.image = new SimpleStringProperty();
		this.idx = new SimpleStringProperty();
		this.start = new SimpleStringProperty();
		this.end = new SimpleStringProperty();
		this.days = new SimpleStringProperty();
		this.text = new SimpleStringProperty();
	}
	
	public HolidayRequest(String num, String id, String idx, String start, String end, String days, String text) {
		this.num = new SimpleStringProperty(num);
		this.id = new SimpleStringProperty(id);
//		this.pw = new SimpleStringProperty(pw);
//		this.name = new SimpleStringProperty(name);
//		this.birth = new SimpleStringProperty(birth);
//		this.gender = new SimpleStringProperty(gender);
//		this.category = new SimpleStringProperty(category);
//		this.salary = new SimpleStringProperty(salay);
//		this.department = new SimpleStringProperty(department);
//		this.position = new SimpleStringProperty(position);
//		this.place = new SimpleStringProperty(place);
//		this.phone = new SimpleStringProperty(phone);
//		this.join = new SimpleStringProperty(join);
//		this.email = new SimpleStringProperty(email);
//		this.education = new SimpleStringProperty(education);
//		this.address = new SimpleStringProperty(adrress);
//		this.image = new SimpleStringProperty(image);
		this.idx = new SimpleStringProperty(idx);
		this.start = new SimpleStringProperty(start);
		this.end = new SimpleStringProperty(end);
		this.days = new SimpleStringProperty(days);
		this.text = new SimpleStringProperty(text);
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
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public StringProperty id() {
		return id;
	}
//	public String getPw() {
//		return pw.get();
//	}
//	public void setPw(String pw) {
//		this.pw.set(pw);
//	}
//	public StringProperty pw() {
//		return pw;
//	}
//	public String getName() {
//		return name.get();
//	}
//	public void setName(String name) {
//		this.name.set(name);
//	}
//	public StringProperty name() {
//		return name;
//	}
//	public String getBirth() {
//		return birth.get();
//	}
//	public void setBirth(String birth) {
//		this.birth.set(birth);
//	}
//	public StringProperty birth() {
//		return birth;
//	}
//	public String getGender() {
//		return gender.get();
//	}
//	public void setGender(String gender) {
//		this.gender.set(gender);
//	}
//	public StringProperty gender() {
//		return gender;
//	}
//	public String getCategory() {
//		return category.get();
//	}
//	public void setCategory(String category) {
//		this.category.set(category);
//	}
//	public StringProperty category() {
//		return category;
//	}
//	public String getSalary() {
//		return salary.get();
//	}
//	public void setSalary(String salary) {
//		this.salary.set(salary);
//	}
//	public StringProperty salary() {
//		return salary;
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
//	public String getPosition() {
//		return position.get();
//	}
//	public void setPosition(String position) {
//		this.position.set(position);
//	}
//	public StringProperty position() {
//		return position;
//	}
//	public String getPlace() {
//		return place.get();
//	}
//	public void setPlace(String place) {
//		this.place.set(place);
//	}
//	public StringProperty place() {
//		return place;
//	}
//	public String getPhone() {
//		return phone.get();
//	}
//	public void setPhone(String phone) {
//		this.phone.set(phone);
//	}
//	public StringProperty phone() {
//		return phone;
//	}
//	public String getJoin() {
//		return join.get();
//	}
//	public void setJoin(String join) {
//		this.join.set(join);
//	}
//	public StringProperty join() {
//		return join;
//	}
//	public String getEmail() {
//		return email.get();
//	}
//	public void setEmail(String email) {
//		this.email.set(email);
//	}
//	public StringProperty email() {
//		return email;
//	}
//	public String getEducation() {
//		return education.get();
//	}
//	public void setEducation(String education) {
//		this.education.set(education);
//	}
//	public StringProperty education() {
//		return education;
//	}
//	public String getAddress() {
//		return address.get();
//	}
//	public void setAddress(String adrress) {
//		this.address.set(adrress);
//	}
//	public StringProperty address() {
//		return address;
//	}
//	public String getImage() {
//		return image.get();
//	}
//	public void setImage(String image) {
//		this.image.set(image);
//	}
//	public StringProperty Image() {
//		return image;
//	}
	public String getIdx() {
		return idx.get();
	}
	public void setIdx(String idx) {
		this.idx.set(idx);
	}
	public StringProperty idx() {
		return idx;
	}
	public String getStart() {
		return start.get();
	}
	public void setStart(String start) {
		this.start.set(start);
	}
	public StringProperty start() {
		return idx;
	}
	public String getEnd() {
		return end.get();
	}
	public void setEnd(String end) {
		this.end.set(end);
	}
	public StringProperty end() {
		return end;
	}
	public String getDays() {
		return days.get();
	}
	public void setDays(String days) {
		this.days.set(days);
	}
	public StringProperty days() {
		return days;
	}
	public String getText() {
		return text.get();
	}
	public void setText(String text) {
		this.text.set(text);
	}
	public StringProperty Text() {
		return text;
	}
}