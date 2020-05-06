package com.midas.db.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:C:/자바취업반/exam.db";
	final static String CREATETABLESQL =
			"CREATE TABLE login(" +
					"id varchar2(20) not null PRIMARY KEY, " +
					"pw varchar2(30) not null" +
					")";

	
	public static void main(String[] args) {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(CREATETABLESQL);

			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
