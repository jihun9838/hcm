package com.midas.salary.service;

import java.util.List;

import com.midas.db.SalaryResult;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface SalaryService {
	public String c(double n);

	public void Chart(Stage stage);
	public void ShowTableViewByList(Scene scene, String id, List list);
	public void ShowLineChartByList(Scene scene, String id, List<SalaryResult> list);
	public void ShowSalaryStmt(Scene scene, String id, SalaryResult salaryResult);
}
