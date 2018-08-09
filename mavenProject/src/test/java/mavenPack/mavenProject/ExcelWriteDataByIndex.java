package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ExcelWriteDataByIndex {

	WebDriver driver;
	public static final String path = "C://Users//Quennie//Desktop//login.xlsx";
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void f() throws Exception {
		File f = new File(path);
		FileInputStream fin = new FileInputStream(f);
		FileOutputStream fos = null;
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet("loginn");
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style=workbook.createCellStyle();
		row = sheet.getRow(3);
		cell = row.getCell(2);
		
		font.setFontName("Algerian");
		font.setFontHeight(10.0);
		font.setBold(true);		
		
		style.setFont(font);
		
		cell.setCellStyle(style);
		cell.setCellValue("Skipped");
				
		fos=new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
	}

	@AfterMethod
	public void afterMethod() {
	}

}
