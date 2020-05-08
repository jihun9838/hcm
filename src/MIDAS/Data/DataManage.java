package MIDAS.Data;

import java.util.List;

import MIDAS.Employee;

public interface DataManage {
	public Employee getEmployee(String num);
	public List<Employee> getEmployeelst(int i);
	public List<Employee> getEmployeeSearch(String attribute, String txt, int i);
	public boolean SaveInfo(Employee employee);
	public boolean EditInfo(String num, Employee employee);
	public boolean DeleteInfo(String num);
}
