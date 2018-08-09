package mavenPack.mavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserLaunch {
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers/chromedriver.exe");
	  ChromeDriver obj = new ChromeDriver();
	  obj.get("http://www.amazon.com");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
