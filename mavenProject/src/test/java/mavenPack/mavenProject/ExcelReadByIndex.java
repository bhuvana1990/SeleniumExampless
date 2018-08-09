package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ExcelReadByIndex {
	
	WebDriver driver;
	public static final String path = "C://Users//Quennie//Desktop//login.xlsx";
	
	@BeforeMethod
	public void startProcess() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void excelReader() throws Exception {
		File f =new File(path);
		FileInputStream fin = new FileInputStream(f);
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet("loginn");
//		XSSFRow row= sheet.getRow(2);
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(4);
//		System.out.println(cell.getStringCellValue());
//		System.out.println(cell.getNumericCellValue());
		System.out.println(cell.getDateCellValue());
		book.close(); 
		fin.close();
		
	}

	@AfterMethod
	public void endProcess() {
		driver.close();
	}

}
