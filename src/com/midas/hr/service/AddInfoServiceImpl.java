package MIDAS.Service;

import MIDAS.Employee;
import MIDAS.Data.DataManage;
import MIDAS.Data.DataManageImpl;

public class AddInfoServiceImpl implements AddInfoService {

	@Override
	public boolean SaveInfo(Employee employee) {
		DataManage dataManage = new DataManageImpl();
		return dataManage.SaveInfo(employee);
	}

}
