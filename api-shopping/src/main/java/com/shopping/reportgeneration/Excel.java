package com.shopping.reportgeneration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Excel {

	private static Logger log = LoggerFactory.getLogger(Excel.class);

	public static void main(String[] args) {

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			Sheet spreadsheet = workbook.createSheet(" customer Data ");
			Row row = spreadsheet.createRow(0);
			CellStyle headerStyle = workbook.createCellStyle();

			XSSFFont font = workbook.createFont();
			font.setFontName("Arial");
			font.setFontHeightInPoints((short) 16);
			font.setBold(true);
			headerStyle.setFont(font);

			Cell headerCell = row.createCell(0);
			headerCell.setCellValue("Name");
			headerCell.setCellStyle(headerStyle);

			headerCell = row.createCell(1);
			headerCell.setCellValue("Number");
			headerCell.setCellStyle(headerStyle);
			CellStyle style = workbook.createCellStyle();
			style.setWrapText(true);
			Row row1 = spreadsheet.createRow(1);
			Cell cell = row1.createCell(0);
			cell.setCellValue("Somu");
			cell.setCellStyle(style);

			cell = row1.createCell(1);
			cell.setCellValue(987654321);
			cell.setCellStyle(style);

			Row row2 = spreadsheet.createRow(2);
			Cell cell1 = row2.createCell(0);
			cell1.setCellValue("Ramu");
			cell1.setCellStyle(style);
			cell = row1.createCell(1);
			cell.setCellValue(985432172);
			cell.setCellStyle(style);
			cell1 = row1.createCell(1);
			cell1.setCellValue(987654321);
			cell1.setCellStyle(style);

			File currDir = new File(".");
			String path = currDir.getAbsolutePath();
			String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";
			FileOutputStream outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			log.info(e.getMessage());
		}

		log.info("report generated!!");
	}
}
