package com.midas.db.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectTest {
	final static int ZEROASCII = 48;
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:C:/자바취업반/exam.db";
	final static String SQL =
					"SELECT count(*) " +
					"FROM student " +
					"WHERE year=?";
	
	public static void main(String[] args) {
		
		int year = 0;
		try {
			year = System.in.read() - ZEROASCII;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB);
			PreparedStatement pStmt = conn.prepareStatement(SQL);
			
			pStmt.setString(1, "stu_id");
			pStmt.setString(2, "stu_");
			//pStmt.setInt(3, "stu_id");
			pStmt.setString(4, "stu_id");
			
			
			pStmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
