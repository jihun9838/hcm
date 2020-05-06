package com.midas.db.service;//package com.midas.db;//import java.io.FileOutputStream;//import java.io.IOException;//import java.sql.Connection;//import java.sql.DriverManager;//import java.sql.ResultSet;//import java.sql.SQLException;//import java.sql.Statement;//import java.sql.Timestamp;////import org.apache.poi.ss.usermodel.Cell;//import org.apache.poi.ss.usermodel.CellStyle;//import org.apache.poi.ss.usermodel.CreationHelper;//import org.apache.poi.ss.usermodel.Row;//import org.apache.poi.xssf.usermodel.XSSFSheet;//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// * A simple Java program that exports data from database to Excel file.
// * @author Nam Ha Minh
// * (C) Copyright codejava.net
// */
public class DB2ExcelExporter {
//
//	public static void main(String[] args) {
//		new DB2ExcelExporter().export();
//	}
//
//	public void export() {
//		//		Class.forName("org.sqlite.JDBC");
//		//		Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/자바취업반/exam.db");
//		//		Statement stmt = conn.createStatement();
//		//		
//		//		final String sql = 
//		//				"SELECT * FROM student";
//		//		//		try {//			Class.forName("org.sqlite.JDBC");//		} catch (ClassNotFoundException e1) {//			// TODO Auto-generated catch block//			e1.printStackTrace();//		}
//		String jdbcURL = "jdbc:sqlite:C:/자바취업반/MIDAS_Project.db";
//		//        String username = "root";
//		//        String password = "password";
//
//		String excelFilePath = "Reviews-export2.xlsx";
//
//		try (Connection connection = DriverManager.getConnection(jdbcURL/*, username, password)*/)) {
//			String sql = "SELECT * FROM Member";
//
//			Statement statement = connection.createStatement();
//
//			ResultSet result = statement.executeQuery(sql);
//
//			XSSFWorkbook workbook = new XSSFWorkbook();
//			XSSFSheet sheet = workbook.createSheet("Reviews");
//
//			writeHeaderLine(sheet);
//
//			writeDataLines(result, workbook, sheet);
//
//			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
//			workbook.write(outputStream);
//			// workbook.close();
//
//			statement.close();
//
//		} catch (SQLException e) {
//			System.out.println("Datababse error:");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("File IO error:");
//			e.printStackTrace();
//		}
//	}
//
//	private void writeHeaderLine(XSSFSheet sheet) {
//
//		Row headerRow = sheet.createRow(0);
//
//		Cell headerCell = headerRow.createCell(0);
//		headerCell.setCellValue("사원번호");
//
//		headerCell = headerRow.createCell(1);
//		headerCell.setCellValue("id");
//
////		headerCell = headerRow.createCell(2);
////		headerCell.setCellValue("pw");
////
////		headerCell = headerRow.createCell(3);
////		headerCell.setCellValue("이름");
////
////		headerCell = headerRow.createCell(4);
////		headerCell.setCellValue("생년월일");
//	}
//
//	private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
//			XSSFSheet sheet) throws SQLException {
//		int rowCount = 1;
//
//		while (result.next()) {
//			String courseName = result.getString("사원번호");
//			String studentName = result.getString("id");
//			String rating = result.getString("pw");
//			String timestamp = result.getString("이름");
//			String comment = result.getString("생년월일");
//
//			Row row = sheet.createRow(rowCount++);
//
//			int columnCount = 0;
//			Cell cell = row.createCell(columnCount++);
//			cell.setCellValue(courseName);
//
//			cell = row.createCell(columnCount++);
//			cell.setCellValue(studentName);
//
////			cell = row.createCell(columnCount++);
////
////			CellStyle cellStyle = workbook.createCellStyle();
////			CreationHelper creationHelper = workbook.getCreationHelper();
////			cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
////			cell.setCellStyle(cellStyle);
////
////			cell.setCellValue(timestamp);
////
////			cell = row.createCell(columnCount++);
////			cell.setCellValue(rating);
////
////			cell = row.createCell(columnCount);
////			cell.setCellValue(comment);
//
//		}
//	}
//
}