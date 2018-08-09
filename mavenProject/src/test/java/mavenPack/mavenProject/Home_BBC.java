package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Home_BBC{
 
  static WebDriver driver;
  
  @BeforeMethod
  public void startBrowser() throws Exception {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://www.bbc.com");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
  }
  
  @Test
  public void home() throws Exception {
	  HomePage_BBC hp = new HomePage_BBC(driver);
	  hp.loadPage(driver);
  }
  
  
  @AfterMethod
  public void afterMethod() {
  }

}
