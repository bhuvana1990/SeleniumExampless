package mavenPack.mavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownSelect {
	
	WebDriver driver;
	
	@BeforeMethod
	public void start() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com");
	}
	
	@Test
	public void dropDown() {
		driver.findElement(By.xpath(".//*[@id='orb-nav-more']/a")).click();
		List<WebElement> li = driver.findElements(By.xpath(".//*[@id='orb-panel-more']/div/ul/li/a"));
		for(int i=0; i <li.size(); i++) {
			// print all sub-menu-links of "more"
			System.out.println(li.get(i).getText());
//			li.get(i).click();
		} 
	}
	
//	@Test
//	public void selectDD() {
//		driver.findElement(By.linkText("Register")).click();
//		WebElement ele = driver.findElement(By.name("country"));
//		Select s = new Select(ele);
//		List<WebElement> li = s.getOptions();
//		for(int i=0; i<li.size(); i++) {
//			System.out.println(li.get(i).getText());
//		}
//	}
	
	@AfterMethod
	public void end() {
		driver.close();
	}
}
