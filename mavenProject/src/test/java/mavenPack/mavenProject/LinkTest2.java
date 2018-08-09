package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LinkTest2 {
	WebDriver driver;
	int count=0;
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bbc.com");
	}
	
	
	@Test
	public void linkTesting2()
	{
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list);
		for(int i=0;i<list.size();i++) {
			if(!list.get(i).getText().isEmpty()) {
				count++;
				String str = list.get(i).getText();
				System.out.println(str);
				list=driver.findElements(By.tagName("a"));

			}
		}
		System.out.println("number of links:"+count);
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}


}
