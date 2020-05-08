package MIDAS.Service;

import java.time.LocalDate;

import MIDAS.Employee;
import javafx.scene.Parent;

public interface DetailInfoService {
	public void setInfo(Parent form, String num);
	public LocalDate LOCAL_DATE (String dateString);
	public Employee getEmployee(String num);
	public boolean EditInfo(String num, Employee employee);
	public boolean DeleteProc(Parent form);
}
