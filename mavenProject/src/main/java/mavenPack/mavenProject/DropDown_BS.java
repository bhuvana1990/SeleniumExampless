package mavenPack.mavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown_BS {
	
	WebDriver driver;

	@BeforeMethod
	public void startMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in");
	}
	
	@Test
	public void selectDropDown() {
		driver.findElement(By.id("src")).sendKeys("hyd");
		List<WebElement> list=driver.findElements(By.xpath("//*[@id='search']/div/div[1]/div/ul/li"));
		for(WebElement ele:list) {
			String option = ele.getAttribute("innerHTML");
			if(option.contains("Hyderabad")) {
				ele.click();
			}
		}
	}
	
	@AfterMethod
	public void endMethod() {
		driver.close();
	}
}
