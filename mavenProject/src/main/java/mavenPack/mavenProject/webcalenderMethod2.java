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

public class webcalenderMethod2 {
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
		public void  selectCldr() throws Exception {
			driver.get("https://www.skyscanner.com");
			driver.findElement(By.id("depart-fsc-datepicker-input")).click();
			WebElement date_input = driver.findElement(By.cssSelector("[class='bpk-select-XFm4Y']"));
			Select s = new Select(date_input);
			
			//selecting month
			while(!s.getFirstSelectedOption().getText().contains("September 2018")) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("depart-calendar__bpk_calendar_nav_month_nudger_next"))));
				driver.findElement(By.id("depart-calendar__bpk_calendar_nav_month_nudger_next")).click();			
			}
			
			//selecting day
			List<WebElement> date_list= driver.findElements(By.cssSelector("[class='bpk-calendar-date-1Mg7I']"));
			for(int i=0;i<date_list.size(); i++) {
				String date = date_list.get(i).getText();
				if(date.equalsIgnoreCase("24")) {
					date_list.get(i).click();
					break;
				}
			}
		}			
}
