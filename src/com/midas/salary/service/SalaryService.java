package com.midas.salary.service;

import java.util.List;

import com.midas.db.Employee;

import javafx.scene.Parent;
import javafx.scene.chart.LineChart;

public interface SalaryService {
	public LineChart AddDataToLineChart(List<Employee> empList);
	public void ShowSalaryStmt(Parent root, String id);
}
