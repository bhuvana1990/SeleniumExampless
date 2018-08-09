package mavenPack.mavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCalender {
static WebDriver driver;
static WebElement departPick;
static WebElement returnPick;
static String dataText;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void selectCalender() {
		driver.get("https://www.skyscanner.com");
		departPick = driver.findElement(By.id("depart-fsc-datepicker-input"));
		departPick.click();
		if(departPick.isDisplayed()) {
			dataText = "depart";
		}

		returnPick = driver.findElement(By.id("return-fsc-datepicker-input"));
		//depart date
		String departDate = "30-August 2018";
		String[] splitDate = departDate.split("-");
		String departDay = splitDate[0];
		String departMonth = splitDate[1];
		selectReturnDate(departDay, departMonth);
		
	}

	//return date picker method
	private static void selectReturnDate(String day, String month) {

		WebElement selecttDrop = driver.findElement(By.id(dataText+"-calendar__bpk_calendar_nav_select"));
		Select s = new Select(selecttDrop);
		
		//get month and year from selected date
		String cmonth_year = s.getFirstSelectedOption().getText();
		
		while(!cmonth_year.equals(month)) {
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(dataText+"-calendar__bpk_calendar_nav_month_nudger_next"))));
			driver.findElement(By.id(dataText+"-calendar__bpk_calendar_nav_month_nudger_next")).click();
			break;
		}

		List<WebElement> tableCol = driver.findElements(By.xpath(".//*[@id='"+dataText+"-fsc-datepicker-input-popover']/div/div[2]/div/table/tbody/tr/td/button[not(contains(@class,' bpk-calendar-date--outside-1mvEm'))]"));
		for(WebElement cdays: tableCol) {
			if(cdays.getText().equals(day)) {
				cdays.click();
				break;
			}
		}

		returnPick.click();
		dataText="return";
		String returndate = "6-November 2018";
		String[] splitOutDate = returndate.split("-");
		String returnDay = splitOutDate[0];
		String returnMonth = splitOutDate[1];
		selectReturnDate(returnDay, returnMonth);	
			
////		returnPick.click();
//		if(returnPick.isDisplayed()){
//			dataText="return";
//
//			//return date
//			String returndate = "6-November 2018";
//			String[] splitOutDate = returndate.split("-");
//			String returnDay = splitOutDate[0];
//			String returnMonth = splitOutDate[1];
//			selectReturnDate(returnDay, returnMonth);
//		}	
	}
}
