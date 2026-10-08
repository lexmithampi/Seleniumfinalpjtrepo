package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {

	static FileInputStream f; // FileInputStream is used to read excel file our system
	static XSSFWorkbook w; // XSSWorkbook is used to represent entire excel work book in our system
	static XSSFSheet sh; // XSSFSheet is used to represent a sheet from the excel(eg: sheet1)

	public static String readStringData(int row, int col, String sheet) throws IOException { // method to read the
																								// values, eg:the values
																								// in Name cell from
																								// book1.xslx
		// To open the excel file from given location
		f = new FileInputStream(Constant.EXCELFILE);
		// To load the excel file to load into memory using apache poi libraries
		w = new XSSFWorkbook(f);
		// To select "sheet1"
		sh = w.getSheet(sheet);
		// To get the values from the row based on the parameter
		XSSFRow r = sh.getRow(row);
		// To get cell in that row based on the column number
		XSSFCell c = r.getCell(col);
		// to return the text in that cell (String)
		return c.getStringCellValue();

	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {
		f = new FileInputStream(Constant.EXCELFILE);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue(); // convert double to int using typecasting
		return String.valueOf(val); // convert int to string using valueOf() method

	}

}
