package com.midas.hr.service;
import java.time.LocalDate;

import com.midas.db.Employee;

import javafx.scene.Parent;

public interface DetailInfoService {
	public void setInfo(Parent form, String num);
	public LocalDate LOCAL_DATE (String dateString);
	public Employee getEmployee(String num);
	public boolean EditInfo(String num, Employee employee);
	public void DeleteProc(Parent form);
}
