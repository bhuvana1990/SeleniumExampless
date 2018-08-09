package mPack_1.newMavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Cart extends BasePage{
	static WebDriver driver;
  
  @BeforeMethod
  public void startBrowser() throws Exception {
//	  BrowserLaunch(getData("browser"), getData("url"));
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
  }
  
  @Test
  public void shoppingProcess() throws Exception {
	  
	  ShoppingCart cart = new ShoppingCart(driver);
	  cart.addToCart(driver);
  }
  
//
//  public void cartList() {
//	  ShoppingCart cL = new ShoppingCart(driver);
//  }
  
  @AfterMethod
  public void endBrowser() {
	  driver.close();
  }
  

}
