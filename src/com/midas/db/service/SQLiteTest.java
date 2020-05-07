package com.midas.db.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteTest {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/자바취업반/exam.db");
			Statement stmt = conn.createStatement();
			
			final String sql = 
					"SELECT * FROM student";
			
			ResultSet rs = stmt.executeQuery(sql);

			//System.out.println(rs.getRowId(1));
			while(rs.next()) {
				String res = "";
				res += rs.getString(1) + "\t";
				res += rs.getString("resident_id") +"\t";
				res += rs.getString(3) + "\t";
				res += rs.getString(4) + "\t";

				System.out.println(res);
			}
			
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		System.out.println("connect!!");
		
	}
}
