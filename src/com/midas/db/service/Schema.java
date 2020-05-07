package com.midas.db.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Schema {
	final static String DRIVER = "org.sqlite.JDBC";
	final static String DB = "jdbc:sqlite:C:/자바취업반/exam.db";
	static String SQL = "";

	static void drop() {
		SQL = "alter table member "
				+ "drop column ";
	}
	
	static void delete() {
		SQL = "delete from member";
	}

	static void update() {
		SQL = "update member "
				+ "set PW = \"asdsdsdin1234\" "
				+ "where ID = \"Din\"";
	}
	
	static void query() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(SQL);
			
			stmt.close();
			conn.close();
			System.out.println("SUCCESSSSS");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
//		update();
//		drop();
//		delete();
		query();
	}
}
