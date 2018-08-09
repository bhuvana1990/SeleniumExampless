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

public class webCalender {
static WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void selectCalender() throws InterruptedException {
		driver.get("https://www.skyscanner.com");
		driver.findElement(By.id("depart-fsc-datepicker-input")).click();
		
		//depart date
		String departDate = "30-August 2018";
		String[] splitDate = departDate.split("-");
		String departDay = splitDate[0];
		String departMonth = splitDate[1];
		selectDepartDate(departDay, departMonth);
		
		//return date
		String returndate = "6-November 2018";
		String[] splitOutDate = returndate.split("-");
		String returnDay = splitOutDate[0];
		String returnMonth = splitOutDate[1]; 
		
		selectReturnDate(returnDay, returnMonth);
	}

	//return date picker method
	private static void selectReturnDate(String returnDay, String returnMonth) throws InterruptedException {
		// TODO Auto-generated method stub
				
		driver.findElement(By.id("return-fsc-datepicker-input")).click();
		WebElement selecttDrop = driver.findElement(By.id("return-calendar__bpk_calendar_nav_select"));
		Select s = new Select(selecttDrop);
		
		//get month and year from selected date
		String cmonth_year = s.getFirstSelectedOption().getText();
//		System.out.println(month_year);		
		
		if(cmonth_year.equals(returnMonth)) {
			
			List<WebElement> tableCol = driver.findElements(By.xpath(".//*[@id='return-fsc-datepicker-input-popover']/div/div[2]/div/table/tbody/tr/td/button[not(contains(@class,' bpk-calendar-date--outside-1mvEm'))]"));
			for(WebElement cdays: tableCol) {
//				System.out.println(days.getText());
				if(cdays.getText().equals(returnDay)) {
					cdays.click();
					return;
				}
			}
		}
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("return-calendar__bpk_calendar_nav_month_nudger_next"))));
			driver.findElement(By.id("return-calendar__bpk_calendar_nav_month_nudger_next")).click();
			selectReturnDate(returnDay, returnMonth);
		
	}

	//depart date picker method
	private static void selectDepartDate(String day, String month) throws InterruptedException {
		
		// Date drop down
		WebElement selectDrop = driver.findElement(By.id("depart-calendar__bpk_calendar_nav_select"));
		Select s = new Select(selectDrop);
		
		//get month and year from selected date
		String month_year = s.getFirstSelectedOption().getText();
//		System.out.println(month_year);
		
		
		if(month_year.equals(month)) {
			
			List<WebElement> tCol = driver.findElements(By.xpath(".//*[@class = 'bpk-calendar-grid-2VWOF']/tbody/tr/td/button[not(contains(@class,' bpk-calendar-date--outside-1mvEm'))]"));
			for(WebElement days: tCol) {
//				System.out.println(days.getText());
				if(days.getText().equals(day)) {
					days.click();
					return;
				}
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("depart-calendar__bpk_calendar_nav_month_nudger_next"))));
		driver.findElement(By.id("depart-calendar__bpk_calendar_nav_month_nudger_next")).click();
		Thread.sleep(2000);
		selectDepartDate(day, month);
		
	}

}
