package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SwitcchFrame {
	  
	WebDriver driver;	

	  @BeforeMethod
	  public void setup()
	  {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://jqueryui.com/autocomplete/");
	  }
	  
	  
	  @Test
	  public void frameDemo() 
	  {
		/*List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for(WebElement e:frames)
		{
			System.out.println(e.getTagName());
		}*/
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		driver.findElement(By.id("tags")).sendKeys("Selenium");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Button")).click();
		
	  }
	  

	  @AfterMethod
	  public void teardown()
	  {
		 // driver.quit();
	  }

}
