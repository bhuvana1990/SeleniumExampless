package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DropDown {
	WebDriver driver;
	
	@SuppressWarnings("unused")
	@Test
	  public void dropSelect() {
		  //from place
		driver.findElement(By.xpath(".//*[@id='bookflights']/div/div[2]/div[1]/form/table/tbody/tr[2]/td[1]/span/input")).click();
		List<WebElement> fromList = driver.findElements(By.xpath(".//*[@id='ui-id-5']/li/a"));
		for(int i=0; i<fromList.size(); i++) {
			String str = fromList.get(i).getText();
//			System.out.println(str);
			WebElement strEle = fromList.get(i);
			strEle.click();
			
			//to places 
			driver.findElement(By.xpath(".//*[@id='bookflights']/div/div[2]/div[1]/form/table/tbody/tr[2]/td[2]/span/input")).click();
			List<WebElement> toList = driver.findElements(By.xpath(".//*[@id='ui-id-1']/li/a"));
			for(int j=0; j<toList.size();j++) {
				String listStr = toList.get(j).getText();
//				System.out.println(listStr);
				if(listStr.equals(str)) {
					System.out.println("true");
				}else {
					System.out.println("false");
				}
				return;
			}
			
			return;
		}		
	}
	  
	  @BeforeMethod
	  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.goair.in");
	  }
	
	  @AfterMethod
	  public void afterMethod() {
//		  driver.quit();
	  }

}
