package com.midas.salary.service;

import java.util.List;

import com.midas.db.SalaryResult;
import com.midas.service.CommonServiceImpl;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SalaryServiceImpl implements SalaryService{

	public String c(double n) {
		return String.valueOf(Math.round(n));
	}

	public void Chart(Stage stage) {
		// https://docs.oracle.com/javafx/2/charts/line-chart.htm

		stage.setTitle("Line Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Month");
		final LineChart<String,Number> lineChart = 
				new LineChart<String,Number>(xAxis,yAxis);

		lineChart.setTitle("Stock Monitoring, 2010");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Portfolio 1");

		series1.getData().add(new XYChart.Data("Jan", 23));
		series1.getData().add(new XYChart.Data("Feb", 14));
		series1.getData().add(new XYChart.Data("Mar", 15));
		series1.getData().add(new XYChart.Data("Apr", 24));
		series1.getData().add(new XYChart.Data("May", 34));
		series1.getData().add(new XYChart.Data("Jun", 36));
		series1.getData().add(new XYChart.Data("Jul", 22));
		series1.getData().add(new XYChart.Data("Aug", 45));
		series1.getData().add(new XYChart.Data("Sep", 43));
		series1.getData().add(new XYChart.Data("Oct", 17));
		series1.getData().add(new XYChart.Data("Nov", 29));
		series1.getData().add(new XYChart.Data("Dec", 25));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Portfolio 2");
		series2.getData().add(new XYChart.Data("Jan", 33));
		series2.getData().add(new XYChart.Data("Feb", 34));
		series2.getData().add(new XYChart.Data("Mar", 25));
		series2.getData().add(new XYChart.Data("Apr", 44));
		series2.getData().add(new XYChart.Data("May", 39));
		series2.getData().add(new XYChart.Data("Jun", 16));
		series2.getData().add(new XYChart.Data("Jul", 55));
		series2.getData().add(new XYChart.Data("Aug", 54));
		series2.getData().add(new XYChart.Data("Sep", 48));
		series2.getData().add(new XYChart.Data("Oct", 27));
		series2.getData().add(new XYChart.Data("Nov", 37));
		series2.getData().add(new XYChart.Data("Dec", 29));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Portfolio 3");
		series3.getData().add(new XYChart.Data("Jan", 44));
		series3.getData().add(new XYChart.Data("Feb", 35));
		series3.getData().add(new XYChart.Data("Mar", 36));
		series3.getData().add(new XYChart.Data("Apr", 33));
		series3.getData().add(new XYChart.Data("May", 31));
		series3.getData().add(new XYChart.Data("Jun", 26));
		series3.getData().add(new XYChart.Data("Jul", 22));
		series3.getData().add(new XYChart.Data("Aug", 25));
		series3.getData().add(new XYChart.Data("Sep", 43));
		series3.getData().add(new XYChart.Data("Oct", 44));
		series3.getData().add(new XYChart.Data("Nov", 45));
		series3.getData().add(new XYChart.Data("Dec", 44));

		Scene scene  = new Scene(lineChart,800,600);       
		lineChart.getData().addAll(series1, series2, series3);

		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void ShowTableViewByList(Scene scene, String id, List list) {
		new CommonServiceImpl().ShowTableViewByList(scene, id, list);
	}

	@Override
	public void ShowLineChartByList(Scene scene, String id, List<SalaryResult> list) {
		//Chart(new Stage());
		new CommonServiceImpl().ShowLineChartByList(scene, id, list);
	}

	@Override
	public void ShowSalaryStmt(Scene scene, String id, SalaryResult salaryResult) {
		TextArea tf = (TextArea)scene.lookup(id);
		double salary = (Integer.valueOf(salaryResult.getSalary()) * 100000) / 12;

		String result = "";
		result += "\n\n";
		result += "\t\t\t\t\t\t\t�޿�����";
		result += "\n\n\n\n\n";
		result += "\n\t\t\t���\t\t\t:\t" + salaryResult.getNum();
		result += "\n\t\t\t����\t\t\t:\t" + salaryResult.getYear();
		result += "\n\t\t\t��\t\t\t:\t" + salaryResult.getMonth();
		result += "\n\n";
		result += "\n\t\t\t���� �Ѿ�\t\t:\t" + String.valueOf(salary) + "��";;
		result += "\n\n";
		result += "\n\t\t\t���� ����\t\t:\t" + c(salary * 0.045) + "��";
		result += "\n\t\t\t�ǰ� ����\t\t:\t" + c(salary * 0.0335) + "��";
		result += "\n\t\t\t�Ǿ� �޿�\t\t:\t" + c(salary * 0.008) + "��";
		result += "\n\t\t\t�ҵ漼\t\t:\t" + c(salary * 0.0252) + "��";
		result += "\n\t\t\t���� �ҵ漼\t:\t" + c(salary * 0.00252) + "��";
		result += "\n\t\t\t���� ����\t\t:\t" + "���� ȸ�� �δ�";
		result += "\n\n";
		result += "\n\t\t\t���� �Ѿ�\t\t:\t" + c(salary * (0.045 + 0.0335 + 0.008 + 0.0252 + 0.00252)) + "��";
		result += "\n\n";
		result += "\n\t\t\t�����޾�\t\t:\t" + c(salary - (salary * (0.045 + 0.0335 + 0.008 + 0.0252 + 0.00252))) + "��";
		result += "\n\n\n\n\n";
		result += "\t\t\t" + salaryResult.getMonth() + "�� �Ѵ� �� ��� �����̽��ϴ� !";

		tf.setText(result);
	}
}
