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

public class ExcelReadByValue {
	
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
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = null;
		int colnum = 0;
		
		//to pick a single cell of a column in a row
		for(int i=0;i < row.getLastCellNum(); i++) {
			if(row.getCell(i).getStringCellValue().trim().equals("Username")) {
				colnum = i;
			}
//			System.out.println(colnum);//getting column number
		}
		row = sheet.getRow(1);
		cell = row.getCell(colnum);//getting column cell data
		
		System.out.println(cell);
		book.close(); 
		fin.close();
		
	}

	@AfterMethod
	public void endProcess() {
		driver.close();
	}

}
