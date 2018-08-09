package mavenPack.mavenProject;

import org.openqa.selenium.WebDriver;

public class ReadExcelDataDriverClass {
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception 
	{
		
		ExcelReaderAPI e=new ExcelReaderAPI("C:\\Users\\Quennie\\Desktop\\testdata.xlsx");	
		
		System.out.println("------Reading cell data from Excel by using Column Number--------");
		System.out.println(e.getCellData("login", 0, 1));
		System.out.println(e.getCellData("login", 1, 1));
		System.out.println(e.getCellData("login", 2, 1));
		System.out.println(e.getCellData("login", 3, 1));
		
		
		
		
		System.out.println("*********************************************");
		
		System.out.println("------Reading cell data from Excel by using Column Name--------");
		System.out.println(e.getCellData("login", "UserName", 1));
		System.out.println(e.getCellData("login", "Password", 1));
		System.out.println(e.getCellData("login", "DateCreated", 1));
		System.out.println(e.getCellData("login", "NoOfAttemps", 1));
	}
	
	

}
