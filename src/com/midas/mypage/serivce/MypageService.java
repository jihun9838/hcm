package com.midas.mypage.serivce;

import com.midas.db.Employee;

import javafx.scene.Parent;

public interface MypageService {
	public Employee getEmployee(String id);
	public void setInfo(Parent form, String num);
}
