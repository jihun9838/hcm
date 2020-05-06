package com.midas.salary.service;

import java.util.List;

import com.midas.db.Employee;

import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;

public class SalaryServiceImpl implements SalaryService{

	@Override
	public LineChart AddDataToLineChart(List<Employee> empList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ShowSalaryStmt(Parent root, String id) {
		TextField tf = (TextField)root.lookup(id);
		String result = "";
		result += "";
		result += "";
		result += "";
		result += "";
		
		tf.setText(result);
	}
}
